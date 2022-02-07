package com.bitc.service;

import com.bitc.dto.MemberDto;

public interface LoginService {

	int selectMemberInfoYn(String userId, String userPw) throws Exception;

	MemberDto checkLoginInfoYn(String userId) throws Exception;

}
