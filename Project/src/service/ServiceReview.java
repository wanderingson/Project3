package service;



import javax.naming.NamingException;


import review.ReviewBoardDAO;



public class ServiceReview{


	public int insert(String id, String prdname,String review) throws NamingException, Exception {
		
		ReviewBoardDAO rbdao = new ReviewBoardDAO();
		rbdao.insert_review(id, prdname, review);
		
		return 1;
		
	}

}
