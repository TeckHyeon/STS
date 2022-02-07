package com.bitc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.dto.BlogMainDto;
import com.bitc.dto.GuestBookDto;
import com.bitc.mapper.BlogMapper;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogMapper blogMapper;
	
	@Override
	public void insertGuestBook(GuestBookDto guestBook) throws Exception {
		
		blogMapper.insertGuestBook(guestBook);
	}

	@Override
	public List<GuestBookDto> selectGuestList() throws Exception {
		// TODO Auto-generated method stub
		return blogMapper.selectGuestList();
	}

	@Override
	public List<BlogMainDto> selectBlogList() throws Exception {
		// TODO Auto-generated method stub
		return blogMapper.selectBlogList();
	}

	@Override
	public void insertBlog(BlogMainDto blogMain) throws Exception {
		 blogMapper.insertBlog(blogMain);
	}

	@Override
	public GuestBookDto getContentByseq(GuestBookDto guestBookDto) throws Exception {
		
		return blogMapper.getContentByseq(guestBookDto);
	}

	@Override
	public void updateGuest(GuestBookDto guest) throws Exception {
		blogMapper.updateGuest(guest);
	}

	@Override
	public void deleteGuest(int seq) throws Exception {
		blogMapper.deleteGuest(seq);
	}

}
