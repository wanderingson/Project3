package managerservice;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ProductDAO;
import service.ServiceImpl;

public class ServicePrdUpdate implements ServiceImpl{

	@Override
	public void revise(HttpServletRequest request, HttpServletResponse response) throws NamingException, Exception {
		// TODO Auto-generated method stub
	
		ProductDAO pd= new ProductDAO();
		int cnum=Integer.parseInt(request.getParameter("cnum"));
		String csub=request.getParameter("csub");
		String prdname=request.getParameter("prdname");
		String discript = request.getParameter("prddiscription");
		int price =Integer.parseInt(request.getParameter("prdprice"));
		String sprdname = request.getParameter("sprdname");
		 pd.prdUpdate(cnum, csub, prdname, discript, price,sprdname);			
		
	}

}
