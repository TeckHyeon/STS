package com.bitc.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.board.dto.personDto;

@Controller
public class PersonController {
// @Controller 어노테이션을 해당 매서드에 반환타입을 String으로 지정했을 경우 템플릿의 위치를 지정한 것으로 간주함
	@RequestMapping("/person/signin")
	public String signin() throws Exception {
		return "person/signin";
	}
	
	@RequestMapping("/person/signin.do")
	public String inputPage() {
		return "person/signin";
	}

	@RequestMapping("/person/signinProcess.do")
	public ModelAndView inputPageProcess(personDto dto) {
		ModelAndView mv = new ModelAndView("/person/signinProcess");

		mv.addObject("data", dto);

		return mv;
	}

	@RequestMapping("/person/signinProcess2.do")
	public ModelAndView inputPageProcess(@RequestParam("idx") int idx, @RequestParam("userName") String userName,
			@RequestParam("userAge") int userAge, @RequestParam("userId") String userId, @RequestParam("userPw") String userPw,
			@RequestParam("userEmail") String userEmail) {
		ModelAndView mv = new ModelAndView("/person/signinProcess2");

		mv.addObject("idx", idx);
		mv.addObject("userName", userName);
		mv.addObject("userAge", userAge);
		mv.addObject("userId", userId);
		mv.addObject("userPw", userPw);
		mv.addObject("userEmail", userEmail);
		

		return mv;
	}
}
