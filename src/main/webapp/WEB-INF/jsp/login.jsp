<%-- 
    Document   : login
    Created on : 14-Aug-2017, 12:51:50
    Author     : dfitzsimons
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css"/>
    </head>
    <body onload='document.f.username.focus();'>
        <h3>Login with Username and Password</h3>
        <form name='f' action='${pageContext.request.contextPath}/login' method='POST'>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <table class="formtable">
                <tr>
                    <td>User:</td>
                    <td><input type='text' name='username' value=''></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td>
                        <input type='password' name='password'/>
                    </td>
                </tr>
                <tr><td colspan='2'>
                        <input name="submit" type="submit" value="Login"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
