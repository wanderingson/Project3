package db;

public class SearchVO {
	
	private String img_url;
	private String prdName ;
	private int prdPrice;
	
	public SearchVO() {}
	
	public SearchVO(String prdName,int prdPrice) {
		this.prdName=prdName; 
		this.prdPrice=prdPrice;
		
	}

	
	

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	

	public int getPrdPrice() {
		return prdPrice;
	}

	public void setPrdPrice(int prdPrice) {
		this.prdPrice = prdPrice;
	}
	
	
	
	
}

