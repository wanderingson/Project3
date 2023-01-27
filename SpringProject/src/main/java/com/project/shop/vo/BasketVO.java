package com.project.shop.vo;

public class BasketVO {
	
	// 장바구니 VO
	
	private String name;
	private int price1;
	private int num;
	
	public BasketVO(String name,int price1,int num) {
		  this.name = name;
		  this.price1 = price1;
		  this.num = num;
		}
	
	public BasketVO(String name) {
		this.name = name;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice1() {
		return price1;
	}

	public void setPrice1(int price1) {
		this.price1 = price1;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
	
	
	
	
	
	

}
