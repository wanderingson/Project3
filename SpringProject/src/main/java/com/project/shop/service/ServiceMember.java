package com.project.shop.service;


import java.util.ArrayList;

import com.project.shop.vo.CartVO;
import com.project.shop.vo.GradeVO;
import com.project.shop.vo.MemInfoVO;
import com.project.shop.vo.OrderDetailsVO;
import com.project.shop.vo.OrderVO;
import com.project.shop.vo.ReviewBoardVO;

public interface ServiceMember {
	
	// 주문내역 관련
	//===========================================================================================
	
	// 해당 id 주문내역 가져오기 
	ArrayList<OrderVO> getInfo(String mem_id);
	
	// 주문버튼 눌렀을 때 DB 에 정보 입력해주기
	void insert_orderInfo(String mem_id, String address1, String address2, String address3, String tel, int totPrice, String deliveryMessage);
	void insert_orderDetailsInfo(String product_name, int product_qty, int order_price);
	
	// 주문내역에 상품대표명 1개 가져오기
	String select_listMainName(int order_num);
	// 해당 주문의 상품개수 가져오기
	Integer select_count(int order_num);

	
	
	//===========================================================================================
	
	// === 주문상세 ===
	//===========================================================================================
	
	// 해당 주문번호의 상세 내역 가져오기
	ArrayList<OrderDetailsVO> getOrderDetailsInfo(int order_num);
		
	Double select_refundCheck(int order_num);
	// "환불요청" 버튼 눌렀을 때, 배송상태 "환불요청"으로 바꿔주기
	void update_deliveryState(OrderDetailsVO orderdetailsVO);
	// 상세주문내역에서 모든 상품을 환불상태 확인
	int check_reqRefundCnt(OrderDetailsVO orderdetailsVO);
	// 상세주문내역에서 모든 상품이 환불요청상태일 때 주문내역 상태 환불요청으로 바꿔주기
	void update_reqRefund(OrderDetailsVO orderdetailsVO);
	
	//===========================================================================================
	
	
	
	// 주문 목록 후기작성
	//===========================================================================================
	// 후기작성
	void insert_review(ReviewBoardVO reviewboardVO);
	// 후기작성되었는지 확인
	int check_review(String rid, String rproduct, int order_details_num);
	
	//===========================================================================================
	
	
	
	
	// 마이페이지 관련
	//===========================================================================================
	
	// 회원정보 수정
	void update_memInfo(String mem_id, String pw, String tel, String address1, String address2, String address3);
	
	// 해당 id 회원정보 가져오기
	MemInfoVO select_memInfo(String mem_id);
	
	
	//===========================================================================================
	
	
	
	
	// 로그인페이지관련
	//===========================================================================================
	
	// 로그인
	ArrayList<MemInfoVO> select_loginCheck();
	// 아이디 찾기
	String FindID(MemInfoVO vo);
	
	// 비밀번호
	String FindPW(MemInfoVO memvo);

	// 장바구니 등급 할인 
	GradeVO CartGrade(String id);
	
	//===========================================================================================
	
	// 회원가입 관련
	//===========================================================================================
	
	// 회원가입
	void memberJoinProcess(MemInfoVO meminfoVO);
	
	// 회원 전체 가져오기
	ArrayList<MemInfoVO> getAllInfo();
	
	//===========================================================================================
	
	// 회원 탈퇴
	//===========================================================================================
	int memberDelProcess(MemInfoVO meminfoVO);
	//===========================================================================================
	
	
	
	// 주문 페이지 관련
	//===========================================================================================
	// 해당 id 장바구니 목록 가져오기
	ArrayList<CartVO> getCartList(String mem_id);
	
	// 회원등급, 적립금 수정해주기
	void update_grade(String mem_id, String grade_name, int mem_point);
	
	// 장바구니 비워주기
	void cart_clear(String mem_id);


	
}
