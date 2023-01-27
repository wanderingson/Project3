package com.project.shop.vo;

public class CartVO {
	// 장바구니 VO
	
		private String name;
		private String id;
		private int price1;
		private int num;
		
		public CartVO(String id,String name,int num) {
			  this.name = name;
			  this.id = id;
			  this.num = num;
			}
		
		public CartVO(String name) {
			this.name = name;
		}
		public CartVO() {}
		
		
		

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
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
