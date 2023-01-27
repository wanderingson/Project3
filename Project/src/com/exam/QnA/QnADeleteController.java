package com.exam.QnA;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.QnADao;



public class QnADeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			process(req, resp);
		} catch (NumberFormatException | ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			process(req, resp);
		} catch (NumberFormatException | ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException, SQLException {
		String qnaId = req.getParameter("qnaId");
		QnADao qnaDao;
		try {
			qnaDao = new QnADao();
			qnaDao.del(Integer.parseInt(qnaId));
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		resp.sendRedirect("qna.do");
	}
	
}