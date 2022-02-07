package com.bitc.quizkdh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.quizkdh.dto.QuizUserDto;
import com.bitc.quizkdh.service.QuizUserService;

@Controller
public class QuizUserController {

	@Autowired
	private QuizUserService quizUserService;

	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public ModelAndView quizUserList() throws Exception {
		ModelAndView mv = new ModelAndView("/quiz2/userList");
		List<QuizUserDto> userList = quizUserService.viewUserList();
		mv.addObject("userList", userList);

		return mv;
	}

	@RequestMapping(value = "/userList/createUser", method = RequestMethod.GET)
	public String addUser() throws Exception {
		return "/quiz2/createUser";
	}

	@RequestMapping(value = "/userList/createUser", method = RequestMethod.POST)
	public String createUser(QuizUserDto quizUser) throws Exception {
		quizUserService.createUser(quizUser);

		return "redirect:/userList";
	}

	@RequestMapping(value = "/userList/{seq}", method = RequestMethod.GET)
	public ModelAndView userDetails(@PathVariable("seq") int seq) throws Exception {
		ModelAndView mv = new ModelAndView("/quiz2/userDetails");
		QuizUserDto quizUser = quizUserService.viewUserDetails(seq);
		mv.addObject("quizUser", quizUser);
		return mv;

	}

	@RequestMapping(value = "/userList/{seq}", method = RequestMethod.PUT)
	public String userEdit(@RequestBody QuizUserDto quizUser) throws Exception {
		quizUserService.EditUser(quizUser);

		return "redirect:/userList";
	}

	@RequestMapping(value = "/userList/{seq}", method = RequestMethod.DELETE)
	public String boardDelete(@PathVariable("seq") int seq) throws Exception {
		quizUserService.deleteUser(seq);

		return "redirect:/userList";
	}
}
