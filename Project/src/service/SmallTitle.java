package service;

import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CategoryDAO;
import db.CategoryVO;

public class SmallTitle implements ServiceImpl {
	
	private String title;
	
	public SmallTitle(String title) {
		this.title = title;
	}
	
	public SmallTitle() {}
	
	@Override
	public void revise(HttpServletRequest request, HttpServletResponse response) throws NamingException, Exception {
		
		CategoryDAO small = new CategoryDAO();
		small.setSmall(title);
		ArrayList<CategoryVO> small1 = small.AllSmallCategoryGet();
		
		request.setAttribute("smalltitle", small1);
		
	}
	
}
