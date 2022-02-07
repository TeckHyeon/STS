package com.bitc.quizkdh.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bitc.quizkdh.dto.QuizBoardDto;

@Mapper
public interface QuizBoardMapper {

	public List<QuizBoardDto> viewBoardList() throws Exception;

	public void boardInsert(QuizBoardDto quizBoard) throws Exception;

	public QuizBoardDto viewBoardDetails(int idx) throws Exception;

	public void boardEdit(QuizBoardDto quizBoard) throws Exception;

	public void boardDelete(int idx) throws Exception;

	public void updateHitCnt(int idx) throws Exception;

}
