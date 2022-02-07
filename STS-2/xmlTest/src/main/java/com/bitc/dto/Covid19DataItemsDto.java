package com.bitc.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="items")
public class Covid19DataItemsDto {

	private List<Covid19DataItemDto> itemList;

	@XmlElement(name="item")
	public List<Covid19DataItemDto> getItemList() {
		return itemList;
	}

	public void setItemList(List<Covid19DataItemDto> itemList) {
		this.itemList = itemList;
	}
	
	
}
