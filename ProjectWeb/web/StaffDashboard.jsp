<%-- 
    Document   : StaffDasboard
    Created on : 21-Jan-2019, 11:50:10
    Author     : David Atkinson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Database.DatabaseHandling"%>
<%@page import="javax.servlet.http.HttpSession"  %>
<%@page import="java.sql.*"  %>

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
                                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
                                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                                <meta name="viewport" content="width=device-width, initial-scale=1">
                          <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
                        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
                        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
            

            </head>
            <body>
            
                 <nav class="navbar navbar-expand-lg bg-dark navbar-dark sticky-top">
                          <a class="navbar-brand" href="StaffDashboard.jsp">Staff Dashboard</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                          </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav">
                        <li class="nav-item">
                          <a class="nav-link" href="CreateExamDTL.jsp">Upload Exam Paper</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="BrowseExamS">View My Exams</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="CreateResitExamDTL.jsp">Upload Resit Exam</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="BrowseExamResit">View Resit Exams</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="ViewPastPaper">View Past Papers</a>
                        </li>
                        </ul>
                        </div>
                        </nav> 
        <%
            String username = (String) session.getAttribute("username");
            //out.println(username);
            DatabaseHandling conn = new DatabaseHandling();
            ResultSet examChange = conn.getChange(username);
            int count = 0;
            
            if(examChange != null){
                while(examChange.next()){
                   count++;
                }
            }
               
            
            
    %>
        <div align="center">
         <div class="btn btn-danger">
             <p>
                 You have <% out.print(count); %> update(s)! 
                 
             </p>
         </div> 
        </div>   
    
        <div align="center" class="plain">
    <form  name="logoutForm" action="LogoutServlet">
        <input class="btn btn-info" type="submit" value="Logout" name="logoutbtn">
    </form>
    
        
    
        
        </div>
        
        <br>
        <div align = "center">
        <% out.print("Hello, "); out.print(session.getAttribute("username")); %>
        </div>
        
    </body>
</html>
