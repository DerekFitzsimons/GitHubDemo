<%@ page language="java" contentType="text/html; utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <h1>Available offers</h1>
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
