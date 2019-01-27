<%-- 
    Document   : AdminDasboard
    Created on : 21-Jan-2019, 11:50:10
    Author     : owenkelbie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"  %>


<!DOCTYPE html>
<html>
    <%
        if(session.getAttribute("username") == null || !session.getAttribute("role").equals("Admin")){
            response.sendRedirect("LogoutServlet");
        }
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
      <a class="navbar-brand" href="#">Admin Staff Dashboard</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">Add Staff</a></li>
      <li><a href="#">Delete Staff</a></li>
      <li><a href="#">Assign Staff New role</a></li>
      <li><a href="#">View Staff</a></li>
      <li><a href="#">Set Deadlines</a></li>
      <li><a href="#">Assign Staff to new exam</a></li>
    </ul>
  </div>
</nav>
    
        <div class ="img">
        <a href="AdminDashboard.jsp">
     <img src="DundeeUniLogo.png" width="100" height="125" alt="DundeeLogo" align=”left” />
        </a>
     </div>
 
        <div align="center" >
        <h1><u>Staff</u></h1>
        <p>Options to edit and view options for all members of staff</p>
        <form name="StaffButton" action="ManagementPage.jsp">
        <input type="submit" value="Manage Staff" name="staffbtn" />
        </form>
        
        <div></div>
        
        
        <h1 align="center"><u>Exams </u></h1>
        
        <form name="ipExamForm" action="ViewNewExams"> 
        <input type="submit" value="View all exams" name="ExamBtn" />
         </form>
     
        <br>
        <div align="center" class="plain">
            <a href="index.jsp">
            <form  name="logoutForm" action="LogoutServlet">
            <img src="Logout.png" width="20" height="20" alt="Logout"/>
             </a>
      
    </form>
               
      
            <br>
            <% out.print("Hello, "); out.print(session.getAttribute("username")); %>
            
        </div>
            <img src="opengraph.png" max-width="100%" height="auto" alt="Logo"/>
        </div>
           
    </body>
    
</html>
