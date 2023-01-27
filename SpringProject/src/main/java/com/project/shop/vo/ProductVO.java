package com.project.shop.vo;

public class ProductVO {
	
	// 상품상세페이지 VO
	private int productnum;
	private String category_subName;
	private String product;
	private int price;
	private String descrip;
	private int count;
	
	
	

	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
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


	public String getDescrip() {
		return descrip;
	}


	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}


	public int getProductnum() {
		return productnum;
	}


	public void setProductnum(int productnum) {
		this.productnum = productnum;
	}


	public String getCategory_subName() {
		return category_subName;
	}


	public void setCategory_subName(String category_subName) {
		this.category_subName = category_subName;
	}
	
	
}
