<%-- 
    Document   : createOffer
    Created on : 06-Aug-2017, 11:29:01
    Author     : Derek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css"/>

    </head>
    <body>
        <h1>Create Account</h1>

        <sf:form method="post" action="${pageContext.request.contextPath}/createAccount" commandName="user">
            <table class="formtable">
                <tr>
                    <td class="label">Username</td>
                    <td>
                        <sf:input class="control" path="username" name="username"  type="text" /><br/>
                        <sf:errors path="username" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td class="label">Email</td>
                    <td>
                        <sf:input type="text" path="email" name="email" class="control"/><br/>
                        <sf:errors path="email" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td class="label">Password</td>
                    <td>
                        <sf:input type="text" path="password" name="password" class="control"/><br/>
                        <sf:errors path="password" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td class="label">Confirm Password</td>
                    <td>
                        <input type="text" class="control" name="confirmPassword" class="control"/><br/>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" value="Create Account" class="control"/></td>
                </tr>
            </table>
        </sf:form>
    </body>
</html>
