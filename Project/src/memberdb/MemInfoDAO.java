package memberdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;





public class MemInfoDAO {

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private Connection con = null;
	DataSource ds;
    public MemInfoDAO() throws NamingException, SQLException{ //생성자
            
            	Context initContext = new InitialContext();
               Context envContext  = (Context)initContext.lookup("java:/comp/env");
               ds = (DataSource)envContext.lookup("jdbc/myoracle");
    }
    
	
	public boolean insert_mem(String name, String id, String password, String tel, String email, String address,String address2,String address3, String birth) throws SQLException {
        con = ds.getConnection();

		String sql = "INSERT INTO Member(memname, memid, mempw, memtel, mememail, address1,address2,address3,memBirth)"
				+ " VALUES(?,?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, password);
			pstmt.setString(4, tel);
			pstmt.setString(5, email);
			pstmt.setString(6, address);
			pstmt.setString(7, address2);
			pstmt.setString(8, address3);
			pstmt.setString(9, birth);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("insert_join Exception");
			return false;
		}
		con.close(); 
		return true;
	}//insert-end
	
	
	//회원삭제
		public int delete_mem(String id, String password) throws SQLException {
            con = ds.getConnection();

			int result = -1;
			
			String sql = "SELECT MEMID, MEMPW FROM MEMBER WHERE MEMID=? AND MEMPW=?";
			
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.setString(2, password);	
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					if(id.equals(rs.getString("memid"))&&password.equals(rs.getString("mempw"))) {
						sql = "DELETE FROM MEMBER WHERE MEMID=? AND MEMPW=?";
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, id);
						pstmt.setString(2, password);
						pstmt.executeUpdate();
						result = 0;
						System.out.println("회원삭제 성공");
					}else {
						result = 1;
						System.out.println("회원삭제 실패 result = 1");
					}
				}else {
					result = -1;
					System.out.println("회원삭제 실패 result = -1");
				}
						
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("delete Exception");
				
			}
		 con.close();
			return result;
		}//delete-end
	
	public boolean update_all
		(String name, String id, String password, String tel, String email, String address, String birth) throws SQLException {
        con = ds.getConnection();

		String sql = "UPDATE MEMBER set memname=?, mempw=?, memtel=?, mememail=? "
				+ "				memaddress=?, membirth=? where memid=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, password);
		pstmt.setString(3, tel);
		pstmt.setString(4, email);
		pstmt.setString(5, address);
		pstmt.setString(6, birth);
		pstmt.setString(7, id);
		
		pstmt.executeUpdate();
		
		con.close();
		return true;
	}
	
