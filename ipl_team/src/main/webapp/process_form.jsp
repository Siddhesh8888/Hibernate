<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:setProperty property="*" name="ipl"/>
<body>
<h4>Status : ${applicationScope.ipl.validatePlayer()}</h4>
</body>
</html>