package com.project.shop.vo;

import java.util.Date;

public class OrderVO {
	
	private int order_num; // 주문번호
	private String mem_id; // 회원아이디
	private String address1; // 우편번호
	private String address2; // 주소
	private String address3; // 상세주소
	private String tel; // 전화번호
	private int total_price; // 총 결제금액
	private String delivery_state; // 배송상태 (ex 1:주문확인, 2:배송완료 , 3:환불)
	private Date order_date; // 주문날짜
	private String delivery_message; // 배송시 요청사항
	
	public OrderVO() {}
	
	public OrderVO(int order_num, String mem_id, String address1, String address2, String address3, 
			String tel, int total_price, String delivery_state, Date order_date, String delivery_message) {
		
		this.order_num = order_num;
		this.mem_id = mem_id;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.tel = tel;
		this.total_price = total_price;
		this.delivery_state = delivery_state;
		this.order_date = order_date;
		this.delivery_message = delivery_message;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getDelivery_state() {
		return delivery_state;
	}

	public void setDelivery_state(String delivery_state) {
		this.delivery_state = delivery_state;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getDelivery_message() {
		return delivery_message;
	}

	public void setDelivery_message(String delivery_message) {
		this.delivery_message = delivery_message;
	}
}
