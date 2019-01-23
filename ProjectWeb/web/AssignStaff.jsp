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
           <link rel="stylesheet" href="CSS.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/regular.css" integrity="sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4" crossorigin="anonymous">
        <title>Assign Staff</title>
    </head>
    <body>
       <div class ="img">
        <a href="AdminDashboard.jsp">
     <img src="DundeeUniLogo.png" width="100" height="125" alt="DundeeLogo" align=”left”    />
        </a>
     </div>
        <h1 align = "center"><u>Assign Staff</u></h1>
        
       <div align ="center">
           <p>Enter the name of a staff member and which role you wish to assign them to</p>
         <form name="Details Input Form" action="AdminChangeStaffRole" method="POST">
            <h4>Enter Staff Name:</h4>
            <input type="text" name="StaffName" value="" />
            </div>
            
            <div align ="center">
            <h4>Enter New Staff Role:</h4>
            <input type="text" name="NewStaffRole" value="" />
            </div>    
             
             <br>
             <div align ="center">
            <input type="submit" value="Submit" name="examSubmit" />
             </div>
           
         </form>
           <br>
            <div align ="center"
           <form name="Back " action="AdminDashboard.jsp">
                <input type="submit" value="<- Go Back" name="backBtn" />   
            </form>
            </div>
    </body>
</html>
