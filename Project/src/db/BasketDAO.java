package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BasketDAO {

	DataSource ds;
    public BasketDAO() throws NamingException, SQLException{ //생성자
            
            Context initContext = new InitialContext();
               Context envContext  = (Context)initContext.lookup("java:/comp/env");
               ds = (DataSource)envContext.lookup("jdbc/myoracle");
    }
    
    
    // 장바구니 내용전체 출력
    public ArrayList<BasketVO> getCartList(String id) throws SQLException {
		
    	Connection conn = ds.getConnection(); /////////////////
        PreparedStatement ps;
        ResultSet rs;
    	
    	String sql = "SELECT p.prdName, p.prdPrice, c.cQuantity "
				+ " FROM CART c, PRODUCT p "
				+ " WHERE c.prdName=p.prdName "
				+ " AND c.memID=?"; // 이름
		
		ArrayList<BasketVO> cvArray = new ArrayList<>();
		
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		rs = ps.executeQuery();
		
		while(rs.next()) { // memID, prdName cQuantity price
			String prdName = rs.getString("prdName");
			int prdPrice = rs.getInt("prdPrice");
			int cQuantity = rs.getInt("cQuantity");
			
			BasketVO cv = new BasketVO(prdName, prdPrice, cQuantity);
			cvArray.add(cv);
		}
		
		conn.close();
		return cvArray;	
	}

    
    // 장바구니안에 제품 유무확인
    public ArrayList<BasketVO> getOneCartList(String id) throws SQLException {
		
    	Connection conn = ds.getConnection(); /////////////////
        PreparedStatement ps;
        ResultSet rs;
    	
    	String sql = "SELECT prdName"
				+ " FROM CART"
				+ " WHERE memID = ?";
		
		ArrayList<BasketVO> cvArray = new ArrayList<BasketVO>();
		
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		rs = ps.executeQuery();
		
		while(rs.next()) { // memID, prdName cQuantity price
			String prdName = rs.getString("prdName");
			
			BasketVO cv = new BasketVO(prdName);
			cvArray.add(cv);
		}
		
		conn.close();
		return cvArray;	
	}
    

 	
    
    // 장바구니 db 이름 추가
    public void InsertBasket(String id,String name,int num) throws SQLException{
    		
		 Connection conn = ds.getConnection(); /////////////////
         PreparedStatement ps;
    	
         String sql = "INSERT INTO CART(memid,prdName,cQuantity)"
          		+ " VALUES (?,?,?)";
         ps = conn.prepareStatement(sql);
         ps.setString(1, id); //멤버아이디
         ps.setString(2, name); //상품 이름
         ps.setInt(3, num); //상품 총 개수
         ps.executeUpdate();	
    	
    	conn.close();
    	
    }
    
 	// 장바구니추가시에 중복된 이름있을시 업데이트 
    // 장바구니 페이지에 개수 업데이트
    // 중복사용
    // basketplus 오류상태
    public void UpdateBasket(String id,String name,int num) throws SQLException {
    	Connection conn = ds.getConnection(); /////////////////
        PreparedStatement ps;
        
        String sql2 = "UPDATE CART"
        		+ " SET cQuantity=?"
        		+ " WHERE memID=?"
        		+ " AND prdName=?";
        ps = conn.prepareStatement(sql2);
        ps.setInt(1, num); // 상품개수 수정
        ps.setString(2, id); //회원 아이디
        ps.setString(3, name); //상품 이름
        ps.executeUpdate();	
    	
        conn.close();
    }
    
    public void DeleteBasket(String id, String name) throws SQLException {
    	Connection conn = ds.getConnection(); /////////////////
        PreparedStatement ps;
    	
        String sql2 = "DELETE"
        		+ " FROM CART"
        		+ " WHERE memID=?"
        		+ " AND prdName=?";
        ps = conn.prepareStatement(sql2);
        ps.setString(1, id); //회원 아이디
        ps.setString(2, name); //상품 이름
        ps.executeUpdate();	

        conn.close();
    }
    
    // 장바구니 내역 전체 삭제
    public void DeleteAllB(String id) throws SQLException {
    	Connection conn = ds.getConnection(); /////////////////
        PreparedStatement ps;
    	
        String sql2 = "DELETE"
        		+ " FROM CART"
        		+ " WHERE memID=?";
        ps = conn.prepareStatement(sql2);
        ps.setString(1, id); //회원 아이디
        ps.executeUpdate();	

        conn.close();
    }
  
    
    // 	장바구니 총상품금액 구하기
 	public int select_cartPrice(String id) throws SQLException {
 		
 		Connection conn = ds.getConnection(); /////////////////
        PreparedStatement ps;
        ResultSet rs;
 		
 		String sql = "SELECT p.prdPrice, c.cQuantity "
 				+ " FROM CART c, PRODUCT p "
 				+ " WHERE c.prdName=p.prdName "
 				+ " AND c.memID=?";
 		
 		int totalPrice = 0;
 		
 		ps = conn.prepareStatement(sql);
 		ps.setString(1, id);
 		rs = ps.executeQuery();
 		
 		while(rs.next()) {
 			int price = rs.getInt("prdPrice");
 			int qty = rs.getInt("cQuantity");
 			int qPrice = price*qty;
 			totalPrice += qPrice;
 		}
 		conn.close();
 		return totalPrice;
 	}
 	
 	public void InsertTotal(String name,String id, int total) throws SQLException {
 		Connection conn = ds.getConnection(); /////////////////
        PreparedStatement ps;
 		String sql = "UPDATE cart"
 				+ " SET product_price=?"
 				+ " WHERE memid=?"
 				+ " AND prdName=?";
 		ps = conn.prepareStatement(sql);
 		ps.setInt(1, total);
 		ps.setString(2, id);
 		ps.setString(3, name);
 		
 		ps.executeUpdate();	

        conn.close();
	}

 	
 	
 	
 
  
}
