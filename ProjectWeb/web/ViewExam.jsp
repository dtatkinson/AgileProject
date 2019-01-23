<%-- 
    Document   : ViewExam
    Created on : 23-Jan-2019, 10:39:27
    Author     : owenkelbie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Exam</title>
    </head>
    <body>
        <div align="center">
            <h1>some Module code/year goes here</h1>
           
            
                <embed src="http:\\silva.computing.dundee.ac.uk\\2018-agileteam3\\test\\file_name.pdf" width="750" height="700">
           
            
                <embed src="http:\\silva.computing.dundee.ac.uk\\2018-agileteam3\\test\\ethical.txt" width="750" height="700">
                
                <div align="center">
                <form action="writeComment" method="POST">
                        <textarea name="writeComments" rows="15" cols="100">
                        </textarea>
                    <div align="center">
                        <input type="submit" value="Add Comment" name="writeCmntbtn" />
                    </div>
                </form>
                </div>
        </div>
        
    </body>
</html>
