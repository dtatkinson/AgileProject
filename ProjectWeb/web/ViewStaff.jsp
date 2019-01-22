<%-- 
    Document   : ViewStaff
    Created on : 22-Jan-2019, 14:10:33
    Author     : camerontaylor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Staff</title>
    </head>
    <body>
        <h1>Staff Members:</h1>
        
        <form name="SearchForm" action="AdminViewStaffServlet" method="POST">
            <input type="submit" value="Search"/>
        </form>
        
        <form action="ManagementPage.jsp">
            <input type="submit" value="<-Back" />
        </form>
        
    </body>  
</html>
