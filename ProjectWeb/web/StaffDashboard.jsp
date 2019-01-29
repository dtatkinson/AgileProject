<%-- 
    Document   : StaffDasboard
    Created on : 21-Jan-2019, 11:50:10
    Author     : David Atkinson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <%
        /*if(session.getAttribute("username") == null || session.getAttribute("role").equals("Admin")|| session.getAttribute("role").equals("SO")){
            response.sendRedirect("LogoutServlet");
        }*/
        %>
  
        <head>
       
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/regular.css" integrity="sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4" crossorigin="anonymous">
        <link rel="stylesheet" href="CSS.css">
        <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>Admin Page </title>
    </head>
 
    <body>
      
        <nav class="navbar fixed-bottom navbar-inverse" >
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Staff Dashboard</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="#">Upload an Exam paper</a></li>
      <li><a href="#">View my Exams</a></li>
      <li><a href="#">Upload Resit Exam paper</a></li>
      <li><a href="#">View Resit Exam papers</a></li>
      <li><a href="#">View Past papers</a></li>
    </ul>
  </div>
</nav>
        
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
    <form name="Notifications" action="NotificationServlet">
        <input type="submit" value="New Lenard button" name="Lenard"/>
    </form>
        </div>
     </div>
    
        <br>
        <div align = "center">
        <% out.print("Hello, "); out.print(session.getAttribute("username")); %>
        </div>
    </body>
</html>
