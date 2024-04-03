<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/login.css">
</head>
<body>
    <h2>Đăng nhập</h2>
    <form action="login" method="post">
        Email: <input type="text" name="email"><br>
        Mật khẩu: <input type="password" name="password"><br>
        <input type="submit" value="Đăng nhập">
    </form>
    <%-- Hiển thị thông báo lỗi nếu có --%>
    <c:if test="${not empty errorMessage}">
        <p style="color: red;">${errorMessage}</p>
    </c:if>
    <%-- Hiển thị thông báo thành công nếu đăng nhập thành công --%>
    <c:if test="${not empty successMessage}">
        <p style="color: green;">${successMessage}</p>
    </c:if>
</body>
</html>
