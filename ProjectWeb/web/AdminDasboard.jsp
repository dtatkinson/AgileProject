<%-- 
    Document   : AdminDasboard
    Created on : 21-Jan-2019, 11:50:10
    Author     : owenkelbie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="StaffButton" action="tempstaff.jsp">
        <h1>Staff</h1>
        <input type="submit" value="Manage Staff" name="staffbtn" />
        </form>
        
        <form name="ipExamForm" action="ipExam.jsp">
        <h1>Exams </h1> 
        <input type="submit" value="Check Exams" name="ExamBtn" />
        </form>
        <form name="compExmForm" action="compExams.jsp">
            <input type="submit" value="Completed" name="compExambtn" />
        </form>
    
    </body>
</html>
