<%-- 
    Document   : DeleteStaff
    Created on : 22-Jan-2019, 13:31:01
    Author     : camerontaylor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    

    <head>
         <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/regular.css" integrity="sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4" crossorigin="anonymous">
                                <link rel="stylesheet" href="CSS.css">
                                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
                                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                                <meta name="viewport" content="width=device-width, initial-scale=1">
                          <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
                        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
                        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
            

            </head>
            <body>
            
                 <nav class="navbar navbar-expand-lg bg-dark navbar-dark sticky-top">
                          <a class="navbar-brand" href="ViewNewExams">Admin Staff Dashboard</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                          </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav">
                        <li class="nav-item">
                          <a class="nav-link" href="AddStaff.jsp">Add Staff</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="DeleteStaff.jsp">Delete Staff</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="AdminAssignStaffServlet">Assign Staff New Role</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="ViewStaff.jsp ">View Staff</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="AdminSetDeadlineServlet">Set Deadlines</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="AdminAssignToExam">Assign Staff To New Exam</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="AdminCreateFilePathServlet">Create Folders</a> 
                        </li>
                        </ul>
                        </div>
                        </nav>
        <div align="center">
            <div class ="white">
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
            </div>
        </div>
                  
    </body>
</html>
