package com.project.shop.vo;

public class MemInfoVO {

	private String name; // 회원명
	private String id; // 아이디
	private String pw; // 비밀번호
	private String tel; // 전화번호
	private String email; // 이메일
	private String address; // 주소
	private String address2; // 주소
	private String address3; // 주소
	private String birth; // 생년월일
	private String gName; // 회원등급
	private int memPoint; // 등급포인트
	
	public MemInfoVO() {}
	
	public MemInfoVO(String id,String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	
	
	public MemInfoVO(String name, String id, String pw, String tel, String email, String address,String address2,String address3, String birth, String gName, int memPoint) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.tel = tel;
		this.email = email;
		this.address = address;
		this.address2 = address2;
		this.address3 = address3;
		this.birth = birth;
		this.gName = gName;
		this.memPoint = memPoint;
	}


	
	
	public String getAddress2() {
		return address2;
	}
	

	public String getAddress3() {
		return address3;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public void setAddress2(String adress2) {
		this.address2 = adress2;
	}
	public void setAddress3(String adress3) {
		this.address3 = adress3;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getgName() {
		return gName;
	}

	public void setgName(String gName) {
		this.gName = gName;
	}

	public int getMemPoint() {
		return memPoint;
	}

	public void setMemPoint(int memPoint) {
		this.memPoint = memPoint;
	}
	
}
