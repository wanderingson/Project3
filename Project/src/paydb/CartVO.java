package paydb;

public class CartVO {
	
	private String mem_id; // 회원아이디
	private String product_name; // 상품이름
	private int product_qty; // 장바구니에 담은 상품 수량
	// 조인을 통해 가져올 정보
	private int product_price; // 상품가격
	
	public CartVO() {}
	
	public CartVO(String mem_id, String product_name, int product_qty, int product_price) {
		this.mem_id = mem_id;
		this.product_name = product_name;
		this.product_qty = product_qty;
		this.product_price = product_price;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
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

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	
	
	
	
}
