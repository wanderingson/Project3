package com.project.shop.vo;

public class CategoryVO {
	
//	대분류 상품 이름 가격 VO
	
	private String product;
	private int price;

	
	
	public CategoryVO(String product, int price) {
		this.product = product;
		this.price = price;
	}
	
	
	public CategoryVO() {
	
	}
	
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	
	
	
}
