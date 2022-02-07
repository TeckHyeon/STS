package com.bitc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitc.dto.MemberDto;
import com.bitc.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/")
	public String index() throws Exception {
		return "index";
	}
	
	@RequestMapping(value = "/login/login", method=RequestMethod.GET)
	public String login() throws Exception {
		
		return "/login/login";
	}
	
	@RequestMapping(value = "/login/loginCheck", method = RequestMethod.POST)
	public String loginCheck(MemberDto member, HttpServletRequest request) throws Exception {
		
		int count = loginService.selectMemberInfoYn(member.getUserId(), member.getUserPw());
		
		if (count ==1) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", member.getUserId());
			session.setMaxInactiveInterval(30);
			
			return "redirect:/login/loginOK";
		}
		else {
			return "redirect:/login/loginFail";
		}
		
	}
	
	@RequestMapping(value = "/login/loginOK", method = RequestMethod.GET)
	public String loginOK(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("userId")!=null) {
			return "/login/loginOK";
		}
		else {
			return "/login/loginFail";
		}
		
	}
	
	@RequestMapping(value = "/login/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.invalidate();
		
		return "/login/logout";
	}
	@RequestMapping(value = "/login/loginFail", method = RequestMethod.GET)
	public String loginFail() throws Exception {
		return "/login/loginFail";
	}
}
