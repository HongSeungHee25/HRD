<%@page import="DTO.PmemberDTO"%>
<%@page import="DAO.PmemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>외부평가 쇼핑몰 - 회원정보 수정</title>
<link rel="stylesheet" href="../css/layout.css">
<link rel="stylesheet" href="../css/reg.css">
</head>
<body>
<%
	//custno 파라미터 받기	 
	//        ㄴ dao 의 selectOne 메소드 실행해서 가져온 값을
	//아래 input 의 value에 넣어 줍니다.(애트리뷰트 사용안함.)
	
	String temp = request.getParameter("custno");
	int custno=0;
	PmemberDTO vo =null;
	try {
		custno = Integer.parseInt(temp);
		PmemberDAO dao = PmemberDAO.getPmemberDao();
		vo = dao.selectOne(custno);
	}catch(NumberFormatException e){	}
	if(vo==null){
		response.sendRedirect("../fail.jsp");
	}else {
%>
<jsp:include page="../header.jsp"></jsp:include>
<main>
		<h3>홈쇼핑 회원 등록</h3>
		<form action="updateAction.jsp" method="POST"> 
		<table>
			<tr>
				<td>회원번호(자동발생)</td>
				<td>
				<input type="text" name="custno" value="<%= vo.getCustno()%>" readonly>
				</td>
			</tr>
			<tr>
				<td>회원성명</td>
				<td>
				<input type="text" name="custname" value="<%= vo.getCustname()%>" disabled>
				</td>
			</tr>
			<tr>
				<td>회원전화</td>
				<td>
				<input type="text" name="phone" size="30" value="<%= vo.getPhone()%>">
				</td>
			</tr>
			<tr>
				<td>회원주소</td>
				<td>
				<input type="text" name="address" size="40" value="<%= vo.getAddress()%>">
				</td>
			</tr>
			<tr>
				<td>가입일자</td>
				<td>
				<input type="text" name="regDate" value="<%= vo.getJoindate()%>" disabled>
				</td>
			</tr>
			<tr>
				<td>고객등급[A:VIP,B:일반,C:직원]</td>
				<td>
				<input type="text" name="grade" value="<%= vo.getGrade()%>" >
				</td>
			</tr>
			<tr>
				<td>도시코드</td>
				<td>
				<input type="text" name="city" value="<%= vo.getCity()%>">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" onclick="func_valid()">수정</button> 
										 <!-- 유효성 검사 후 submit -->
					<button type="button">조회</button>  <!-- 일반버튼 -->
				</td>
			</tr>
		</table>
		</form>
	</main>
<script type="text/javascript" src="../js/update.js"></script>	
<%
	}
%>
<jsp:include page="../footer.jsp"></jsp:include>


</body>
</html>