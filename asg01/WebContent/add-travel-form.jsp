<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm mới chuyến du lịch</title>
</head>
<body>
    <h2>Thêm mới chuyến du lịch</h2>
    <form action="AddTravel" method="post">
        <label for="name">Tên chuyến du lịch:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="price">Giá (VND):</label>
        <input type="number" id="price" name="price" required><br><br>

        <label for="startDate">Ngày bắt đầu:</label>
        <input type="date" id="startDate" name="startDate" required><br><br>

        <label for="endDate">Ngày kết thúc:</label>
        <input type="date" id="endDate" name="endDate" required><br><br>

        <label for="address">Địa chỉ:</label>
        <input type="text" id="address" name="address" required><br><br>

        <label for="imageDescription">Ảnh mô tả:</label>
        <input type="text" id="imageDescription" name="imageDescription" required><br><br>

        <label for="detailDescription">Mô tả chi tiết chuyến du lịch:</label><br>
        <textarea id="detailDescription" name="detailDescription" rows="4" cols="50"></textarea><br><br>

        <input type="submit" value="Thêm">
        <input type="button" value="Đóng" onclick="window.location.href='/manageTravels'">
    </form>
    
</body>
</html>
