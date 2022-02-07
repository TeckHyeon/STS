package com.bitc.kdh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.kdh.entity.BoardEntity;
import com.bitc.kdh.repository.JpaBoardRepository;

@Service
public class JpaBoardServiceImpl implements JpaBoardService {

	@Autowired
	private JpaBoardRepository jpaBoardRepository;

	@Override
	public List<BoardEntity> SelectBoardList() throws Exception {
		// TODO Auto-generated method stub
		return jpaBoardRepository.SelectBoardList();
	}
	
}
