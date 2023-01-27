package com.project.shop.service;

import java.util.ArrayList;

import com.project.shop.vo.MemInfoVO;
import com.project.shop.vo.OrderDetailsVO;
import com.project.shop.vo.OrderVO;
import com.project.shop.vo.ProductVO;

public interface ServiceAdmin {
	// === MemInfo ===
		// 모든 회원정보 가져오기
		ArrayList<MemInfoVO> getAllInfo();
		
		// === Order ===
		// 해당 id 주문내역 가져오기 
		ArrayList<OrderVO> getInfo(String mem_id);
		// '주문요청' 상태인 주문내역 전체 가져오기(관리자)
		ArrayList<OrderVO> getAllCheckOrders();
		// "주문확인" 버튼 눌렀을 때 주문내역에 있는 "주문요청" => "배송완료" 로 바꿔주기
		void checkOrder(int order_num);
		// '배송완료' 상태인 주문내역 전체 가져오기(관리자)
		ArrayList<OrderVO> getAllOrders();
		// 주문번호를 통해 한사람 정보 가져오기(관리자)
		OrderVO getOneInfo(int order_num);
		
		// === OrderDetails ===
		// 해당 주문번호의 상세 내역 가져오기
		ArrayList<OrderDetailsVO> getOrderDetailsInfo(int order_num);
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
		
		
		ArrayList<ProductVO> getAllInfo1();

		int insert_product(int cnum,String csub, String prdname,String prddiscription,int prdprice);
		
		ProductVO prdone(String product);
		
		ProductVO prdonename(String product);
		
		int prdUpdate(int cnum,String csub, String prdname,String prddiscription,int prdprice,String sprdname);
		
		int prddelete(String dprdname);
		
		
}
