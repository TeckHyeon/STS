package com.bitc.kdh.service;

import java.util.List;

import com.bitc.kdh.entity.BoardEntity;

public interface JpaBoardService {

	List<BoardEntity> SelectBoardList() throws Exception;


}
