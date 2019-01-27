
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
        <link rel="stylesheet" href="CSS.css">
        <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    </head>
 <body>
  
<div class="container">
    <div class="row">
		<div class="span12">
                     
                      <div align ="center">
			 <form name="Details Input Form" action="LoginServlet" method="POST">
			  <fieldset>
			    <div id="legend">
			      <legend class="" >Login</legend>
			    </div>
			    <div class="control-group">
			      <!-- Username -->
			      <label class="control-label"  for="username">Staff ID</label>
			      <div class="controls">
			        <input type="text" name="staffID" value="" />
			      </div>
			    </div>
			    <div class="control-group">
			      <!-- Password-->
			      <label class="control-label" for="password">Password</label>
			      <div class="controls">
			       <input type="password" name="passwd" value="" />
			      </div>
			    </div>
			    <div class="control-group">
			      <!-- Button -->
			      <div class="controls">
			        <button class="btn btn-info">Login</button>
			      </div>
			    </div>
			  </fieldset>
			</form>
                          <div >
                          <img src="opengraph.png" max-width="100%" height="auto" alt="Logo"/>
                          </div>
		</div>
	</div>
</div>
 </body>
</html>
