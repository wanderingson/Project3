package memberservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberdb.MemInfoDAO;
import memberdb.MemInfoVO;


public class MemberUpdate implements MemberImpl{
	
	@Override
	public void haeva(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        MemInfoDAO midao = null;
        MemInfoVO mv = null;
        
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        String birth = request.getParameter("birth");
        String address = request.getParameter("address");
        
        midao = new MemInfoDAO();
        
        midao.update_all(id, password, name, email, tel, birth, address);

		
	}

}
