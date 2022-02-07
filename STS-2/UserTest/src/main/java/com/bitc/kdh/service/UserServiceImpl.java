package com.bitc.kdh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.kdh.dto.UserDto;
import com.bitc.kdh.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserMapper userMapper;
	
	@Override
	public List<UserDto> selectUserList() throws Exception {
		
		return userMapper.selectUserList();
	}
	@Override
	public void insertUser(UserDto user) throws Exception {
		userMapper.insertUser(user);
	}
	
	@Override
	public UserDto selectUserDetail(int seq) throws Exception {
		
		UserDto user = userMapper.selectUserDetail(seq);
		return user;
	}
	
	@Override
	public void deleteUser(int seq) throws Exception {
		userMapper.deleteUser(seq);
	}
	@Override
	public void updateUser(UserDto user) throws Exception {
		userMapper.updateUser(user);
	}
}
