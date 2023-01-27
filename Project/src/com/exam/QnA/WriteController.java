package com.exam.QnA;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.QnADao;
import board.QnADto;



public class WriteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/Qnawrite.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String sessionID = (String) session.getAttribute("sid");
		if (sessionID == null) {
			sessionID = "비회원";
		}
		
		String qnaCategory = req.getParameter("qnaCategory");
		String qnaTitle = req.getParameter("qnaTitle");
		String qnaContent = req.getParameter("qnaContent");
		
		QnADao qnaDao;
		try {
			qnaDao = new QnADao();
			QnADto qnaDto = new QnADto();
			qnaDto.setQnaId(qnaDao.nextval() + 1);
			qnaDto.setQnaCategory(qnaCategory);
			qnaDto.setQnaTitle(qnaTitle);
			qnaDto.setQnaContent(qnaContent);
			qnaDto.setId(sessionID);
			int wResult = qnaDao.write(qnaDto);
			System.out.println(wResult);
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