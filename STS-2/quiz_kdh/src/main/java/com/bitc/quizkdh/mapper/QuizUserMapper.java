package com.bitc.quizkdh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.quizkdh.dto.QuizUserDto;

@Mapper
public interface QuizUserMapper {

	public List<QuizUserDto> viewUserList() throws Exception;

	public void createUser(QuizUserDto quizUser) throws Exception;

	public QuizUserDto viewUserDetails(int seq) throws Exception;

	public void EditUser(QuizUserDto quizUser) throws Exception;

	public void deleteUser(int seq) throws Exception;

	public boolean checkPw(int seq, String userPw) throws Exception;

}
