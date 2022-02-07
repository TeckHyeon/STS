package com.bitc.kdh.service;

import java.util.List;

import com.bitc.kdh.dto.UserDto;

public interface UserService {

	List<UserDto> selectUserList() throws Exception;
	
	void insertUser(UserDto user) throws Exception;
	
	UserDto selectUserDetail(int seq) throws Exception;

	void deleteUser(int seq) throws Exception;

	void updateUser(UserDto user) throws Exception;
}
