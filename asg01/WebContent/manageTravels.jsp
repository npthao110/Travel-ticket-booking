<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách chuyến du lịch</title>
</head>
<body>
    <h2>Danh sách chuyến du lịch</h2>
    
    <form action="SearchTravelServlet" method="GET">
    <input type="text" name="searchQuery" placeholder="Nhập tên chuyến du lịch">
    <input type="submit" value="Tìm kiếm">
	</form>
    
    <br></br>
    <!-- Hiển thị bảng danh sách người dùng -->
    <table border="1">
        <thead>
            <tr>
                <th>Tên</th>
            	<th>Giá</th>
            	<th>Ảnh mô tả</th>
            	<th>Mô tả chi tiết</th>
	            <th>Ngày bắt đầu</th>
	            <th>Ngày kết thúc</th>
	            <th>Địa chỉ</th>
	            <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="travel" items="${travels}">
            <tr>
                <td>${travel.name}</td>
                <td>${travel.price}</td>
                <td>${travel.imageDescription}</td>
				<td>
				    <a href="TravelDetailsServlet?id=${travel.id}">Mô tả chi tiết</a>
				</td>
                <td>${travel.startDate}</td>
                <td>${travel.endDate}</td>
                <td>${travel.address}</td>
                <td>
                    <!-- Action buttons -->           
                    <button onclick="confirmUpdate(${travel.id}, '${travel.name}')">Cập nhật</button>
					<button onclick="confirmDelete(${travel.id}, '${travel.name}')">Xóa</button>
                    
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <script>
    function confirmDelete(travelId, travelName) {
        var isConfirmed = confirm("Bạn có chắc chắn muốn xóa Travel " + travelName + " không?");
        if (isConfirmed) {
            window.location.href = "deleteTravel?travelId=" + travelId; // Redirect to Servlet to delete user
        }
    }
    function confirmUpdate(travelId, travelName) {
        var isConfirmed = confirm("Bạn có chắc chắn muốn update Travel " + travelName + " không?");
        if (isConfirmed) {
            window.location.href = "getTravelDetails?travelId=" + travelId; // Redirect to Servlet to details user
        }
    }
    
	</script>
    
   
    <br></br>
    <input type="button" value="Thêm mới" 
				   onclick="window.location.href='add-travel-form.jsp'; return false;"
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