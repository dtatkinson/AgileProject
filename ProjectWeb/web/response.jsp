<%-- 
    Document   : response
    Created on : 20-Jan-2019, 15:24:05
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
        <jsp:useBean id="staffIDbean" scope="session" class="Login.DetailHandler" />
        <jsp:setProperty name="staffIDbean" property="staffID" />
        <h1>Your Staff ID is, <jsp:getProperty name="staffIDbean" property="staffID" />!</h1>
        <jsp:useBean id="passwdbean" scope="session" class="Login.DetailHandler" />
        <jsp:setProperty name="passwdbean" property="passwd" />
        <h1>Your Password is, <jsp:getProperty name="passwdbean" property="passwd" /></h1>
    </body>
</html>
