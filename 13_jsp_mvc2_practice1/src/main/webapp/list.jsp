<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table border="1">
			<tr>
				<td>번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
				<td>조회수</td>
			</tr>
			<c:forEach var="boardDTO" items="${boardList}">
				<tr>
				<td>${boardDTO.boardId}</td>
				<td>${boardDTO.writer}</td>
				<td><a href="detail?boardId=${boardDTO.boardId}">${boardDTO.subject}</td>
				<td>${boardDTO.enrollDt}</td>
				<td>${boardDTO.readCnt}</td>
				</tr>
			</c:forEach>
			<tr align="right">
				<td colspan="5">
					<input type="button" value="글쓰기" onclick="location.href='write';"/>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>