/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Database.DatabaseHandling;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.time.Year;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lenardgaunt
 */
@WebServlet(name = "AdminSetDeadlineServlet", urlPatterns = {"/AdminSetDeadlineServlet"})
public class AdminSetDeadlineServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
                   out.println(" <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/regular.css\" integrity=\"sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4\" crossorigin=\"anonymous\">\n" +
                        "        <link rel=\"stylesheet\" href=\"CSS.css\">\n" +
                        "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
                        "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "  <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
                        "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
                        "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>"
            );

                out.println("</head>");
                out.println("<body>");

                out.println("<nav class=\"navbar navbar-expand-lg bg-dark navbar-dark sticky-top\">\n" +
                        "  <a class=\"navbar-brand\" href=\"#\">Admin Staff Dashboard</a>\n" +
                        "<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                        "    <span class=\"navbar-toggler-icon\"></span>\n" +
                        "  </button>"+
                        "<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n"+
                        "<ul class=\"navbar-nav\">"+
                        "<li class=\"nav-item\">"+
                        "  <a class=\"nav-link\" href=\"AddStaff.jsp\">Add Staff</a>\n" +
                        "</li>"+
                        "<li class=\"nav-item\">"+
                        "  <a class=\"nav-link\" href=\"DeleteStaff.jsp\">Delete Staff</a>\n" +
                        "</li>"+
                        "<li class=\"nav-item\">"+
                        "  <a class=\"nav-link\" href=\"AdminAssignStaffServlet\">Assign Staff New Role</a>\n" +
                        "</li>"+
                        "<li class=\"nav-item\">"+
                        "  <a class=\"nav-link\" href=\"ViewStaff.jsp \">View Staff</a>\n" +
                        "</li>"+
                        "<li class=\"nav-item\">"+
                        "  <a class=\"nav-link\" href=\"AdminSetDeadlineServlet\">Set Deadlines</a>\n" +
                        "</li>"+
                        "<li class=\"nav-item\">"+
                        "  <a class=\"nav-link\" href=\"AdminAssignToExam\">Assign Staff To New Exam</a>\n" +
                        "</li>"+
                        "<li class=\"nav-item\">"+
                        "  <a class=\"nav-link\" href=\"AdminCreateFilePathServlet\">Create Folders</a>\n" +
                        "</li>"+
                        "</ul>"+
                        "</div>"+
                        "</nav>");
            DatabaseHandling conn = new DatabaseHandling();
            String year; 
                year  = ""+Year.now().getValue();
             
                ResultSet moduleList = conn.listTableWhere("Exam", "AcademicYear", year);
                   out.println("<div align='center'>");
            out.println("<div class='white'>");
            
              out.println("<h2>Assign Exam Deadlines</h2>");
            
            out.println("<div align='center'>");
      
            out.println("<form action='SetDeadlineServlet' method='POST'>");
                out.println("<h4>Modules:</h4>");
                out.println("<select name='Modules' width='150'>");
                
                try{
                    while(moduleList.next()){
                        out.println("<option name='Module' value=" + moduleList.getString("ModuleCode") + ":" + moduleList.getString("ExamID") + ">"+ moduleList.getString("ModuleCode") +"</option>");
                    }
                }
                catch(Exception e){

                }
                out.println("</select>");
                
                out.println("<br>");
                out.println("<br>");
                out.println("<h4>Internal: </h4>");
                out.println("<input type='date' name='IMdeadline'>");
                out.println("<br>");
                out.println("<br>");
                out.println("<h4>Commitee:</h4>");
                out.println("<input type='date' name='ECdeadline'>");
                out.println("<br>");
                out.println("<br>");
                out.println("<h4>External: </h4>");
                out.println("<input type='date' name='EMdeadline'>");
                out.println("<br>");
                out.println("<br>");
                out.println("<input type='submit' value='Select' name='select'>");
            out.println("</form>");
            
            out.println("<br>");
                out.println("<br>");
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
            out.println("</body>");
            out.println("</html>");
        }
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
