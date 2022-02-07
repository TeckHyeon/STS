package com.bitc.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class Covid19DataDto {

	private Covid19DataHeaderDto header;
	private Covid19DataBodyDto body;
		
	@XmlElement(name="header")
	public Covid19DataHeaderDto getHeader() {
		return header;
	}
	public void setHeader(Covid19DataHeaderDto header) {
		this.header = header;
	}
	@XmlElement(name="body")
	public Covid19DataBodyDto getBody() {
		return body;
	}
	public void setBody(Covid19DataBodyDto body) {
		this.body = body;
	}
}
