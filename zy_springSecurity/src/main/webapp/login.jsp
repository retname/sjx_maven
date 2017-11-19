<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="container">
    <h1>This is secured!</h1>
    <p>
      Hello <b><c:out value="${pageContext.request.loginUser}"/></b>
    </p>
    <form class="form-inline" action="/login" method="post">
        用户名 ：<input type="text" name="username"><br>
        密  码 ：<input type="password" name="pwd"><br>
        <input type="submit" value="提交">
    </form>
  </div>
</body>