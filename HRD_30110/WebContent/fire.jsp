<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>인사관리 퇴사처리 화면</h1>
	<div class="index">
		<form action="/fire.do">
			<table>
				<tr>
					<td>성명 </td>
					<td>: <input type="text" name="name"></td>
				</tr>
				<tr>
					<td>사원번호 </td>
					<td>: <input type="text" name="id"></td>
				</tr>
				<tr>
					<td><input type="submit" value="조회"></td>
					<td><button type="button" onclick="location.href='main.jsp'">취소</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
			