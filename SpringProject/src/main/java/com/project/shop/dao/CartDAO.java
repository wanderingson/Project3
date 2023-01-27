package com.project.shop.dao;

import java.util.ArrayList;

import com.project.shop.vo.CartVO;

public interface CartDAO {
		//장바구니 내용전체 출력
		ArrayList<CartVO> getCartList(String id); 
		
		// 장바구니 상품의 유무 확인
		ArrayList<CartVO>getOneCartList(String id);


		// 상세페이지에서 추가시 장바구니에 아무것도없을시
		void InsertBasket(CartVO vv);
		
		// 중복사용중 
		// 장바구니 수량 수정 
		//상세페이지에서 추가시 장바구니에 물품이 있을경우
		void UpdateBasket(CartVO vv);
		
	    // 	장바구니 총상품금액 구하기
		ArrayList<CartVO> select_cartPrice(String id);
		
		// 장바구니 하나 삭제
		int DeleteBasket(CartVO vv);
		
		// 장바구니 전체 삭제
		void DeleteAllB(String id);
//	    // 장바구니 내역 전체 삭제
//	     throws SQLException {
//	    	Connection conn = ds.getConnection(); /////////////////
//	        PreparedStatement ps;
//	    	
//	        String sql2 = "DELETE"
//	        		+ " FROM CART"
//	        		+ " WHERE memID=?";
//	        ps = conn.prepareStatement(sql2);
//	        ps.setString(1, id); //회원 아이디
//	        ps.executeUpdate();	
	//
//	        conn.close();
//	    }
	//  
		
    
//	    public throws SQLException {
//	    	Connection conn = ds.getConnection(); /////////////////
//	        PreparedStatement ps;
//	    	
//	        String sql2 = "DELETE"
//	        		+ " FROM CART"
//	        		+ " WHERE memID=?"
//	        		+ " AND prdName=?";
//	        ps = conn.prepareStatement(sql2);
//	        ps.setString(1, id); //회원 아이디
//	        ps.setString(2, name); //상품 이름
//	        ps.executeUpdate();	
	//
//	        conn.close();
//	    }
	//    

