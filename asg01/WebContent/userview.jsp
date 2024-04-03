<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách chuyến du lịch</title>
    <style>
        .travel {
            border: 1px solid #ccc;
            padding: 10px;
            margin: 10px;
            width: 200px; /* Adjust width as needed */
            float: left; /* Arrange divs horizontally */
        }
    </style>
</head>
<body>
    <h2>Danh sách chuyến du lịch</h2>
    
    <!-- Form tìm kiếm theo tên chuyến du lịch và giá vé -->
    <form action="SearchTravelServlet" method="GET">
        <input type="text" name="searchByNameOrPrice" placeholder="Tìm kiếm theo tên hoặc giá vé">
        <input type="submit" value="Tìm kiếm">
    </form>

    <!-- Form tìm kiếm theo ngày bắt đầu -->
    <form action="SearchByStartDateServlet" method="GET">
        <input type="date" name="searchByStartDate" placeholder="Tìm kiếm theo ngày bắt đầu">
        <input type="submit" value="Tìm kiếm">
    </form>
    
    <!-- Hiển thị danh sách chuyến du lịch -->
    <div class="travel-container">
        <c:forEach var="travel" items="${travels}">
            <div class="travel">
                <h3>${travel.name}</h3>
                <p>Giá: ${travel.price}</p>
                <img src="${travel.imageDescription}" alt="Ảnh mô tả">
                <p>${travel.detailDescription}</p>
                <p>Ngày bắt đầu: ${travel.startDate}</p>
                <p>Ngày kết thúc: ${travel.endDate}</p>
                <p>Địa chỉ: ${travel.address}</p>
                <p>Lượt bình chọn: ${travel.votes}</p>
            </div>
        </c:forEach>
    </div>
</body>
</html>
