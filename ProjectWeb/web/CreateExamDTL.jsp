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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Exam</title>
    </head>
    <body>
         <div align ="center"> <u><h1>Create Exam</u></h1><div>
            
         <form name="Details Input Form" action="CreateExamServlet" method="POST">
            <div align ="center">
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
        
            <input type="submit" value="Submit" name="examSubmit" />
           
         </form>
             
             <form name="Back " action="StaffDashboard.jsp">
                <input type="submit" value="<- Go Back" name="backBtn" />   
            </form>
             
    </body>
</html>
