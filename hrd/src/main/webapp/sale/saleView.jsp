<%@page import="java.text.DecimalFormat"%>
<%@page import="DTO.PsaleDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원매출조회</title>
<link rel="stylesheet" href="../css/list.css">
<link rel="stylesheet" href="../css/layout.css">
</head>
<body>
<%
	@SuppressWarnings("unchecked")
	List<PsaleDTO> list = (List<PsaleDTO>)request.getAttribute("list");
%>
<jsp:include page="../header.jsp"></jsp:include>
<main>
		<h3>회원 매출조회</h3>
		<div id="sale">
		<table>
		<tr>
		<th>회원번호</th><th>회원성명</th><th>고객등급</th><th>매출</th>
		</tr>
<%
		for(int i=0;i<list.size();i++) {
%>
		<tr>
		<td><%= list.get(i).getCustno() %></td>
		<td><%= list.get(i).getCustname() %></td>
		<td><%= list.get(i).getAgrade() %></td>
<%-- 		<td><%= list.get(i).getPsum() %></td> --%>
		<td>
			<%
				DecimalFormat df = new DecimalFormat("###,###");
				out.print(df.format(list.get(i).getPsum()));
			%>
		</td>
		</tr>
<%
		}
%>		
		</table>
		
		</div>
	</main>


<jsp:include page="../footer.jsp"></jsp:include>

</body>
</html>