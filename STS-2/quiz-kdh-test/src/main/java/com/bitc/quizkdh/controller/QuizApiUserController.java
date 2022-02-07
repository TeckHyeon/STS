package com.bitc.quizkdh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bitc.quizkdh.dto.QuizUserDto;
import com.bitc.quizkdh.service.QuizUserService;

@RestController
public class QuizApiUserController {

	@Autowired
	private QuizUserService quizUserService;

	@RequestMapping(value = "/api/userList", method = RequestMethod.GET)
	public List<QuizUserDto> quizUserList() throws Exception {

		return quizUserService.viewUserList();
	}

	@RequestMapping(value = "/api/userList/createUser", method = RequestMethod.POST)
	public void createUser(@RequestBody QuizUserDto quizUser) throws Exception {
		quizUserService.createUser(quizUser);

	}

	@RequestMapping(value = "/api/userList/{seq}", method = RequestMethod.GET)
	public QuizUserDto userDetails(@PathVariable("seq") int seq) throws Exception {

		return quizUserService.viewUserDetails(seq);

	}

	@RequestMapping(value = "/api/userList/edit/{seq}", method = RequestMethod.PUT)
	public String userEdit(@RequestBody QuizUserDto quizUser) throws Exception {
		quizUserService.EditUser(quizUser);

		return "redirect:/userList";
	}

	@RequestMapping(value = "/api/userList/delete/{seq}", method = RequestMethod.DELETE)
	public String boardDelete(@PathVariable("seq") int seq) throws Exception {
		quizUserService.deleteUser(seq);

		return "redirect:/userList";
	}
}
