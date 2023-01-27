package db;

public class PReviewVO {
	
	private String id;
	private String review;
	private String date1;
	
	
	public PReviewVO(String id,String review,String date1) {
		this.id = id;
		this.review = review;
		this.date1 = date1;
	}
	
	public PReviewVO() {}

	
	
	
	public String getDate1() {
		return date1;
	}

	public String getId() {
		return id;
	}

	public String getReview() {
		return review;
	}
	
	
	
	

}
