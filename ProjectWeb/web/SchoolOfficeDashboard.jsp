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
        <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>School Office Dashboard</title>
    </head>
    <body>
        <div class ="img">
        <a href="SchoolOfficeDashboard.jsp">
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
