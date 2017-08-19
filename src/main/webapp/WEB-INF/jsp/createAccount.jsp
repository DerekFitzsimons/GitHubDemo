<%-- 
    Document   : createOffer
    Created on : 06-Aug-2017, 11:29:01
    Author     : Derek
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/main.css"/>
        <script type='application/javascript' src='${pageContext.request.contextPath}/static/js/jquery-3_2_1_min.js'></script>
        <script type='application/javascript'>
            
            function checkPasswordsMatch(){
                var password = $('#password').val();
                var confirmPassword = $('#confirmPassword').val();
                
                if(password.length > 2 || confirmPassword.length > 2){
                    if(password != confirmPassword){
                        $('#matchPass').addClass("error");
                        $('#matchPass').removeClass("valid");
                        $('#matchPass').text('<fmt:message key="UnmatchedPasswords.user.password"/>');
                    }else {
                        $('#matchPass').text('<fmt:message key="MatchedPasswords.user.password"/>');
                        $('#matchPass').removeClass("error");
                        $('#matchPass').addClass("valid");
                        
                    }
                }else {
                    $('#matchPass').removeClass("error");
                    $('#matchPass').removeClass("valid");
                    $('#matchPass').text("");
                }
            }
            
            function validateForm(){
                var size = $('password').val().length > 2;
                var match = $('password').val() == $('#confirmPassword').val();
                
                var output = size && match;
                
                console.log("Size:"+size);
                console.log("Match:"+match);
                
                if(!output){
                    alert('<fmt:message key="UnmatchedPasswords.user.password"/>');
                }
                return output;
            }
            
            
            function onLoad(){
                $('#password').keyup(checkPasswordsMatch);
                $('#confirmPassword').keyup(checkPasswordsMatch);
                
                $('#details').submit( validateForm )
            }
            
            
            
            $(document).ready( onLoad );
        </script>           
    </head>
    <body>
        <h1>Create Account</h1>
        
        <sf:form method="post" action="${pageContext.request.contextPath}/createAccount" id="details" commandName="user">
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
                        <sf:input type="password" path="password" name="password" id="password" class="control"/><br/>
                        <sf:errors path="password" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td class="label">Confirm Password</td>
                    <td>
                        <input type="password" class="control" name="confirmPassword" id="confirmPassword" class="control"/><br/>
                        <div id="matchPass" class="error"></div>
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
