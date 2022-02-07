package com.bitc.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bitc.board.dto.BoardDto;
import com.bitc.board.dto.BoardFileDto;
import com.github.pagehelper.Page;

@Mapper
public interface BoardMapper {

	List<BoardDto> selectBoardList() throws Exception;

	void insertBoard(BoardDto board) throws Exception;

	BoardDto selectBoardDetail(int idx) throws Exception;

	void deleteBoard(int idx) throws Exception;
	
	void updateBoard(BoardDto board) throws Exception;

	void updateHitCnt(int idx) throws Exception;

	void insertBoardFileList(List<BoardFileDto> list) throws Exception;
	
	List<BoardFileDto> selectBoardFileList(@Param("idx") int idx) throws Exception;
	
	BoardFileDto selectBoardFileInfo(@Param("fileIdx") int fileIdx, @Param("boardIdx") int boardIdx);

	Page<BoardDto> pagingBoardList() throws Exception;
}
