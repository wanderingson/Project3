package com.project.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.shop.service.ServiceAdmin;
import com.project.shop.service.ServiceBbs;
import com.project.shop.service.ServiceMember;
import com.project.shop.service.ServiceProduct;
import com.project.shop.service.ServiceQnA;
import com.project.shop.vo.BbsVO;
import com.project.shop.vo.CartVO;
import com.project.shop.vo.CategoryVO;
import com.project.shop.vo.GradeVO;
import com.project.shop.vo.MemInfoVO;
import com.project.shop.vo.OrderDetailsVO;
import com.project.shop.vo.OrderVO;
import com.project.shop.vo.PReviewVO;
import com.project.shop.vo.Paging;
import com.project.shop.vo.ProductVO;
import com.project.shop.vo.QnAVO;
import com.project.shop.vo.ReviewBoardVO;




@Controller
public class HomeController {
	
	@Autowired
	private SqlSession sqlsession;
	
	@Resource(name ="serviceProduct")
	private ServiceProduct serviceproduct;
	@Resource(name ="serviceMemer")
	private ServiceMember servicemember;
	
	@Resource(name = "serviceAdmin")
	private ServiceAdmin serviceAdmin;
	
	@Resource(name="servicebbs")
	private  ServiceBbs servicebbs;
	
	@Resource(name="serviceqna")
	private ServiceQnA serviceqna;
	
	
	
	// 메인페이지 이동
	@RequestMapping(value="/index.do")
	public String main() {
		return "index";
	}
	
	// 회원가입 관련
	//========================================================================================
		// 회원가입페이지 이동
		@RequestMapping(value = "/memJoinForm.do")
		public String memberJoinpro() {
			return "memJoinForm";
		}
		
		// 회원가입
		@RequestMapping(value ="/memberInsert.do") 
		public String memberInsert(@ModelAttribute("meminfoVO") MemInfoVO meminfoVO , Model model){
		  
		servicemember.memberJoinProcess(meminfoVO);
		
		return "joinComplete"; }

		// 아이디 중복체크
		@RequestMapping(value = "/idcheck.do")
		@ResponseBody
		public HashMap<String, Object> idCheck(@RequestParam("id") String id) {
			HashMap<String, Object> check1 = new HashMap<String, Object>();

			ArrayList<MemInfoVO> mem = servicemember.getAllInfo();

			int c = 3;
			for (MemInfoVO vv : mem) {
				
				if (!vv.getId().equals(id)) {
					c = 0;
				} else {
					c = 1;
					break;
				}
			}
			if(id == "") {
				check1.put("check", "I");
			}else {
				if (c == 0) {
					check1.put("check", "Y");
				} else if (c == 1) {
					check1.put("check", "N");
				}
			}
			

			return check1;

		}

	
		
	//========================================================================================
		
	// 회원 탈퇴
	//========================================================================================

	// 회원탈퇴 페이지
	@RequestMapping(value = "/memDeleteForm.do")
	public String memberDelpro() {		
		return "memDeleteForm";
	}	
	
	// 회원탈퇴
	@RequestMapping(value ="/memberDelete.do") 
	public String memberDelete(@ModelAttribute("meminfoVO") MemInfoVO meminfoVO , 
				HttpServletRequest re , HttpServletResponse response) throws IOException{	
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter sc = response.getWriter();
		String str = "";
		int num = servicemember.memberDelProcess(meminfoVO);
		if (num == 0) {
			sc.println("<script>");
			sc.println("alert('해당 아이디 또는 비밀번호가 존재하지 않습니다.')");
			sc.println("</script>");
			sc.flush();
			
			str="memDeleteForm";
		}else {
			HttpSession session = re.getSession();
			session.invalidate();
			str="deleteComplete";
		}	
		return str; 
	}
	//========================================================================================
	
		
		
	// 카테고리관련
	//========================================================================================
	
