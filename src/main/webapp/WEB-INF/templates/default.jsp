<%-- 
    Document   : default
    Created on : 19-Aug-2017, 11:34:02
    Author     : dfitzsimons
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title"/></title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css"/>
        <script type='application/javascript' src='${pageContext.request.contextPath}/static/js/jquery-3_2_1_min.js'></script>        
    </head>
    <body>
        <div class="header">
            <tiles:insertAttribute name="header"/>
        </div>
        <div class="content">
            <tiles:insertAttribute name="content"/>
        </div>
        <div class="footer">
            <tiles:insertAttribute name="footer"/>
        </div>
    </body>
</html>
