package service;

import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.PReviewVO;
import db.ProductDAO;
import db.ProductVO;

public class ProductPage implements ServiceImpl {
	
	private String product;
	
	public ProductPage(String product) {
		this.product = product;
	}
	
	@Override
	public void revise(HttpServletRequest request, HttpServletResponse response) throws NamingException, Exception {
	
		ProductDAO dao = new ProductDAO();
		
		ProductVO vo = dao.ProductAll(product); 
		
		String name = vo.getProduct();
		int price = vo.getPrice();
		String descrip = vo.getDescrip();
	

		ArrayList<PReviewVO> re = dao.ProductReview(product);
		
		
		request.setAttribute("name", name);
		request.setAttribute("price", price);
		request.setAttribute("des", descrip);
		request.setAttribute("review", re);
		
	}
}
