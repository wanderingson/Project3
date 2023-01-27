package db;

public class ProductVO {
	
	// 상품상세페이지 VO
	private int productnum;
	private String category_subName;
	private String product;
	private int price;
	private String descrip;
	
	
	
	public ProductVO(String product,int price,String descrip) {
		this.product = product;
		this.price = price;
		this.descrip = descrip;
	}
	
	public ProductVO(int productnum,String category_subName,String product,String descrip,int price) {
		
		this.productnum = productnum;
		this.category_subName = category_subName;
		this.product = product;
		this.price = price;
		this.descrip = descrip;
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
