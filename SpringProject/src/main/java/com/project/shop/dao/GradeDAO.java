package com.project.shop.dao;

import com.project.shop.vo.GradeVO;

public interface GradeDAO {
	
	
	
	GradeVO select_gradeInfo(String id);
//	
//	// 등급이름, 등급할인 검색메소드
//	public GradeVO select_gradeInfo(String id) throws SQLException {
//		Connection con = null;
//		con = ds.getConnection();
//		String sql = "SELECT * "
//				+ " FROM GRADE "
//				+ " WHERE gName = (SELECT grade_name FROM MEMBER WHERE memID=?)";
//		
//		GradeVO gv = null;
//		pstmt = con.prepareStatement(sql);
//		
//		pstmt.setString(1, id);
//		
//		rs = pstmt.executeQuery();
//		
//		if(rs.next()) {
//			String gName = rs.getString("gName");
//			int dcPercent = rs.getInt("dcPercent");
//			int startPoint = rs.getInt("startPoint");
//			int endPoint = rs.getInt("endPoint");
//			
//			gv = new GradeVO(gName, dcPercent, startPoint, endPoint);
//		}
//		con.close();
//		return gv;
//	}
//	
//	// 등급까지 남은 점수 구하기
//		public int select_point(String grade_name, int mem_point) throws SQLException {
//			Connection con = ds.getConnection();
//			String sql = "SELECT * FROM Grade "
//					+ " WHERE gname=?";
//			
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, grade_name);
//			rs = pstmt.executeQuery();
//			
//			int end_point = 0;
//			
//			while(rs.next()) {
//				end_point = rs.getInt("endPoint");
//			}
//			
//			int nextpoint = end_point - mem_point + 1;
//
//			con.close();
//			return nextpoint;
//		}
//		
//		
//		// 장바구니에에서 뽑은 상품가격을 등급할인 계산해서 반환해주는 메소드
//		public int discount_oneprice(String mem_id, int product_price) throws SQLException {
//			Connection con = ds.getConnection();
//			String sql = "SELECT dcpercent "
//					+ " FROM Grade "
//					+ " WHERE gname = (SELECT grade_name FROM Member WHERE memid=?)";
//
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, mem_id);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				int dc_percent = rs.getInt("dcpercent");
//				product_price = product_price - product_price*dc_percent/100;
//			}
//			con.close();
//			return product_price;
//		}
//	
	
}
