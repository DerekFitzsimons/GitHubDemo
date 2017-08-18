<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-­ default header name is X-CSRF-TOKEN ­‐>	
        <meta name="_csrf_header" content="${_csrf.headerName}"/>	
  
        <title>Home Page</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css"/>
        <script type='application/javascript' src='${pageContext.request.contextPath}/static/js/jquery-3_2_1_min.js'></script>
        <script type="text/javascript">
        </script>
    </head>
    <body>
        
        <h1>Home Page</h1>

        <p><a href="${pageContext.request.contextPath}/offers"> Show Current Offers</a></p>
        <p><a href="${pageContext.request.contextPath}/createOffer">Create new Offer</a></p>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <p><a href="${pageContext.request.contextPath}/admin">Administration</a></p>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
            <c:url value='/login' var='loginUrl'/>
            <form action="${loginUrl}" method="post">
                <input id="error" type="hidden" value="false"/>
                <input type="submit" value="Log in"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  
            </form>	
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <c:url value='/logout' var='logoutUrl'/>
            <form action="${logoutUrl}" method="post">
                <input type="submit" value="Log out"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  
            </form>	
        </sec:authorize>
    </body>
</html>