package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class QnADao {
//	private static QnADao qnaDao = new QnADao();
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private int result = 0;
	DataSource ds;

//	public static QnADao getInstance() {
//		return qnaDao;
//	}
	
	
	public QnADao() throws NamingException {
		Context initContext = new InitialContext();
        Context envContext  = (Context)initContext.lookup("java:/comp/env");
        ds = (DataSource)envContext.lookup("jdbc/myoracle");
	}

//	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
//		
//		if (rs != null) {
//			try {
//				rs.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		if (pstmt != null) {
//			try {
//				pstmt.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		if (con != null) {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	public int nextval() throws SQLException {
		Connection con = ds.getConnection();
		StringBuffer query = new StringBuffer();
		query.append("SELECT MAX(qnaId) ").append("FROM qna");
		
		try {
			pstmt = con.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getInt("MAX(qnaId)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}
	
	public int answer(QnADto qnaDto) throws SQLException {
		Connection con = ds.getConnection();
		StringBuffer query = new StringBuffer();
		query.append("UPDATE qna set qnaAnswer=? ");
		query.append("WHERE qnaID=?");
		
		pstmt=con.prepareStatement(query.toString());
		pstmt.setString(1, qnaDto.getQnaAnswer());
		pstmt.setInt(2, qnaDto.getQnaId());
		result = pstmt.executeUpdate();
		
		con.close();

		return result;
	}
	
	public int write(QnADto qnaDto) throws SQLException {
		Connection con = ds.getConnection();
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO qna ");
		query.append("(qnaId, qnaTitle, qnaContent, qnaDate,  qnaCategory, memid) ");
		query.append("VALUES (?, ?, ?, SYSDATE+9/24, ?, ?)");
		try {
			pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(1, qnaDto.getQnaId());
			pstmt.setString(2, qnaDto.getQnaTitle());
			pstmt.setString(3, qnaDto.getQnaContent());
			pstmt.setString(4, qnaDto.getQnaCategory());
			pstmt.setString(5, qnaDto.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}
	public List<QnADto> selectList() throws SQLException{
		List<QnADto> list = new ArrayList<>();
		Connection con = ds.getConnection();
		try {
			
			String sql ="SELECT * FROM qna ORDER BY qnaId DESC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				QnADto qnaDto = new QnADto();
				qnaDto.setQnaId(rs.getInt("qnaId"));
				qnaDto.setQnaTitle(rs.getString("qnaTitle"));
				qnaDto.setQnaContent(rs.getString("qnaContent"));
				qnaDto.setQnaDate(rs.getTimestamp("qnaDate"));
//				qnaDto.setQnaHit(rs.getInt("qnaHit"));
				qnaDto.setQnaAnswer(rs.getString("qnaAnswer"));
				qnaDto.setQnaCategory(rs.getString("qnaCategory"));
				qnaDto.setId(rs.getString("memid"));
				list.add(qnaDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return list;
	}
	
//	public int hitUpdate(String qnaId) {
//		con = getConnect();
//		String sql = "UPDATE qna SET qnaHit = qnaHit + 1 WHERE qnaId = ?";
//		
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, qnaId);
//			result = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(con, pstmt, null);
//		}
//		return result;
//	}
	
	public QnADto selectById(String qnaId) throws SQLException {
		QnADto qnaDto = new QnADto();
		Connection con = ds.getConnection();
		String sql = "SELECT * FROM qna WHERE qnaId = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, qnaId);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				qnaDto.setQnaId(rs.getInt("qnaid"));
				qnaDto.setQnaTitle(rs.getString("qnatitle"));
				qnaDto.setQnaContent(rs.getString("qnacontent"));
				qnaDto.setQnaAnswer(rs.getString("qnaAnswer"));
				qnaDto.setQnaDate(rs.getTimestamp("qnadate"));
//				qnaDto.setQnaHit(rs.getInt("qnahit"));
				qnaDto.setQnaCategory(rs.getString("qnacategory"));
				qnaDto.setId(rs.getString("memid"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return qnaDto;
	}
	public int del(int qnaId) throws SQLException {
		Connection con = ds.getConnection();
		String sql = "DELETE FROM qna WHERE qnaId = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, qnaId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}

	public int update(QnADto qnaDto) throws SQLException {
		Connection con = ds.getConnection();
		StringBuffer query = new StringBuffer();
		query.append("UPDATE qna SET qnaTitle = ?, ");
		query.append("qnaContent = ?, ");
		query.append("qnaCategory = ? ");
		query.append("WHERE qnaId = ?");
		
		try {
			pstmt = con.prepareStatement(query.toString());
			pstmt.setString(1, qnaDto.getQnaTitle());
			pstmt.setString(2, qnaDto.getQnaContent());
			pstmt.setString(3, qnaDto.getQnaCategory());
			pstmt.setInt(4, qnaDto.getQnaId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}
}