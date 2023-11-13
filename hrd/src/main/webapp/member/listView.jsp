<%@page import="DTO.PmemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록조회/수정</title>
<!-- <link rel="stylesheet" href="../css/list.css"> -->
<link rel="stylesheet" href="../css/layout.css">
</head>
<body>
<% 
	@SuppressWarnings("unchecked")
	List<PmemberDTO> list = (List<PmemberDTO>)request.getAttribute("list");
%>

<jsp:include page="../header.jsp"></jsp:include>
<main>
		<h3>회원목록조회/수정</h3>
		<div id="list">
<table>
			<tr>
			<th>회원번호</th><th>회원성명</th><th>전화번호</th><th>주소</th><th>가입일자</th><th>고객등급</th><th>거주지역</th>
			</tr>
			
<%
		for(int i=0;i<list.size();i++) {
			PmemberDTO vo = list.get(i);
%>			
            <tr>
                <%-- <td><%= vo.getCustno() %></td>  --%> 
                <!-- updateView.jsp로 custno 파라미터 넘겨주는 링크 -->
				<td>
				<a href="updateView.jsp?custno=<%= vo.getCustno() %>">
						<%= vo.getCustno() %></a>
				</td>                
                <td><%= vo.getCustname() %></td>
                <td><%= vo.getPhone() %></td>
                <td><%= vo.getAddress() %></td>
                <td><%= vo.getJoindate() %></td>
                <td><%= vo.getGrade() %></td>
                <td><%= vo.getCity() %></td>
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