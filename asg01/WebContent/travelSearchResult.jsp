<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Travel Search</title>
</head>
<body>
    <h1>Travel Search</h1>
    
    <form action="SearchTravelServlet" method="GET">
        <label for="searchQuery">Search by Name:</label>
        <input type="text" id="searchQuery" name="searchQuery" placeholder="Enter Travel Name" />
        <input type="submit" value="Search" />
    </form>

    <%-- Check if there are searched travels --%>
    <c:if test="${not empty searchedTravels}">
        <table border="1">
            <thead>
                <tr>
                    <th>Travel ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Address</th>
                    <!-- Add more columns as needed -->
                </tr>
            </thead>
            <tbody>
                <%-- Loop through searched travels and display information --%>
                <c:forEach var="travel" items="${searchedTravels}">
                    <tr>
                        <td>${travel.id}</td>
                        <td>${travel.name}</td>
                        <td>${travel.price}</td>
                        <td>${travel.startDate}</td>
                        <td>${travel.endDate}</td>
                        <td>${travel.address}</td>
                        <!-- Add more columns as needed -->
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <%-- Display a message if no travels are found --%>
    <c:if test="${empty searchedTravels}">
        <p>No travels found for the given search query.</p>
    </c:if>
</body>
</html>
