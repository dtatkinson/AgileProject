<%@page import="com.oreilly.servlet.MultipartRequest" %>

<%

    MultipartRequest m=new MultipartRequest(request, "\\\\silva.computing.dundee.ac.uk\\webapps\\2018-agileteam3\\test");

    out.println("Successfully Uploaded..");

    %> 
