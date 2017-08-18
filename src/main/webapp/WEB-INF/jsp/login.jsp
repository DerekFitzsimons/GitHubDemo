<%-- 
    Document   : login
    Created on : 14-Aug-2017, 12:51:50
    Author     : dfitzsimons
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css"/>
    </head>
    <body onload='document.f.username.focus();'>
        <div class="loginBox">
            <h3>Login with Username and Password</h3>
            <c:if test="${param.error ne null}">
                <p class="loginError">Login failed. Check that your username and password are correct.</p>                                       
            </c:if>
            <c:url value="/login" var="loginUrl" />
            <form name='f' action='${loginUrl}' method='POST'>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <table class="logintable">
                    <tr>
                        <td class="label">User:</td>
                        <td><input type='text' name='username' value=''></td>
                    </tr>
                    <tr>
                        <td class="label">Password:</td>
                        <td>
                            <input type='password' name='password'/>
                        </td>
                    </tr>
                </table>

                <input class="fullButton" name="submit" type="submit" value="Login"/>

            </form>
                
                <p>create new Account <a href='<c:url value="/newAccount"/>'>Here</a></p>
        </div>
    </body>
</html>
