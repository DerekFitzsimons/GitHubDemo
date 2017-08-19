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
    </head>
    <body>
        <div>
            <tiles:insertAttribute name="header"/>
        </div>
        <div>
            <tiles:insertAttribute name="content"/>
        </div>
        <div>
            <tiles:insertAttribute name="footer"/>
        </div>
    </body>
</html>
