package com.bitc.board.dto;

import lombok.Data;

// t_file 테이블과 연동되는 DTO 클래스
@Data
public class BoardFileDto {

	private int fileIdx;
	private int boardIdx;
	private String originalFileName;
	private String storedFilePath;
	private String fileSize;
}
