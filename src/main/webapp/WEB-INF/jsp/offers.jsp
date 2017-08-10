<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Show Offers</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css"/>
    </head>
    <body>

        <h1>Available offers</h1>
        <table class="offers">
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Offer</th>
            </tr>
        <c:forEach var="offer" items="${offers}">
            <tr>
                <td>${offer.name}</td>
                <td>${offer.email}</td>
                <td>${offer.text}</td>
            </tr>
        </c:forEach>
    </table>
    </body>
</html>