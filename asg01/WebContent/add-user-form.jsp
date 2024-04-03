<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm mới người dùng</title>
</head>
<body>
    <h2>Thêm mới người dùng</h2>
    <form action="saveUser" method="post">
        Họ và tên: <input type="text" name="fullName"><br>
        Email: <input type="email" name="email"><br>
        Số điện thoại: <input type="text" name="phone"><br>
        Địa chỉ: <input type="text" name="address"><br>
        Tài khoản: <input type="text" name="username"><br>
        Vai trò: 
        <select name="role">
            <option value="Admin">Admin</option>
            <option value="User">User</option>
        </select><br>
        Trạng thái: 
        <select name="status">
            <option value="Active">Active</option>
            <option value="Inactive">Inactive</option>
        </select><br>
        <input type="submit" value="Thêm">
        <input type="button" value="Đóng" onclick="window.location.href='/listUsers'">
    </form>
    

</body>
</html>
