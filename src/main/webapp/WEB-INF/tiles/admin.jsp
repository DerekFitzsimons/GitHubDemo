<%-- 
    Document   : admin
    Created on : 17-Aug-2017, 14:25:13
    Author     : dfitzsimons
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <h1>Admin Page</h1>
        <p>Authorised Users Only</p>
        <table class="formtable">
            <tr>
                <th>Username</th>
                <th>Email</th>
                <th>Role</th>
                <th>Enabled</th>
            </tr>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.username}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.authority}"/></td>
                    <td><c:out value="${user.enabled}"/></td>
                </tr>
            </c:forEach>
        </table>

