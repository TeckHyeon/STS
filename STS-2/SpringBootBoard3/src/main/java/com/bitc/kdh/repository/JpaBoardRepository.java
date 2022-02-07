package com.bitc.kdh.repository;

import java.util.List;

import com.bitc.kdh.entity.BoardEntity;

public interface JpaBoardRepository {

	List<BoardEntity> SelectBoardList() throws Exception;

}
