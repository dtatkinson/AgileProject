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
        <title>Management Page</title>
    </head>
    <body>
        <div align ="center">
        <form name="Add Staff" action="AddTemp">
        <input type="submit" value="Add Staff" name="AddStaffbtn" />
        </form>
        </div>
        <div align ="center">
        <form name="Delete Staff" action="DeleteTemp">
             <input type="submit" value="Delete Staff" name="DeleteStaffbtn" />
        </form>
         </div>
        
        <div align ="center">
        <form name="Assign Staff" action="AssignTemp">
        <input type="submit" value="Assign Staff" name="AssignStaffbtn" />
        </form>
         </div>
        
        <div align ="center">
        <form name="View Staff" action="ViewTemp">
        <input type="submit" value="View Staff" name="ViewStaffbtn" />
        </form>
        </div>
        
        <div align ="center">
        <form name="Set Deadlines" action="DeadlineTemp">
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
