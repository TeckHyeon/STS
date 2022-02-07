package com.bitc.kdh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.kdh.dto.UserDto;

@Mapper
public interface UserMapper {

	List<UserDto> selectUserList() throws Exception;

	void insertUser(UserDto user) throws Exception;

	UserDto selectUserDetail(int seq) throws Exception;

	void deleteUser(int seq) throws Exception;

	void updateUser(UserDto user) throws Exception;
}
