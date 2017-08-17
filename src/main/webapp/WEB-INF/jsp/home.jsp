<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <c:url value='/logout' var='logoutUrl'/>
        <h1>Home Page</h1>

        <p><a href="${pageContext.request.contextPath}/offers"> Show Current Offers</a></p>
        <p><a href="${pageContext.request.contextPath}/createOffer">Create new Offer</a></p>
        <form action="${logoutUrl}" method="post">	

            <input type="submit" value="Log out"/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  
        </form>	
    </body>
</html>