<!-- userUpdateForm.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cập Nhật Thông Tin Người Dùng</title>
</head>
<body>
    <h1>Cập Nhật Thông Tin Người Dùng</h1>
    <form action="updateUser" method="post">
        <input type="hidden" name="userId" id="userId" value ="${user.id}">
        
        <label for="fullName">Họ và Tên:</label>
        <input type="text" id="fullName" name="fullName"><br><br>
        
        <label for="phone">Số Điện Thoại:</label>
        <input type="text" id="phone" name="phone"><br><br>
        
        
        <label for="role">Vai Trò:</label>
        <select id="role" name="role">
            <option value="User">User</option>
            <option value="Admin">Admin</option>
        </select><br><br>
        
        <input type="submit" value="Lưu">
        <button type="button" onclick="closeForm()">Đóng</button>
    </form>

    <script>
        function closeForm() {
            // Đóng pop-up hoặc form
            window.close(); // Đóng cửa sổ
        }
        
        
    </script>
</body>
</html>