	//    

//	 	public void InsertTotal(String name,String id, int total) throws SQLException {
//	 		Connection conn = ds.getConnection(); /////////////////
//	        PreparedStatement ps;
//	 		String sql = "UPDATE cart"
//	 				+ " SET product_price=?"
//	 				+ " WHERE memid=?"
//	 				+ " AND prdName=?";
//	 		ps = conn.prepareStatement(sql);
//	 		ps.setInt(1, total);
//	 		ps.setString(2, id);
//	 		ps.setString(3, name);
//	 		
//	 		ps.executeUpdate();	
	//
//	        conn.close();
//		}
	//
	// 	
	// 	
	 	

//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//	
//	DataSource ds;
//    public CartDAO() throws NamingException, SQLException{ //생성자
//            
//            	Context initContext = new InitialContext();
//               Context envContext  = (Context)initContext.lookup("java:/comp/env");
//               ds = (DataSource)envContext.lookup("jdbc/myoracle");
//    }
//    
//	
//	// memID 별 장바구니 목록 가져오기
//	public ArrayList<CartVO> getCartList(String mem_id) throws SQLException {
//		Connection con = ds.getConnection();
//		String sql = "SELECT * FROM Cart "
//				+ " WHERE memid=?"; // 이름
//		
//		ArrayList<CartVO> cvArray = new ArrayList<>();
//		
//		pstmt = con.prepareStatement(sql);
//		pstmt.setString(1, mem_id);
//		rs = pstmt.executeQuery();
//		
//		while(rs.next()) { // memID, prdName cQuantity price
//			String product_name = rs.getString("prdName");
//			int product_qty = rs.getInt("cQuantity");
//			int product_price = rs.getInt("product_price");
//			
//			CartVO cv = new CartVO(mem_id, product_name, product_qty, product_price);
//			cvArray.add(cv);
//		}
//		con.close();
//		return cvArray;	
//	}
//	
//	
//	// 장바구니 추가메소드
//	public void insert_cart(String mem_id, String product_name, int product_qty, int product_price) throws SQLException{
//		Connection con = ds.getConnection();
//		String sql = "INSERT INTO Cart VALUES(?,?,?,?)";
//		
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, mem_id);
//			pstmt.setString(2, product_name);
//			pstmt.setInt(3, product_qty);
//			pstmt.setInt(4, product_price);
//			pstmt.executeUpdate();
//			con.close();
//		} catch (SQLException e) {
//			System.out.println("insert_cart Exception");
//			//e.printStackTrace();
//		}
//	
//	}
//	
//	// 장바구니 상품개수 수정
//	public void update_cart(String mem_id, String product_name, int product_qty, int product_price) throws SQLException {
//		Connection con = ds.getConnection();
//		String sql = "UPDATE Cart SET cQuantity=?, product_price=? WHERE Cart memid=? AND prdname=?";
//		
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, product_qty);
//			pstmt.setInt(2, product_price);
//			pstmt.setString(3, mem_id);
//			pstmt.setString(4, product_name);
//			pstmt.executeUpdate();
//			con.close();
//
//		} catch (SQLException e) {
//			System.out.println("update_cart Exception");
//			e.printStackTrace();
//		}
//		
//	}
//	
//	// 장바구니 상품하나 삭제
//	public void delete_cart(String mem_id, String product_name) throws SQLException {
//		Connection con = ds.getConnection();
//		String sql = "DELETE FROM Cart WHERE memid=? AND prdname=?";
//		
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, mem_id);
//			pstmt.setString(2, product_name);
//			pstmt.executeUpdate();
//			con.close();
//		} catch (SQLException e) {
//			System.out.println("delete_cart Exception");
//			//e.printStackTrace();
//		}
//		
//	}
//	
//	// 장바구니 전체삭제
//	public void clear_cart(String mem_id) throws SQLException {
//		Connection con = ds.getConnection();
//		String sql = "DELETE FROM Cart WHERE memid=?";
//		
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, mem_id);
//			pstmt.executeUpdate();
//			con.close();
//	
//		} catch (SQLException e) {
//			System.out.println("clear_cart Exception");
//			//e.printStackTrace();
//		}
//		
//	}
//	
//	// 장바구니 총상품금액 구하기(할인x)
//	public int select_cartPrice(String mem_id) throws SQLException {
//		Connection con = ds.getConnection();
//		String sql = "SELECT product_price "
//				+ " FROM CART c "
//				+ " WHERE memid=?";
//		
//		int totalPrice = 0;
//		
//		pstmt = con.prepareStatement(sql);
//		pstmt.setString(1, mem_id);
//		rs = pstmt.executeQuery();
//		
//		while(rs.next()) {
//			int product_price = rs.getInt("product_price");
//			totalPrice += product_price;
//		}
//		con.close();
//		return totalPrice;
//	}
//	
//	// 등급할인 구하는 메소드
//	// 회원의 할인율을 구하고 장바구니의 총상품금액을 구해서 계산해줌
//	public int discount_price(String mem_id, int dc_percent) throws SQLException {
//		Connection con = ds.getConnection();
//		String sql = "SELECT product_price "
//				+ " FROM CART c "
//				+ " WHERE memid=?";
//		
//		int discount_price = 0;
//		
//		pstmt = con.prepareStatement(sql);
//		pstmt.setString(1, mem_id);
//		rs = pstmt.executeQuery();
//		
//		while(rs.next()) {
//			int product_price = rs.getInt("product_price");
//			discount_price += product_price;
//		}
//		con.close();
//		return discount_price = discount_price * dc_percent/100; 
//	}
//	
//	// 아이디로 장바구니 가격 구해서 합쳐주고, 등급할인 계산해주기
//	public int order_price(String mem_id, int dc_percent) throws SQLException {
//		Connection con = ds.getConnection();
//		
//		String sql = "SELECT product_price "
//				+ " FROM CART c "
//				+ " WHERE memid=?";
//		
//		int order_price = 0;
//		
//		pstmt = con.prepareStatement(sql);
//		pstmt.setString(1, mem_id);
//		rs = pstmt.executeQuery();
//		
//		while(rs.next()) {
//			int product_price = rs.getInt("product_price");
//			order_price += product_price;
//		}
//		con.close();
//		return order_price = order_price - order_price*dc_percent/100;
//	}
//	
//	
//	public String select_onename(String mem_id) throws SQLException{
//	      String sql = "SELECT prdname FROM Cart WHERE memid=? AND ROWNUM=1";
//	      Connection con = ds.getConnection();
//	      pstmt = con.prepareStatement(sql);
//	      pstmt.setString(1, mem_id);
//	      rs = pstmt.executeQuery();
//	      
//	      String product_name = "";
//	      
//	      if(rs.next()) {
//	         product_name = rs.getString("prdname");
//	      }
//	      
//	      
//	      return product_name;
//	   }
//
	
}
