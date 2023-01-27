package com.project.shop.vo;

public class OrderDetailsVO {
	
	private int order_details_num; // 상세주문 번호
	private int order_num; // 주문번호
	private String product_name; // 상품명
	private int product_qty; // 상품수량
	private int order_price; // 결제한 상품금액(기존가격*등급할인/100)
	private String delivery_state;
	
	public OrderDetailsVO() {}
	
	public OrderDetailsVO(int order_details_num, int order_num, String product_name, int product_qty, int order_price, String delivery_state) {
		this.order_details_num = order_details_num;
		this.order_num = order_num;
		this.product_name = product_name;
		this.product_qty = product_qty;
		this.order_price = order_price;
		this.delivery_state = delivery_state;
	}

	public int getOrder_details_num() {
		return order_details_num;
	}

	public void setOrder_details_num(int order_details_num) {
		this.order_details_num = order_details_num;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_qty() {
		return product_qty;
	}

	public void setProduct_qty(int product_qty) {
		this.product_qty = product_qty;
	}

	public int getOrder_price() {
		return order_price;
	}

	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}

	public String getDelivery_state() {
		return delivery_state;
	}

	public void setDelivery_state(String delivery_state) {
		this.delivery_state = delivery_state;
	}
}
