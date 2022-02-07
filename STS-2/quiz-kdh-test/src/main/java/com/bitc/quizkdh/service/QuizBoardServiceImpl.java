package com.bitc.quizkdh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitc.quizkdh.dto.QuizBoardDto;
import com.bitc.quizkdh.mapper.QuizBoardMapper;

@Service
public class QuizBoardServiceImpl implements QuizBoardService {

	@Autowired
	private QuizBoardMapper quizBoardMapper;

	@Override
	public List<QuizBoardDto> viewBoardList() throws Exception {
		
		return quizBoardMapper.viewBoardList();
	}

	@Override
	public void boardInsert(QuizBoardDto quizBoard) throws Exception {
		quizBoardMapper.boardInsert(quizBoard);
		
	}

	@Override
	public QuizBoardDto viewBoardDetails(int idx) throws Exception {
		quizBoardMapper.updateHitCnt(idx);
		return quizBoardMapper.viewBoardDetails(idx);
	}

	@Override
	public void boardEdit(QuizBoardDto quizBoard) throws Exception {
		quizBoardMapper.boardEdit(quizBoard);
	}

	@Override
	public void boardDelete(int idx) throws Exception {
		quizBoardMapper.boardDelete(idx);
	}
}
