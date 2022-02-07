package com.bitc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.dto.BlogMainDto;
import com.bitc.dto.GuestBookDto;
import com.bitc.dto.MemberDto;
import com.bitc.service.BlogService;
import com.bitc.service.LoginService;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/blog/main")
	public ModelAndView main() throws Exception {
		ModelAndView mv = new ModelAndView("/blog/main");
		List<BlogMainDto> blogList = blogService.selectBlogList();
		mv.addObject("blogList", blogList);

		return mv;
	}

	@RequestMapping(value = "/blog/guestBook", method = RequestMethod.GET)
	public ModelAndView guestBook() throws Exception {
		ModelAndView mv = new ModelAndView("/blog/guestBook");

		List<GuestBookDto> guestList = blogService.selectGuestList();
		mv.addObject("guestList", guestList);
		return mv;
	}
	
	
	@RequestMapping(value = "/blog/guestBook", method = RequestMethod.POST)
	public String insertGuestBook(GuestBookDto guestBook) throws Exception {

		blogService.insertGuestBook(guestBook);
		return "redirect:/blog/guestBook";
	}

	@RequestMapping(value="/blog/updateGuest/{seq}", method=RequestMethod.PUT)
	public String updateGuest(GuestBookDto guest) throws Exception {
		
		blogService.updateGuest(guest);
		
		return "redirect:/blog/guestBook";
	}
	
	@RequestMapping(value="/blog/guestBook/{seq}", method=RequestMethod.DELETE)
	public String deleteGuest(@RequestParam("seq") int seq) throws Exception {

		blogService.deleteGuest(seq);

		return "redirect:/blog/guestBook";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/blog/guestBook1", method = RequestMethod.GET)
	public GuestBookDto getPassword(@RequestParam("seq") int seq, @RequestParam("guestPw") String guestPw, Model model)
			throws Exception {
		GuestBookDto guestBookDto = new GuestBookDto();
		guestBookDto.setSeq(seq);
		GuestBookDto result = blogService.getContentByseq(guestBookDto);
		return result;
	}

	@RequestMapping(value = "/blog/write", method = RequestMethod.GET)
	public String writeBlog() throws Exception {
		return "/blog/write";
	}

	@RequestMapping(value = "/blog/write", method = RequestMethod.POST)
	public String insertBlog(BlogMainDto blogMain) throws Exception {
		
		blogService.insertBlog(blogMain);
		
		return "redirect:/blog/main";

	}

	@RequestMapping(value = "/blog/blogHeader")
	public String header(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.getAttribute("userId");
		return "/blog/main";
	}

	@RequestMapping(value = "/blog/login", method = RequestMethod.GET)
	public String login() throws Exception {

		return "/blog/login";
	}

	@RequestMapping(value = "/blog/loginCheck", method = RequestMethod.POST)
	public String loginCheck(MemberDto member, HttpServletRequest request) throws Exception {

		int count = loginService.selectMemberInfoYn(member.getUserId(), member.getUserPw());

		if (count == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", member.getUserId());
			session.setMaxInactiveInterval(30);

			return "redirect:/blog/main";
		} else {
			return "redirect:/blog/loginFail";
		}

	}

	@RequestMapping(value = "/blog/loginOK", method = RequestMethod.GET)
	public String loginOK(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();

		if (session.getAttribute("userId") != null) {

			return "/blog/loginOK";
		} else {
			return "/blog/loginFail";
		}

	}

	@RequestMapping(value = "/blog/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.invalidate();

		return "/blog/logout";
	}

	@RequestMapping(value = "/blog/loginFail", method = RequestMethod.GET)
	public String loginFail() throws Exception {
		return "/blog/loginFail";
	}
}
