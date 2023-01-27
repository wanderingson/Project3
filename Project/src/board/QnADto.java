package board;

import java.sql.Timestamp;

public class QnADto {
	private int qnaId = 1;//, qnaHit = 0;
	private String qnaTitle, qnaContent, qnaCategory, id,qnaAnswer;
	private Timestamp qnaDate;
	
	public int getQnaId() {
		return qnaId;
	}
	public void setQnaId(int qnaId) {
		this.qnaId = qnaId;
	}
//	public int getQnaHit() {
//		return qnaHit;
//	}
//	public void setQnaHit(int qnaHit) {
//		this.qnaHit = qnaHit;
//	}
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BbsDto [bbsId=").append(qnaId).append(", qnaTitle=")
				.append(qnaTitle).append(", qnaContent=").append(qnaContent).append(", qnaCategory=")
				.append(qnaCategory).append(", qnaDate=").append(qnaDate).append(", id=").append(id).append("]");
		return builder.toString();
	}
	
}
