package service;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;


import db.BasketDAO;
import db.BasketVO;

public class BasketPlus{
	private String id = "";
	private String name = "";
	private String num = "";
	
	
	public BasketPlus(String id,String name,String num) {
		this.id = id;
		this.name = name;
		this.num = num;
	}
	
	
	public void Insert() throws NamingException, SQLException{
		
		int number = Integer.parseInt(num);
		String search= ""; 
		BasketDAO dao = new BasketDAO();
		
		ArrayList<BasketVO> vo = new ArrayList<BasketVO>();
		
		vo = dao.getOneCartList(id);
		
		
		if (vo.isEmpty()) {
			search = "insert";
		}else {
			for (BasketVO print : vo) {
				if(name.equals(print.getName())) {
					search = "update";
					break;
				}
				else {
					search = "insert";
				}
			}
		}
		

		if(search.equals("update")) {
			
			dao.UpdateBasket(id, name, number);
			
		}else if (search.equals("insert")) {
			
			dao.InsertBasket(id,name,number); 
		}

	}	
	
	
	
}