//	// 로그인 확인 메소드
//	public boolean select_loginCheck(String id, String password) throws SQLException {
//		String sql = "SELECT memID, memPW FROM MEMBER "
//				+ " WHERE memID=? AND memPW=?";
//		boolean result = false;
//		
//
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, id);
//			pstmt.setString(2, password);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				result = true;
//			}
//		
//		con.close();
//		return result;		
//	}
	public int select_loginCheck(String userId, String pw) throws SQLException {
        con = ds.getConnection();

		String sql="SELECT memid,mempw FROM member";
		ArrayList<MemInfoVO> us1 = new ArrayList<MemInfoVO>();
		int login = 0;
		
		try {
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String pw1 = rs.getString(2);
				MemInfoVO user = new MemInfoVO(id,pw1);
				us1.add(user);
			}
			for(MemInfoVO us2 : us1 ) {
				if(us2.getId().equals(userId)) {
					if (us2.getPw().equals(pw)) {
						login=1;// 로그인 성공
						break;
					}	
					login=2;// 비밀번호 오류
					break;
				}								
				else
					login=3;  // 아이디 비밀번호 오류			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			login=4; // db 오류 
			return login;
			
		}
		con.close();
	return login; 
	}
	
	public ArrayList<MemInfoVO> getAllInfo() throws SQLException {
		ArrayList<MemInfoVO> miArray = new ArrayList<>();
        con = ds.getConnection();

		String sql = "SELECT * FROM MEMBER";
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String name = rs.getString("memName");
			String id = rs.getString("memID");
			String pw = rs.getString("memPW");
			String tel = rs.getString("memTel");
			String email = rs.getString("memEmail");
			String address = rs.getString("address1");
			String address2 = rs.getString("address2");
			String address3 = rs.getString("address3");
			String birth = rs.getString("memBirth");
			String gName = rs.getString("grade_name"); // 회원등급 
			int memPoint = rs.getInt("mem_point"); // 등급포인트
			
			MemInfoVO mv = new MemInfoVO(name, id, pw, tel, email, address,address2,address3, birth, gName, memPoint);
			miArray.add(mv);
		}
		con.close();
		return miArray;
	}
	
	// 한사람 검색 메소드
	public MemInfoVO select_memInfo(String id) throws SQLException {
		MemInfoVO mv = null;
        con = ds.getConnection();

		String sql = "SELECT * FROM MEMBER WHERE memID=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String name = rs.getString("memname");
			id = rs.getString("memid");
			String pw = rs.getString("mempw");
			String tel = rs.getString("memtel");
			String email = rs.getString("mememail");
			String address = rs.getString("address1");
			String address2 = rs.getString("address2");
			String address3 = rs.getString("address3");
			String birth = rs.getString("membirth");
			String gName = rs.getString("grade_name"); // 회원등급 
			int memPoint = rs.getInt("mem_point"); // 등급포인트
			
			mv = new MemInfoVO(name, id, pw, tel, email, address,address2,address3, birth, gName, memPoint);
		}
		con.close();
		return mv;
	}
	
	
	//아이디찾기
	public String findId(String name, String tel) throws SQLException {
		String id = null;
        con = ds.getConnection();

		String sql = "SELECT MEMID FROM MEMBER WHERE MEMNAME=? and MEMTEL=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				id = rs.getString("memid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.close();
		return id;
	}

	//비밀번호 찾기
	public String findPw(String id, String name, String tel) throws SQLException {
		String pw = null;
        con = ds.getConnection();

		String sql = "SELECT MEMPW FROM MEMBER WHERE MEMID=? and MEMNAME=? and MEMTEL=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, tel);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				pw = rs.getString("mempw");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.close();
		return pw;
	}

	//아이디 중복체크
	public int joinIdCheck(String id) throws SQLException {
        con = ds.getConnection();

		int result = -1;
		
		String sql = "SELECT MEMID FROM MEMBER WHERE MEMID=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 0;
			}else {
				result = 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block 
			e.printStackTrace();
		}
		con.close();
		return result;

	}
	
	// 회원 등급, 적립금을 수정해주는 메소드
		public void update_gradeName(String mem_id, int mem_point) throws SQLException {
			String grade="";

			MemInfoVO mv = select_memInfo(mem_id);
			mem_point += mv.getMemPoint();
			
			if (mem_point >= 1000000) {
				grade="DIA";
			}else if (mem_point >= 100000) {
				grade="GOLD";
			}else if (mem_point >= 10000) {
				grade="SILVER";
			}else if (mem_point > 1000) {
				grade="BRONZE";
			}else {
				grade="ROOKIE";
			}
			
			String sql = "UPDATE Member "
					+ " SET grade_name=?, mem_point=? "
					+ " WHERE memid=?";
            con = ds.getConnection();

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, grade);
			pstmt.setInt(2, mem_point);
			pstmt.setString(3, mem_id);
			pstmt.executeUpdate();
			
			con.close();
		}	
		// 회원정보수정
		public void update_memInfo(String id, String pw, String tel, 
				String address1,String address2,String address3) throws SQLException {
            con = ds.getConnection();

			String sql = "UPDATE Member "
					+ " SET mempw=?, memtel=?, address1=?,address2=?,address3=?"
					+ " WHERE memid=?";
			
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, pw);
				pstmt.setString(2, tel);
				pstmt.setString(3, address1);
				pstmt.setString(4, address2);
				pstmt.setString(5, address3);
				pstmt.setString(6, id);
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				System.out.println("update_memInfo Exception");
				e.printStackTrace();
			}
			
			System.out.println("update_memInfo");
			con.close();
					
		}


}	

