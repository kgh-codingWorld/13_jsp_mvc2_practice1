<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세조회 페이지</title>
</head>
<body>
	<div align="center">
		<table border="1">
			<tr>
				<td>번호</td>
				<td>${boardDTO.boardId}</td>
			</tr>		
			<tr>
				<td>작성자</td>
				<td>${boardDTO.writer}</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${boardDTO.subject}</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${boardDTO.content}</td>
			</tr>
			<tr>
				<td>등록일</td>
				<td>${boardDTO.enrollDt}</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td>${boardDTO.readCnt}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${boardDTO.writer }</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="수정하기" onclick="location.href='bAuthentication?boardId=${boardDTO.boardId}&menu=update';"/>				
					<input type="button" value="삭제하기"/>				
					<input type="button" value="목록보기"/>				
				</td>
			</tr>
		</table>
	</div>
</body>
</html>