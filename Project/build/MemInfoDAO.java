package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import meminfoBDConn.MemInfoDBConn;
import meminfoVO.MemInfoVO;


public class MemInfoDAO {

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private Connection con = null;
	DataSource ds;
    public MemInfoDAO() throws NamingException, SQLException{ //생성자
            
            Context initContext = new InitialContext();
               Context envContext  = (Context)initContext.lookup("java:/comp/env");
               ds = (DataSource)envContext.lookup("jdbc/myoracle");
               Connection con = ds.getConnection();
    }
    
	
	public boolean insert_mem(String name, String id, String password, String tel, String email, String address, String birth) {
		
		String sql = "INSERT INTO MEMBER values(?,?,?,?,?,?,?,'ROOKIE',0)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, password);
			pstmt.setString(4, tel);
			pstmt.setString(5, email);
			pstmt.setString(6, address);
			pstmt.setString(7, birth);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("insert_join Exception");
			return false;
		}
		return true;
	}//insert-end
	
	public boolean delete_mem(String id, String password) {
		
		String sql = "DELETE FROM MEMBER WHERE MEMID=? AND MEMPW=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("delete Exception");
			return false;
		}
		return true;
	}
	
	public boolean update_all
		(String name, String id, String password, String tel, String email, String address, String birth) throws SQLException {
		
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
		
		return true;
	}
	
	// �α��� Ȯ�� �޼ҵ�
	public boolean select_loginCheck(String id, String password) throws SQLException {
		String sql = "SELECT memID, memPW FROM MEMBER "
				+ " WHERE memID=? AND memPW=?";
		boolean result = false;
		

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
		
		
		return result;		
	}
	
	public ArrayList<MemInfoVO> getAllInfo() throws SQLException {
		ArrayList<MemInfoVO> miArray = new ArrayList<>();
		
		String sql = "SELECT * FROM MEMBER";
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String name = rs.getString("memName");
			String id = rs.getString("memID");
			String pw = rs.getString("memPW");
			String tel = rs.getString("memTel");
			String email = rs.getString("memEmail");
			String address = rs.getString("memAddress");
			String birth = rs.getString("memBirth");
			String gName = rs.getString("gName"); // ȸ����� 
			int memPoint = rs.getInt("memPoint"); // �������Ʈ
			
			MemInfoVO mv = new MemInfoVO(name, id, pw, tel, email, address, birth, gName, memPoint);
			miArray.add(mv);
		}
		return miArray;
	}
	
	// �ѻ�� �˻� �޼ҵ�
	public MemInfoVO select_memInfo(String id) throws SQLException {
		MemInfoVO mv = null;
		
		String sql = "SELECT * FROM MEMBER WHERE memID=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String name = rs.getString("memName");
			id = rs.getString("memID");
			String pw = rs.getString("memPW");
			String tel = rs.getString("memTel");
			String email = rs.getString("memEmail");
			String address = rs.getString("memAddress");
			String birth = rs.getString("memBirth");
			String gName = rs.getString("gName"); // ȸ����� 
			int memPoint = rs.getInt("memPoint"); // �������Ʈ
			
			mv = new MemInfoVO(name, id, pw, tel, email, address, birth, gName, memPoint);
		}
		return mv;
	}
	
	
	//���̵�ã��
	public String findId(String name, String tel) {
		String id = null;
		
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
		return id;
	}

	//��й�ȣ ã��
	public String findPw(String id, String name, String tel) {
		String pw = null;
		
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
		return pw;
	}

	//���̵� �ߺ�üũ
	public int joinIdCheck(String id) {
		
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
			
			System.out.println("���̵� �ߺ�üũ ��� : " + result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
	


}	

