package basketpay;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import db.BasketDAO;
import db.BasketVO;

public class Pay {
	private String id; 
	
	public Pay(String id) {
		this.id = id;
	}
	
	public void payment() throws NamingException, SQLException {
		ArrayList<BasketVO> vo = new ArrayList<BasketVO>();
		BasketDAO dao = new BasketDAO();
		
		vo = dao.getCartList(id);
		
		for (BasketVO vv : vo) {
			int total = vv.getPrice1()*vv.getNum();
			String name = vv.getName();
			
			dao.InsertTotal(name, id, total);
			
		}
		
		
		
	}
}
