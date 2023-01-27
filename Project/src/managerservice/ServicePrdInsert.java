package managerservice;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.ProductDAO;



public class ServicePrdInsert {

	
	public int insertchk(HttpServletRequest request, HttpServletResponse response) throws NamingException, Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ProductDAO pd = new ProductDAO();
		
		int cnum = Integer.parseInt(request.getParameter("cnum"));
		String csub = request.getParameter("csub");
		String prdname=request.getParameter("prdname");
		String prddiscription=request.getParameter("prddiscription");
		int prdprice = Integer.parseInt(request.getParameter("prdprice"));
		System.out.println("asdsa");
		int res = pd.insert_product(cnum, csub, prdname, prddiscription, prdprice);
		
		return res;
	}

}
