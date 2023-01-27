package service;

import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ProductDAO;
import db.ProductVO;

public class NewAll implements ServiceImpl{

	@Override
	public void revise(HttpServletRequest request, HttpServletResponse response) throws NamingException, Exception {
		// TODO Auto-generated method stub
		
		ProductDAO pd = new ProductDAO();
		
		ArrayList<ProductVO> pv = null;
		
		pv = pd.NewProAll();
		
		request.setAttribute("pv", pv);
		
	}

}
