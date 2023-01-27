package com.project.shop.serviceimpl;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.shop.dao.CartDAO;
import com.project.shop.dao.CategoryDAO;
import com.project.shop.dao.ProductDAO;
import com.project.shop.service.ServiceProduct;

import com.project.shop.vo.CartVO;
import com.project.shop.vo.CategoryVO;
import com.project.shop.vo.PReviewVO;
import com.project.shop.vo.ProductVO;


@Service("serviceProduct")
public class ServiceProductImpl implements ServiceProduct{
	
	@Autowired
	SqlSession sqlsession;
	
	@Autowired
	private CategoryDAO cadao;
	
	@Autowired
	private ProductDAO pdao;
	
	@Autowired
	private CartDAO cdao;
	
	
	// 카테고리 페이지 관련 
	//---------------------------------------------------------------------------------
	
	// 대분류 카테고리
	@Override
	public ArrayList<CategoryVO> AllMainCaGet(int page) {

		return cadao.CategorigetAllCount(page);
	}
	
	// 소분류 카테고리
	@Override
	public ArrayList<CategoryVO> AllSubCaGet(String subname) {
		
		return cadao.AllSubCategoryGet(subname);
	}
	
	public ProductVO getMainCount(int num) {

		return pdao.getMainCount(num);
	}
	
	// 카테고리 페이지 관련 메소드
	public List<ProductVO> selectAllCa(int page,int title){
		
		return pdao.selectAllCa(page, title);
	}
	//---------------------------------------------------------------------------------
	
	// --------------------------------------------------------------------------------
	
	// 인기상품 페이지 이동
	@Override
	public ArrayList<ProductVO> RandomProduct(){
		return pdao.RandomProduct();
	}

	
	// 신상품 페이지 이동
	@Override
	public ArrayList<ProductVO> NewProAll() {
		// TODO Auto-generated method stub
		return pdao.NewProAll();
	}
		

		
		
	// --------------------------------------------------------------------------------
	
	
	// 상품상세 페이지 관련
	//---------------------------------------------------------------------------------
	
	// 상품상세 페이지 
	@Override
	public ProductVO DetailProductPage(String pname) {
		return pdao.DetailProductPage(pname);
	}
	
	// 상품상세 페이지 리뷰
	@Override
	public ArrayList<PReviewVO> DetailPageReview(String pname){
		
		return pdao.ProductReview(pname);
	}
	
	// 상세페이지에서 추가시 장바구니에 아무것도없을시

	@Override
	public void InsertBasket(CartVO vv) {
			
		cdao.InsertBasket(vv);
	}


		// 상세페이지에서 추가시 장바구니에 물품이 있을경우
	@Override
	public void UpdateBasket(CartVO vv) {
			
		cdao.UpdateBasket(vv);
			
	}
	
	//---------------------------------------------------------------------------------
	
	
	
	
	// 장바구니 페이지 관련 
	//---------------------------------------------------------------------------------
	
	// 장바구니 상품의 유무 확인
	@Override
	public ArrayList<CartVO> basketchek(String id) {
		
		return cdao.getOneCartList(id);
	}

	
	// 회원의 장바구니 목록 전체 출력 
	@Override
	public ArrayList<CartVO> BasketPage(String id){
		
		return cdao.getCartList(id);
	}
	
	// 장바구니 가격 총합 
	@Override
	public ArrayList<CartVO> TotalPrice(String id) {
		
		return cdao.select_cartPrice(id);
	}
	// 장바구니 수량추가 
	@Override
	public void PlusCart(CartVO vv) {
		cdao.UpdateBasket(vv);
	}
	
	@Override
	public void MinusCart(CartVO vv) {
		cdao.UpdateBasket(vv);
	}
	
	@Override
	public int DeleteBasket(CartVO vv) {
		return cdao.DeleteBasket(vv);
	}
	
	@Override
	public void AllDelteBasket(String id) {
		cdao.DeleteAllB(id);
		
	}
	
	//---------------------------------------------------------------------------------
	
	//---------------------------------------------------------------------------------	
	@Override
	public List<ProductVO> selectAllMember(int page, String search){
		return pdao.selectAllMember(page,search);
	}
	
	@Override
	public ProductVO getAllCount(String search) {
		return sqlsession.selectOne("getAllCount",search);
	}
	//---------------------------------------------------------------------------------
	
	
	
	
	
}
