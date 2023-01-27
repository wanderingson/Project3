package com.project.shop.service;

import java.util.ArrayList;
import java.util.List;

import com.project.shop.vo.CartVO;
import com.project.shop.vo.CategoryVO;
import com.project.shop.vo.PReviewVO;
import com.project.shop.vo.ProductVO;


public interface ServiceProduct {
	
	// 메인카테고리
	ArrayList<CategoryVO> AllMainCaGet(int page);
	
	// 서브카테고리
	ArrayList<CategoryVO> AllSubCaGet(String subname);
	
	ProductVO getMainCount(int num);
	
	// 카테고리 페이지 관련 메소드
	List<ProductVO> selectAllCa(int page,int title);
	
// -------------------------------------------------------------------------------- 

// --------------------------------------------------------------------------------
	// 상품상세 페이지
	ProductVO DetailProductPage(String pname);
	
	// 상품상세 페이지 리뷰
	ArrayList<PReviewVO> DetailPageReview(String pname);
	
	// 상세페이지에서 추가시 장바구니에 물품이 있을경우
		void UpdateBasket(CartVO vv);
		
	// 상세페이지에서 추가시 장바구니에 아무것도없을시
	void InsertBasket(CartVO vv);

// --------------------------------------------------------------------------------
	
// --------------------------------------------------------------------------------
	
	// 인기상품 페이지 이동
	ArrayList<ProductVO> RandomProduct();
	
	// 신상품 페이지 이동
	ArrayList<ProductVO> NewProAll();
	
// --------------------------------------------------------------------------------
	
// --------------------------------------------------------------------------------
	// 장바구니안의 상품유무확인
	ArrayList<CartVO>basketchek(String id);
	
	
	// 장바구니 페이지 장바구니 내용 전체출력
	ArrayList<CartVO> BasketPage(String id);
	
	// 장바구니 총합가격  
	ArrayList<CartVO> TotalPrice(String id);
	
	// 장바구니 수량수정 
	void PlusCart(CartVO vv);
	void MinusCart(CartVO vv);
	
	int DeleteBasket(CartVO vv);
	
	void AllDelteBasket(String id);
	
	
// --------------------------------------------------------------------------------

	
	
// --------------------------------------------------------------------------------


	ProductVO getAllCount(String search);

	List<ProductVO> selectAllMember(int page, String search);

	// --------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
}
