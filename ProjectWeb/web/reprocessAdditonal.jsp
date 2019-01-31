

<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest" %>
<%@page import="javax.servlet.http.HttpSession"  %>
<%
    ServletContext context = session.getServletContext();
   
    
       String moduleCode = (String)session.getAttribute("moduleCode");
        String year = (String)session.getAttribute("year");
    String realContextPath = context.getRealPath("/");
    String uploadpath = realContextPath+"\\"+moduleCode+"\\"+year+"\\additionalUploads\\";
    MultipartRequest m = new MultipartRequest(request,uploadpath );
   
  
   
    
    
    %> 
    
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/regular.css" integrity="sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4" crossorigin="anonymous">
        <title>Create Exam</title>
    </head>
    <body>
          <div class ="img">
        <a href="StaffDashboard.jsp">
     <img src="DundeeUniLogo.png" width="100" height="125" alt="DundeeLogo" align=?left? />
        </a>
     </div>
        
    
        
        <form action="StaffDashboard.jsp">
            <input type="submit" value="Next->" />
        </form>
    </body>
</html>
