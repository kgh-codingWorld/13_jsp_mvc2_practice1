<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정 페이지</title>
</head>
<body>
	<div align="center">
		<form action="update" method="post">
			<table border="1">
				<tr>
					<td>번호</td>
					<td>${boardDTO.boardId }</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${boardDTO.writer }</td>
				</tr>
				<tr>
				
				
					<td>제목</td>
					<td><input type="text" value="${boardDTO.subject }" name="subject"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>