package com.project.shop.vo;

public class GradeVO {
	
	private String gName;
	private int dcPercent;
	private int startPoint;
	private int endPoint;
	
	public GradeVO() {}
	
	public GradeVO(String gName, int dcPercent, int startPoint, int endPoint) {
		this.gName = gName;
		this.dcPercent = dcPercent;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public int getDcPercent() {
		return dcPercent;
	}

	public void setDcPercent(int dcPercent) {
		this.dcPercent = dcPercent;
	}

	public int getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(int startPoint) {
		this.startPoint = startPoint;
	}

	public int getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(int endPoint) {
		this.endPoint = endPoint;
	}
	
	

}
