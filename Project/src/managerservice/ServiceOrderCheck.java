package managerservice;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orderdb.OrderDAO;
import orderdb.OrderDetailsDAO;
import service.ServiceImpl;



public class ServiceOrderCheck implements ServiceImpl{

	@Override
	public void revise(HttpServletRequest request, HttpServletResponse response) throws NamingException, Exception {
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int order_num = Integer.parseInt(request.getParameter("order_num"));
		
		OrderDAO odao = new OrderDAO();
		OrderDetailsDAO oddao = new OrderDetailsDAO();
		
		odao.ckeckOrder(order_num);
		oddao.ckeckOrder(order_num);
	}

}
