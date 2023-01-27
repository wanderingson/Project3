package com.shop.search;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import basketpay.Pay;
import db.BasketDAO;
import managerservice.ServiceOrderCheck;
import managerservice.ServicePrdDelete;
import managerservice.ServicePrdInsert;
import managerservice.ServicePrdUpdate;
import managerservice.ServiceRefundCheck;
import memberdb.MemInfoDAO;
//import memberservice.MemberDelete;
//import memberservice.MemberImpl;
//import memberservice.MemberInsert;
//import memberservice.MemberUpdate;
import memberservice.ServiceLogin;
import memberservice.ServiceMemInfoUpdate;
import service.BasketPage;
import service.BasketPlus;
import service.BestRandom;
import service.BigTitle;
import service.NewAll;
import service.PagingService;
import service.ProductPage;
import service.ServiceImpl;
import service.ServiceOrder;
import service.ServiceRefundReq;
import service.ServiceReview;
import service.SmallTitle;



/**
 * Servlet implementation class Control
 */ 
@WebServlet("*.do")
public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Control() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String c = request.getRequestURI().substring(request.getContextPath().length());
		String str = null;
		ServiceImpl impl = null;
//		MemberImpl m1 = null;
		
		if(c.equals("/pagelist.do")) {
			
			impl=new PagingService();
			
			try {
				impl.revise(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	        str = "search.jsp";
	        RequestDispatcher rd1=request.getRequestDispatcher(str);
			rd1.forward(request, response);
		}
		
		if (c.equals("/bigtitle.do")) { // 대분류 목록 전체 출력
			String title =request.getParameter("title");
			if (title.equals("1")) {
				impl = new BigTitle(1);
				try {
					impl.revise(request, response);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				request.setAttribute("mainmenu","채소/과일");
				request.setAttribute("fir","채소");
				request.setAttribute("sec","과일");
				request.setAttribute("third","견과류");
				request.setAttribute("four","샐러드");
			}
			else if (title.equals("2")) {
				impl = new BigTitle(2);
				try {
					impl.revise(request, response);
				} catch (Exception e) {
					// TODO: handle exception
				}
				request.setAttribute("mainmenu","수산/해산물");
				request.setAttribute("fir","갑각류");
				request.setAttribute("sec","조개류");
				request.setAttribute("third","생선류");
				request.setAttribute("four","해조류");
			}
			else if (title.equals("3")) {
				impl = new BigTitle(3);
				try {
					impl.revise(request, response);
				} catch (Exception e) {
					// TODO: handle exception
				}
				request.setAttribute("mainmenu","정육");
				request.setAttribute("fir","돼지");
				request.setAttribute("sec","소");
				request.setAttribute("third","닭/계란");
				request.setAttribute("four","기타");
			}
			else if (title.equals("4")) {
				impl = new BigTitle(4);
				try {
					impl.revise(request, response);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				request.setAttribute("mainmenu","음료");
				request.setAttribute("fir","탄산음료");
				request.setAttribute("sec","커피");
				request.setAttribute("third","우유/주스");
				request.setAttribute("four","기타");
			}
			str = "MainCategory.jsp";
			RequestDispatcher rd1=request.getRequestDispatcher(str);
			rd1.forward(request, response);
		}
		else if (c.equals("/smalltitle.do")) { // 채소창에서 소분류
			String main = request.getParameter("main");
			String title = request.getParameter("small");
			if (main.equals("채소/과일")) { // 채소관련 소분류 시작점
				if (title.equals("채소")) {
					impl = new SmallTitle(title);
					try {
						impl.revise(request, response);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else if (title.equals("과일")) {
					impl = new SmallTitle(title);
					try {
						impl.revise(request, response);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else if (title.equals("견과류")) {
					impl = new SmallTitle(title);
					try {
						impl.revise(request, response);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else if (title.equals("샐러드")) {
					impl = new SmallTitle(title);
					try {
						impl.revise(request, response);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				request.setAttribute("mainmenu","채소/과일");
				request.setAttribute("fir","채소");
				request.setAttribute("sec","과일");
				request.setAttribute("third","견과류");
				request.setAttribute("four","샐러드");
			}
			else if (main.equals("수산/해산물")) { // 수산물관련 소분류 시작점
				if (title.equals("갑각류")) {
					impl = new SmallTitle(title);
					try {
						impl.revise(request, response);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else if (title.equals("조개류")) {
					impl = new SmallTitle(title);
					try {
						impl.revise(request, response);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else if (title.equals("생선류")) {
					impl = new SmallTitle(title);
					try {
						impl.revise(request, response);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else if (title.equals("해조류")) {
					impl = new SmallTitle(title);
					try {
						impl.revise(request, response);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				request.setAttribute("mainmenu","수산/해산물");
				request.setAttribute("fir","갑각류");
				request.setAttribute("sec","조개류");
				request.setAttribute("third","생선류");
				request.setAttribute("four","해조류");
			}
			else if (main.equals("정육")) { // 채소관련 소분류 시작점
				if (title.equals("돼지")) {
					impl = new SmallTitle(title);
					try {
						impl.revise(request, response);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else if (title.equals("소")) {
					impl = new SmallTitle(title);
					try {
						impl.revise(request, response);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else if (title.equals("닭/계란")) {
					impl = new SmallTitle(title);
					try {
						impl.revise(request, response);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else if (title.equals("기타")) {
					impl = new SmallTitle("정육기타");
					try {
						impl.revise(request, response);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				request.setAttribute("mainmenu","정육");
				request.setAttribute("fir","돼지");
				request.setAttribute("sec","소");
				request.setAttribute("third","닭/계란");
				request.setAttribute("four","기타");
			}
			else if (main.equals("음료")) { // 채소관련 소분류 시작점
				if (title.equals("탄산음료")) {
					impl = new SmallTitle("탄산");
					try {
						impl.revise(request, response);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else if (title.equals("커피")) {
					impl = new SmallTitle(title);
					try {
						impl.revise(request, response);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else if (title.equals("우유/주스")) {
					impl = new SmallTitle(title);
					try {
						impl.revise(request, response);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				else if (title.equals("기타")) {
					impl = new SmallTitle("음료기타");
					try {
						impl.revise(request, response);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				request.setAttribute("mainmenu","음료");
				request.setAttribute("fir","탄산음료");
				request.setAttribute("sec","커피");
				request.setAttribute("third","우유/주스");
				request.setAttribute("four","기타");
			}
			
			str = "SubCategory.jsp";
			RequestDispatcher rd1=request.getRequestDispatcher(str);
			rd1.forward(request, response);
		}
		else if (c.equals("/ProductPage.do")) {  //상품 상세페이지 이동
			String product = request.getParameter("product");
			
			impl = new ProductPage(product);
			try {
				impl.revise(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
			str= "ProductPage.jsp";
			RequestDispatcher rd1=request.getRequestDispatcher(str);
			rd1.forward(request, response);
		}
		else if(c.equals("/Best.do")) {
			
			impl = new BestRandom();
			
			try {
				impl.revise(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			str="Best.jsp";
			RequestDispatcher rd1=request.getRequestDispatcher(str);
			rd1.forward(request, response);
		}
		else if(c.equals("/NewProduct.do")) {
			
			impl = new NewAll();
			try {
				impl.revise(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			str="NewProduct.jsp";
			RequestDispatcher rd1=request.getRequestDispatcher(str);
			rd1.forward(request, response);
		}

		
		
		if(c.equals("/Basket.do")) {   // 장바구니 이동페이지
			
			String id = request.getParameter("id");
			impl = new BasketPage(id);
			
			try {
				impl.revise(request, response);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			str = "Basket.jsp";
			RequestDispatcher rd1=request.getRequestDispatcher(str);
			rd1.forward(request, response);
			
		}else if(c.equals("/basketplus.do")) {  // 장바구니에 물건 추가하기
			String id =request.getParameter("id");
			String name =request.getParameter("name");
			String number =request.getParameter("num");
			BasketPlus bas = new BasketPlus(id,name,number);
			try {
				bas.Insert();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(c.equals("/paymenu.do")) {
			String id = (String)request.getSession().getAttribute("sid");
			
			Pay p = new Pay(id);
			try {
				p.payment();
			} catch (NamingException | SQLException e) {
				e.printStackTrace();
			}
			
			response.sendRedirect("OrderForm.jsp");
		}
		
		if(c.equals("/BPlus.do")) {  // 장바구니페이지에서 수량늘리기 
			String name = request.getParameter("name");
			String id = request.getParameter("id");
	        int idx = name.indexOf("p");
	        String name1 = name.substring(0, idx);
	        String number = request.getParameter("num");
	        int num =Integer.parseInt(number);
	       
			try { 
				BasketDAO dao = new BasketDAO();

				num++;
				dao.UpdateBasket(id, name1, num);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		else if (c.equals("/BMinus.do")) {  // 장바구니페이지에서 수량빼기
			String name = request.getParameter("name");
			String id = request.getParameter("id");
	        int idx = name.indexOf(",");
	        String name1 = name.substring(0, idx);
	        String number = request.getParameter("num");
	        int num =Integer.parseInt(number);
	        
	       if (num > 1 ) {
	    	   try { 
					BasketDAO dao = new BasketDAO();
					num--;
					dao.UpdateBasket(id, name1, num);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
	       }
			
		}
		if(c.equals("/BDelte.do")) { // 장바구니에서 특정 제품 삭제
			String name = request.getParameter("name");
			String id = request.getParameter("id");
			
			try {
				BasketDAO dao = new BasketDAO();
				dao.DeleteBasket(id, name);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(c.equals("/AllBDel.do")){ // 장바구니 내역 전체삭제
			String id = request.getParameter("id");
			try {
				BasketDAO dao = new BasketDAO();
				dao.DeleteAllB(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("Basket.jsp");
		}
		
		//###############
		else if(c.equals("/prdUpdate.do")) {
			impl=new ServicePrdUpdate();
			
			try {
				impl.revise(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			str="getAllProduct.jsp";
			RequestDispatcher rd1=request.getRequestDispatcher(str);
			rd1.forward(request, response);
		}
		else if(c.equals("/prdin.do")) {
			ServicePrdInsert spi = new ServicePrdInsert();
			try {
				int res=spi.insertchk(request, response);
				if(res==1) {
					str="getAllProduct.jsp";
					RequestDispatcher rd1=request.getRequestDispatcher(str);
					rd1.forward(request, response);
				}
				else if(res==0) {
					str="getPrdInsert.jsp";
					RequestDispatcher rd1=request.getRequestDispatcher(str);
					rd1.forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(c.equals("/prddelete.do")) {
			
			ServicePrdDelete sdl = new ServicePrdDelete();
			try {
				int res=sdl.delchk(request, response);
				if(res==1) {
					str="getAllProduct.jsp";
					RequestDispatcher rd1=request.getRequestDispatcher(str);
					rd1.forward(request, response);
				}else {
					request.setAttribute("str", "없는 상품명입니다");
					str="getPrdDelete.jsp";
					RequestDispatcher rd1=request.getRequestDispatcher(str);
					rd1.forward(request, response);
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(!c.equals("")) {
			ServiceLogin sl = new ServiceLogin();
			RequestDispatcher rd1 = null;
			switch(c) {
			
			case "/OrderCheck.do" : // 관리자 페이지 주문요청확인
				impl = new ServiceOrderCheck();
				
				try {
					impl.revise(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				str = "getCheckOrders.jsp";
				rd1 = request.getRequestDispatcher(str);
				rd1.forward(request, response);
				break;
				
			case "/RefundCheck.do" : // 관리자 페이지 환불요청확인
				impl = new ServiceRefundCheck();
				
				try {
					impl.revise(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				str = "getCheckRefund.jsp";
				rd1 = request.getRequestDispatcher(str);
				rd1.forward(request, response);
				break;
			case "/Order.do" : // 관리자 페이지 환불요청확인
				impl = new ServiceOrder();
				
				try {
					impl.revise(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				str = "OrderList.jsp";
				rd1 = request.getRequestDispatcher(str);
				rd1.forward(request, response);
				break;
		
		case "/memInsert.do":
			String name = request.getParameter("name");
	        String id = request.getParameter("id");
	        String password = request.getParameter("password");
	        String tel = request.getParameter("tel");
	        String email = request.getParameter("email");
	        
	        String address = request.getParameter("post");
	        String address1 = request.getParameter("address1");
	        String address2 = request.getParameter("address2");
//	        String address = address1 + " " +address2; 
	        String birth = request.getParameter("birth");
	        String idtext = request.getParameter("idtexth").trim();
	        
	        MemInfoDAO midao = null;
	        if(idtext.equals("아이디 생성이 가능합니다")) {
		        try {
					midao=new MemInfoDAO();
				} catch (NamingException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        boolean num = true;
				try {
					num = midao.insert_mem(name, id, password, tel, email, address,address1,address2,birth);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
		        PrintWriter sc = response.getWriter();
		        if(num) {
		        	response.sendRedirect("joinComplete.jsp");
		        }else if (num == false) {
		        	sc.println("<script>");
		      		sc.println("alert('전화번호 형식이 올바르지않습니다')");
		      		sc.println("history.back()");
		      		sc.println("</script>"); 
				} 
		        
	        	
	        	
	        }else {
	        	PrintWriter sc = response.getWriter();
	    		sc.println("<script>");
	      		sc.println("alert('이미 존재하는 아이디입니다')");
	      		sc.println("history.back()");
	      		sc.println("</script>"); 
	        }
	        
			break;
		case "/memUpdate.do" :
			impl = new ServiceMemInfoUpdate();
			
			try {
				impl.revise(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			str = "Mypage.jsp";
			rd1 = request.getRequestDispatcher(str);
			rd1.forward(request, response);
			break;

			
		case "/login.do" :
			try {
				int result = sl.loginCheck(request, response);
				PrintWriter sc = response.getWriter();
				if(result ==1) {
					str = "index.jsp";  ////나중에 수정
					rd1 = request.getRequestDispatcher(str);
					rd1.forward(request, response);
				}else if(result == 2){
					
					sc.println("<script>");
		      		sc.println("alert('비밀번호가 잘못입력되었습니다')");
		      		sc.println("history.back()");
		      		sc.println("</script>");
					
				}
				else if(result == 3){
					
					sc.println("<script>");
		      		sc.println("alert('아이디 또는 비밀번호가 잘못입력되었습니다')");
		      		sc.println("history.back()");
		      		sc.println("</script>");
					
				}
				else if(result == 4){
					
					sc.println("<script>");
		      		sc.println("alert('페이지 오류')");
		      		sc.println("history.back()");
		      		sc.println("</script>");
					
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
			case "/refundReq.do" :
			impl = new ServiceRefundReq();
			
			try {
				impl.revise(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			str = "OrderDetails.jsp";
			rd1 = request.getRequestDispatcher(str);
			rd1.forward(request, response);
			break;
			
			case "/review.do" :
				
				String memid = request.getParameter("mem_id");
				String product = request.getParameter("product_name");
				String review = request.getParameter("review");
				ServiceReview rv = new ServiceReview();
				int num = 0;
				try {
					num = rv.insert(memid, product, review);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if(num == 1) {
					PrintWriter sc = response.getWriter();
					sc.println("<script>");
			  		sc.println("alert('후기작성이 완료되었습니다')");
			  		sc.println("location.href='OrderList.jsp'");
			  		sc.println("</script>");
			  		
//					str = "OrderList.jsp";
				}
				
				break;
			
		
			}//switch-end
		}
		if (c.equals("/Mypage.do")) {
			String id = request.getParameter("id");
			if(id.equals("admin")) {
				response.sendRedirect("AdminSideBar.jsp");
			}else {
				response.sendRedirect("Mypage.jsp");
			}
			
		}
		else if(c.equals("/logout.do")) {
			HttpSession session = request.getSession();
			session.invalidate();
			
			PrintWriter sc = response.getWriter();
			sc.println("<script>");

	  		sc.println("location.replace('index.jsp')");
	  		sc.println("</script>");

			
			}
		
		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
