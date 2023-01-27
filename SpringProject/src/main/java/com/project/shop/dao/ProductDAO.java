package com.project.shop.dao;


import java.util.ArrayList;
import java.util.List;

import com.project.shop.vo.PReviewVO;
import com.project.shop.vo.ProductVO;

public interface ProductDAO {
	
	// 상품이름,가격,설명 출력 
	ProductVO DetailProductPage(String product);
	
	// 상품상세페이지 후기 
	ArrayList<PReviewVO> ProductReview(String pname);
	
	
	ProductVO getMainCount(int num);
	
	// 카테고리 페이지 관련 메소드
	List<ProductVO> selectAllCa(int page,int title);
	
	
	// --------------------------------------------------------------------------------
	
		// 인기상품 페이지 이동
		ArrayList<ProductVO> RandomProduct();
		
		// 신상품 페이지 이동
		ArrayList<ProductVO> NewProAll();
		
	// --------------------------------------------------------------------------------
		
		

		List<ProductVO> selectAllMember(int page, String search);
		
		ProductVO getAllCount(String search);
		
		int insert_product(int cnum,String csub, String prdname,String prddiscription,int prdprice);
		
		ArrayList<ProductVO> getAllInfo();
		
		ProductVO prdone(String product);
		
		ProductVO prdonename(String product);
		
		int prdUpdate(int cnum, String prdname, String prdname2, String prddiscription, int prdprice, String sprdname);
		
		int prddelete(String dprdname);
	


//	
//    // 인기상품
//    public ArrayList<ProductVO> RandomProduct() throws SQLException{
//    	Connection conn = ds.getConnection(); /////////////////
//        PreparedStatement ps;
//        ResultSet rs;
//        
//        ArrayList<ProductVO> plist = new ArrayList<ProductVO>();
//        ProductVO pv = null;
//        String sql = "select * from"
//        		+ " (select prdName,prdDescription,prdprice from product order by dbms_random.value)"
//        		+ " where rownum <=9";
//        
//        ps=conn.prepareStatement(sql);
//        rs=ps.executeQuery();
//        while(rs.next()) {
//        	String prdName = rs.getString("prdName");
//        	String prdDescription = rs.getString("prdDescription");
//        	int prdPrice = rs.getInt("prdprice");
//        	
//        	pv = new ProductVO(prdName, prdPrice, prdDescription);
//        	
//        	plist.add(pv);
//        }
//        conn.close();
//        return plist;
//        
//    }
//    
//    // 신상품
//    public ArrayList<ProductVO> NewProAll() throws SQLException{
//    	Connection conn = ds.getConnection(); /////////////////
//        PreparedStatement ps;
//        ResultSet rs;
//        
//        ArrayList<ProductVO> plist = new ArrayList<ProductVO>();
//        ProductVO pv = null;
//        String sql = "select * from product where cateNum in (1,2,4) and cateSubName in ('생선류','기타') or prdname ='주황빛 달콤함 귤 1.5kg'";
//        
//        ps=conn.prepareStatement(sql);
//        rs=ps.executeQuery();
//        while(rs.next()) {
//        	String prdName = rs.getString("prdName");
//        	String prdDescription = rs.getString("prdDescription");
//        	int prdPrice = rs.getInt("prdprice");
//        	
//        	pv = new ProductVO(prdName, prdPrice, prdDescription);
//        	
//        	plist.add(pv);
//        }
//        conn.close();
//        return plist;
//        
//    }
//    
//    
		

//    

// 
//    
//    // 관리자 회원 전체출력
//    public ArrayList<ProductVO> getAllInfo() throws SQLException {
//		String sql = "SELECT * FROM Product order by cateNum,cateSubName";
//		Connection conn = ds.getConnection(); /////////////////
//        PreparedStatement ps;
//        ResultSet rs;
//		ps = conn.prepareStatement(sql);
//		rs = ps.executeQuery();
//		
//		ArrayList<ProductVO> pvArray = new ArrayList<>();
//		
//		while(rs.next()) {
//			int category_num = rs.getInt("cateNum");
//			String category_subName = rs.getString("cateSubName");
//			String product_name = rs.getString("prdName");
//			String product_description = rs.getString("prdDescription");
//			int product_price = rs.getInt("prdprice");
//			
//			ProductVO pv = new ProductVO(category_num, category_subName, product_name, product_description, product_price);
//			pvArray.add(pv);
//		}
//		conn.close();
//		return pvArray;
//	}
//    
//    // 관리자 상품내역
//    public ProductVO getPrdOne(String product_name) throws SQLException {
//		String sql = "select * FROM Product WHERE prdName=?";
//		Connection conn = ds.getConnection(); /////////////////
//        PreparedStatement ps;
//        ResultSet rs;
//        ProductVO pv =null;
//        try {
//		ps = conn.prepareStatement(sql);
//        ps.setString(1, product_name);
//        rs=ps.executeQuery();
//        if(rs.next()) {
//        int category_num=rs.getInt("cateNum");
//        String category_subName=rs.getString("cateSubName");
//        String product = rs.getString("prdName");
//        String descipt = rs.getString("prdDescription");
//        int price = rs.getInt("prdprice");
//        
//        pv=new ProductVO(category_num, category_subName, product, descipt, price);
//        }
//        
//        }catch(Exception e) {
//        	e.printStackTrace();
//        	System.out.println("select error");
//        }
//        conn.close();
//        return pv;
//        
//	}
//    
//    // 상품 추가
//    public int insert_product(int category_num, String category_subName, String product_name, String product_description, int product_price) throws SQLException {
//		String sql = "INSERT INTO Product VALUES(?,?,?,?,?)";
//		Connection conn = ds.getConnection(); /////////////////
//        PreparedStatement pstmt;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, category_num);
//			pstmt.setString(2, category_subName);
//			pstmt.setString(3, product_name);
//			pstmt.setString(4, product_description);
//			pstmt.setInt(5, product_price);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			System.out.println("insert_product Exception");
//			e.printStackTrace();
//			return 0;
//		}		
//		conn.close();
//
//		return 1;
//	}
//    
//
//	
//    
//    // 상품 삭제
//    public int delete_product(String product_name) throws SQLException {
//		String sql = "DELETE FROM Product WHERE prdName=?";
//		Connection conn = ds.getConnection(); /////////////////
//        PreparedStatement ps;
//      
//		int res=0;
//		
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.setString(1, product_name);
//			res = ps.executeUpdate();
//			System.out.println("옹");
//			System.out.println(res);
//		} catch (SQLException e) {
//			System.out.println("delete_product Exception");
//			e.printStackTrace();
//			return res;
//		}
//		conn.close();
//		return res;
//	}
//	
//    
//    // 상품 수정
//	public boolean prdUpdate(int category_num,String category_subName,String product_name,String product_description,int product_price,String sproduct_name) throws SQLException {
//		String sql = "update product set cateNum=?,cateSubName=?,prdName=?,prdDescription=?,prdPrice=? where prdName=?";
//		Connection conn = ds.getConnection(); /////////////////
//        PreparedStatement pstmt;
//        ResultSet rs;
//        try {
//		pstmt = conn.prepareStatement(sql);
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setInt(1, category_num);
//		pstmt.setString(2, category_subName);
//		pstmt.setString(3, product_name);
//		pstmt.setString(4, product_description);
//		pstmt.setInt(5, product_price);
//		pstmt.setString(6, sproduct_name);
//		pstmt.executeUpdate();
//        }
//        catch(Exception e) {
//        	e.printStackTrace();
//        	System.out.println("update error");
//        	return false;
//        }
//        conn.close();
//        return true;
//        
//	}
//    
	
	
}