	// 대분류 카테고리
	@RequestMapping(value="/bigtitle.do")
	public String MainCategory(@RequestParam("title")int title,Model model,HttpServletRequest req) {
//		ArrayList<CategoryVO> main = serviceproduct.AllMainCaGet(title);
		
		if (title == 1) {
			int page = 1;
	        
	        if(req.getParameter("page")!=null){
	            page = Integer.parseInt(req.getParameter("page"));
	        }
	        Paging paging = new Paging();
	        int count = serviceproduct.getMainCount(title).getCount();
	        
	        paging.setPage(page);
	        paging.setTotalCount(count);
	        int startNum = (page-1)*9+1;
	        int endNum = page*9;
	        Map<String, Object> para = new HashMap<String, Object>();
	        para.put("para1", title);
	  
	        para.put("para2", startNum);
	        para.put("para3", endNum);
	        List<ProductVO> list = new ArrayList<ProductVO>(); 
	        list=sqlsession.selectList("selectAllCa",para);
	        
	        
	        model.addAttribute("bigtitle", list);
	        model.addAttribute("cpaging", paging);
			
			
			model.addAttribute("mainmenu","채소/과일");
			model.addAttribute("fir","채소");
			model.addAttribute("sec","과일");
			model.addAttribute("third","견과류");
			model.addAttribute("four","샐러드");
			
		} else if (title == 2) {
			int page = 1;
	        
	        if(req.getParameter("page")!=null){
	            page = Integer.parseInt(req.getParameter("page"));
	        }
	        Paging paging = new Paging();
	        int count = serviceproduct.getMainCount(title).getCount();
	        
	        paging.setPage(page);
	        paging.setTotalCount(count);
	        int startNum = (page-1)*9+1;
	        int endNum = page*9;
	        Map<String, Object> para = new HashMap<String, Object>();
	        para.put("para1", title);
	  
	        para.put("para2", startNum);
	        para.put("para3", endNum);
	        List<ProductVO> list = new ArrayList<ProductVO>(); 
	        list=sqlsession.selectList("selectAllCa",para);
	        
	        
	        model.addAttribute("bigtitle", list);
	        model.addAttribute("cpaging", paging);
			
			
			model.addAttribute("mainmenu","수산/해산물");
			model.addAttribute("fir","갑각류");
			model.addAttribute("sec","조개류");
			model.addAttribute("third","생선류");
			model.addAttribute("four","해조류");
			
		} else if (title == 3) {
			
			int page = 1;
	        
	        if(req.getParameter("page")!=null){
	            page = Integer.parseInt(req.getParameter("page"));
	        }
	        Paging paging = new Paging();
	        int count = serviceproduct.getMainCount(title).getCount();
	        
	        paging.setPage(page);
	        paging.setTotalCount(count);
	        int startNum = (page-1)*9+1;
	        int endNum = page*9;
	        Map<String, Object> para = new HashMap<String, Object>();
	        para.put("para1", title);
	  
	        para.put("para2", startNum);
	        para.put("para3", endNum);
	        List<ProductVO> list = new ArrayList<ProductVO>(); 
	        list=sqlsession.selectList("selectAllCa",para);
	        
	        
	        model.addAttribute("bigtitle", list);
	        model.addAttribute("cpaging", paging);
			
			model.addAttribute("mainmenu","정육");
			model.addAttribute("fir","돼지");
			model.addAttribute("sec","소");
			model.addAttribute("third","닭/계란");
			model.addAttribute("four","기타");		
		} else if (title == 4) {
			
			int page = 1;
	        
	        if(req.getParameter("page")!=null){
	            page = Integer.parseInt(req.getParameter("page"));
	        }
	        Paging paging = new Paging();
	        int count = serviceproduct.getMainCount(title).getCount();
	        
	        paging.setPage(page);
	        paging.setTotalCount(count);
	        int startNum = (page-1)*9+1;
	        int endNum = page*9;
	        Map<String, Object> para = new HashMap<String, Object>();
	        para.put("para1", title);
	  
	        para.put("para2", startNum);
	        para.put("para3", endNum);
	        List<ProductVO> list = new ArrayList<ProductVO>(); 
	        list=sqlsession.selectList("selectAllCa",para);
	        
	        
	        model.addAttribute("bigtitle", list);
	        model.addAttribute("cpaging", paging);
			
	        
			model.addAttribute("mainmenu","음료");
			model.addAttribute("fir","탄산음료");
			model.addAttribute("sec","커피");
			model.addAttribute("third","우유/주스");
			model.addAttribute("four","기타");
		}
		
//		model.addAttribute("bigtitle",main);
		
		return "MainCategory";
	}
	
	// 소분류 카테고리
	@RequestMapping(value="/smalltitle.do")
	public String SubCategory(@RequestParam("small") String sub,
						      @RequestParam("main") String title,Model model) {
		
		ArrayList<CategoryVO> subcategory = serviceproduct.AllSubCaGet(sub);
		
		if (title.equals("채소/과일")) {
			
			model.addAttribute("fir","채소");
			model.addAttribute("sec","과일");
			model.addAttribute("third","견과류");
			model.addAttribute("four","샐러드");
			
		} else if (title.equals("수산/해산물")) {
			
			model.addAttribute("fir","갑각류");
			model.addAttribute("sec","조개류");
			model.addAttribute("third","생선류");
			model.addAttribute("four","해조류");
			
		} else if (title.equals("정육")) {
			
			model.addAttribute("fir","돼지");
			model.addAttribute("sec","소");
			model.addAttribute("third","닭/계란");
			model.addAttribute("four","기타");		
		} else if (title.equals("음료")) {
			
			model.addAttribute("fir","탄산음료");
			model.addAttribute("sec","커피");
			model.addAttribute("third","우유/주스");
			model.addAttribute("four","기타");
		}
		
		model.addAttribute("mainmenu",title);
		model.addAttribute("smalltitle",subcategory);
		
		return "SubCategory";
	}
	
	// 상품상세페이지 추가
	@RequestMapping(value="/ProductPage.do")
	public String DetailProductPage(@RequestParam("product") String productname,Model model) {
		
		ProductVO product = serviceproduct.DetailProductPage(productname);
		
		ArrayList<PReviewVO> re = serviceproduct.DetailPageReview(productname);
		
		model.addAttribute("allproduct",product);
		model.addAttribute("preview", re);
		
		return "ProductPage";
	}
	
	// 상품상세페이지 장바구니 추가
	@RequestMapping(value="/basketplus.do")
	public void ProductBasketPlus(@RequestParam("id") String id,
									@RequestParam("name") String pname,
									@RequestParam("num") int pnum) {
		String search = "";

		// 장바구니 물품유무확인
		ArrayList<CartVO> basketCheck = serviceproduct.basketchek(id); 
		
		if(basketCheck.isEmpty()) {
			search = "insert";
		}else {
		
		for(CartVO vo : basketCheck) {
			if(vo.getName().equals(pname)) {
				search = "update";
				break;
			}else {
				search = "insert";
			}
		}
		
		}
		
		
		
		if(search.equals("update")) {
			
			CartVO vv = new CartVO(id,pname,pnum);
			serviceproduct.UpdateBasket(vv); 

			
		}else if (search.equals("insert")) {
			CartVO vv = new CartVO(id,pname,pnum);
			serviceproduct.InsertBasket(vv);
		}
		
	}
	
	// ====================================================================================================
	
	// ====================================================================================================
	
