<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
   <head>
      <meta charset="utf-8">
      <title>Login Form Design | CodeLab</title>
      <link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/login2.css">
   </head>
   <body>
      <div class="wrapper">
         <div class="title">
            Login Form
         </div>
         <form action="login" method="post">
            <div class="field">
               <input name="email" type="text" required>
               <label>Email Address</label>
            </div>
            <div class="field">
               <input name="password" type="password" required>
               <label>Password</label>
            </div>
            <div class="content">
               <div class="checkbox">
                  <input type="checkbox" id="remember-me">
                  <label for="remember-me">Remember me</label>
               </div>
               <div class="pass-link">
                  <a href="#">Forgot password?</a>
               </div>
            </div>
            <%-- Hiển thị thông báo lỗi nếu có --%>
		    <c:if test="${not empty errorMessage}">
		        <p style="color: red;">${errorMessage}</p>
		    </c:if>
		    <%-- Hiển thị thông báo thành công nếu đăng nhập thành công --%>
		    <c:if test="${not empty successMessage}">
		        <p style="color: green;">${successMessage}</p>
		    </c:if>
            <div class="field">
               <input type="submit" value="Login">
            </div>
            <div class="signup-link">
               Not a member? <a href="#">Signup now</a>
            </div>
         </form>
      </div>
   </body>
</html>