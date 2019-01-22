
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@ page import="Users.Admin" %>
<html>
    
    <head>
        <title>Login</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/regular.css" integrity="sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4" crossorigin="anonymous">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Login</h1>
        <form name="Details Input Form" action="LoginServlet" method="POST">
            
            Enter your Staff ID:
            <input type="text" name="staffID" value="" />
                        
            Enter your Password:
            <input type="password" name="passwd" value="" />
            
            <input type="submit" value="OK" />
            
            
        </form>
        
        <form name="Lenard form" method="POST" action ="TestServlet">
            
            <input type="submit" value="Lenard Button"/>
          
        </form>
        
    </body>
</html>
