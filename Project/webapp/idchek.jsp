<%@page import="memberdb.MemInfoDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <% 
  String id = request.getParameter("id");
  
  
  MemInfoDAO dao = new MemInfoDAO();

	int check = dao.joinIdCheck(id);

	if(check == 0){
		out.print("이미 있는 아이디입니다");
	}else if(check == 1){
		out.print("아이디 생성이 가능합니다");

	}
	
	%>
