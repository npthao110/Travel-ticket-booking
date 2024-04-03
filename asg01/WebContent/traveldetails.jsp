
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chi tiết chuyến đi</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        h2 {
            color: #333;
            margin-bottom: 20px;
        }

        p {
            color: #555;
            margin-bottom: 10px;
        }

        form {
            margin-top: 20px;
            padding: 20px;
            background: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input[type="text"],
        input[type="email"],
        button[type="submit"] {
            width: calc(100% - 20px);
            padding: 8px;
            margin-bottom: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        button[type="submit"] {
            background-color: #4caf50;
            color: white;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <c:if test="${not empty travel}">
        <h2>Thông tin chi tiết chuyến đi</h2>
        <p><strong>Tên:</strong> ${travel.name}</p>
        <p><strong>Giá:</strong> ${travel.price}</p>
        <p><strong>Ảnh mô tả:</strong> ${travel.imageDescription}</p>
        <p><strong>Mô tả chi tiết:</strong> ${travel.detailDescription}</p>
        <p><strong>Ngày bắt đầu:</strong> ${travel.startDate}</p>
        <p><strong>Ngày kết thúc:</strong> ${travel.endDate}</p>
        <p><strong>Địa chỉ:</strong> ${travel.address}</p>

        <!-- Form for booking -->
       <form action="BookTravelServlet" method="post">
		    <!-- Include hidden field to pass travel ID -->
		    <input type="hidden" name="travelId" value="${travel.id}">
		    
		    <!-- Include hidden field to pass user ID from session -->
		    <input type="hidden" name="userId" value="${sessionScope.logedInUser.id}">
		    
		    <!-- Include other fields as needed -->
		    <label for="userName">Tên người đặt:</label>
		    <input type="text" id="userName" name="userName"><br><br>
		    
		    <label for="userEmail">Email người đặt:</label>
		    <input type="email" id="userEmail" name="userEmail"><br><br>
		    
		    <!-- Add more fields like date, quantity, etc. -->
		    
		    <button type="submit">Book</button>
		</form>

    </c:if>
    <c:if test="${empty travel}">
        <p>Không tìm thấy thông tin chuyến đi.</p>
    </c:if>
    
    <!-- Nút "Đóng" để quay lại trang manageTravels -->
    <form action="manageTravels"> <!-- Đặt action là URL của trang manageTravels -->
        <button type="submit">Đóng</button>
    </form>
</body>
</html>

