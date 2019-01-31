<%-- 
    Document   : DeleteStaff
    Created on : 22-Jan-2019, 13:31:01
    Author     : camerontaylor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    

    <head>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
        <link rel="stylesheet" href="CSS.css">
        <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>Delete Staff</title>
    </head>
    <body>
            <nav class="navbar fixed-bottom navbar-inverse" >
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="ViewNewExams">Admin Staff Dashboard</a>
    </div>
        <ul class="nav navbar-nav">
        <li><a href="AddStaff.jsp">Add Staff</a></li>
        <li><a href="DeleteStaff.jsp">Delete Staff</a></li>
        <li><a href="AdminAssignStaffServlet">Assign Staff New role</a></li>
        <li><a href="ViewStaff.jsp">View Staff</a></li>
        <li><a href="AdminSetDeadlineServlet">Set Deadlines</a></li>
        <li><a href="AdminAssignToExam">Assign Staff to new exam</a></li>
        <li><a href="AdminCreateFilePathServlet">Create folders for next year</a></li>
    </ul>
  </div>
</nav>
        <div align="center">
            <h1><u>REMOVE STAFF MEMBER</u></h1>
            <br>
            <p>Enter the name of the staff member you wish to delete from the system</p><font color ="red">Please note that this action cannot be reverted</font><br><font color ="red">Leave empty to view all Staff</font>
                <h3>Enter Staff Username:</h3>
                <form name="Gerald" action="AdminRemoveStaffServlet" method="POST">
                    <input type="text" name="staffName"/>
                    <input type="submit" value="OK"  onclick="myFunction()"/>
               
                </form>
                <script>

                    function myFunction() {

                    alert("Are you sure you want to delete this member of staff!");

                    }

</script>


  <script>
             function resizeText(multiplier) {
  if (document.body.style.fontSize == "") {
    document.body.style.fontSize = "1.0em";
  }
  document.body.style.fontSize = parseFloat(document.body.style.fontSize) + (multiplier * 0.2) + "em";
   if(document.getElementById("font").style.fontSize== fontSize+0.2){
        document.getElementById("font").style.fontSize= "1.0em";
    } if(document.getElementById("font").style.fontSize= fontSize-0.2){
        document.getElementById("font").style.fontSize= "1.2em"
    }
}
    </script>       
    <div class ="increase" align = "center" >      
        <i class="fas fa-search-plus" alt="Increase text size" onclick="resizeText(1)" ></i>
    </div>
    <div class ="decrease" align ="center">
         <i class="fas fa-search-minus" alt="Decrease text size"  onclick="resizeText(-1)" ></i> 
    </div>
            
                  
    </body>
</html>
