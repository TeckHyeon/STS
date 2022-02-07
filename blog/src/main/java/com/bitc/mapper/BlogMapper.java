package com.bitc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.dto.BlogMainDto;
import com.bitc.dto.GuestBookDto;

@Mapper
public interface BlogMapper {

	void insertGuestBook(GuestBookDto guestBook) throws Exception;
	
	List<GuestBookDto> selectGuestList() throws Exception;

	List<BlogMainDto> selectBlogList() throws Exception;

	void insertBlog(BlogMainDto blogMain) throws Exception;

	GuestBookDto getContentByseq(GuestBookDto guestBookDto) throws Exception;

	void updateGuest(GuestBookDto guest) throws Exception;

	void deleteGuest(int seq) throws Exception;
}
