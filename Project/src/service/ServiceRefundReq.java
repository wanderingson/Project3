package service;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orderdb.OrderDetailsDAO;



public class ServiceRefundReq implements ServiceImpl{

	@Override
	public void revise(HttpServletRequest request, HttpServletResponse response) throws NamingException, Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int order_details_num = Integer.parseInt(request.getParameter("order_details_num"));
		System.out.println(order_details_num);
		int order_num = Integer.parseInt(request.getParameter("order_num"));
		System.out.println(order_num);
		OrderDetailsDAO oddao = new OrderDetailsDAO();
		oddao.update_deliveryState(order_details_num);
		
		int result = oddao.check_reqRefundCnt(order_num);
		if(result==0) {
			oddao.update_reqRefund(order_num);
		}
		
		
	}

}
