<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 인증 페이지</title>
</head>
<body>
	<div align="center">
	<form action="authentication">
		<table border="1">
			<tr>
				<td>번호</td>
				<td>${boardDTO.boardId }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${boardDTO.writer}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="subject" value="${boardDTO.subject}"/>${boardDTO.subject}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="content" value="${boardDTO.content}"/>${boardDTO.content }</td>
			</tr>
			<tr>
				<td>패스워드 인증</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="hidden" name="boardId" value="${boardDTO.boardId}"/>
					<input type="hidden" name="menu" value="${menu}"/>
					<input type="submit" value="인증"/>
					<input type="button" value="목록보기" onclick="location.href='list';"/>
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>