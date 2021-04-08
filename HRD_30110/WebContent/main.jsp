<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사관리 시스템</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>인사관리 시스템</h1>
	<div class="menu">
		인사관리 메인메뉴<br>
		<button onclick="location.href='selectMode.jsp'">조회</button>
		<button onclick="location.href='insert.jsp'">사원등록</button>
		<button onclick="location.href='updateMode.jsp'">정보변경</button>
		<button onclick="location.href='fire.jsp'">퇴사처리</button>
		<input type="button" value="종료" onClick='window.close()'>
	</div>
</body>
</html>