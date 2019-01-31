
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@ page import="Users.Admin" %>
<html>
    <style>

    </style>
    <head>
        <title>Login</title>
       
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/regular.css" integrity="sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4" crossorigin="anonymous">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">  
        <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" href="LoginCSS.css">
        <link rel="stylesheet" href="CSS.css">
        <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
 
    <body>
   

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn">
      
      <img src="DundeeUniLogo.png" id="icon" width="50%" height="50%" alt="User Icon" />
      
    </div>

    <!-- Login Form -->
    <form name="Details Input Form" action="LoginServlet" method="POST">
      
      <label class="control-label"  for="username">Staff ID</label>
      <input type="text" id="login" class="fadeIn second" name="staffID" placeholder="login">
      
      <label class="control-label" for="password">Password</label>
      <input type="password" id="password" class="fadeIn third" name="passwd" placeholder="password">
      
     
      
      <input type="submit" class="fadeIn fourth" value="Log In">
    </form>

   
   

  </div>
</div>
 </body>
</html>
