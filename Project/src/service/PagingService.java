package service;

import java.util.List;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.Paging;
import db.SearchDAO;
import db.SearchVO;

public class PagingService implements ServiceImpl {

	@Override
	public void revise(HttpServletRequest request, HttpServletResponse response) throws NamingException, Exception {
		// TODO Auto-generated method stub
		SearchDAO dao = new SearchDAO();
        int page = 1;
        
        
        if(request.getParameter("page")!=null){
            page = Integer.parseInt(request.getParameter("page"));
        }
        String search1 = request.getParameter("search");
        Paging paging = new Paging();
        int count=dao.getAllCount(search1);
        paging.setPage(page);
        paging.setTotalCount(count);
       
        List<SearchVO> list = dao.selectAllMember(page,search1);
        	
	        request.setAttribute("memList", list);
	        request.setAttribute("paging", paging);

	}

}
