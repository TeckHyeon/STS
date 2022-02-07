package com.bitc.kdh.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitc.kdh.dto.GametalkPostDto;
import com.bitc.kdh.dto.GametalkPostFileDto;
import com.bitc.kdh.dto.GametalkUserDto;
import com.bitc.kdh.dto.GametalkfollowDto;

public interface GametalkService {

	void signinUser(GametalkUserDto user) throws Exception;

	int selectMemberInfoYn(String userId, String userPw) throws Exception;

	GametalkUserDto userLogin(GametalkUserDto userdto) throws Exception;

	List<GametalkPostDto> viewPost(String userId) throws Exception;

	void createPost(GametalkPostDto posts, MultipartHttpServletRequest multiFiles) throws Exception;

	GametalkUserDto loadUsers(String userId) throws Exception;

	GametalkUserDto myPage(String userName) throws Exception;

	GametalkUserDto profileEdit(String userId) throws Exception;

	void passwordEdit(GametalkUserDto users) throws Exception;

	void infoEdit(GametalkUserDto users) throws Exception;

	GametalkPostFileDto postFileInfo(int postfileIdx, int postIdx) throws Exception;

	List<GametalkfollowDto> loadfollow(String userId) throws Exception;

	List<GametalkPostFileDto> viewPostFileList(int postIdx) throws Exception;
 
}
