package com.project.shop.dao;

import java.util.ArrayList;

import com.project.shop.vo.OrderDetailsVO;

public interface OrderDetailsDAO {
	
	// 해당 주문번호의 상세 내역 가져오기
		ArrayList<OrderDetailsVO> getOrderDetailsInfo(int order_num);
		
		// "환불요청" 버튼 눌렀을 때 "환불요청"으로 바꿔주기
		void update_deliveryState(OrderDetailsVO orderdetailsVO);
		// 상세주문내역에서 모든 상품을 환불상태 확인
		int check_reqRefundCnt(OrderDetailsVO orderdetailsVO);
		// 상세주문내역에서 모든 상품이 환불요청상태일 때 주문내역 상태 환불요청으로 바꿔주기
		void update_reqRefund(OrderDetailsVO orderdetailsVO);
		
		// "환불요청" 상태인 상세내역 가져오기(관리자)
		ArrayList<OrderDetailsVO> getAllRefundChk();
		
		// "환불완료" 상태인 상세내역 가져오기(관리자)
		ArrayList<OrderDetailsVO> getAllRefund();
		
		// 관리자가 주문확인 해주면 주문상세내역 배송완료로 바꿔주기
		void checkOrder2(int order_num);
		
		// 환불확인 해주면 해당 상품 환불완료로 변경해주기
		void update_refundDetails(int order_details_num);
		// 상세주문내역에서 모든 상품을 환불상태 확인
		int check_refundCnt(int order_num);
		// 주문상세내역이 모두 환불완료일 때, 주문내역을 환불완료로 바꿔주기
		void update_refundOrder(int order_num);
		
		String select_listMainName(int order_num);
		Integer select_count(int order_num);

}
