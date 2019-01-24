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
        <link rel="stylesheet" href="CSS.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Exam</title>
    </head>
    <body>
        <div class ="img">
        <a href="AdminDashboard.jsp">
          <img src="DundeeUniLogo.png" width="100" height="125" alt="DundeeLogo" align=”left”    />
        </a>
        </div>
        <u><h1 align ="center">Create Exam</h1></u>
        
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
             <div align ="center">
             <form name="Back " action="StaffDashboard.jsp">
                <input type="submit" value="<- Go Back" name="backBtn" /> 
            </form>
                 </div>
             
    </body>
</html>
