package memberservice;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import memberdb.MemInfoDAO;



public class ServiceLogin{

	public int loginCheck(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, ClassNotFoundException, SQLException, NamingException{
	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		//System.out.println("id");
		String pw = request.getParameter("pw");
		//System.out.println("pw");
		
		MemInfoDAO midao = null;
		HttpSession session = null;
		int result;
		int cnt=0;
		
		midao = new MemInfoDAO();
		
		result = midao.select_loginCheck(id, pw);	
		
		if(result == 1) {
			
			session=request.getSession();
			session.setAttribute("sid", id);

		}
		return result;
	}

}
