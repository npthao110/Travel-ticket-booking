<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách người dùng</title>
</head>
<body>
    <h2>Danh sách người dùng</h2>
    
    <form action="SearchUserServlet" method="GET">
    <input type="text" name="searchQuery" placeholder="Nhập số điện thoại">
    <input type="submit" value="Tìm kiếm">
	</form>
    
    <br></br>
    <!-- Hiển thị bảng danh sách người dùng -->
    <table border="1">
        <thead>
            <tr>
                <th>Họ và tên</th>
                <th>Email</th>
                <th>Số điện thoại</th>
                <th>Tài khoản</th>
                <th>Vai trò</th>
                <th>Trạng thái</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <!-- Duyệt danh sách người dùng từ Servlet và hiển thị -->
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.fullName}</td>
                    <td>${user.email}</td>
                    <td>${user.phone}</td>
                    <td>${user.username}</td>
                    <td>${user.role}</td>
                    <td>${user.status}</td>
                    <td>
                        <!-- Các nút thực hiện hành động -->
                        <button onclick="confirmUpdate(${user.id}, '${user.fullName}')">Sửa</button>
                        <button onclick="showDetails(${user.id})">Chi tiết</button>
                        <button onclick="confirmDelete(${user.id}, '${user.fullName}')">Xóa</button>
                        <c:choose>
        					<c:when test="${user.status eq 'Active'}">
           						 <button onclick="confirmLock(${user.id}, '${user.fullName}')">Khóa</button>
        					</c:when>
        					<c:otherwise>
            					<button onclick="confirmUnLock(${user.id}, '${user.fullName}')">Mở</button>
        					</c:otherwise>
    					</c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <script>
    function confirmDelete(userId, userName) {
        var isConfirmed = confirm("Bạn có chắc chắn muốn xóa người dùng " + userName + " không?");
        if (isConfirmed) {
            window.location.href = "deleteUser?userId=" + userId; // Redirect to Servlet to delete user
        }
    }
    function confirmUpdate(userId, userName) {
        var isConfirmed = confirm("Bạn có chắc chắn muốn update người dùng " + userName + " không?");
        if (isConfirmed) {
            window.location.href = "getUserDetails?userId=" + userId; // Redirect to Servlet to details user
        }
    }
    function confirmLock(userId, userName) {
        var isConfirmed = confirm("Bạn có chắc chắn muốn khóa người dùng " + userName + " không?");
        if (isConfirmed) {
            window.location.href = "lockUser?userId=" + userId; // Redirect to Servlet to delete user
        }
    }
    function confirmUnLock(userId, userName) {
        var isConfirmed = confirm("Bạn có chắc chắn muốn mở người dùng " + userName + " không?");
        if (isConfirmed) {
            window.location.href = "unlockUser?userId=" + userId; // Redirect to Servlet to delete user
        }
    }
	</script>
    
   
    <br></br>
    <input type="button" value="Thêm mới" 
				   onclick="window.location.href='add-user-form.jsp'; return false;"
	/>
	
	    <!-- Phân trang -->
    <div>
        <c:if test="${totalPages > 1}">
            <c:forEach begin="1" end="${totalPages}" var="i">
                <a href="listUsers?page=${i}">${i}</a>
            </c:forEach>
        </c:if>
    </div>
</body>
</html>
