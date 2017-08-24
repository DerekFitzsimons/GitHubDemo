<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
        <h1>Home Page</h1>
        <p><a href="${pageContext.request.contextPath}/offers"> Show Current Offers</a></p>
        <p><a href="${pageContext.request.contextPath}/createOffer">Create new Offer</a></p>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
            <p><a href="${pageContext.request.contextPath}/admin">Administration</a></p>
        </sec:authorize>
