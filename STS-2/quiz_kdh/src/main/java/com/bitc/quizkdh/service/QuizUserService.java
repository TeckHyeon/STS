package com.bitc.quizkdh.service;

import java.util.List;

import com.bitc.quizkdh.dto.QuizUserDto;

public interface QuizUserService {

	List<QuizUserDto> viewUserList() throws Exception;

	void createUser(QuizUserDto quizUser) throws Exception;

	QuizUserDto viewUserDetails(int seq) throws Exception;

	void EditUser(QuizUserDto quizUser) throws Exception;

	void deleteUser(int seq) throws Exception;

	boolean checkPw(int seq, String userPw) throws Exception;

}
