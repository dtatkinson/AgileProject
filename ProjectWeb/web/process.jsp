

<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest" %>
<%@page import="javax.servlet.http.HttpSession"  %>
<%
  
    String modulecode = (String)session.getAttribute("moduleCode");
    MultipartRequest m = new MultipartRequest(request, "\\\\silva.computing.dundee.ac.uk\\webapps\\2018-agileteam3\\"+modulecode+"\\2019\\");
    out.println("Successfully Uploaded..The PDf will auto change to "+modulecode+".pdf");
    String fileName = m.getOriginalFileName("fname");
    File oldName = new File("\\\\silva.computing.dundee.ac.uk\\webapps\\2018-agileteam3\\"+modulecode+"\\2019\\"+fileName);
    File newName = new File("\\\\silva.computing.dundee.ac.uk\\webapps\\2018-agileteam3\\"+modulecode+"\\2019\\"+ modulecode+".pdf");
    oldName.renameTo(newName);
   
    
    
    %> 
    
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/regular.css" integrity="sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4" crossorigin="anonymous">
        <title>Create Exam</title>
    </head>
    <body>
        <h1>Do this later 3</h1>
        
        <form action="StaffDashboard.jsp">
            <input type="submit" value="Next->" />
        </form>
    </body>
</html>