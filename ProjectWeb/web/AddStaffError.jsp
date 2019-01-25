<%-- 
    Document   : StaffDasboard
    Created on : 21-Jan-2019, 11:50:10
    Author     : David Atkinson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
 
         <link rel="stylesheet" href="CSS.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/regular.css" integrity="sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4" crossorigin="anonymous">
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Exam Dashboard</title>
    </head>
    <body>
       <div class ="img">
        <a href="AdminDashboard.jsp">
     <img src="DundeeUniLogo.png" width="100" height="125" alt="DundeeLogo" align=”left” />
        </a>
     </div>
         <div align ="center">
             <h2 align ="center">Sorry, that Staff user name is already taken</h2>

            <form align ="center" name="Try Again" action="AddStaff.jsp">
                <input type="submit" value="Try Again" name="backBtn" />   
            </form>
             
        </div>
     </div>
        <br>
        <div align = "center">
        <% out.print("Hello, "); out.print(session.getAttribute("username")); %>
        </div>
    </body>
</html>

