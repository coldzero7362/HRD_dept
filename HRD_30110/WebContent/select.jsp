<%@page import="departmemt.departVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%
		ArrayList<departVO> list = (ArrayList)request.getAttribute("list");
	%>
	<table border="1">
		<tr align="center">
			<th>성명</th>
			<th>사번</th>
			<th>직급</th>
			<th>직책</th>
			<th>연락처</th>
			<th>소속부서</th>
		</tr>
		
		<%
			for(departVO vo : list){
		%>
			<tr align="center">
			<th><%=vo.getName() %></th>
			<th><%=vo.getId() %></th>
			<th><%=vo.getPosition() %></th>
			<th><%=vo.getDuty() %></th>
			<th><%=vo.getPhone() %></th>
			<th><%=vo.getDept() %></th>
		</tr>
		<%
			}
		%>
		<button type="button" onclick="location.href='main.jsp'">확인</button>
	</table>
</body>
</html>