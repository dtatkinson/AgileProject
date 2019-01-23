<%@page import="com.oreilly.servlet.MultipartRequest" %>
<%@page import="javax.servlet.http.HttpSession"  %>
<%
    MultipartRequest m = new MultipartRequest(request, "\\\\silva.computing.dundee.ac.uk\\webapps\\2018-agileteam3\\test");

    out.println("Successfully Uploaded..");
    %> 
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/regular.css" integrity="sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4" crossorigin="anonymous">
        <title>Create Exam</title>
    </head>
    <body>
        <h1>Do this later 3</h1>
        
        <form action="CreateExamServlet">
            <input type="submit" value="Next->" />
        </form>
    </body>
</html>