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
         <link rel="stylesheet" href="AdminCSS.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <div align="center" >
        <h1>Staff</h1>
        <form name="StaffButton" action="ManagementPage.jsp">
        <input type="submit" value="Manage Staff" name="staffbtn" />
        </form>
        
        <div></div>
        
        <h1 align="center">Exams </h1>
        <form name="ipExamForm" action="ipExam.jsp"> 
        <input type="submit" value="New" name="ExamBtn" />
        </form>
        <form name="compExmForm" action="compExams.jsp">
            <input type="submit" value="In Progress" name="compExambtn" />
        </form>
           
           
    </div>
        <div align="center" class="plain">
    <form  name="logoutForm" action="LogoutServlet">
        <input type="submit" value="Logout" name="logoutbtn"  />
        
    </form>
            <% out.print("Hello, "); out.print(session.getAttribute("username")); %>
        </div>
    </body>
</html>
