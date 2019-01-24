<%-- 
    Document   : ManagementPage
    Created on : 22-Jan-2019, 13:05:04
    Author     : camerontaylor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/regular.css" integrity="sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4" crossorigin="anonymous">
        <title>Management Page</title>
    </head>
    <body>
        <div class ="img">
        <a href="AdminDashboard.jsp">
     <img src="DundeeUniLogo.png" width="100" height="125" alt="DundeeLogo" align=”left” />
        </a>
     </div>
        <div align = "center" ><h1><u> Management</u> <h1> </div>
        <div align ="center">
        <form name="Add Staff" action="AddStaff.jsp">
        <input type="submit" value="Add Staff" name="AddStaffbtn" />
        </form>
        </div>
        <div align ="center">
        <form name="Delete Staff" action="DeleteStaff.jsp">
             <input type="submit" value="Delete Staff" name="DeleteStaffbtn" />
        </form>
         </div>
        
        <div align ="center">
        <form name="Assign Staff" action="AssignStaff.jsp">
        <input type="submit" value="Assign Staff New Role" name="AssignStaffbtn" />
        </form>
         </div>
        
        <div align ="center">
        <form name="View Staff" action="ViewStaff.jsp">
        <input type="submit" value="View Staff" name="ViewStaffbtn" />
        </form>
        </div>
        
        <div align ="center">
        <form name="Set Deadlines" action="AdminSetDeadlinesServlet">
        <input type="submit" value="Set Deadlines" name="deadlinebtn" />
        </div>
        </form>
            
        <div align ="center">
        <form name="Assign Staff to Exam" action="AdminAssignToExam">
        <input type="submit" value="Set Deadlines" name="deadlinebtn" />
        </div>
        </form>
      
        <div align ="center">
            <form name="Back " action="AdminDashboard.jsp">
                <input type="submit" value="<- Go Back" name="backBtn" />   
            </form>
        </form>
        
    </body>
</html>
