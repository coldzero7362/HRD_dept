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
	<h1>인사관리조회화면</h1>
	<div class="index">
		<form action="select.do">
			<input type="radio" name="mode" value="1" required="required">사원번호로 조회
			<input type="text" name="id"><br>
			<input type="radio" name="mode" value="2" required="required">부서명으로 조회
			<select name="dept" required=>
				<option value="인사부">인사부</option>
				<option value="기획부">기획부</option>
				<option value="홍보부">홍보부</option>
				<option value="영업부">영업부</option>
				<option value="경리부">경리부</option>
			</select>
			<br>
			<input type="submit" value="조회">
			<button type="button" onclick="location.href='main.jsp'">취소</button>
		</form>
	
	</div>
</body>
</html>