

<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest" %>
<%@page import="javax.servlet.http.HttpSession"  %>
<%
    ServletContext context = session.getServletContext();
    String modulecode = (String)session.getAttribute("moduleCode");
    String StaffName = (String)session.getAttribute("ReUploadName");
    String realContextPath = context.getRealPath("/");
    String uploadpath = realContextPath+"\\"+modulecode+"\\2019\\additonalUploads\\";
    MultipartRequest m = new MultipartRequest(request,uploadpath );
    out.println("Successfully Uploaded..The PDf will auto change to "+modulecode+StaffName+".pdf");
    out.println(uploadpath);
    String fileName = m.getOriginalFileName("fname");
    File oldName = new File(uploadpath+fileName);
    File newName = new File(uploadpath+ modulecode+".pdf");
    oldName.renameTo(newName);
   
    
    
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
        
        <h1>Do this later 3</h1>
        
        <form action="StaffDashboard.jsp">
            <input type="submit" value="Next->" />
        </form>
    </body>
</html>
