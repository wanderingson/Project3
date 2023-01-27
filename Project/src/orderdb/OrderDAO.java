package orderdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OrderDAO {
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private Connection con = null;
	DataSource ds;
	
	public OrderDAO() throws SQLException, NamingException {
		Context initContext = new InitialContext();
        Context envContext  = (Context)initContext.lookup("java:/comp/env");
        ds = (DataSource)envContext.lookup("jdbc/myoracle");
        
	}
	
	// "배송완료" 인 주문내역 전체 가져오기(관리자)
	public ArrayList<OrderVO> getAllInfo() throws SQLException {
		String sql = "SELECT * FROM Orders WHERE delivery_state='배송완료' ORDER BY order_date DESC ";
		con = ds.getConnection();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		ArrayList<OrderVO> ovArray = new ArrayList<>();
		
		while(rs.next()) {
			int order_num = rs.getInt("order_num");
			String mem_id1  = rs.getString("mem_id");
			String address1 = rs.getString("address1");
			String address2 = rs.getString("address2");
			String address3 = rs.getString("address3");
			String tel = rs.getString("tel");
			int total_price = rs.getInt("total_price");
			String delivery_state = rs.getString("delivery_state");
			Date order_date = rs.getDate("order_date");
			String delivery_message = rs.getString("delivery_message");
			
			OrderVO ov = new OrderVO(order_num, mem_id1, address1, address2, address3, tel, total_price, delivery_state, order_date, delivery_message);
			ovArray.add(ov);
		}
		
		con.close();
		return ovArray;				
	}
	
	// "주문요청" 인 주문내역 전체 가져오기(관리자)
	public ArrayList<OrderVO> getAllCheckOrders() throws SQLException {
		String sql = "SELECT * FROM Orders WHERE delivery_state='주문요청' ORDER BY order_date DESC";
		con = ds.getConnection();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		ArrayList<OrderVO> ovArray = new ArrayList<>();
		
		while(rs.next()) {
			int order_num = rs.getInt("order_num");
			String mem_id1  = rs.getString("mem_id");
			String address1 = rs.getString("address1");
			String address2 = rs.getString("address2");
			String address3 = rs.getString("address3");
			String tel = rs.getString("tel");
			int total_price = rs.getInt("total_price");
			String delivery_state = rs.getString("delivery_state");
			Date order_date = rs.getDate("order_date");
			String delivery_message = rs.getString("delivery_message");
			
			OrderVO ov = new OrderVO(order_num, mem_id1, address1, address2, address3, tel, total_price, delivery_state, order_date, delivery_message);
			ovArray.add(ov);
		}
		
		con.close();
		return ovArray;				
	}
	
	// "환불요청" 인 주문내역 전체 가져오기(관리자)
	public ArrayList<OrderVO> getAllCheckRefunds() throws SQLException {
		String sql = "SELECT * FROM Orders WHERE delivery_state='환불요청' ORDER BY order_date DESC";
		con = ds.getConnection();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
			
		ArrayList<OrderVO> ovArray = new ArrayList<>();
			
		while(rs.next()) {
			int order_num = rs.getInt("order_num");
			String mem_id1  = rs.getString("mem_id");
			String address1 = rs.getString("address1");
			String address2 = rs.getString("address2");
			String address3 = rs.getString("address3");
			String tel = rs.getString("tel");
			int total_price = rs.getInt("total_price");
			String delivery_state = rs.getString("delivery_state");
			Date order_date = rs.getDate("order_date");
			String delivery_message = rs.getString("delivery_message");
				
			OrderVO ov = new OrderVO(order_num, mem_id1, address1, address2, address3, tel, total_price, delivery_state, order_date, delivery_message);
			ovArray.add(ov);
		}
		con.close();
		return ovArray;				
	}
		
	// "환불완료" 인 주문내역 전체 가져오기(관리자)
	public ArrayList<OrderVO> getAllRefunds() throws SQLException {
		String sql = "SELECT * FROM Orders WHERE delivery_state='환불완료' ORDER BY order_date DESC ";
		con = ds.getConnection();
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
			
		ArrayList<OrderVO> ovArray = new ArrayList<>();
			
		while(rs.next()) {
			int order_num = rs.getInt("order_num");
			String mem_id1  = rs.getString("mem_id");
			String address1 = rs.getString("address1");
			String address2 = rs.getString("address2");
			String address3 = rs.getString("address3");
			String tel = rs.getString("tel");
			int total_price = rs.getInt("total_price");
			String delivery_state = rs.getString("delivery_state");
			Date order_date = rs.getDate("order_date");
			String delivery_message = rs.getString("delivery_message");
				
			OrderVO ov = new OrderVO(order_num, mem_id1, address1, address2, address3, tel, total_price, delivery_state, order_date, delivery_message);
			ovArray.add(ov);
		}

		con.close();
		return ovArray;				
	}
	
	
	
	
	// 주문자의 주문목록 뽑아오기(관리자)
	public ArrayList<OrderVO> getInfo(String mem_id) throws SQLException {
		String sql = "SELECT * FROM Orders WHERE mem_id=? ORDER BY order_date DESC";
		con = ds.getConnection();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, mem_id);
		rs = pstmt.executeQuery();
		
		ArrayList<OrderVO> ovArray = new ArrayList<>();
		
		while(rs.next()) {
			int order_num = rs.getInt("order_num");
			String mem_id1  = rs.getString("mem_id");
			String address1 = rs.getString("address1");
			String address2 = rs.getString("address2");
			String address3 = rs.getString("address3");
			String tel = rs.getString("tel");
			int total_price = rs.getInt("total_price");
			String delivery_state = rs.getString("delivery_state");
			Date order_date = rs.getDate("order_date");
			String delivery_message = rs.getString("delivery_message");
			
			OrderVO ov = new OrderVO(order_num, mem_id1, address1, address2, address3, tel, total_price, delivery_state, order_date, delivery_message);
			ovArray.add(ov);
		}
		
		con.close();
		return ovArray;
	}
	
	// 주문번호를 통해 한사람정보 가져오기(관리자)
	public OrderVO getOneInfo(int order_num) throws SQLException {
		String sql = "SELECT * FROM Orders WHERE order_num=?";
		con = ds.getConnection();
		pstmt = con.prepareStatement(sql);
		//pstmt.setString(1, mem_id);
		pstmt.setInt(1, order_num);
		rs = pstmt.executeQuery();
		
		OrderVO odvo = null;
		
		if(rs.next()) {
			order_num = rs.getInt("order_num");
			String mem_id1  = rs.getString("mem_id");
			String address1 = rs.getString("address1");
			String address2 = rs.getString("address2");
			String address3 = rs.getString("address3");
			String tel = rs.getString("tel");
			int total_price = rs.getInt("total_price");
			String delivery_state = rs.getString("delivery_state");
			Date order_date = rs.getDate("order_date");
			String delivery_message = rs.getString("delivery_message");
			
			odvo = new OrderVO(order_num, mem_id1, address1, address2, address3, tel, total_price, delivery_state, order_date, delivery_message);
		}
		
		con.close();
		return odvo;
		
	}
	
	// 주문버튼 눌렀을 떄 DB에 정보 입력
	public void insert_orderInfo(String mem_id, String address1, String address2, String address3, String tel, int total_price, String delivery_message) throws SQLException {
		String sql = "INSERT INTO Orders(order_num, mem_id, address1, address2, address3, tel, total_price, delivery_message) "
				+ " VALUES(order_num.NEXTVAL,?,?,?,?,?,?,?)";
		con = ds.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, address1);
			pstmt.setString(3, address2);
			pstmt.setString(4, address3);
			pstmt.setString(5, tel);
			pstmt.setInt(6, total_price);
			pstmt.setString(7, delivery_message);
			pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			System.out.println("insert_orderInfo Exception");
			//e.printStackTrace();
		}con.close();
		
		
	}
	
	// 주문확인버튼 누르면 주문내역에 있는 주문요청을 배송완료로 바꿔주기
	public void ckeckOrder(int order_num) throws SQLException {
		String sql = "UPDATE Orders SET delivery_state='배송완료' WHERE order_num=? ";
		con = ds.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order_num);
			pstmt.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("checkOrder Exception");
			e.printStackTrace();
		}con.close();
		
		
	}
	
	// 주문상세 내용 입력(결제할때 사용)
	// 시퀀스 세션때문에 OrderDAO 에서 사용
	public void insert_orderDeatailsInfo(String product_name, int product_qty, int order_price) throws SQLException {
		String sql = "INSERT INTO OrderDetails (order_details_num, order_num, product_name, product_qty, order_price)"
				+ " VALUES(order_details_num.NEXTVAL, order_num.CURRVAL,?,?,?)";
		con = ds.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product_name);
			pstmt.setInt(2, product_qty);
			pstmt.setInt(3, order_price);
			pstmt.executeUpdate();
			con.close();
		
		} catch (SQLException e) {
			System.out.println("insert_orderDeatailsInfo Exception");
			e.printStackTrace();
		}con.close();
		
	}

}
