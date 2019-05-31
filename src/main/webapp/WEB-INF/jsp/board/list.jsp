<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>안녕하세요</title>
</head>
<body>
	<h2>엑셀자료실</h2>
	<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>첨부파일</td>
		</tr>
		<c:forEach items="${resultList}" var="list">
		<tr>
			<td>${list.boardidx}</td>
			<td><a href="detail?idx=${list.boardidx}">${list.title}</a></td>
			<td>${list.writer }</td>
			<td>${list.regDate }</td>
			<td>${list.attachFile }</td>
		</tr>
		</c:forEach>
		<a href="stat?format=xls">엑셀 다운로드</a>
	</table>
	<a href="/board/write">글쓰기</a>
	

</body>
</html>