	// 상품검색
	@RequestMapping("/pagelist.do")
	public String selectAllMember(Model model,@RequestParam("search") String search,HttpServletRequest req) {
				
        int page = 1;
        
        if(req.getParameter("page")!=null){
            page = Integer.parseInt(req.getParameter("page"));
        }
        Paging paging = new Paging();
        
        int count = serviceproduct.getAllCount(search).getCount();
//        int count=30;
        
        
        paging.setPage(page);
        paging.setTotalCount(count);
        int startNum = (page-1)*9+1;
        int endNum = page*9;
        Map<String, Object> para = new HashMap<String, Object>();
        para.put("para1", search);
//        System.out.println(serviceProduct.getAllCount(search));
  
        
        para.put("para2", startNum);
        para.put("para3", endNum);
        
        List<ProductVO> list = new ArrayList<ProductVO>(); 
        list=sqlsession.selectList("selectAllMember",para);
//        System.out.println(list);
        
        
	       model.addAttribute("memList", list);
	       model.addAttribute("paging", paging);
	       
	       return "search";
	}
	
	// ====================================================================================================
	
	
	
	// 장바구니관련
	//========================================================================================
	
		// 장바구니 페이지 이동
		@RequestMapping(value="/Basket.do")
		public String BasketPage(@RequestParam("id") String id,Model model) {					
			
			// 장바구니 페이지 장바구니 전체 출력 
			ArrayList<CartVO> allcart = serviceproduct.BasketPage(id);
			
			// 장바구니 등급할인율 적용 
			GradeVO grade = servicemember.CartGrade(id);
			
			// 장바구니 총합 가격  
			ArrayList<CartVO> totalprice = serviceproduct.TotalPrice(id);
			int total = 0;
			for(CartVO all : totalprice) {
				
				total += all.getNum() * all.getPrice1();
				
			}
			
			int dc = total * grade.getDcPercent()/100;
			
			int totaldc = total - (total * grade.getDcPercent()/100);
			
			int point =  total * 1/100;
			
			model.addAttribute("allc", allcart);
			
			model.addAttribute("grade", grade);
			
			model.addAttribute("total", total);
			
			model.addAttribute("dc", dc);
			
			model.addAttribute("totaldc", totaldc);
			
			model.addAttribute("point", point);
			
			return "Basket";
		}
		
		// 장바구니 +버튼 
		@RequestMapping(value="/BPlus.do")
		@ResponseBody
		public HashMap<String, Object> CartPlus(@RequestParam("name") String name,
												@RequestParam("id") String id,
												@RequestParam("num") int num,Model model) {
	        int idx = name.indexOf("p");
	        String name1 = name.substring(0, idx);
	        num++;
	        CartVO vv = new CartVO(id,name1,num);
	        serviceproduct.PlusCart(vv);
	        
	       // 장바구니 총합 가격  
	        ArrayList<CartVO> totalprice = serviceproduct.TotalPrice(id);
	        int total = 0;
	        for(CartVO all : totalprice) {
	     				
	        	total += all.getNum() * all.getPrice1();
	     				
	        }
			// 장바구니 등급할인율 적용 
			GradeVO grade = servicemember.CartGrade(id);

			int dc = total * grade.getDcPercent()/100;
			
			
			
			int totaldc = total - (total * grade.getDcPercent()/100);
			
	        
			HashMap<String, Object> Plus = new HashMap<String, Object>();
			
			Plus.put("number", num);
			Plus.put("alltotal", total);
			Plus.put("dc", dc);
			Plus.put("totaldc", totaldc);
			
			
			return Plus;
		}		
	
		// 장바구니 - 버튼 
		@RequestMapping(value="/BMinus.do")
		@ResponseBody
		public HashMap<String, Object> CartMinus(@RequestParam("name") String name,
												@RequestParam("id") String id,
												@RequestParam("num") int num,Model model) {
			int idx = name.indexOf("p");
			String name1 = name.substring(0, idx);
			num--;
			CartVO vv = new CartVO(id,name1,num);
			serviceproduct.MinusCart(vv);
			        
			// 장바구니 총합 가격  
			ArrayList<CartVO> totalprice = serviceproduct.TotalPrice(id);
			int total = 0;
			for(CartVO all : totalprice) {
			     				
				total += all.getNum() * all.getPrice1();
			     				
			}
			//장바구니 등급할인율 적용 
			GradeVO grade = servicemember.CartGrade(id);

			int dc = total * grade.getDcPercent()/100;
					
			int totaldc = total - (total * grade.getDcPercent()/100);
			        
			HashMap<String, Object> Plus = new HashMap<String, Object>();
					
			Plus.put("number", num);
			Plus.put("alltotal", total);
			Plus.put("dc", dc);
			Plus.put("totaldc", totaldc);
					
					
			return Plus;
		}		
			
				
		
		// 장바구니 하나 삭제 	
		@RequestMapping(value="/BDelte.do")
		@ResponseBody
		public HashMap<String, Object> CartDelete(@RequestParam("name") String name,
							   @RequestParam("id") String id,Model model) {
			
			HashMap<String, Object> one = new HashMap<String, Object>();
			
			CartVO vv = new CartVO();
			vv.setId(id);
			vv.setName(name);
			
			int a = serviceproduct.DeleteBasket(vv);
			
			if (a>0) {
				
				one.put("delete1", "장바구니에서 삭제되었습니다");
				
			}else {
				one.put("delete1", "db에러");
			}
			
			return one;
		}
		
		
		// 장바구니 전체 삭제
		@RequestMapping(value="/AllBDel.do")
		public String AllCartD(@RequestParam("id") String id,Model model) {
			
			serviceproduct.AllDelteBasket(id);
			
			// 장바구니 페이지 장바구니 전체 출력 
			ArrayList<CartVO> allcart = serviceproduct.BasketPage(id);
						
			// 장바구니 등급할인율 적용 
			GradeVO grade = servicemember.CartGrade(id);
						
			// 장바구니 총합 가격  
			ArrayList<CartVO> totalprice = serviceproduct.TotalPrice(id);
			int total = 0;
			for(CartVO all : totalprice) {
				total += all.getNum() * all.getPrice1();
			}
			int dc = total * grade.getDcPercent()/100;
						
			int totaldc = total - (total * grade.getDcPercent()/100);
						
			int point =  total * 1/100;
						
			model.addAttribute("allc", allcart);
						
			model.addAttribute("grade", grade);
						
			model.addAttribute("total", total);
						
			model.addAttribute("dc", dc);
						
			model.addAttribute("totaldc", totaldc);
						
			model.addAttribute("point", point);
			
			return "Basket";
		}
		
