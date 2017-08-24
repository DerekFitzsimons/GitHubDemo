<%-- 
    Document   : createAccountScript
    Created on : 19-Aug-2017, 13:17:14
    Author     : dfitzsimons
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
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

                $('#details').submit( validateForm );
            }         

            $(document).ready( onLoad );
        </script> 
