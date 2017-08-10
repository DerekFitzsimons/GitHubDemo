<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Home Page</title>
    </head>
    <body>

        <h1>Home Page</h1>

        <p><a href="${pageContext.request.contextPath}/offers"> Show Current Offers</a></p>
        <p><a href="${pageContext.request.contextPath}/createOffer">Create new Offer</a></p>
    </body>
</html>