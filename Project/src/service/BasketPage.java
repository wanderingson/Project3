package service;

import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.BasketDAO;
import db.BasketVO;

public class BasketPage implements ServiceImpl {
	
	private String id;
	
	public BasketPage(String id) {
		this.id = id;
	}
	
	
	@Override
	public void revise(HttpServletRequest request, HttpServletResponse response) throws NamingException, Exception {
		
		BasketDAO dao = new BasketDAO();
		
		ArrayList<BasketVO> vo = dao.getCartList(id);
	
		
		request.setAttribute("AllBasket", vo);
		
	}
}
