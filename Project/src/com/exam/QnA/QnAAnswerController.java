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



public class QnAAnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			try {
				process(req, resp);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			try {
				process(req, resp);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, NamingException {
		req.setCharacterEncoding("UTF-8");
		QnADto qnadto = new QnADto();
		QnADao qnaDao = new QnADao();

		String qnaAnswer = req.getParameter("qnaAnswer");
		int qnaId= Integer.parseInt(req.getParameter("qnaId"));
		qnadto.setQnaId(qnaId);
		qnadto.setQnaAnswer(qnaAnswer);
		int wResult = qnaDao.answer(qnadto);
		System.out.println(wResult);
		
		RequestDispatcher rd = req.getRequestDispatcher("qview.do");
		rd.forward(req, resp);
	}
	
}
