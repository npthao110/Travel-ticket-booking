<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update Travel</title>
</head>
<body>
    <h1>Update Travel</h1>

    <form action="UpdateTravelServlet" method="post">
    	<input type="hidden" name="travelId" id="travelId" value ="${travel.id}">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${travel.name}" /><br/><br/>

        <label for="price">Price:</label>
        <input type="number" id="price" name="price" value="${travel.price}" /><br/><br/>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" value="${travel.address}" /><br/><br/>

        <input type="hidden" name="id" value="${travel.id}" />
        <input type="submit" value="Update" />
    </form>
</body>
</html>
