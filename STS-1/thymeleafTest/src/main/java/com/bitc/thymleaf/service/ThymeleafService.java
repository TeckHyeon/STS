package com.bitc.thymleaf.service;

import java.util.List;

import com.bitc.thymleaf.dto.MemberDto;

public interface ThymeleafService {

	List<MemberDto> selectMemberList() throws Exception;
}
