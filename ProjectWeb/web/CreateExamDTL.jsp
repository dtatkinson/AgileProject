<%-- 
    Document   : CreateExamDTL
    Created on : 22-Jan-2019, 15:28:28
    Author     : camerontaylor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession"  %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/regular.css" integrity="sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4" crossorigin="anonymous">
        <link rel="stylesheet" href="CSS.css">
        <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>Create Exam</title>
    </head>
    <body>
        <nav class="navbar fixed-bottom navbar-inverse" >
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="StaffDashboard.jsp">Staff Dashboard</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="CreateExamDTL.jsp">Upload an Exam paper</a></li>
      <li><a href="BrowseExamS">View my Exams</a></li>
      <li><a href="CreateResitExamDTL.jsp">Upload Resit Exam paper</a></li>
      <li><a href="BrowseExamResit">View Resit Exam papers</a></li>
      <li><a href="#">View Past papers</a></li>
    </ul>
  </div>
</nav>
        
        <div class ="img">
        
        </div>
        <h1 align ="center"><u>Create Exam</u></h1>    
             <div align ="center">
         <form name="Details Input Form" action="CreateExamServlet" method="POST">
            <h4>Module Name:</h4>
            <input type="text" name="ModName" value="" />
            </div>
        
            <div align ="center">
                <h4>Module Code:</h4>
            <input type="text" name="ModCode" value="" />
            </div>
            
            <div align ="center">
            <h4>Institution:</h4>
            <input type="text" name="Inst" value="" />
            </div>
                        
            <div align ="center">
            <h4>School:</h4>
            <input type="text" name="School" value="" />
            </div>
             
            <div align ="center">
            <h4>Academic Year:</h4>
            <input type="text" name="Year" value="" />
            </div>
            <div align ="center">
            <input type="submit" value="Submit" name="examSubmit" />
            </div>
         </form>
                 
             
             
    </body>
</html>
