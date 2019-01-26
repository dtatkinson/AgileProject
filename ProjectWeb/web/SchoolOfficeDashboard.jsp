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
        <title>School Office Dashboard</title>
    </head>
    <body>
        <div class ="img">
        <a href="AdminDashboard.jsp">
          <img src="DundeeUniLogo.png" width="100" height="125" alt="DundeeLogo" align=”left”    />
        </a>
        </div>
           <h1 align ="center">School Office Dashboard</h1>
    <div align="center" >
        <h2>View Exams </h2>
        <form name="viewForm" action="SchoolOfficeViewExams">
            <input type="submit" value="View & Downlaod Exams" name="viewbtn" />
        </form>
    </div>
           <div align ="center">
               <h2 > Options</h2>
        <form name="Optionsbtn" action="compExams.jsp">
            <input type="submit" value="Options" name="Optionsbtn" />
        </form>
        </div>
           <<div align ="center">
           <form  name="logoutForm" action="index.jsp">
        <input type="submit" value="Logout" name="logoutbtn"/>
    </form>
           
    </div>
        
    </body>
</html>
