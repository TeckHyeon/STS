package com.bitc.board.dto;

import java.util.List;

import lombok.Data;

@Data
public class BoardDto {
	private int idx;
	private String title;
	private String contents;
	private String creatorId;
	private String createdDate;
	private String updateId;
	private String updatedDate;
	private int hitCnt;
	private String passwd;
	private List<BoardFileDto> fileList;
}
