<%@page import="DTO.PmemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="DAO.PmemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	PmemberDAO dao = PmemberDAO.getPmemberDao();
	List<PmemberDTO> list = dao.selectList();
	
	request.setAttribute("list", list);
	pageContext.forward("listView.jsp");
%>