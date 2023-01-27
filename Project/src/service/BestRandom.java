package service;

import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ProductDAO;
import db.ProductVO;

public class BestRandom implements ServiceImpl {

	@Override
	public void revise(HttpServletRequest request, HttpServletResponse response) throws NamingException, Exception {
		// TODO Auto-generated method stub
		ArrayList<ProductVO> pv =null;
		ProductDAO pd= new ProductDAO();
		
		pv = pd.RandomProduct();
		
		request.setAttribute("pv", pv);
		
	}

}
