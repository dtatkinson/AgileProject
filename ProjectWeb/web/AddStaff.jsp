<%-- 
    Document   : AddStaff
    Created on : 22-Jan-2019, 13:21:31
    Author     : camerontaylor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/regular.css" integrity="sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4" crossorigin="anonymous">  
        <link rel="stylesheet" href="CSS.css">
        <title>Add Staff</title>
    </head>
    <body>
       <div class ="img">
       <a href="AdminDashboard.jsp">
     <img src="DundeeUniLogo.png" width="100" height="125" alt="DundeeLogo" align=”left”    />
    </a>
     </div>
        <div align="center">
            <h1><u>Add Staff Member</u></h1>
            
         <form name="Details Input Form" action="AdminServlet" method="POST">
             
            <div align ="center">
                <h4>Enter Staff Username:</h4>
            <input type="text" name="StaffName" value="" />
            </div>
            
             <div align ="center">
            <h4>Enter Staff Name:</h4>
            <input type="text" name="Name" value="" />
            </div>
             
            <div align ="center">
                <h4>Enter Staff Password:</h4>
            <input type="text" name="StaffPassword" value="" />
            </div>
            
            <div align ="center">
            <h4>Enter Role:</h4>
            <input type="text" name="Role" value="" />
            </div>
            <input type="submit" value="Submit" />
             
         </form>
            <form action="ManagementPage.jsp">
                <input type="submit" value="<-Back" />
            </form>
            </div>
    </body>
</html>
