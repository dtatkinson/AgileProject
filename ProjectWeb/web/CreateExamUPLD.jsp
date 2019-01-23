<%-- 
    Document   : CreateExam
    Created on : 22-Jan-2019, 15:08:28
    Author     : camerontaylor
--%>
<%@page import="com.oreilly.servlet.MultipartRequest" %>
<%@page import="javax.servlet.http.HttpSession"  %>
<%@page import="javax.servlet.http.HttpSession"  %>
<%
        
        String moduleName = request.getParameter("ModName");
        String moduleCode = request.getParameter("ModCode");
        String institution = request.getParameter("Inst");
        String school = request.getParameter("School");
        String academicYear = request.getParameter("Year");
        String publishedBy = (String)session.getAttribute("username");
        session.setAttribute("MN",moduleName);
        session.setAttribute("MC",moduleCode );
        session.setAttribute("I",institution);
        session.setAttribute("S",school);
        session.setAttribute("AY",academicYear);
        session.setAttribute("PB",publishedBy);
    %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/regular.css" integrity="sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4" crossorigin="anonymous">
        

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Create Exam</title>

    </head>

    <body>
        <div align ="center"> <u><h1>Create Exam</u></h1><div>
                                 
        <form action="process.jsp" method="post" enctype="multipart/form-data">

            <b>Upload Exam PDF:</b> <input type="file" name="fname"><br/>

            <input type="submit" value="Upload">

        </form>

    </body>
</html>
