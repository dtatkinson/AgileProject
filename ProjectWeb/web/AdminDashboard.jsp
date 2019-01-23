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
        if(session.getAttribute("username") == null){
            response.sendRedirect("index.jsp");
        }
        %>
    <head>
       
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/regular.css" integrity="sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4" crossorigin="anonymous">
        <link rel="stylesheet" href="CSS.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page </title>
    </head>
    <body>
        <div class ="img">
        <a href="AdminDashboard.jsp">
     <img src="DundeeUniLogo.png" width="100" height="125" alt="DundeeLogo" align=”left” />
        </a>
     </div>
 
        <div align="center" >
        <h1><u>Staff</u></h1>
        <form name="StaffButton" action="ManagementPage.jsp">
        <input type="submit" value="Manage Staff" name="staffbtn" />
        </form>
        
        <div></div>
        
        
        <h1 align="center"><u>Exams </u></h1>
        <form name="ipExamForm" action="ipExam.jsp"> 
        <input type="submit" value="New" name="ExamBtn" />
        </form>
        <br>
        <form name="compExmForm" action="compExams.jsp">
            <input type="submit" value="In Progress" name="compExambtn" />
        </form>
        <br>
        <div align="center" class="plain">
            <a href="index.jsp">
            <form  name="logoutForm" action="index.jsp">
            <img src="Logout.png" width="20" height="20" alt="Logout"/>
             </a>
      
    </form>

            <br>
            <% out.print("Hello, "); out.print(session.getAttribute("username")); %>
            
        </div>
        
    </body>
</html>
