
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@ page import="Users.Admin" %>
<html>
    <%!
        void testing(){
            Admin test = new Admin();
            out.println(test.test());
    }
        %>
    
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Login</h1>
        <form name="Details Input Form" action="response.jsp">
            
            Enter your Staff ID:
            <input type="text" name="staffID" value="" />
                        
            Enter your Password:
            <input type="password" name="passwd" value="" />
            
            <input type="submit" value="OK" />
            
            
        </form>
        
        <form name="Lenard form" action ="#">
            
            <input type="submit" value="Lenard Button" onclick="testing()"/>
          
        </form>
        
    </body>
</html>
