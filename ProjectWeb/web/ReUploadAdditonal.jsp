

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

    <head>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/regular.css" integrity="sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4" crossorigin="anonymous">
        <style type="text/css">

            body {background-color: khaki;}           
  <% 
        String moduleCode = request.getParameter("modcode");
        String year = request.getParameter("year");
        %>
        </style>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>File Upload App in JSP</title>

    </head>

    <body>

        <form action="reprocessAdditonal.jsp" method="post" enctype="multipart/form-data">

            <b>Select File:</b> <input type="file" name="fname" accept="application/pdf" ><br/>
             <input type='hidden' name ='modcode'  value ="<%out.println(moduleCode);%>">
            <input type='hidden' name ='year'  value ="<%out.println(year);%>">
            <input type="submit" value="Upload">

        </form>

    </body>

</html> 
