package com.project.shop.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.shop.dao.MemInfoDAO;
import com.project.shop.dao.OrderDAO;
import com.project.shop.dao.OrderDetailsDAO;
import com.project.shop.dao.ProductDAO;
import com.project.shop.service.ServiceAdmin;
import com.project.shop.vo.MemInfoVO;
import com.project.shop.vo.OrderDetailsVO;
import com.project.shop.vo.OrderVO;
import com.project.shop.vo.ProductVO;

@Service("serviceAdmin")
public class ServiceAdminImpl implements ServiceAdmin{
	
	@Autowired
	private MemInfoDAO meminfodao;
	
	@Autowired
	private ProductDAO productdao;
	
	@Override // 모든 회원정보 가져오기
	public ArrayList<MemInfoVO> getAllInfo() {
		
		return meminfodao.getAllInfo();
	}
	
	// ==============================================================================
	
	// 관리자 페이지 관련
	// ==============================================================================
	@Autowired
	private OrderDAO orderdao;

	@Override // 해당 id 주문내역 가져오기 
	public ArrayList<OrderVO> getInfo(String mem_id) {
		
		return orderdao.getInfo(mem_id);
	}
	
	@Override // '주문요청' 상태인 주문내역 전체 가져오기(관리자)
	public ArrayList<OrderVO> getAllCheckOrders() {
		
		return orderdao.getAllCheckOrders();
	}
	
	@Override // "주문확인" 버튼 눌렀을 때 주문내역에 있는 "주문요청" => "배송완료" 로 바꿔주기
	public void checkOrder(int order_num) {
		orderdao.checkOrder(order_num);
	}
	
	@Override // '배송완료' 상태인 주문내역 전체 가져오기(관리자)
	public ArrayList<OrderVO> getAllOrders() {
		
		return orderdao.getAllOrders();
	}
	
	@Override // 주문번호를 통해 한사람 정보 가져오기(관리자)
	public OrderVO getOneInfo(int order_num) {
		
		return orderdao.getOneInfo(order_num);
	}
	
	
	
	// ==============================================================================
	@Autowired
	private OrderDetailsDAO orderdetailsdao;

	@Override // 해당 주문번호의 상세 내역 가져오기
	public ArrayList<OrderDetailsVO> getOrderDetailsInfo(int order_num) {

		return orderdetailsdao.getOrderDetailsInfo(order_num);
	}
	
	@Override // "환불요청" 상태인 상세내역 가져오기(관리자)
	public ArrayList<OrderDetailsVO> getAllRefundChk() {
		
		return orderdetailsdao.getAllRefundChk();
	}

	@Override // "환불완료" 상태인 상세내역 가져오기(관리자)
	public ArrayList<OrderDetailsVO> getAllRefund() {
		
		return orderdetailsdao.getAllRefund();
	}

	@Override // 관리자가 주문확인 해주면 주문상세내역 배송완료로 바꿔주기
	public void checkOrder2(int order_num) {
		orderdetailsdao.checkOrder2(order_num);
	}

	@Override // 환불확인 해주면 해당 상품 환불완료로 변경해주기
	public void update_refundDetails(int order_details_num) {
		orderdetailsdao.update_refundDetails(order_details_num);
	}

	@Override // 상세주문내역에서 모든 상품을 환불상태 확인
	public int check_refundCnt(int order_num) {
		return orderdetailsdao.check_refundCnt(order_num);
	}

	@Override // 주문상세내역이 모두 환불완료일 때, 주문내역을 환불완료로 바꿔주기
	public void update_refundOrder(int order_num) {
		orderdetailsdao.update_refundOrder(order_num);
	}

	// ==============================================================================
	
	
	// ==============================================================================
		
	@Override
	public int insert_product(int cnum,String csub, String prdname,String prddiscription,int prdprice) {
		// TODO Auto-generated method stub
		return productdao.insert_product(cnum, csub, prdname, prddiscription, prdprice);
	}
	

	@Override
	public ArrayList<ProductVO> getAllInfo1() {
		// TODO Auto-generated method stub
		return productdao.getAllInfo();
	}
	
	@Override
	public ProductVO prdone(String product) {
		// TODO Auto-generated method stub
		return productdao.prdone(product);
	}

	@Override
	public ProductVO prdonename(String product) {
		// TODO Auto-generated method stub
		return productdao.prdonename(product);
	}

	@Override
	public int prdUpdate(int cnum,String csub, String prdname,String prddiscription,int prdprice,String sprdname) {
		// TODO Auto-generated method stub
		return productdao.prdUpdate(cnum, csub, prdname, prddiscription, prdprice,sprdname);
	}

	@Override
	public int prddelete(String dprdname) {
		// TODO Auto-generated method stub
		return productdao.prddelete(dprdname);
	}
	
	
	// ==============================================================================

	
}
