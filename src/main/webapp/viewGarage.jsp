<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Your Garage</title>
</head>
<body>
    <h2>Your Cars</h2>
    <ul>
        <c:forEach items="${userCars}" var="car">
            <li>${car.car.model} - ${car.car.description} - $${car.car.price}</li>
        </c:forEach>
    </ul>

</body>
</html>