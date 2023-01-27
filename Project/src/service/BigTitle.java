package service;



import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.CategoryDAO;
import db.CategoryVO;
import db.Paging;



public class BigTitle implements ServiceImpl {
	
	private int title;
	
	public BigTitle(int title) {
		this.title = title;
	}
	
	public BigTitle() {}
	
	
	@Override
	public void revise(HttpServletRequest request, HttpServletResponse response) throws NamingException, Exception {

		
		int page=1;
		CategoryDAO big = new CategoryDAO();
		
		if(request.getParameter("page")!=null){
            page = Integer.parseInt(request.getParameter("page"));
        }
		
		Paging paging1 = new Paging();
		big.setBig(title);
        int count=big.CategorigetAllCount();

		paging1.setPage(page);
        paging1.setTotalCount(count);
		
		
		ArrayList<CategoryVO> big1 = big.AllBigCategoryGet(page);
		
		
		request.setAttribute("bigtitle", big1);
        request.setAttribute("cpaging", paging1);
		
		request.setAttribute("bigtitle", big1);
		
	}
}
