package com.bitc.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="body")
public class PharmacyFullDataBodyDto {

	private int numOfRows;
	private int pageNo;
	private int totalCOunt;
	private PharmacyFullDataItemsDto items;
	
	@XmlElement
	public int getNumOfRows() {
		return numOfRows;
	}
	public void setNumOfRows(int numOfRows) {
		this.numOfRows = numOfRows;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalCOunt() {
		return totalCOunt;
	}
	public void setTotalCOunt(int totalCOunt) {
		this.totalCOunt = totalCOunt;
	}
	@XmlElement(name="items")
	public PharmacyFullDataItemsDto getItems() {
		return items;
	}
	public void setItems(PharmacyFullDataItemsDto items) {
		this.items = items;
	}
	
}
