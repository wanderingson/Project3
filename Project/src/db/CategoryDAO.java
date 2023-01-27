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

public class CategoryDAO {
	
	private int big;
	
	public void setBig(int big) {
		this.big = big;
	}
	
	private String small;
	
	public void setSmall(String small) {
		this.small = small;
	}
	
	DataSource ds;
    public CategoryDAO() throws NamingException, SQLException{ //생성자
            
            Context initContext = new InitialContext();
               Context envContext  = (Context)initContext.lookup("java:/comp/env");
               ds = (DataSource)envContext.lookup("jdbc/myoracle");
    }
    
    //  카테고리 페이지
    public int CategorigetAllCount() throws SQLException {
        String sql = "SELECT COUNT(*) as count FROM product WHERE cateNum LIKE '%' || ? || '%'";
        PreparedStatement ps;
		ResultSet rs;
		Connection con = ds.getConnection();
        int count = 0;
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, big);
            rs= ps.executeQuery();
            if(rs.next()){
                count = rs.getInt("count");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        con.close();
        return count;
     }
	
	// 대분류 분야별 전체 출력 
    public ArrayList<CategoryVO> AllBigCategoryGet(int page) throws SQLException {
		
		ArrayList<CategoryVO> vo = new ArrayList<CategoryVO>();
		 Connection conn = ds.getConnection(); /////////////////
         PreparedStatement ps;
         ResultSet rs;
         int startNum = (page-1)*9+1;
         int endNum = page*9;
         
         String sql = "SELECT *"
         		+ " FROM (SELECT *"
         		+ " FROM (SELECT ROWNUM row_num, product.* FROM product WHERE cateNum LIKE '%' || ? || '%')"
         		+ " WHERE row_num >= ?) WHERE row_num <= ?";
        
         
             ps = conn.prepareStatement(sql);
             ps.setInt(2, startNum);
             ps.setInt(3, endNum);
             ps.setInt(1, big); 
             rs = ps.executeQuery();
         
         while (rs.next()) {
			String product = rs.getString("prdName");
			int price = rs.getInt("prdPrice");
        	 CategoryVO resultVO = new CategoryVO(product,price);
        	 vo.add(resultVO);
		}
 		conn.close();
		return vo;
		
	}
	
	
	// 소분류 분야별 전체 출력
	public ArrayList<CategoryVO> AllSmallCategoryGet() throws SQLException {
		
		ArrayList<CategoryVO> vo = new ArrayList<CategoryVO>();
		 Connection conn = ds.getConnection(); /////////////////
         PreparedStatement ps;
         ResultSet rs;
         
         String sql = "SELECT * "
         		+ " FROM PRODUCT"
         		+ " WHERE cateSubName = ?";
        
         
         ps = conn.prepareStatement(sql);
         ps.setString(1, small); //소분류 이름
         rs = ps.executeQuery();
         
         while (rs.next()) {
			String product = rs.getString("prdName");
			int price = rs.getInt("prdPrice");
        	 CategoryVO resultVO = new CategoryVO(product,price);
        	 vo.add(resultVO);
		}
        conn.close();
		return vo;
	}
	
}
