package com.bitc.thymleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.thymleaf.dto.MemberDto;
import com.bitc.thymleaf.service.ThymeleafService;

@Controller
public class ThymeleafController {

	@Autowired
	private ThymeleafService service;

	@RequestMapping("/")
	public String index() throws Exception {
		return "index";
	}

	@RequestMapping("/test1")
	public String test1(Model model) throws Exception {
		List<MemberDto> members = service.selectMemberList();

		model.addAttribute("value1", "값 1");
		model.addAttribute("value2", "값 2");
		model.addAttribute("members", members);
		model.addAttribute("active", false);
		
		return "test1";
	}
	@RequestMapping("/test2")
	public ModelAndView test2() throws Exception {
		MemberDto member = new MemberDto();
		member.setUserId("test1");
		member.setUserPw("bitc1234");
		member.setUserName("테스트1");
		member.setUserEmail("test1@bitc.co.kr");
		
		ModelAndView mv = new ModelAndView("/test2");
		mv.addObject("member", member);

		return mv;
	}
	@RequestMapping("/test3")
	public ModelAndView test3() throws Exception {
		ModelAndView mv = new ModelAndView("/test3");
		
		List<MemberDto> members = service.selectMemberList();
		
		mv.addObject("members",members);
		
		return mv;
	}
	
	@RequestMapping("/basicLayout")
	public String basicLayout() throws Exception {
		return "basicLayout";
	}
	@RequestMapping("/includeLayout")
	public String includeLayout() throws Exception {
		return "includeLayout";
	}
	@RequestMapping("/layoutTest")
	public String layoutTest() throws Exception {
		return "layoutTest";
	}
}
