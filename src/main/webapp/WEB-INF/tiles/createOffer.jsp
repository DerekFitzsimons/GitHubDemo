<%-- 
    Document   : createOffer
    Created on : 06-Aug-2017, 11:29:01
    Author     : Derek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

        <h1>Create A New Offer</h1>

        <c:url value="/doCreate" var="doCreate" />
        <sf:form method="post" action="${doCreate}" commandName="offer">
            <table class="formtable">
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

