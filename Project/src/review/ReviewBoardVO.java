package review;

import java.util.Date;

public class ReviewBoardVO {

	// 상품후기
	private String mem_id;
	private String product_name;
	private String review;
	private Date regDate;
	
	public ReviewBoardVO(String mem_id, String product_name, String review, Date regDate) {
		this.mem_id = mem_id;
		this.product_name = product_name;
		this.review = review;
		this.regDate = regDate;
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

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	
	
}
