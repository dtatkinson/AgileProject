<%-- 
    Document   : DeleteStaff
    Created on : 22-Jan-2019, 13:31:01
    Author     : camerontaylor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    

    <head>
        <link rel="stylesheet" href="CSS.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/regular.css" integrity="sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Staff</title>
    </head>
    <body>
        <div align="center">
            <h1><u>REMOVE STAFF MEMBER</u></h1>
                <h3>Enter Staff ID:</h3>
                <form name="Gerald" action="AdminRemoveStaffServlet" method="POST">
                <input type="text" name="staffNameToDelete" value=""  />
                <input type="submit" value="OK" name="Davids" />
               
                </form>
                

                  
        </div>
        <div>
            <form action="ManagementPage.jsp">
                       <input type="submit" value="<-Back" />
                   </form>
        </div>
    </body>
</html>
