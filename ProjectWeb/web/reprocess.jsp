

<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest" %>
<%@page import="javax.servlet.http.HttpSession"  %>
<%
    ServletContext context = session.getServletContext();
    String modulecode = (String)session.getAttribute("moduleCode");
    String year = (String)session.getAttribute("year");
    String realContextPath = context.getRealPath("/");
    String uploadpath = realContextPath+"\\"+modulecode+"\\"+year+"\\";
    
    //kills older version of file
    File olderName = new File(uploadpath+modulecode+".pdf");
    olderName.delete();
    
    MultipartRequest m = new MultipartRequest(request,uploadpath );
    out.println("Successfully Uploaded..The PDf will auto change to "+modulecode+".pdf");
    
    String fileName = m.getOriginalFileName("fname");
    File oldName = new File(uploadpath+fileName);
    File newName = new File(uploadpath+ modulecode+".pdf");
    oldName.renameTo(newName);
    
    
   
    
    
    %> 
    
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
                          <a class="navbar-brand" href="StaffDashboard.jsp">Staff Dashboard</a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                          </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav">
                        <li class="nav-item">
                          <a class="nav-link" href="CreateExamDTL.jsp">Upload Exam Paper</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="BrowseExamS">View My Exams</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="CreateResitExamDTL.jsp">Upload Resit Exam</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="BrowseExamResit">View Resit Exams</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link" href="ViewPastPaper">View Past Papers</a>
                        </li>
                        </ul>
                        </div>
                        </nav>
        
        
        <form action="StaffDashboard.jsp">
            <input type="submit" value="Next->" />
        </form>
    </body>
</html>