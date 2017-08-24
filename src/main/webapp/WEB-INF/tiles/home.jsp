<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
        <h1>Home Page</h1>

        <h3>Available offers</h3>
        <table class="offers">
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Offer</th>
            </tr>
            <c:forEach var="offer" items="${offers}">
                <tr>
                    <td>${offer.user.name}</td>
                    <td>${offer.user.email}</td>
                    <td>${offer.text}</td>
                </tr>
            </c:forEach>
        </table>
        <hr/>
        <c:choose>
            <c:when test="${hasOffer}">
                <p><a href="${pageContext.request.contextPath}/createOffer">Edit or delete your Offer</a></p>
            </c:when>
            <c:otherwise>
                <p><a href="${pageContext.request.contextPath}/createOffer">Create new Offer</a></p>
            </c:otherwise>
        </c:choose>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <p><a href="${pageContext.request.contextPath}/admin">Administration</a></p>
        </sec:authorize>
