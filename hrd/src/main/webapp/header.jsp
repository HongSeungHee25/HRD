<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
</head>
<body>
	<header>
		<h1>쇼핑몰 회원관리 ver1.0</h1>	
	</header>
	<nav>
		<ul>
			<li><a href="<%= request.getContextPath() %>/member/regView.jsp">회원등록</a></li>  <!-- 뷰  -> 처리   -->
			<li><a href="<%= request.getContextPath() %>/member/list.jsp">회원목록조회/수정</a></li> <!--  처리 -> 뷰  -->
			<li><a href="<%= request.getContextPath() %>/sale/sale.jsp">회원매출조회</a></li>
			<li><a href="<%= request.getContextPath() %>">홈으로.</a></li>
		</ul>
	</nav>
</body>
</html>