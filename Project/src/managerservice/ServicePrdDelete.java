package managerservice;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ProductDAO;



public class ServicePrdDelete{

	public int delchk(HttpServletRequest request, HttpServletResponse response) throws NamingException, Exception {
		// TODO Auto-generated method stub
	
		
		ProductDAO pd = new ProductDAO();
		
		String dprdname=request.getParameter("dprdname");
		int res=pd.delete_product(dprdname);
		
		return res;
		
	}

}
