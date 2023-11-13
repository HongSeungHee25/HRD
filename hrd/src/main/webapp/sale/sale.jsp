<%@page import="DTO.PsaleDTO"%>
<%@page import="java.util.List"%>
<%@page import="DAO.PmoneyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	PmoneyDAO dao = PmoneyDAO.getPmoneyDao();
	List<PsaleDTO> list = dao.selectTotal();
	
	request.setAttribute("list", list);
	pageContext.forward("saleView.jsp");
%>