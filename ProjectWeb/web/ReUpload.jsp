<%-- 
    Document   : CreateExam
    Created on : 22-Jan-2019, 15:08:28
    Author     : camerontaylor
--%>
<%@page import="com.oreilly.servlet.MultipartRequest" %>
<%@page import="javax.servlet.http.HttpSession"  %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
              
                
       <div align ="center"> <h1><u>Re-upload Exam</u></h1></div>
       <div align="center"> 
   

        <% 
        String moduleCode = request.getParameter("modcode");
        String year = request.getParameter("year");
        out.println(moduleCode);
        out.println(year);
        //ServletContext context = session.getServletContext();
        session.setAttribute("year",year);
        session.setAttribute("moduleCode",moduleCode);
            
        
        out.println("<form action='reprocess.jsp' method='post' enctype='multipart/form-data'>");

            out.println("<b>Select File:</b> <input type='file' name='fname' accept='application/pdf'>");
          
           out.println(" <input type='submit' value='Upload'>");

        out.println("</form>");
%>
    </body>

</html> 


