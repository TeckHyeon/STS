package com.bitc.thymleaf.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bitc.thymleaf.dto.MemberDto;

@Service
public class ThymeleafServiceimpl implements ThymeleafService {

	@Override
	public List<MemberDto> selectMemberList() throws Exception {
		List<MemberDto> memberList = createMemberList(5);
		return memberList;
	}
	
	private List<MemberDto> createMemberList(int count) {
		List<MemberDto> memberList = new ArrayList<MemberDto>();
		for (int i = 0; i < count; i++) {
			MemberDto member = new MemberDto();
			member.setUserId("tester" + (i+1));
			member.setUserPw("bitc1234");
			member.setUserName("테스터" + (i + 1));
			member.setUserEmail("tester" + (i + 1) + "@bitc.co.kr");
			
			memberList.add(member);
		}
		
		return memberList;
	}
}
