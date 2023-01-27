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


public class QnAViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		try {
			try {
				process(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ServletException | IOException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		try {
			try {
				process(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ServletException | IOException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NamingException, SQLException {
		String qnaId = req.getParameter("qnaId");
		QnADao qnaDao =new QnADao();
		QnADto qnaDto = new QnADto();
//		qnaDao.hitUpdate(qnaId);
		qnaDto = qnaDao.selectById(qnaId);
//		qnaDto.setQnaAnswer((String)req.getAttribute("qnaAnswer"));
//		String qnaAnswer=(String)req.getAttribute("qnaAnswer");
		req.setAttribute("qnaview", qnaDto);
		System.out.println(qnaDto.getQnaAnswer());
//		req.setAttribute("qnaAnswer", qnaAnswer);
		RequestDispatcher rd = req.getRequestDispatcher("/QnAview.jsp");
		rd.forward(req, resp);
	}
	
}
