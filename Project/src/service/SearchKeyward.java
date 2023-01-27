package service;

import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CategoryDAO;
import db.CategoryVO;


public class SearchKeyward implements ServiceImpl{

	@Override
	public void revise(HttpServletRequest request, HttpServletResponse response) throws NamingException, Exception {
		// TODO Auto-generated method stub 
		String search = request.getParameter("search");

		CategoryDAO cd = new CategoryDAO();
		
		
//		ArrayList<CategoryVO> cv1 = cd.Searchkey(search);
		
//		request.setAttribute("cv1",cv1 );	 	
		
	}
	
}
 