package memberservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberdb.MemInfoDAO;



public class MemberInsert implements MemberImpl {

	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
	
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        //입력을 위한 작업으로 값을 넘겨 받음
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String address = address1 + " " +address2; 
        
        String birth = request.getParameter("birth");
        
        MemInfoDAO midao = null;
        
        midao=new MemInfoDAO();
//        midao.insert_mem(name, id, password, tel, email, address, birth);
        
	}
}
