<%@page import="departmemt.departVO"%>
<%@page import="departmemt.departDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<%
	request.setCharacterEncoding("utf-8");
	int id = Integer.parseInt(request.getParameter("id"));
	departDAO instance = departDAO.getInstance();
	departVO vo = instance.getADept(id);
%>
<body>
	<h1>인사관리 사원등록화면</h1>
	<hr>
	<div class="index">
		인사관리 사원등록
		<form action="/update.do">
			<table>
				<tr>
					<td>성명 </td>
					<td>: <input type="text" name="name" value="<%=vo.getName()%>"></td>
				</tr>
				<tr>
					<td>사원번호 </td>
					<td>: <input type="text" name="id" value="<%=vo.getId()%>"></td>
				</tr>
				<tr>
					<td>소속부서 </td>
					<td>: <select name="dept">
						<option value="인사부">인사부</option>
						<option value="기획부">기획부</option>
						<option value="홍보부">홍보부</option>
						<option value="영업부">영업부</option>
						<option value="경리부">경리부</option>
					</select></td>
				</tr>
				<tr>
					<td>소속부서 </td>
					<td>: <select name="position">
						<option value="1">1급</option>
						<option value="2">2급</option>
						<option value="3">3급</option>
						<option value="4">4급</option>
					</select></td>
				</tr>
				<tr>
					<td>직책 </td>
					<td>: <input type="text" name="duty" value="<%=vo.getDuty()%>"></td>
				</tr>
					<td>연락처 </td>
					<td>: <input type="text" name="phone" value="<%=vo.getPhone()%>"></td>
				</tr>
				</tr>
					<td colspan="2">
					<input type="submit" value="등록">
					<button type="button" class="btn" onClick="location.href='main.jsp'">취소</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>