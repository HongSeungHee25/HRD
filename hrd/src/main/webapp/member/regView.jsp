<%@page import="DAO.PmemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>외부평가 쇼핑몰 - 회원등록</title>
<!-- 외부평가 : 화면이 보통 4~5개. 공통 레이아웃 css -->
<link rel="stylesheet" href="../css/layout.css">
<!--  각 화면마다 다르게 적용되는 css -->
<link rel="stylesheet" href="../css/reg.css">
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<% 
	PmemberDAO dao = PmemberDAO.getPmemberDao();
	int custno = dao.nextSeq();
%>
<main>
<h3>홈쇼핑 회원 등록</h3>
		<form action="regAction.jsp" method="POST">
		<table>
			<tr>
				<td>회원번호(자동발생)</td>
				<td>
				<input type="text" name="custno" value="<%= custno%>" readonly>
				</td>
			</tr>
			<tr>
				<td>회원성명</td>
				<td>
				<input type="text" name="custname" >
				</td>
			</tr>
			<tr>
				<td>회원전화</td>
				<td>
				<input type="text" name="phone" size="30">
				</td>
			</tr>
			<tr>
				<td>회원주소</td>
				<td>
				<input type="text" name="address" size="40">
				</td>
			</tr>
			<tr>
				<td>가입일자</td>
				<td>
				<input type="text" name="regDate" disabled>
				</td>
			</tr>
			<tr>
				<td>고객등급[A:VIP,B:일반,C:직원]</td>
				<td>
				<input type="text" name="grade">
				</td>
			</tr>
			<tr>
				<td>도시코드</td>
				<td>
				<input type="text" name="city">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" onclick="func_reg()">등록</button>  
					                      <!-- 유효성 검사 후 submit -->
					<button type="button">조회</button>  <!-- 일반버튼 -->
				</td>
			</tr>
		</table>
		</form>
	</main>
<script type="text/javascript" src="../js/reg.js"></script>	
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>