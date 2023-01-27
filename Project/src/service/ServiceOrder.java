package service;


import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.GradeDAO;
import memberdb.MemInfoDAO;
import orderdb.OrderDAO;
import orderdb.OrderDetailsDAO;
import paydb.CartDAO;
import paydb.CartVO;


public class ServiceOrder implements ServiceImpl{

	@Override
	public void revise(HttpServletRequest request, HttpServletResponse response) throws NamingException, Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String address3 = request.getParameter("address3");
		String tel = request.getParameter("tel");
		int totPrice = Integer.parseInt(request.getParameter("totPrice"));
		String delivery_message = request.getParameter("deliveryMessage");
		int point = Integer.parseInt(request.getParameter("point"));
		
		System.out.println(id);
		System.out.println(address1);
		System.out.println(address2);
		System.out.println(address3);
		System.out.println(tel);
		System.out.println(totPrice);
		System.out.println(delivery_message);
		System.out.println(point);
		
		OrderDAO odao = new OrderDAO();
		OrderDetailsDAO oddao = new OrderDetailsDAO();
		CartDAO cdao = new CartDAO();
		ArrayList<CartVO> cvArray = new ArrayList<>();
		// 주문 상세내역 insert	
		cvArray = cdao.getCartList(id);
		// 주문 내역 insert
		odao.insert_orderInfo(id, address1, address2, address3, tel, totPrice, delivery_message);

		GradeDAO gdao = new GradeDAO();
		for(CartVO imsi : cvArray) {
			int product_price = gdao.discount_oneprice(id, imsi.getProduct_price());
			odao.insert_orderDeatailsInfo(imsi.getProduct_name(), imsi.getProduct_qty(), product_price);
			
		}
		// 적립금 update
		MemInfoDAO midao = new MemInfoDAO();
		midao.update_gradeName(id, point);
		cdao.clear_cart(id);
	}

}
// 전체 주문 내역을 DB 로 insert 시키고
// 회원의 cart 를 모두 가져와서 반복해서 주문상세내역에 집어넣음
// 이때 가격은 결제금액으로 바꿔서 집어넣는다
// 다음은 적립금 결정해주기
