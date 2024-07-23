<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록 페이지</title>
</head>
<body>
	<div align="center">
		<table border="1">
			<tr>
				<td>번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>날짜</td>
				<td>조회수</td>
			</tr>
			<tr align="right">
				<td colspan="5" >
					<input type="button" value="글쓰기" onclick="location.href='write';"/>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>