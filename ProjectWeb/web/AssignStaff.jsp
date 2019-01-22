<%-- 
    Document   : AssignStaff
    Created on : 22-Jan-2019, 14:06:41
    Author     : camerontaylor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/regular.css" integrity="sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4" crossorigin="anonymous">
        <title>Assign Staff</title>
    </head>
    <body>
        <h1 align = "center"><u>Assign Staff</u></h1>
            <form name="Details Input Form" action="CreateExamServlet" method="POST">
            <div align ="center">
         <form name="Details Input Form" action="CreateExamServlet" method="POST">
            <div align ="center">
            <h4>Enter Staff Name:</h4>
            <input type="text" name="StaffName" value="" />
            </div>
            
            <div align ="center">
                <h4>Enter Current Staff Role:</h4>
            <input type="text" name="OldStaffRole" value="" />
            </div>
            
            <div align ="center">
            <h4>Enter New Staff Role:</h4>
            <input type="text" name="NewStaffRole" value="" />
            </div>    
             
             <br>
            <input type="submit" value="Submit" name="examSubmit" />
           
         </form>
    </body>
</html>
