<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>User Search Result</title>
</head>
<body>
    <h1>User Search Result</h1>
    
    <%-- Kiểm tra xem danh sách người dùng có dữ liệu hay không --%>
    <c:if test="${not empty searchedUsers}">
        <table border="1">
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>Full Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Username</th>
                    <th>Role</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <%-- Lặp qua từng người dùng trong danh sách và hiển thị thông tin --%>
                <c:forEach var="user" items="${searchedUsers}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.fullName}</td>
                        <td>${user.email}</td>
                        <td>${user.phone}</td>
                        <td>${user.username}</td>
                        <td>${user.role}</td>
                        <td>${user.status}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <%-- Hiển thị thông báo nếu không tìm thấy kết quả --%>
    <c:if test="${empty searchedUsers}">
        <p>No users found for the given search query.</p>
    </c:if>
</body>
</html>
