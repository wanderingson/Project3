package review;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ReviewBoardDAO {
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private Connection con = null;
	DataSource ds;
	
	public ReviewBoardDAO() throws SQLException, NamingException {
		Context initContext = new InitialContext();
        Context envContext  = (Context)initContext.lookup("java:/comp/env");
        ds = (DataSource)envContext.lookup("jdbc/myoracle");
        con = ds.getConnection();
	}
	
	
	// 상품 후기 가져오기
//		public ArrayList<ReviewBoardVO> getAllReview(String product_name) throws SQLException {
//			String sql = "SELECT * FROM reviewboard WHERE rproduct=?";
//			
//			ArrayList<ReviewBoardVO> rbArray = new ArrayList<>();
//			
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, product_name);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				String mem_id = rs.getString("rid");
//				String review = rs.getString("review");
//				Date reqDate = rs.getDate("rdate");
//				
//				ReviewBoardVO rbvo = new ReviewBoardVO(mem_id, product_name, review, reqDate);
//				rbArray.add(rbvo);
//			}
//			con.close();
//			return rbArray;
//		}
	// 상품후기 입력했으면 입력못하게
	   public int check_review(String mem_id, String product_name) throws SQLException {
	      String sql = "SELECT * FROM reviewboard "
	            + " WHERE rid=? AND rproduct=?";
	      
	      pstmt = con.prepareStatement(sql);
	      pstmt.setString(1, mem_id);
	      pstmt.setString(2, product_name);
	      rs = pstmt.executeQuery();
	      
	      int cnt = 0;
	      
	      if(rs.next()) {
	         cnt++;
	      }
	      
	      return cnt;
	      // 이미 후기작성을 했으면 1 작성 안 했으면 0 반환   
	   }
		
		// 상품 후기 입력
		public void insert_review(String mem_id, String product_name, String review) {
			String sql = "INSERT INTO reviewboard (rid, rproduct, review,rdate) "
					+ " VALUES(?,?,?,SYSDATE+9/24)";
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mem_id);
				pstmt.setString(2, product_name);
				pstmt.setString(3, review);
				pstmt.executeUpdate();
				con.close();
			} catch (SQLException e) {
				System.out.println("insert_review Exception");
				e.printStackTrace();
			}
			
		}
		
		// 상품후기 입력했으면 입력못하게
//		public void check_review(String mem_id, String product_name) throws SQLException {
//			String sql = "SELECT COUNT(*) as cnt FROM reviewboard "
//					+ " WHERE mem_id=? AND product_name=?";
//			
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, mem_id);
//			pstmt.setString(2, product_name);
//			
//			int cnt = 0;
//			
//			if(rs.next()) {
//				cnt = rs.getInt("cnt");
//			}
//			
//			if(cnt!=0)
//				
//		}
	
	
}
