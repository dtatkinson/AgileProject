/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Database.DatabaseHandling;
import FileHandling.FileHandling;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author matthewmchale
 */
@WebServlet(name = "AdminCreateFilePathServlet", urlPatterns = {"/AdminCreateFilePathServlet"})
public class AdminCreateFilePathServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //String search = request.getParameter("Search");
        try (PrintWriter out = response.getWriter()) {
            try
            {       
                
                out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("         <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.0/css/all.css\" integrity=\"sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ\" crossorigin=\"anonymous\">\n" +
                        "        <link rel=\"stylesheet\" href=\"CSS.css\">\n" +
                        "        <link href=\"//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n" +
                        "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n" +
                        "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" +
                        "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>");
                        
            out.println("</head>");
            out.println("<body>");
            
            out.println("<nav class=\"navbar fixed-bottom navbar-inverse\" >\n" +
                        "  <div class=\"container-fluid\">\n" +
                        "    <div class=\"navbar-header\">\n" +
                        "      <a class=\"navbar-brand\" href=\"ViewNewExams\">Admin Staff Dashboard</a>\n" +
                        "    </div>\n" +
                        "    <ul class=\"nav navbar-nav\">\n" +
                        "      <li><a href=\"AddStaff.jsp\">Add Staff</a></li>\n" +
                        "      <li><a href=\"DeleteStaff.jsp\">Delete Staff</a></li>\n" +
                        "      <li><a href=\"AdminAssignStaffServlet\">Assign Staff New role</a></li>\n" +
                        "      <li><a href=\"ViewStaff.jsp\">View Staff</a></li>\n" +
                        "      <li><a href=\"AdminSetDeadlineServlet\">Set Deadlines</a></li>\n" +
                        "      <li><a href=\"AdminAssignToExam\">Assign Staff to new exam</a></li>\n" +
                        "      <li><a href=\"AdminCreateFilePathServlet\">Create folders for next year</a></li>\n" +
                        "    </ul>\n" +
                        "  </div>\n" +
                        "</nav>");
            
            
          out.println("<div align = 'center'>");
          out.println("<div class='white'>");
            out.println("<form action='AdminCreateFilePathServlet' method='POST'>");
                  out.println("<input type=\"text\" name = 'inputbox'>");
                  out.println("<br>");
                   out.println("<input type=\"submit\" value='Create folders for this year'>");
                 out.println("</form>");
                 
                                 out.println("<script>\n" +
                    "             function resizeText(multiplier) {\n" +
                    "  if (document.body.style.fontSize == \"\") {\n" +
                    "    document.body.style.fontSize = \"1.0em\";\n" +
                    "  }\n" +
                    "  document.body.style.fontSize = parseFloat(document.body.style.fontSize) + (multiplier * 0.2) + \"em\";\n" +
                    "}\n" +
                    "</script>       \n" +
                    "    <div class =\"increase\" align = \"center\" >      \n" +
                    "        <i class=\"fas fa-search-plus\" alt=\"Increase text size\" onclick=\"resizeText(1)\" ></i>\n" +
                    "    </div>\n" +
                    "    <div class =\"decrease\" align =\"center\">\n" +
                    "         <i class=\"fas fa-search-minus\" alt=\"Decrease text size\"  onclick=\"resizeText(-1)\" ></i> \n" +
                    "    </div>        ");
                 out.println("</div>");
               out.println("</div>");
            
            out.println("</body>");
            out.println("</html>");
                 if (request.getParameter("inputbox") != null) {
            createPaths(request, response);
                 }
            }catch(Exception e){
                
            }
        }
        catch(Exception e){
            
        }
          
                
     
            
        
    }
    public void createPaths(HttpServletRequest request, HttpServletResponse response){
        String yearE = request.getParameter("inputbox");
        DatabaseHandling conn = new DatabaseHandling();
        FileHandling file = new FileHandling();
        String modCode;
        String year = "\\"+yearE+"\\";  //Only accepts 2019 as the year
        String lenardPath = getPath();
        file.defaultPath = lenardPath;
        try{
            
            ResultSet moduleList = conn.listTable("Exam");
            while(moduleList.next()){
                modCode = moduleList.getString("ModuleCode");
                if(!file.checkIfFileExists(modCode)){ //Checks if folder with the moodule code exists
                    file.createDirectory(modCode,year);
                    file.createDirectory(modCode+year, "additionalUploads");
                    file.createFile(modCode+year, "comments.txt");
                    file.createFile(modCode+year, "commentsResit.txt");
                }else if (file.checkIfFileExists(modCode) && !file.checkIfFileExists(modCode+year)){ //Checks if the folder with the year exists inside of the mod code folder
                    file.createDirectory(modCode, year);
                    file.createFile(modCode+year, "comments.txt");
                    file.createFile(modCode+year, "commentsResit.txt");
                    file.createDirectory(modCode+year, "additionalUploads");
                }else if(file.checkIfFileExists(modCode+year) && !file.checkIfFileExists(modCode+year+"comments.txt") && !file.checkIfFileExists(modCode+year+"commentsResit.txt")){ //Checks if the comments file exists inside the year folder
                    file.createFile(modCode+year, "comments.txt");
                    file.createFile(modCode+year, "commentsResit.txt");
                }else if(file.checkIfFileExists(modCode+year) && file.checkIfFileExists(modCode+year+"comments.txt") && !file.checkIfFileExists(modCode+year+"commentsResit.txt")){
                    file.createFile(modCode+year, "commentsResit.txt");
                }
                if(file.checkIfFileExists(modCode+year)&& !file.checkIfFileExists(modCode+year+"additionalUploads")){ //Checks if the aditional uploads folder exists inside year
                    file.createDirectory(modCode+year, "additionalUploads");
                }
                    }
          
        }catch(Exception e){}

    }
    
    public String getPath()
    { 
        String rightPath = getServletContext().getRealPath("/");
        rightPath = rightPath + "/";
        out.println(rightPath);
        return rightPath;
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
