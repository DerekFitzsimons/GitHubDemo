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
        <title>Create Offer</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css"/>

    </head>
    <body>
        <h1>Hello World!</h1>

        <sf:form method="post" action="${pageContext.request.contextPath}/doCreate" commandName="offer">
            <table class="formtable">
                <tr>
                    <td class="label">Name</td>
                    <td>
                        <sf:input class="control" path="name" name="name"  type="text" /><br/>
                        <sf:errors path="name" cssClass="error"/>
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
                    <td class="label">Your Offer</td>
                    <td>
                        <sf:textarea path="text" name="text" class="control" /><br/>
                        <sf:errors path="text" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" value="Create Offer" class="control"/></td>
                </tr>
            </table>
        </sf:form>
    </body>
</html>
