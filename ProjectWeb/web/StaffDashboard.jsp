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
        <title>Staff Dashboard</title>
    </head>
    <body>
       <div class ="img">
        <a href="StaffDashboard.jsp">
     <img src="DundeeUniLogo.png" width="100" height="125" alt="DundeeLogo" align=”left” />
        </a>
     </div>
         <div>
             <h1 align ="center"><u>Staff Dashboard</u></h1>
    <div align="center" >
        <h2>New</h2>
        <form name="newButton" action="CreateExamDTL.jsp">
        <input type="submit" value="Create a new exam" name="newbtn" />
        </form>
  
        
        <h2 align="center">My exams </h2>
        <form name="viewForm" action="BrowseExamS">
            <input type="submit" value="View my exams" name="viewbtn" />
        </form>
           
        
        <h2 align="center"> Options</h2>
        <form name="Optionsbtn" action="compExams.jsp">
            <input type="submit" value="Options" name="Optionsbtn" />
        </form>
           
           
    </div>
        <div align="center" class="plain">
    <form  name="logoutForm" action="LogoutServlet">
        <input type="submit" value="Logout" name="logoutbtn"  />
    </form>
        </div>
     </div>
        <br>
        <div align = "center">
        <% out.print("Hello, "); out.print(session.getAttribute("username")); %>
        </div>
    </body>
</html>
