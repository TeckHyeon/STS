package com.bitc.service;

import java.util.List;

import com.bitc.dto.BlogMainDto;
import com.bitc.dto.GuestBookDto;

public interface BlogService {

	void insertGuestBook(GuestBookDto guestBook) throws Exception;

	List<GuestBookDto> selectGuestList() throws Exception;

	List<BlogMainDto> selectBlogList() throws Exception;

	void insertBlog(BlogMainDto blogMain) throws Exception;

	GuestBookDto getContentByseq(GuestBookDto guestBookDto) throws Exception;

	void updateGuest(GuestBookDto guest) throws Exception;

	void deleteGuest(int seq) throws Exception;

}
