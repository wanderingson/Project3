package com.project.shop.serviceimpl;




import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shop.dao.CartDAO;
import com.project.shop.dao.GradeDAO;
import com.project.shop.dao.MemInfoDAO;
import com.project.shop.dao.OrderDAO;
import com.project.shop.dao.OrderDetailsDAO;
import com.project.shop.dao.ReviewBoardDAO;
import com.project.shop.service.ServiceMember;
import com.project.shop.vo.CartVO;
import com.project.shop.vo.GradeVO;
import com.project.shop.vo.MemInfoVO;
import com.project.shop.vo.OrderDetailsVO;
import com.project.shop.vo.OrderVO;
import com.project.shop.vo.ReviewBoardVO;


@Service("serviceMemer")
public class ServiceMemberImpl implements ServiceMember{
	
	@Autowired
	private GradeDAO gdao;
	
	@Autowired
	private MemInfoDAO mdao;
	
	@Autowired
	private OrderDAO orderdao;
	
	@Autowired
	private OrderDetailsDAO orderdetailsdao;
	
	@Autowired
	private CartDAO cartdao;

	@Autowired
	private ReviewBoardDAO reviewboarddao;
	
	
	// 장바구니 등급 할인
	@Override
	public GradeVO CartGrade(String id) {
		
		return gdao.select_gradeInfo(id);
	}

	// 회원가입 관련
	//======================================================================================

	// 회원가입
	@Override
	public void memberJoinProcess(MemInfoVO meminfoVO) {
		mdao.memberInsert(meminfoVO);
		
	}
	// 회원 전체 가져오기
	@Override
	public ArrayList<MemInfoVO> getAllInfo() {
		
		return mdao.getAllInfo();
	}

	//======================================================================================
	
	// 회원 탈퇴
	//======================================================================================
	@Override
	public int memberDelProcess(MemInfoVO meminfoVO) {
		return mdao.memberDelete(meminfoVO);
	}
	//======================================================================================
	
	
	// 로그인 관련
	//======================================================================================
	
	@Override
	public ArrayList<MemInfoVO> select_loginCheck() {
		// TODO Auto-generated method stub
		return mdao.select_loginCheck();
	}
	
	// 아이디 찾기
	@Override
	public String FindID(MemInfoVO vo) {
		
		return mdao.findId(vo);
	}
	
	// 비밀번호 찾기
	@Override
	public String FindPW(MemInfoVO memvo) {

		return mdao.FindPW(memvo);
	}
	
	//======================================================================================
	
	

	// 마이페이지 관련
	//===========================================================================================
	
	@Override // 해당 id 의 회원정보 가져오기
	public MemInfoVO select_memInfo(String mem_id) {
		
		return mdao.select_memInfo(mem_id);
	}

	@Override // 회원정보 수정
	public void update_memInfo(String mem_id, String pw, String tel, String address1, String address2, String address3) {
		mdao.update_memInfo(mem_id, pw, tel, address1, address2, address3);
	}
	
	//===========================================================================================
	
	// 주문내역 관련
	//===========================================================================================
	
	@Override // 해당 id 주문내역 가져오기 
	public ArrayList<OrderVO> getInfo(String mem_id) {
		
		return orderdao.getInfo(mem_id);
	}
	@Override // 주문버튼 눌렀을 때 DB 에 정보 입력해주기(주문내역)
	public void insert_orderInfo(String mem_id, String address1, String address2, String address3, String tel, int totPrice, String delivery_message) {
		System.out.println(mem_id);
		orderdao.insert_orderInfo(mem_id, address1, address2, address3, tel, totPrice, delivery_message);
	}

	@Override // 주문버튼 눌렀을 때 DB 에 정보 입력해주기(주문상세내역)
	public void insert_orderDetailsInfo(String product_name, int product_qty, int order_price) {
		orderdao.insert_orderDeatailsInfo(product_name, product_qty,order_price);
	}

	@Override
	public Double select_refundCheck(int order_num) {
		System.out.println(orderdao.select_refundCheck(order_num));
		return orderdao.select_refundCheck(order_num);
	}
	
	// 주문목록 후기 작성하기
	@Override // 후기 작성하기
	public void insert_review(ReviewBoardVO reviewboardVO) {
			
		reviewboarddao.insert_review(reviewboardVO);
	}
		
	@Override // 후기작성되었는지 확인
	public int check_review(String rid, String rproduct, int order_details_num) {
			
		return reviewboarddao.check_review(rid, rproduct, order_details_num);
	}
	
	@Override // 주문내역에 상품대표명 1개 가져오기
	public String select_listMainName(int order_num) {
		
		return orderdetailsdao.select_listMainName(order_num);
	}
	
	
	
	@Override // 해당 주문의 상품개수 가져오기
	public Integer select_count(int order_num) {
			
		return orderdetailsdao.select_count(order_num);
	}
	

	//===========================================================================================
	
	
	// 주문페이지 관련 
	//===========================================================================================
	
	
	@Override // 해당 id 의 장바구니 목록 가져오기
	public ArrayList<CartVO> getCartList(String id) {
		
		return cartdao.getCartList(id);
	}
	
	@Override // 회원등급, 적립금 수정해주기
	public void update_grade(String mem_id, String grade_name, int mem_point) {
		mdao.update_grade(mem_id, grade_name, mem_point);
	}
	
	@Override // 장바구니 전체 삭제
	public void cart_clear(String id) {
		cartdao.DeleteAllB(id);
	}
	
	//===========================================================================================
	
	

	@Override // 해당 주문번호의 상세 내역 가져오기
	public ArrayList<OrderDetailsVO> getOrderDetailsInfo(int order_num) {
		
		return orderdetailsdao.getOrderDetailsInfo(order_num);
	}

	@Override // "환불요청" 버튼 눌렀을 때 "환불요청"으로 바꿔주기
	public void update_deliveryState(OrderDetailsVO orderdetailsVO) {
		
		orderdetailsdao.update_deliveryState(orderdetailsVO);
	}
	
	@Override // 상세주문내역에서 모든 상품을 환불상태 확인
	public int check_reqRefundCnt(OrderDetailsVO orderdetailsVO) {
		
		return orderdetailsdao.check_reqRefundCnt(orderdetailsVO);
	}

	@Override // 상세주문내역에서 모든 상품이 환불요청상태일 때 주문내역 상태 환불요청으로 바꿔주기
	public void update_reqRefund(OrderDetailsVO orderdetailsVO) {
		orderdetailsdao.update_reqRefund(orderdetailsVO);
	}

	
	
	
	
	
	
}
