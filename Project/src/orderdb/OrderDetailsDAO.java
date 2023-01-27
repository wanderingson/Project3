package orderdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OrderDetailsDAO {
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	private Connection con = null;
	DataSource ds;
	
	public OrderDetailsDAO() throws SQLException, NamingException {
		Context initContext = new InitialContext();
        Context envContext  = (Context)initContext.lookup("java:/comp/env");
        ds = (DataSource)envContext.lookup("jdbc/myoracle");
	}
	
	
	// 주문상세 내용 가져오기
	public ArrayList<OrderDetailsVO> getOrderDetailsInfo(int order_num) throws SQLException {
		String sql = "SELECT * FROM OrderDetails WHERE order_num=? ORDER BY order_details_num";
        con = ds.getConnection();

		ArrayList<OrderDetailsVO> odvArray = new ArrayList<>();
		OrderDetailsVO odv = null;
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, order_num);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int order_details_num = rs.getInt("order_details_num");
			String product_name = rs.getString("product_name");
			int product_qty = rs.getInt("product_qty");
			int order_price = rs.getInt("order_price");
			String delivery_state = rs.getString("delivery_state");
			odv = new OrderDetailsVO(order_details_num, order_num, product_name, product_qty, order_price, delivery_state);
			odvArray.add(odv);
		}
		con.close();
		return odvArray;
	}
	
	// 배송상태가 "환불요청"인 상세내역 가져오기
	public ArrayList<OrderDetailsVO> getAllRefundChk() throws SQLException {
		String sql = "SELECT * FROM OrderDetails WHERE delivery_state='환불요청' "
				+ " ORDER BY order_details_num"; 
        con = ds.getConnection();

		ArrayList<OrderDetailsVO> odvArray = new ArrayList<>();
		OrderDetailsVO odv = null;
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int order_details_num = rs.getInt("order_details_num");
			int order_num = rs.getInt("order_num");
			String product_name = rs.getString("product_name");
			int product_qty = rs.getInt("product_qty");
			int order_price = rs.getInt("order_price");
			String delivery_state = rs.getString("delivery_state");
			odv = new OrderDetailsVO(order_details_num, order_num, product_name, product_qty, order_price, delivery_state);
			odvArray.add(odv);
		}		
		con.close();
		return odvArray;
	}
	
	// 배송상태가 "환불완료"인 상세내역 가져오기
	public ArrayList<OrderDetailsVO> getAllRefund() throws SQLException {
		String sql = "SELECT * FROM OrderDetails WHERE delivery_state='환불완료' "
				+ " ORDER BY order_details_num"; 
        con = ds.getConnection();

		ArrayList<OrderDetailsVO> odvArray = new ArrayList<>();
		OrderDetailsVO odv = null;
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int order_details_num = rs.getInt("order_details_num");
			int order_num = rs.getInt("order_num");
			String product_name = rs.getString("product_name");
			int product_qty = rs.getInt("product_qty");
			int order_price = rs.getInt("order_price");
			String delivery_state = rs.getString("delivery_state");
			odv = new OrderDetailsVO(order_details_num, order_num, product_name, product_qty, order_price, delivery_state);
			odvArray.add(odv);
		}		
		con.close();
		
		return odvArray;
	}
	
	
	// 주문상세 내용 입력(결제할때 사용)
	// 시퀀스 세션때문에 OrderDAO 에서 사용
