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
                        "      <li><a href=\"AssignStaff.jsp\">Assign Staff New role</a></li>\n" +
                        "      <li><a href=\"ViewStaff.jsp\">View Staff</a></li>\n" +
                        "      <li><a href=\"AdminSetDeadlineServlet\">Set Deadlines</a></li>\n" +
                        "      <li><a href=\"AssignStaff.jsp\">Assign Staff to new exam</a></li>\n" +
                        "    </ul>\n" +
                        "  </div>\n" +
                        "</nav>");
            DatabaseHandling conn = new DatabaseHandling();
            String year; 
                year  = ""+Year.now().getValue();
             
                ResultSet moduleList = conn.listTableWhere("Exam", "AcademicYear", year);
                
            out.println("<h2 align='center'>Assign Exam Deadlines</h2>");
            
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
