<%-- 
    Document   : AdminDasboard
    Created on : 21-Jan-2019, 11:50:10
    Author     : David Atkinson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
 
         <link rel="stylesheet" href="AdminCSS.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Dashboard</title>
    </head>
    <body>
           <h1 align ="center">Staff Dashboard</h1>
    <div align="center" >
        <h2>New</h2>
        <form name="newButton" action="tempstaff.jsp">
        <input type="submit" value="Create a new exam" name="newbtn" />
        </form>
        
        <div></div>
        
        <h2 align="center">My exams </h2>
        <form name="viewForm" action="will go somewhere.jsp">
            <input type="submit" value="View my exams" name="viewbtn" />
        </form>
           
        
        <h2 align="center"> Options</h2>
        <form name="Optionsbtn" action="compExams.jsp">
            <input type="submit" value="Options" name="Optionsbtn" />
        </form>
           
           
    </div>
        <div align="center" class="plain">
    <form  name="logoutForm" action="index.jsp">
        <input type="submit" value="Logout" name="logoutbtn"  />
    </form>
        </div>
    </body>
</html>
