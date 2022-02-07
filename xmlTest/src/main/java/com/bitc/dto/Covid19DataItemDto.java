package com.bitc.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="item")
public class Covid19DataItemDto {

	private String accExamCnt;
	private String createDt;
	private String deathCnt;
	private String decideCnt;
	private String seq;
	private String stateDt;
	private String stateTime;
	private String updateDt;
	
	@XmlElement
	public String getAccExamCnt() {
		return accExamCnt;
	}
	public void setAccExamCnt(String accExamCnt) {
		this.accExamCnt = accExamCnt;
	}
	public String getCreateDt() {
		return createDt;
	}
	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}
	public String getDeathCnt() {
		return deathCnt;
	}
	public void setDeathCnt(String deathCnt) {
		this.deathCnt = deathCnt;
	}
	public String getDecideCnt() {
		return decideCnt;
	}
	public void setDecideCnt(String decideCnt) {
		this.decideCnt = decideCnt;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getStateDt() {
		return stateDt;
	}
	public void setStateDt(String stateDt) {
		this.stateDt = stateDt;
	}
	public String getStateTime() {
		return stateTime;
	}
	public void setStateTime(String stateTime) {
		this.stateTime = stateTime;
	}
	public String getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(String updateDt) {
		this.updateDt = updateDt;
	}
	
	
}
