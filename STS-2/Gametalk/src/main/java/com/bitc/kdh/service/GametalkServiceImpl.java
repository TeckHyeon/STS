package com.bitc.kdh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bitc.kdh.common.PostFiles;
import com.bitc.kdh.dto.GametalkPostDto;
import com.bitc.kdh.dto.GametalkPostFileDto;
import com.bitc.kdh.dto.GametalkUserDto;
import com.bitc.kdh.dto.GametalkfollowDto;
import com.bitc.kdh.mapper.GametalkMapper;

@Service
public class GametalkServiceImpl implements GametalkService {

	@Autowired
	private GametalkMapper gametalkMapper;

	@Autowired
	private PostFiles postFiles;

	@Override
	public void signinUser(GametalkUserDto user) throws Exception {
		gametalkMapper.signinUser(user);
	}

	@Override
	public int selectMemberInfoYn(String userId, String userPw) throws Exception {

		return gametalkMapper.selectMemberInfoYn(userId, userPw);
	}

	@Override
	public GametalkUserDto userLogin(GametalkUserDto userdto) throws Exception {

		return gametalkMapper.selectUser(userdto);
	}

	@Override
	public List<GametalkPostDto> viewPost(String userId) throws Exception {
		List<GametalkPostDto> posts = gametalkMapper.viewPost(userId);

		return posts;

	}

	@Override
	public List<GametalkfollowDto> loadfollow(String userId) throws Exception {
		// TODO Auto-generated method stub
		return gametalkMapper.loadfollow(userId);
	}

	@Override
	public void createPost(GametalkPostDto posts, MultipartHttpServletRequest multiFiles) throws Exception {
		gametalkMapper.createPost(posts);

		List<GametalkPostFileDto> list = postFiles.parseFileInfo(posts.getPostIdx(), multiFiles);

		if (CollectionUtils.isEmpty(list) == false) {
			gametalkMapper.createPostFileList(list);
		}
	}

	@Override
	public GametalkUserDto loadUsers(String userId) throws Exception {
		return gametalkMapper.loadUsers(userId);

	}

	@Override
	public GametalkUserDto myPage(String userName) throws Exception {

		return gametalkMapper.myPage(userName);
	}

	@Override
	public GametalkUserDto profileEdit(String userId) throws Exception {
		// TODO Auto-generated method stub
		return gametalkMapper.profileEdit(userId);
	}

	@Override
	public void passwordEdit(GametalkUserDto users) throws Exception {
		gametalkMapper.passwordEdit(users);

	}

	@Override
	public void infoEdit(GametalkUserDto users) throws Exception {
		gametalkMapper.infoEdit(users);

	}

	@Override
	public GametalkPostFileDto postFileInfo(int postfileIdx, int postIdx) throws Exception {
		return gametalkMapper.postFileInfo(postfileIdx, postIdx);
	}

	@Override
	public List<GametalkPostFileDto> viewPostFileList(int postIdx) throws Exception {

		return gametalkMapper.viewPostFileList(postIdx);
	}

}
