<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<form action="write" method="post">
		<table border="1">
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer"/></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject"/></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
						<textarea rows="10" cols="50" name="content"></textarea>
					</td>
			</tr>
			<tr align="center">
			<td colspan="2">
			<input type="submit" value="글쓰기"/>
			<input type="button" value="목록보기" onclick="location.href='list';"/>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>