//	public void insert_orderDeatailsInfo(String product_name, int product_qty, int order_price) {
//		String sql = "INSERT INTO OrderDetails (order_details_num, order_num, product_name, product_qty, order_price)"
//				+ " VALUES(order_details_num.NEXTVAL, order_num.CURRVAL,?,?,?)";
//		
//		try {
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, product_name);
//			pstmt.setInt(2, product_qty);
//			pstmt.setInt(3, order_price);
//			pstmt.executeUpdate();
//			
//	
//		} catch (SQLException e) {
//			System.out.println("insert_orderDeatailsInfo Exception");
//			e.printStackTrace();
//		}
//		
//	}
	
	// 전체 상품수량 구하기(주문내역에 표시)
	public int select_allQty(int order_num) throws SQLException {
		String sql = "SELECT product_qty FROM OrderDetails WHERE order_num=?";
        con = ds.getConnection();

		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, order_num);
		rs = pstmt.executeQuery();
		
		int total_qty = 0;
		
		while(rs.next()) {
			int product_qty = rs.getInt("product_qty");
			total_qty += product_qty;
		}

		con.close();
		return total_qty;
	}
	
	// 환불요청되었을 때 상품현황 환불요청로 바꿔주기
	public void update_deliveryState(int order_details_num) throws SQLException {
		String sql = "UPDATE OrderDetails "
				+ " SET delivery_state='환불요청' "
				+ " WHERE order_details_num=?";
        con = ds.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order_details_num);
			pstmt.executeUpdate();
	
		} catch (SQLException e) {
			System.out.println("update_deliveryState");
			e.printStackTrace();
		}con.close();
		
	}
	
	
	
	// 상품수량 검색
	public int select_count(int order_num) throws SQLException {
		String sql = "SELECT COUNT(*) as count FROM OrderDetails WHERE order_num=?";
        con = ds.getConnection();

		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, order_num);
		rs = pstmt.executeQuery();
		
		int cnt = 0;
		
		if(rs.next()) {
			cnt = rs.getInt("count");
		}
		con.close();
		
		return cnt;
		
	}
	
	// 대표이름 반환, 주문내역에 상품명 등 0건을 표시해주기 위해 주문상세내역에서 상위 상품명1개 가져오기
	public String select_listMainName(int order_num) throws SQLException {
		String sql = "SELECT product_name FROM OrderDetails WHERE order_num=? AND ROWNUM=1";
        con = ds.getConnection();

		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, order_num);
		rs = pstmt.executeQuery();
		
		String product_name = "";
		
		if(rs.next()) {
			product_name = rs.getString("product_name");
		}
		
		con.close();
		return product_name;
	}
	
	// 전체가격에서 환불처리된 가격 뺴주기// 환불 완료
	public int select_refundPrice(int order_num, int total_price) throws SQLException {
		String sql = "SELECT order_price, product_qty FROM OrderDetails "
				+ " WHERE order_num=? AND delivery_state='환불완료'";
        con = ds.getConnection();

		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, order_num);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int order_price = rs.getInt("order_price");
			total_price = total_price - order_price;
		}
		
		if(total_price < 0) {
			total_price = 0;
		}
		con.close();
		return total_price;	
	}
	
	// 환불가능여부 확인
	// 환불날짜 - 주문날짜가 14 보다 크면 주문 못하게 하기
	public boolean select_refundCheck(int order_num) throws SQLException {
		String sql = "SELECT (SYSDATE - (SELECT order_date FROM Orders WHERE order_num =?)) as dd "
				+ " FROM dual";
        con = ds.getConnection();

		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, order_num);
		rs = pstmt.executeQuery();
			
		double time_chk = 0.0;
			
		if(rs.next()) {
			time_chk = rs.getDouble("dd");
		}
		con.close();
			
		if(time_chk > 14) {
			return false;
		}else {
			return true;
		}
		
	}
	

	// 상세주문내역에서 모든 상품을 환불상태 확인 
	public int check_reqRefundCnt(int order_num) throws SQLException {
		String sql = "SELECT count(*) as cnt FROM OrderDetails "
				+ " WHERE (delivery_state='배송완료' or delivery_state='주문요청') "
				+ " AND order_num=?";
        con = ds.getConnection();

		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, order_num);
		rs = pstmt.executeQuery();
		
		int cnt = 0;
		
		if(rs.next()) {
			 cnt = rs.getInt("cnt");
		}

		con.close();
		return cnt;
	}
	
	// check_stateInfo()로 Orderdetails 에 '주문요청' 또는 '배송완료'가 1개도 없으면 Orders 도 환불요청으로 
	public void update_reqRefund(int order_num) throws SQLException {
		String sql = "UPDATE Orders SET delivery_state='환불요청' "
				+ " WHERE order_num=?";
        con = ds.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order_num);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}con.close();
	}
	
	// 관리자가 환불확인 해주면 해당 상품 환불완료로 변경해주기
	public void update_refundDetails(int order_details_num) throws SQLException {
		String sql = "UPDATE OrderDetails SET delivery_state='환불완료' "
				+ " WHERE order_details_num=?";
        con = ds.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order_details_num);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("update_refundOrder Exception");
			e.printStackTrace();
		}
		con.close();
		
	}
	
	
	// 상세주문내역에서 모든 상품을 환불상태 확인 
	public int check_refundCnt(int order_num) throws SQLException {
		String sql = "SELECT count(*) as cnt FROM OrderDetails "
				+ " WHERE (delivery_state='배송완료' or delivery_state='주문요청' or delivery_state='환불요청') "
				+ " AND order_num=?";
        con = ds.getConnection();

		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, order_num);
		rs = pstmt.executeQuery();
			
		int cnt = 0;
			
		if(rs.next()) {
			 cnt = rs.getInt("cnt");
		}
		con.close();
		return cnt;
	}
	
	
	// 관리자가 환불처리를 했을 때 orderdetails 이 모두 환불완료면 orders 도 '환불완료'로 
	public void update_refundOrder(int order_num) throws SQLException {
		String sql = "UPDATE Orders SET delivery_state='환불완료' "
				+ " WHERE order_num=?";
        con = ds.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order_num);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("update_refundDetails Exception");
			e.printStackTrace();
		}con.close();
	}
	
	// 관리자가 주문확인 해주면 주문상세내역 배송완료로
	public void ckeckOrder(int order_num) throws SQLException {
		String sql = "UPDATE OrderDetails SET delivery_state='배송완료' WHERE order_num=? ";
        con = ds.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order_num);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("checkOrder Exception");
			e.printStackTrace();
		}
		con.close();
	}
	
	
}
