package com.project.shop.vo;

import java.sql.Timestamp;

public class BbsVO {
	private int bbsId = 1, bbsHit = 0;
	private String bbsTitle, bbsContent, bbsCategory, memID;
	private Timestamp bbsDate;
	
	public BbsVO () {}
	
	public int getBbsId() {
		return bbsId;
	}
	public void setBbsId(int bbsId) {
		this.bbsId = bbsId;
	}
	public int getBbsHit() {
		return bbsHit;
	}
	public void setBbsHit(int bbsHit) {
		this.bbsHit = bbsHit;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}
	public String getBbsCategory() {
		return bbsCategory;
	}
	public void setBbsCategory(String bbsCategory) {
		this.bbsCategory = bbsCategory;
	}
	public Timestamp getBbsDate() {
		return bbsDate;
	}
	public void setBbsDate(Timestamp bbsDate) {
		this.bbsDate = bbsDate;
	}
	public String getMemID() {
		return memID;
	}
	public void setMemID(String memID) {
		this.memID = memID;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BbsDto [bbsId=").append(bbsId).append(", bbsHit=").append(bbsHit).append(", bbsTitle=")
				.append(bbsTitle).append(", bbsContent=").append(bbsContent).append(", bbsCategory=")
				.append(bbsCategory).append(", bbsDate=").append(bbsDate).append(", id=").append(memID).append("]");
		return builder.toString();
	}
	
}
