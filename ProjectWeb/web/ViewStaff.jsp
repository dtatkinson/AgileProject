<%-- 
    Document   : ViewStaff
    Created on : 22-Jan-2019, 14:10:33
    Author     : camerontaylor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/regular.css" integrity="sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Staff</title>
    </head>
    <body>
     <div class ="img">
       <a href="AdminDashboard.jsp">
     <img src="DundeeUniLogo.png" width="100" height="125" alt="DundeeLogo" align=”left”    />
       </a>
     </div>
        <div align ="center">
        <h1>Staff Members:</h1>
         
        
        <form name="SearchForm" action="AdminViewStaffServlet" method="POST">
            <input type="text" name="SearchT" value="" placeholder="Staff Username"/>
            <input type="submit" value="Search"/>
        </form>
        <br>
        </div>
        
        <div align ="center">
        <form action="ManagementPage.jsp">  
        <input type="submit" value="<-Back" />
            </div>
        </form>
    </body>  
</html>
