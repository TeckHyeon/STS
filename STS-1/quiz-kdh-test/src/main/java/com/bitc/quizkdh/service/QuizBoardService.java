package com.bitc.quizkdh.service;

import java.util.List;

import com.bitc.quizkdh.dto.QuizBoardDto;

public interface QuizBoardService {

	List<QuizBoardDto> viewBoardList() throws Exception;

	void boardInsert(QuizBoardDto quizBoard) throws Exception;

	QuizBoardDto viewBoardDetails(int idx) throws Exception;

	void boardEdit(QuizBoardDto quizBoard) throws Exception;

	void boardDelete(int idx) throws Exception;

}
