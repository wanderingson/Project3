package com.project.shop.vo;

import java.sql.Timestamp;

public class QnAVO {
	private int qnaId = 1;//, qnaHit = 0;
	private String qnaTitle, qnaContent, qnaCategory, memId,qnaAnswer;
	private Timestamp qnaDate;
	
	public int getQnaId() {
		return qnaId;
	}
	public void setQnaId(int qnaId) {
		this.qnaId = qnaId;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaAnswer() {
		return qnaAnswer;
	}
	public void setQnaAnswer(String qnaAnswer) {
		this.qnaAnswer = qnaAnswer;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public String getQnaCategory() {
		return qnaCategory;
	}
	public void setQnaCategory(String qnaCategory) {
		this.qnaCategory = qnaCategory;
	}
	public Timestamp getQnaDate() {
		return qnaDate;
	}
	public void setQnaDate(Timestamp qnaDate) {
		this.qnaDate = qnaDate;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemid(String memId) {
		this.memId = memId;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BbsDto [bbsId=").append(qnaId).append(", qnaTitle=")
				.append(qnaTitle).append(", qnaContent=").append(qnaContent).append(", qnaCategory=")
				.append(qnaCategory).append(", qnaDate=").append(qnaDate).append(", id=").append(memId).append("]");
		return builder.toString();
	}
	
}
