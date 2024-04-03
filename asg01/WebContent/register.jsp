<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 50px;
        }
        h1 {
            text-align: center;
        }
        form {
            margin-top: 20px;
        }
        input[type="text"],
        input[type="password"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
        p {
            text-align: center;
        }
        .error {
            color: red;
        }
        .success {
            color: green;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Đăng ký</h1>
        <% if (request.getAttribute("errorMessage") != null) { %>
            <p class="error"><%= request.getAttribute("errorMessage") %></p>
        <% } %>
        <% if (request.getAttribute("successMessage") != null) { %>
            <p class="success"><%= request.getAttribute("successMessage") %></p>
        <% } %>
        <form action="register" method="post">
            Email: <input type="text" name="email"><br>
            Họ và tên: <input type="text" name="fullName"><br>
            Tài khoản: <input type="text" name="username"><br>
            Mật khẩu: <input type="password" name="password"><br>
            Nhập lại mật khẩu: <input type="password" name="confirmPassword"><br>
            Số điện thoại: <input type="text" name="phone"><br>
            Vai trò:
            <select name="role">
                <option value="User">User</option>
                <option value="Admin">Admin</option>
            </select><br>
            <input type="submit" value="Đăng ký">
        </form>
    </div>
</body>
</html>
