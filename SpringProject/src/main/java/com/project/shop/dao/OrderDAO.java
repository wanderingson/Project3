package com.project.shop.dao;

import java.util.ArrayList;

import com.project.shop.vo.OrderVO;

public interface OrderDAO {
	

	// 해당 id 의 주문목록 가져오기
	ArrayList<OrderVO> getInfo(String mem_id);
	
	// 환불가능여부 확인
		Double select_refundCheck(int order_num);
		
	// 주문버튼 눌렀을 때 DB 에 정보 입력해주기
	void insert_orderInfo(String mem_id, String address1, String address2, String address3, String tel, int totPrice, String delivery_message);
	void insert_orderDeatailsInfo(String product_name, int product_qty, int order_price);
		
	// '주문요청' 상태인 주문내역 전체 가져오기(관리자)
	ArrayList<OrderVO> getAllCheckOrders();
		
	// "주문확인" 버튼 눌렀을 때 주문내역에 있는 "주문요청" => "배송완료" 로 바꿔주기
	void checkOrder(int order_num);
		
	// '배송완료' 상태인 주문내역 전체 가져오기(관리자)
	ArrayList<OrderVO> getAllOrders();
		
	// 주문번호를 통해 한사람 정보 가져오기(관리자)
	OrderVO getOneInfo(int order_num);
	
	
}
