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

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        
        
        <title>Create Exam</title>

    </head>

    <body>
        
        <div class ="img">
        <a href="StaffDashboard.jsp">
     <img src="DundeeUniLogo.png" width="100" height="125" alt="DundeeLogo" align=”left” />
        </a>
     </div>
        <div align ="center"> <u><h1>Create Exam</u></h1><div>
                                 
        <form action="process.jsp" method="post" enctype="multipart/form-data">

            <b>Upload Exam PDF:</b> 
            <input type="file" name="fname" accept="application/pdf"><br/>
            <input type="submit" value="Upload" onClick="Check_Data()">

        </form>

            
            
    </body>
</html>
