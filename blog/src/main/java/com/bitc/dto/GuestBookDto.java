package com.bitc.dto;

import lombok.Data;

@Data
public class GuestBookDto {
	private int seq;
	private String guestName;
	private String guestPw;
	private String guestContents;
	private String guestCreatedDt;
	private String deletedYn;
	
}