		//========================================================================================
		
		
		// 신상품,인기상품 관련
		//========================================================================================
		
		// 인기상품
		@RequestMapping("/Best.do")
		public String Best(Model model) {
			ArrayList<ProductVO> plist = serviceproduct.RandomProduct(); 
			
			model.addAttribute("pv",plist);
			
			return "Best";
		}
		
		// 신상품
		@RequestMapping("/NewProduct.do")
		public String NewProAll(Model model) {
			
			ArrayList<ProductVO> plist = serviceproduct.NewProAll();
			
			model.addAttribute("pv",plist);

			return "NewProduct";
		}
		
		
		
		//========================================================================================
		
		
		
		// 로그인관련
		//========================================================================================
		
		// 로그인 페이지 이동
		@RequestMapping("/loginpage.do")
		public String loginpage(){
			return "Login";
		}
		// 로그인
		//================================================================
		@RequestMapping("/login.do")
		public String login(@RequestParam("id") String id,@RequestParam("pw") String pw, 
							HttpServletResponse response,HttpServletRequest request) {
			
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			ArrayList<MemInfoVO> us1 = servicemember.select_loginCheck();
			int login = 0;
			String str=null;
			
			try {
				for(MemInfoVO us2 : us1 ) {
					if(us2.getId().equals(id)) {
						if (us2.getPw().equals(pw)) {
							login=1;// 로그인 성공
							break;
						}	
						login=2;// 비밀번호 오류
						break;
					}								
					else
						login=3;  // 아이디 비밀번호 오류			
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				login=4; // db 오류 
			}
			try {
			PrintWriter sc = response.getWriter();

			if(login ==1) {
				HttpSession session = request.getSession();
				session.setAttribute("sid", id);
				str= "index";  ////나중에 수정
				
			}else if(login == 2){
				
				sc.println("<script>");
	      		sc.println("alert('비밀번호가 잘못입력되었습니다')");
	      		sc.println("</script>");
	      		sc.flush();
				str= "Login";
			}
			else if(login == 3){
				
				sc.println("<script>");
	      		sc.println("alert('아이디 또는 비밀번호가 잘못입력되었습니다')");
//	      		sc.println("history.back()");
	      		sc.println("</script>");
	      		sc.flush();
	      		str= "Login";
			}
			else if(login == 4){
				
				sc.println("<script>");
	      		sc.println("alert('페이지 오류')");
//	      		sc.println("history.back()");
	      		sc.println("</script>");
	      		sc.flush();
	      		str= "Login";
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return str;
			
		}
	
		
		// 아이디 찾기 사이트 이동
		@RequestMapping(value="/FindIDForm.do")
		public String IDFind(Model model) {			
			
			return "FindIDForm";
		}
		
		// 아이디 찾기 세부
		@RequestMapping(value="/FindIDResult.do")
		public String IDFindR(@RequestParam("name") String name, 
							  @RequestParam("tel") String tel,Model model) {			
			
			MemInfoVO vo = new MemInfoVO();
			
			vo.setName(name);
			vo.setTel(tel);
			
			String find = servicemember.FindID(vo);
			
			model.addAttribute("id", find);
			
			return "FindIDResult";
		}
		
		// 비번 찾기 사이트 이동
		@RequestMapping(value="/FindPWForm.do")
		public String PWFind(Model model) {			
			
			return "FindPWForm";
		}
		
		// 비번 찾기 세부
		@RequestMapping(value="/FindPWResult.do")
		public String PWFindR(@ModelAttribute("memVO") MemInfoVO memvo,Model model) {
			
			String pw = servicemember.FindPW(memvo);
			
			model.addAttribute("pw", pw);
			
			return "FindPWResult";
		}
		
		// 로그아웃
		@RequestMapping("/logout.do")
		public String logout(HttpServletRequest request) {
			
		HttpSession session = request.getSession();
		session.invalidate();
		return "index";
		
		}
		
		
		//========================================================================================
		
		
		// 마이페이지 관련
		//========================================================================================
		
		// 마이페이지 접속
		@RequestMapping(value="/mypage.do")
		public String mypage(@RequestParam("id") String mem_id, Model model){
			
			String move = "";
			
			if(mem_id.equals("admin")) {
				move = "AdminSideBar";
				
			}else {
				MemInfoVO mv = servicemember.select_memInfo(mem_id);
				GradeVO gv = servicemember.CartGrade(mem_id);
				
				int nPoint = gv.getEndPoint() - mv.getMemPoint() + 1;
				
				model.addAttribute("mv", mv);
				model.addAttribute("nPoint", nPoint);
				move="Mypage";
			}
			
			
			
			return move;
		}
		
		// 마이페이지에서 회원정보 수정눌렀을 때
		@RequestMapping(value="/memupdate.do")
		public void mypage(@RequestParam("userid") String mem_id, @RequestParam("password0") String pw,
						@RequestParam("password1") String pw1, @RequestParam("password2") String pw2,
						@RequestParam("email") String email, @RequestParam("tel") String tel, 
						@RequestParam("post") String address1, @RequestParam("address1") String address2,
						@RequestParam("address2") String address3, Model model
						, HttpServletResponse res) throws IOException {
			
			res.setCharacterEncoding("UTF-8");
			res.setContentType("text/html; charset=UTF-8");
			PrintWriter pwr = res.getWriter();
			if(pw1!=""&&pw2!="") {
				pw=pw2;
				
		    }
	
			
			
			servicemember.update_memInfo(mem_id, pw, tel, address1,address2,address3);
			model.addAttribute("id", mem_id);

			pwr.println("<script>");
			pwr.println("alert('회원정보가 수정되었습니다')");
			pwr.println("location.href='/shop/mypage.do?id="+mem_id+"'");
			pwr.println("</script>");
			pwr.flush();
			pwr.close();
			
			
//			return "redirect:/mypage.do";
			
		}
		//========================================================================================
		
		
		// 주문목록
		//========================================================================================
		
		// 주문내역
		@RequestMapping(value = "/orderlist.do")
		public String orderList(@RequestParam("id") String mem_id, Model model) {
			ArrayList<OrderVO> ovlist = servicemember.getInfo(mem_id);
			ArrayList<String> arrName = new ArrayList<String>();
			ArrayList<Integer> arrNum = new ArrayList<Integer>();
				
			for(OrderVO imsi : ovlist) {
				Integer num = servicemember.select_count(imsi.getOrder_num());
				String name = servicemember.select_listMainName(imsi.getOrder_num());
				arrNum.add(num);
				arrName.add(name);
			}
			model.addAttribute("id", mem_id);
			model.addAttribute("ovlist", ovlist);
			model.addAttribute("arrNum", arrNum);
			model.addAttribute("arrName", arrName);
			
			return "OrderList";
		}
		// 주문상세 페이지
		@RequestMapping(value = "/orderdetails.do")
		public String orderdetails(@RequestParam("order_num") int order_num, @RequestParam("mem_id") String rid, Model model) {
			ArrayList<OrderDetailsVO> odvlist = servicemember.getOrderDetailsInfo(order_num);
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for(OrderDetailsVO imsi : odvlist) {
				int num = servicemember.check_review(rid, imsi.getProduct_name(), imsi.getOrder_details_num());
				arr.add(num);
			}

			model.addAttribute("order_num", order_num);
			model.addAttribute("odvlist", odvlist);
			model.addAttribute("arr", arr);
			model.addAttribute("mem_id", rid);
				
			return "OrderDetails";
		}
		
		// 주문상세내역에서 환불요청 버튼눌렀을 때
		   @RequestMapping(value = "/refundreq.do")
		   public String refundreq(@ModelAttribute("orderdetailsVO") OrderDetailsVO orderdetailsVO, 
		         @RequestParam("mem_id") String mem_id, Model model) {

		      servicemember.update_deliveryState(orderdetailsVO);
		      int cnt = servicemember.check_reqRefundCnt(orderdetailsVO);
		    
		      if(cnt == 0) {
		         
		         servicemember.update_reqRefund(orderdetailsVO);
		      }
		      model.addAttribute("order_num", orderdetailsVO.getOrder_num());

		      return "redirect:/orderdetails.do?mem_id=mem_id";
		   }
		
		// 후기작성 페이지
		   @RequestMapping(value = "/reviewform.do")
		   public String reviewform(@RequestParam("product_name") String product_name, 
		   	@RequestParam("order_details_num") int order_details_num, Model model) {

		   	model.addAttribute("product_name", product_name);
		   	model.addAttribute("order_details_num", order_details_num);
		   		
		   	return "ReviewForm";
		   }
		
		// 후기작성 페이지에서 후기작성
		@RequestMapping(value="/review.do") 
		public void review(@ModelAttribute("reviewboardVO") ReviewBoardVO reviewboardVO, Model model
				, HttpServletResponse res) throws IOException {
			
				res.setCharacterEncoding("UTF-8");
				res.setContentType("text/html; charset=UTF-8");
				String ss = reviewboardVO.getMem_id(); 
				servicemember.insert_review(reviewboardVO);
				PrintWriter pwr = res.getWriter();
				pwr.println("<script>");
				pwr.println("alert('리뷰작성이 완료되었습니다')");
				pwr.println("location.href='/shop/orderlist.do?id="+ss+"'");
				pwr.println("</script>");
				pwr.flush();
				pwr.close();
				
				
		
		}
		
		//========================================================================================
		
		// 마이페이지 등급혜택 페이지
		//========================================================================================
		// 등급혜택 페이지
		@RequestMapping(value="/gradebenefit.do")
		public String gradebenefit(Model model) {
			
			return "GradeBenefit";
		}
		//========================================================================================
		
		// 주문 페이지 관련
		//========================================================================================
		// 주문페이지 이동
		@RequestMapping(value="/orderform.do")
		public String orderfrom(@RequestParam("id") String mem_id, Model model) throws IOException {
			
			// 회원정보, 장바구니
			MemInfoVO mv = servicemember.select_memInfo(mem_id);
			ArrayList<CartVO> cvlist = servicemember.getCartList(mem_id);
			GradeVO gv = servicemember.CartGrade(mem_id);
			
			// 적립금, 총결제금액 구하기
			int point=0;
			int order_price=0;
	
			
			for(int i=0;i<cvlist.size();i++) {
				cvlist.get(i).setPrice1(cvlist.get(i).getNum()*cvlist.get(i).getPrice1()); 
			}
			
			
			for(CartVO imsi : cvlist) {
				order_price += imsi.getPrice1();
			}		
			
			order_price = order_price - order_price*gv.getDcPercent()/100;
			point = order_price*gv.getDcPercent()/100;
			
			model.addAttribute("mv", mv);
			model.addAttribute("cvlist", cvlist);
			model.addAttribute("point", point);
			model.addAttribute("gv", gv);
			model.addAttribute("order_price", order_price);
			
			return "OrderForm";
		}
		
		

		
		
		
		
		// 주문페이지에서 주문버튼 눌렀을 때
		@RequestMapping(value="/order.do")
		public String order(@RequestParam("point") int point,
					@RequestParam("id") String mem_id, @RequestParam("address1") String address1,
					@RequestParam("address2") String address2, @RequestParam("address3") String address3, 
					@RequestParam("tel") String tel, @RequestParam("totPrice") int totPrice, 
					@RequestParam("deliveryMessage") String delivery_message, Model model) {
			
			MemInfoVO mv = servicemember.select_memInfo(mem_id);
			ArrayList<CartVO> cvlist = servicemember.getCartList(mem_id);
			GradeVO gv = servicemember.CartGrade(mem_id);
			String grade = "";
			
			// 주문내역 insert
			servicemember.insert_orderInfo(mem_id, address1, address2, address3, tel, totPrice, delivery_message);
			// 주문상세내역 insert
			for(CartVO imsi : cvlist) {
				int order_price = imsi.getPrice1() - imsi.getPrice1()*gv.getDcPercent()/100;
				servicemember.insert_orderDetailsInfo(imsi.getName(), imsi.getNum(), order_price);
			}
			// 적립금 update
			point += mv.getMemPoint();
			if (point >= 1000000) {
				grade="DIA";
			}else if (point >= 100000) {
				grade="GOLD";
			}else if (point >= 10000) {
				grade="SILVER";
			}else if (point > 1000) {
				grade="BRONZE";
			}else {
				grade="ROOKIE";
			}
			servicemember.update_grade(mem_id, grade, point);
			// 장바구니 비우기
			servicemember.cart_clear(mem_id);
			
			model.addAttribute("mem_id", mem_id);
			
			return "OrderList";
		}
		
		//========================================================================================
		
		// ================= ServiceAdmin =================
		@RequestMapping(value="/adminsidebar.do")
		public String adminsidebar(Model model) {
			return "AdminSideBar";
		}
		
		
		// 회원관리 페이지
		@RequestMapping(value="/getallinfo.do")
		public String getallinfo(Model model) {
			
			ArrayList<MemInfoVO> mvlist = serviceAdmin.getAllInfo();
			model.addAttribute("mvlist", mvlist);
			
			return "getAllInfo";
		}
		
		// 회원관리 페이지에서 id 눌렀을 때
		@RequestMapping(value="/getmeminfo.do")
		public String meminfo(@RequestParam("mem_id") String mem_id, Model model) {
			
			ArrayList<OrderVO> ovlist = serviceAdmin.getInfo(mem_id);
			model.addAttribute("ovlist", ovlist);
			
			ArrayList<OrderDetailsVO> odvlist = null;
			ArrayList<Object> oblist = new ArrayList<Object>();
			for(int i = 0; i < ovlist.size(); i++) {
				odvlist = serviceAdmin.getOrderDetailsInfo(ovlist.get(i).getOrder_num());
				oblist.add(odvlist);
			}
			
			model.addAttribute("oblist", oblist);
			return "getMemInfo";
		}
		
		// 주문확인 페이지
		@RequestMapping(value="/getcheckorders.do")
		public String getcheckorders(Model model) {
			
			ArrayList<OrderVO> ovlist = serviceAdmin.getAllCheckOrders();
			model.addAttribute("ovlist", ovlist);
			
			return "getCheckOrders";
		}
		
		// 주문승인 해주기
		@RequestMapping(value="/ordercheck.do")
		public String ordercheck(@RequestParam("order_num") int order_num, Model model) {
			
			serviceAdmin.checkOrder(order_num);
			serviceAdmin.checkOrder2(order_num);
			return "redirect:/getcheckorders.do";
		}
		
		// 주문내역 페이지
		@RequestMapping(value="/getallorders.do")
		public String getallorders(Model model) {
				
			ArrayList<OrderVO> ovlist = serviceAdmin.getAllOrders();
				
			model.addAttribute("ovlist", ovlist);
				
			return "getAllOrders";
		}
		
		// 환불확인 페이지
		@RequestMapping(value="/getcheckrefund.do")
		public String getcheckrefund(Model model) {
			
			ArrayList<OrderDetailsVO> odvlist = serviceAdmin.getAllRefundChk();
			
			model.addAttribute("odvlist", odvlist);
			
			return "getCheckRefund";
		}
		
		// 환불승인 해주기
		@RequestMapping(value="/refundcheck.do")
		public String refundcheck(@RequestParam("order_details_num") int order_details_num,
				@RequestParam("order_num") int order_num, Model model) {
			
			serviceAdmin.update_refundDetails(order_details_num);
			int cnt = serviceAdmin.check_refundCnt(order_num);
			if(cnt == 0) {
				serviceAdmin.update_refundOrder(order_num);
			}
			return "redirect:/getcheckrefund.do";
		}
		
		// 환불내역 페이지
		@RequestMapping(value="/getallrefund.do")
		public String getallrefund(Model model) {
			
			ArrayList<OrderDetailsVO> odvlist = serviceAdmin.getAllRefund();
			
			model.addAttribute("odvlist", odvlist);
			
			return "getAllRefund";
		}
		
		// 주문관리에서 주문번호 눌렀을 때 나오는 정보
		@RequestMapping(value="/getorderdetails.do")
		public String getorderdetails(@RequestParam("order_num") int order_num, Model model) {

			ArrayList<OrderDetailsVO> odvlist = serviceAdmin.getOrderDetailsInfo(order_num);
			model.addAttribute("order_num", order_num);
			model.addAttribute("odvlist", odvlist);
			
			return "getOrderDetails";
		}
		
		// 환불관리에서 주문번호 눌렀을 때 나오는 정보
		@RequestMapping(value="/getmemorderinfo.do")
		public String getmemorderinfo(@RequestParam("order_num") int order_num, Model model) {
			
			// 주문정보, 주문상세정보
			OrderVO ov = serviceAdmin.getOneInfo(order_num);
			ArrayList<OrderDetailsVO> odvlist = serviceAdmin.getOrderDetailsInfo(order_num);
			model.addAttribute("ov", ov);
			model.addAttribute("odvlist", odvlist);
			
			return "getMemOrderInfo";
		}
		
		
		
//	====================================================================================================
		//======게시판=====================	
		

		@RequestMapping(value="/bbs.do")
		public String bbs (Model model) {
			/*
			 * HttpSession session = request.getSession(); session.invalidate();
			 */
			ArrayList<BbsVO> alist = servicebbs.selectlist();
		
			model.addAttribute("alist",alist);
			return "bbs";
		}
		@RequestMapping (value="/bbswrite.do") 
		public String bbsWriteForm(Model model) {

			return "bbsWrite";
		}
			
		@RequestMapping(value="/bwrite.do")
		public String bbsWrite( Model model, @RequestParam("bbsCategory") String bbsCategory,
				@RequestParam("bbsTitle") String bbsTitle,
				@RequestParam("bbsContent") String bbsContent,
				HttpServletRequest req) {
			int result=0;
			HttpSession session = req.getSession();
			String memID = (String) session.getAttribute("sid");
			
			if(servicebbs.nextval()==null) {
				result=0;
				
			}else
			result = servicebbs.nextval();
			
			
			
			BbsVO bbsVO = new BbsVO();
			bbsVO.setBbsId(result+1);
			bbsVO.setBbsTitle(bbsTitle);
			bbsVO.setBbsCategory(bbsCategory);
			bbsVO.setBbsContent(bbsContent);
			bbsVO.setMemID(memID);
		
		
			servicebbs.bbsWrite(bbsVO);
			
			return"redirect:/bbs.do";
		}
		
		@RequestMapping(value="/bbsView.do")
		public String bbsView(@RequestParam("bbsId") String bbsid, Model model) {
			
			String str = "";
			
			if(bbsid.equals("1")) {
				servicebbs.hitupdate(bbsid);
				str="banner1";
				
			} else if (bbsid.equals("2")) {
			  servicebbs.hitupdate(bbsid);
			  str="banner2";
				
			}else {
				BbsVO bbsVO = new BbsVO();
				
				servicebbs.hitupdate(bbsid);
				
				bbsVO = servicebbs.selectById(bbsid);
				
				model.addAttribute("bbsview",bbsVO);
				
				str="bbsView";
			}
			
			
			
			
			return str;
		}	
		
		@RequestMapping(value="/bbsdelete.do")
		public String bbsDelete( Model model, @RequestParam("bbsId") String bbsId) {
		BbsVO bbsVO = new BbsVO();
			
			bbsVO = servicebbs.selectById(bbsId);
			servicebbs.bbsDelete(bbsVO);
			
			return  "redirect:/bbs.do";
		} 
		
		@RequestMapping(value="/bbsUpdate.do")
		public String bbsUpdate(@RequestParam("bbsId") String bbsid, Model model) {
		BbsVO bbsVO = new BbsVO();
			
			bbsVO = servicebbs.selectById(bbsid);
			
			model.addAttribute("bbsupdate",bbsVO);
			
			return  "bbsUpdate"; 
		}
		
		@RequestMapping(value="/bupdate.do")
		public String bbsUpdate( Model model,@RequestParam("bbsCategory")String bbsCategory,
																				@RequestParam("bbsContent")String bbsContent,
																				@RequestParam("bbsTitle")String bbsTitle,
																				@RequestParam("bbsId")int bbsId) {
		BbsVO bbsVO = new BbsVO();

		bbsVO.setBbsTitle(bbsTitle);
		bbsVO.setBbsCategory(bbsCategory);
		bbsVO.setBbsContent(bbsContent);
		bbsVO.setBbsId(bbsId);
			servicebbs.bbsUpdate(bbsVO);
			
			return  "redirect:/bbs.do"; 
		}
		
		
		//=================================================
		
		
//	====================================================================================================
		
		// Q&A 문의
//		====================================================================================================
		
		
		@RequestMapping("/QnA.do")
		public String QnA(Model model) {
			ArrayList<QnAVO> list = serviceqna.selectlist();
			
			model.addAttribute("qlist",list);
			return "QnA";
		}
		
		@RequestMapping("/Qnawrite.do")
		public String Qnawrite() {
			
			return "Qnawrite";
		}
		
		@RequestMapping("/qwrite.do")
		public String write(Model model, @RequestParam("qnaCategory") String qnaCategory,
							@RequestParam("qnaTitle") String qnaTitle,
							@RequestParam("qnaContent") String qnaContent,
							HttpServletRequest req) {
			HttpSession session = req.getSession();
			String sessionID = (String) session.getAttribute("sid");
			int result=0;
			if(serviceqna.nextval()==null) {
				result=0;
			}else 
				
			result =serviceqna.nextval();
			QnAVO qnaVO = new QnAVO();
			qnaVO.setQnaId(result+1);
			qnaVO.setQnaCategory(qnaCategory);
			qnaVO.setQnaTitle(qnaTitle);
			qnaVO.setQnaContent(qnaContent);
			qnaVO.setMemid(sessionID);
			serviceqna.write(qnaVO);
			
			
			return "redirect:/QnA.do";
		}
		
		@RequestMapping("/qview.do")
		public String QnAview(Model model,@RequestParam("qnaId") String qnaId) {
			
			QnAVO qnaVO = new QnAVO();
			
			qnaVO=serviceqna.selectById(qnaId);
			
			model.addAttribute("qnaview",qnaVO);
			
			return "QnAview";
		}
		
		@RequestMapping("/QnAAnswer.do")
		public String QnaAnswer(Model model,@RequestParam("qnaId") String qnaId,
								@RequestParam("qnaTitle") String qnaTitle,
								@RequestParam("qnaCategory") String qnaCategory,
								@RequestParam("memId") String memId,
								@RequestParam("qnaDate") String qnaDate,
								@RequestParam("qnaContent") String qnaContent,
								@RequestParam("qnaAnswer") String qnaAnswer) {
			
			model.addAttribute("qnaId",qnaId);
			model.addAttribute("qnaTitle",qnaTitle);
			model.addAttribute("qnaCategory",qnaCategory);
			model.addAttribute("memId",memId);
			model.addAttribute("qnaDate",qnaDate);
			model.addAttribute("qnaContent",qnaContent);
			model.addAttribute("qnaAnswer",qnaAnswer);
			
			return "QnAAnswer";
		}
		
		@RequestMapping(value="/qupdate.do", method = RequestMethod.GET )
		public String qupdateview(Model model,@RequestParam("qnaId") String qnaId) {
			
			QnAVO qnaVO = new QnAVO();
			
			qnaVO=serviceqna.selectById(qnaId);
			
			model.addAttribute("qnaupdate",qnaVO);
			
			return "QnAupdate";
		}
		
		@RequestMapping(value="/qupdate.do", method = RequestMethod.POST )
		public String qupdate(Model model,@RequestParam("qnaId") String qnaId,
				@RequestParam("qnaTitle") String qnaTitle,
				@RequestParam("qnaCategory") String qnaCategory,
				@RequestParam("qnaContent") String qnaContent) {
			
			QnAVO qnaVO = new QnAVO();
			qnaVO.setQnaId(Integer.parseInt(qnaId));
			qnaVO.setQnaCategory(qnaCategory);
			qnaVO.setQnaTitle(qnaTitle);
			qnaVO.setQnaContent(qnaContent);	
			
			serviceqna.update(qnaVO);
			
			return "redirect:/QnA.do";
		}
		
		@RequestMapping("/answer.do")
		public String answer(Model model,@RequestParam("qnaAnswer") String qnaAnswer,
										@RequestParam("qnaId") String qnaId) {
			
			
			QnAVO qnaVO = new QnAVO();
			qnaVO.setQnaId(Integer.parseInt(qnaId));
			qnaVO.setQnaAnswer(qnaAnswer);
			
			serviceqna.answer(qnaVO);
			model.addAttribute("qnaId",qnaId);
			
			return "redirect:/qview.do";
		}
		
//		====================================================================================================
		
		
		
		
		
//		====================================================================================================
		
		
		@RequestMapping("/banner1.do")
		public String banner1() {
			
			return "banner1";
		}
		
		@RequestMapping("/banner2.do")
		public String banner2() {
			
			return "banner2";
		}
//		====================================================================================================
		
		
		
//		====================================================================================================
		
		@RequestMapping("/getAllProduct.do")
		public String getAllProduct(Model model) {
			
			ArrayList<ProductVO> plist = serviceAdmin.getAllInfo1();
			
			model.addAttribute("plist",plist);
			
			return "getAllProduct";
		}
		
		@RequestMapping("/prdUpdate.do")
		public String prdUpdate(Model model,@RequestParam("cnum") int cnum,
				@RequestParam("csub") String csub,
				@RequestParam("prdname") String prdname,
				@RequestParam("prddiscription") String prddiscription,
				@RequestParam("prdprice") int prdprice,
				@RequestParam("sprdname") String sprdname,HttpServletResponse response) throws IOException {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			String str = null;
			
			int res = serviceAdmin.prdone(prdname).getCount();
			
			
			if(res==0) {
				serviceAdmin.prdUpdate(cnum, csub, prdname, prddiscription, prdprice,sprdname);
				str="redirect:/getAllProduct.do";
			}else {
				PrintWriter sc = response.getWriter();
				sc.println("<script>");
		  		sc.println("alert('중복된 상품명입니다')");
//		  		sc.println("history.back()");
		  		sc.println("</script>");
		  		sc.flush();
		  		ProductVO pv = new ProductVO();
				pv = serviceAdmin.prdonename(prdname);
				model.addAttribute("pv",pv);
				str="/getPrdUpdate";
			}
			
			return str;
		}
		
		@RequestMapping("/getPrdUpdate.do")
		public String getPrdUpdate(Model model,@RequestParam("product") String prdname) {
			
			ProductVO pv = new ProductVO();
			pv = serviceAdmin.prdonename(prdname);
			model.addAttribute("pv",pv);
			
			return "getPrdUpdate";
		}
		
		@RequestMapping("/getPrdInsert.do")
		public String getPrdInsert() {
			
			return "getPrdInsert";
		}
		
		@RequestMapping("/prdin.do")
		public String Prdin(Model model, @RequestParam("cnum") String cnum,
									@RequestParam("csub") String csub,
									@RequestParam("prdname") String prdname,
									@RequestParam("prddiscription") String prddiscription,
									@RequestParam("prdprice") String prdprice,HttpServletResponse response) throws IOException {
		String str = null;
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		int res = serviceAdmin.prdone(prdname).getCount();
		
		if(res==0) {
			serviceAdmin.insert_product(Integer.parseInt(cnum), csub, prdname, prddiscription, Integer.parseInt(prdprice));
			str="redirect:/getAllProduct.do";
		}else {
			PrintWriter sc = response.getWriter();
			sc.println("<script>");
	  		sc.println("alert('중복된 상품명입니다')");
//	  		sc.println("history.back()");
	  		sc.println("</script>");
	  		sc.flush();
			str="getPrdInsert";
		}
		
			return str;
		}
		
		@RequestMapping("/getPrdDelete.do")
		public String gePrdDelete() {
			
			return "getPrdDelete";
		}
		
		
		@RequestMapping("/prddelete.do")
		public String prddelete(Model model, @RequestParam("dprdname") String dprdname,HttpServletResponse response) throws IOException {
			
			String str = null;
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			int res = serviceAdmin.prdone(dprdname).getCount();
			if(res==1) {
				serviceAdmin.prddelete(dprdname);
				str="redirect:/getAllProduct.do";
			}else {
				PrintWriter sc = response.getWriter();
				sc.println("<script>");
		  		sc.println("alert('없는 상품명입니다')");
//		  		sc.println("history.back()");
		  		sc.println("</script>");
		  		sc.flush();
				str="getPrdDelete";
			}
			
				return str;
			}
			
//		====================================================================================================		
	
}
