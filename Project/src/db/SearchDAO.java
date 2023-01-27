package db;

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



public class SearchDAO {
	DataSource ds; ////////////////
    public SearchDAO() throws NamingException, SQLException{ //생성자
            try {
            Context initContext = new InitialContext();
               Context envContext  = (Context)initContext.lookup("java:/comp/env");
               ds = (DataSource)envContext.lookup("jdbc/myoracle");
              // Connection conn = ds.getConnection();
               //etc.
            }catch (Exception e) {
				e.printStackTrace();
            	// TODO: handle exception
			}
    }
    
    public ArrayList<SearchVO> Searchkey(String keyword) throws SQLException{
//		Connection conn = ds.getConnection();
		PreparedStatement ps;
		 ResultSet rs;
		Connection con = ds.getConnection();
		 ArrayList<SearchVO> clist = new ArrayList<SearchVO>();

		
		try {
		String sql = "SELECT prdName,prdPrice FROM PRODUCT WHERE prdName LIKE '%' || ? || '%'";
//		String sql="insert into product values(4,'이런시발',?,'부들',3000)";

		ps = con.prepareStatement(sql);
		ps.setString(1, keyword);
        rs = ps.executeQuery();

        while (rs.next()) {
        	
        	
    		String prdName = rs.getString(1);
    		int prdPrice = rs.getInt(2);
    		SearchVO cv = new SearchVO(prdName,prdPrice);
        	clist.add(cv); 
    		
        	System.out.println(rs);
		}
        
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("select error");
		}
		System.out.println("생성성공!");
		
        System.out.println(clist.size());
        
        return clist;
        
	}
    
    public List<SearchVO> selectAllMember(int page, String search) throws SQLException{
    	PreparedStatement ps;
		ResultSet rs;
		Connection con = ds.getConnection();
        //1번 페이지 1~10
        //2번 페이지 11~20        
        int startNum = (page-1)*9+1;
        int endNum = page*9;
        
        String sql = "SELECT *"
        		+ " FROM (SELECT *"
        		+ " FROM (SELECT ROWNUM row_num, product.* FROM product WHERE prdName LIKE '%' || ? || '%')"
        		+ " WHERE row_num >= ?) WHERE row_num <= ?";
        List<SearchVO> list1 = new ArrayList<SearchVO>();
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(2, startNum);
            ps.setInt(3, endNum);
            ps.setString(1, search); 
            rs = ps.executeQuery();
            while(rs.next()){
            	
        		String prdName = rs.getString("prdName");
        		int prdPrice = rs.getInt("prdPrice");
        		
        		SearchVO vo = new SearchVO(prdName, prdPrice);
               
                list1.add(vo);
                
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        System.out.println("성공");
        System.out.println(list1.size());
        return list1;
    }
    
    public int getAllCount(String search) throws SQLException {
        String sql = "SELECT COUNT(*) as count FROM product WHERE prdName LIKE '%' || ? || '%'";
        PreparedStatement ps;
		ResultSet rs;
		Connection con = ds.getConnection();
        int count = 0;
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, search);
            rs= ps.executeQuery();
            if(rs.next()){
                count = rs.getInt("count");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return count;
     }

	public static SearchDAO getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
    
    

	


	

}
