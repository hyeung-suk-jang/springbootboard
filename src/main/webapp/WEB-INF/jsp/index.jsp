<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>안녕하세요</title>
</head>
<body>
	<h2>Hello! ${name}</h2>
	<div>JSP version</div>
	<a href="/board/list">엑셀 자료실</a><br>
	<a href="/list">별도의 페이지...</a>
</body>
</html>