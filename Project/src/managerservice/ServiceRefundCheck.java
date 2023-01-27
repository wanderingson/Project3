package managerservice;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orderdb.OrderDetailsDAO;
import service.ServiceImpl;



public class ServiceRefundCheck implements ServiceImpl{

	@Override
	public void revise(HttpServletRequest request, HttpServletResponse response) throws NamingException, Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int order_details_num = Integer.parseInt(request.getParameter("order_details_num"));
		int order_num = Integer.parseInt(request.getParameter("order_num"));
		
		OrderDetailsDAO oddao = new OrderDetailsDAO();
		
		oddao.update_refundDetails(order_details_num);
		
		int result = oddao.check_refundCnt(order_num);
		if(result==0)
			oddao.update_refundOrder(order_num);
		
		
	}

}
