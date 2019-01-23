<%-- 
    Document   : ViewStaff
    Created on : 22-Jan-2019, 14:10:33
    Author     : camerontaylor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/regular.css" integrity="sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Staff</title>
    </head>
    <body>
        <h1>Staff Members:</h1>
        
        <form name="SearchForm" action="AdminViewStaffServlet" method="POST">
            <input type="text" name="SearchT" value="" placeholder="Staff Username"/>
            <input type="submit" value="Search"/>
        </form>
        
        <form action="ManagementPage.jsp">
            <input type="submit" value="<-Back" />
        </form>
        
    </body>  
</html>
