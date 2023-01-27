package com.exam.QnA;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.QnADao;
import board.QnADto;



public class QnAUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String qnaId = req.getParameter("qnaId");
		QnADao qnaDao;
		try {
			qnaDao = new QnADao();
			QnADto qnaDto = new QnADto();
			qnaDto = qnaDao.selectById(qnaId);
			req.setAttribute("qnaupdate", qnaDto);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/QnAupdate.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String qnaId = req.getParameter("qnaId");
		String qnaCategory = req.getParameter("qnaCategory");
		String qnaTitle = req.getParameter("qnaTitle");
		String qnaContent = req.getParameter("qnaContent");
		
//		QnADao qnaDao = null;

			
//			qnaDao = new QnADao();
		QnADao qnaDao;
		try {
			qnaDao = new QnADao();
			QnADto qnaDto = new QnADto();
			qnaDto.setQnaId(Integer.parseInt(qnaId));
			qnaDto.setQnaCategory(qnaCategory);
			qnaDto.setQnaTitle(qnaTitle);
			qnaDto.setQnaContent(qnaContent);
		
		qnaDao.update(qnaDto);
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

			
		resp.sendRedirect("qna.do");
	}
	
}