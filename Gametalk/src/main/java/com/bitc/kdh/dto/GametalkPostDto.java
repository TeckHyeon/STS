package com.bitc.kdh.dto;

import java.util.List;

import lombok.Data;

@Data
public class GametalkPostDto {
	private int postIdx;
	private String postId;
	private String postName;
	private String postTitle;
	private String postContents;
	private String postLikes;
	private String userCreatedDate;
	private String userUpdatedDate;
	private String deletedYn;
	List<GametalkPostFileDto> files;
	 
}
