package com.bitc.kdh.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.kdh.dto.GametalkPostDto;
import com.bitc.kdh.dto.GametalkPostFileDto;
import com.bitc.kdh.dto.GametalkUserDto;
import com.bitc.kdh.dto.GametalkfollowDto;
import com.bitc.kdh.service.GametalkService;

@Controller
public class gametalkController {

	@Autowired
	private GametalkService gametalkService;

	@RequestMapping("/")
	public String index() throws Exception {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() throws Exception {

		return "/gametalk/login";
	}

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String loginCheck(GametalkUserDto user, HttpServletRequest request) throws Exception {

		int count = gametalkService.selectMemberInfoYn(user.getUserId(), user.getUserPw());

		if (count == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getUserId());
			session.setAttribute("userName", user.getUserName());
			session.setMaxInactiveInterval(1800);
			return "redirect:/main";
		} else {
			return "redirect:/loginFail";
		}
	}

	@RequestMapping(value = "/loginOK", method = RequestMethod.GET)
	public String loginOK(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();

		if (session.getAttribute("userId") != null) {
			return "/main";
		} else {
			return "/loginFail";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.invalidate();

		return "redirect:/login";
	}

	@RequestMapping(value = "/loginFail", method = RequestMethod.GET)
	public String loginFail() throws Exception {
		return "/gametalk/loginFail";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public ModelAndView main(@SessionAttribute("userId") String userId) throws Exception {
		ModelAndView mv = new ModelAndView("/gametalk/main");
		List<GametalkPostDto> posts = gametalkService.viewPost(userId);
		GametalkUserDto users = gametalkService.loadUsers(userId);
		List<GametalkfollowDto> follow = gametalkService.loadfollow(userId);
		List<GametalkPostFileDto> files = new ArrayList<GametalkPostFileDto>();
		for(int i=0; i<posts.size(); i++) {
			int postIdx = posts.get(i).getPostIdx();
			files = gametalkService.viewPostFileList(postIdx); 
			mv.addObject("files", files);
		}
		
		mv.addObject("posts", posts);
		mv.addObject("users", users);
		mv.addObject("follow", follow);
		return mv;
	}

	@RequestMapping(value = "/main/createPost", method = RequestMethod.POST)
	public String createPost(GametalkPostDto posts, MultipartHttpServletRequest multiFiles) throws Exception {
		gametalkService.createPost(posts, multiFiles);
		return "redirect:/main";
	}

	@RequestMapping(value = "/main/downloadPostFile", method = RequestMethod.GET)
	public void downloadPostFile(@RequestParam int postfileIdx, @RequestParam int postIdx, HttpServletResponse response)
			throws Exception {
		GametalkPostFileDto postFile = gametalkService.postFileInfo(postfileIdx, postIdx);

		if (ObjectUtils.isEmpty(postFile) == false) {
			String fileName = postFile.getOriginalName();

			byte[] files = FileUtils.readFileToByteArray(new File(postFile.getFilePath()));

			response.setContentType("application/octet-stream");
			response.setContentLength(files.length);
			response.setHeader("Content-Disposition",
					"attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");

			response.getOutputStream().write(files);
			response.getOutputStream().flush();
			response.getOutputStream().close();
		}
	}

	@RequestMapping(value = "/mypage/{userName}", method = RequestMethod.GET)
	public ModelAndView myPage(@PathVariable("userName") String userName) throws Exception {
		ModelAndView mv = new ModelAndView("/gametalk/mypage");

		GametalkUserDto users = gametalkService.myPage(userName);
		mv.addObject("users", users);

		return mv;
	}

	@RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
	public ModelAndView profileEdit(@PathVariable("userId") String userId) throws Exception {
		ModelAndView mv = new ModelAndView("/gametalk/profileEdit");

		GametalkUserDto users = gametalkService.profileEdit(userId);
		mv.addObject("users", users);

		return mv;
	}

	@RequestMapping(value = "/profile/{userId}/edit", method = RequestMethod.PUT)
	public String passwordEdit(@PathVariable("userId") String userId, GametalkUserDto users) throws Exception {

		gametalkService.passwordEdit(users);

		return "redirect:/profile/{userId}";
	}

	@RequestMapping(value = "/profile/{userId}/info", method = RequestMethod.PUT)
	public String infoEdit(@PathVariable("userId") String userId, GametalkUserDto users) throws Exception {
		gametalkService.infoEdit(users);

		return "redirect:/profile/{userId}";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signin() throws Exception {

		return "/gametalk/signin";
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String createUser(GametalkUserDto User) throws Exception {
		gametalkService.signinUser(User);

		return "redirect:/login";
	}
}
