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
		<form action="update.jsp">
		수정할 사원번호를 입력해주세요.
			<input type="text" name="id" required="required"><br>
			<br>
			<input type="submit" value="조회">
			<button type="button" onclick="location.href='main.jsp'">취소</button>
		</form>
	
	</div>
</body>
</html>