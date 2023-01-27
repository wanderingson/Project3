package memberservice;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memberdb.MemInfoDAO;
import service.ServiceImpl;



public class ServiceMemInfoUpdate implements ServiceImpl{

   @Override
   public void revise(HttpServletRequest request, HttpServletResponse response) throws NamingException, Exception {
      request.setCharacterEncoding("UTF-8");
      response.setCharacterEncoding("UTF-8");
      System.out.println("Service 확인");
      MemInfoDAO midao = new MemInfoDAO();
      
      String id = request.getParameter("userid");
      String pw0 = request.getParameter("password0");
      String pw1 = request.getParameter("password1");
      String pw2 = request.getParameter("password2");
      String tel = request.getParameter("tel");
      String address1 = request.getParameter("post");
      String address2 = request.getParameter("address1");
      String address3 = request.getParameter("address2");

      
      System.out.println("id " + id);
      System.out.println("pw0 " + pw0);
      System.out.println("pw1 " + pw1);
      System.out.println("pw2 " + pw2);
      System.out.println("tel " + tel);
      System.out.println("address1 " + address1);
      
      if(pw1!=""&&pw2!=""||pw1==pw2) {
         midao.update_memInfo(id, pw2, tel, address1,address2,address3);
         System.out.println("pw2 저장");
      }else {
         midao.update_memInfo(id, pw0, tel, address1,address2,address3);
         System.out.println("pw0 저장");
      }
      
      
      
   }

}