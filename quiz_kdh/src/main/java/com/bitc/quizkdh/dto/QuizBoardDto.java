package com.bitc.quizkdh.dto;

import lombok.Data;

@Data
public class QuizBoardDto {
	private int idx;
	private String title;
	private String contents;
	private String creatorId;
	private String createdDt;
	private String updatorId;
	private String updatedDt;
	private String hitCnt;
	private String deletedYn;
	
}
