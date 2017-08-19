<%-- 
    Document   : header
    Created on : 19-Aug-2017, 11:57:20
    Author     : dfitzsimons
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
        <div class="title">Spring Tutorial - Offers</div>
        <div class="buttonHolder">
            <c:url value='/' var='homeUrl'/>
            <form action="${loginUrl}" method="post">
                <input type="submit" value="Home"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  
            </form>	
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
        </div>