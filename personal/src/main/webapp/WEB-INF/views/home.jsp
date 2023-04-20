<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>Hello world! </h1>
	<c:if test="${member == null}">
		<a href="/pe/member/login">로그인</a>
	</c:if>
	
	<c:if test="${member != null}">
		<div>${member.name}님 환영합니다.</div>
		<div><a href="/pe/member/doLogout">로그아웃</a></div>
	</c:if>
</body>
</html>
