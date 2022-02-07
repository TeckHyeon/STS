package com.bitc.quizkdh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.quizkdh.dto.QuizUserDto;
import com.bitc.quizkdh.mapper.QuizUserMapper;

@Service
public class QuizUserServiceImpl implements QuizUserService {
	
	@Autowired
	private QuizUserMapper quizUserMapper;

	@Override
	public List<QuizUserDto> viewUserList() throws Exception {
		// TODO Auto-generated method stub
		return quizUserMapper.viewUserList();
	}

	@Override
	public void createUser(QuizUserDto quizUser) throws Exception {
		quizUserMapper.createUser(quizUser);
		
	}

	@Override
	public QuizUserDto viewUserDetails(int seq) throws Exception {
		// TODO Auto-generated method stub
		return quizUserMapper.viewUserDetails(seq);
	}

	@Override
	public void EditUser(QuizUserDto quizUser) throws Exception {
		quizUserMapper.EditUser(quizUser);
		
	}

	@Override
	public void deleteUser(int seq) throws Exception {
		quizUserMapper.deleteUser(seq);
		
	}

	@Override
	public boolean checkPw(int seq, String userPw) throws Exception {
		// TODO Auto-generated method stub
		return quizUserMapper.checkPw(seq, userPw);
	}

}
