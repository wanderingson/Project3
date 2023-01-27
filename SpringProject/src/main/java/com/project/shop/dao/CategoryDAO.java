package com.project.shop.dao;

import java.util.ArrayList;

import com.project.shop.vo.CategoryVO;


public interface CategoryDAO {
	
	
    ArrayList<CategoryVO> CategorigetAllCount(int page);
    ArrayList<CategoryVO> AllSubCategoryGet(String subname);
    
//    
//    //  카테고리 페이지
//    public int CategorigetAllCount() throws SQLException {
//        String sql = "SELECT COUNT(*) as count FROM product WHERE cateNum LIKE '%' || ? || '%'";
//        PreparedStatement ps;
//		ResultSet rs;
//		Connection con = ds.getConnection();
//        int count = 0;
//        try{
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, big);
//            rs= ps.executeQuery();
//            if(rs.next()){
//                count = rs.getInt("count");
//            }
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//        con.close();
//        return count;
//     }
//	
	
}
