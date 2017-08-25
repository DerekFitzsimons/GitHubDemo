<%-- 
    Document   : createOfferScript
    Created on : 24-Aug-2017, 15:36:48
    Author     : dfitzsimons
--%>

<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
        <script type='application/javascript'>
            
            function onLoad(){
               $('#delete').click(onDeleteClick)
            }         

            function onDeleteClick(event){
                
                var doDelete = confirm("Are you sure you want to delete this offer?");
                
                if(!doDelete){
                    event.preventDefault();
                }
            }

            $(document).ready( onLoad );
        </script> 

