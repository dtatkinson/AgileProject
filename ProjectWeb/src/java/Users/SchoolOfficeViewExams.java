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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author oliversimpson
 */
@WebServlet(name = "SchoolOfficeViewExams", urlPatterns = {"/SchoolOfficeViewExams"})
public class SchoolOfficeViewExams extends HttpServlet {

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
       out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
             out.println("<!-- Latest compiled and minified CSS -->\n" +
"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
            out.println("</head>");
            out.println("<body>");
            try{
                HttpSession session = request.getSession();
                DatabaseHandling instance = new DatabaseHandling();

                ResultSet completed = instance.listTableWhere("Exam", "ExamStatus", "Complete");
                
                out.println( "<div class ='img'>");
                out.println("<a href='SchoolDashboard.jsp'>");
                out.println("<img src='DundeeUniLogo.png' width='100' height='125' alt='DundeeLogo' vertical-align='center' ></img>");
                out.println("</a>");
                out.println("</div>");
                
                out.println("<h1 align='center'>Exams</h1>");
                
                out.println("<table style='width: 50%' border='4' align='center' >");
                out.println("<tr>");
                out.println("<th>");
                out.println("Module Name");
                out.println("</th>");
                out.println("<th>");
                out.println("Module Code");
                out.println("</th>");
                out.println("<th>");
                out.println("Instiution");
                out.println("</th>");
                out.println("<th>");
                out.println("School");
                out.println("</th>");
                out.println("<th>");
                out.println("Adademic Year");
                out.println("</th>");
                out.println("<th>");
                out.println("Published By");
                out.println("</th>");
                out.println("<th>");
                out.println("Download");
                out.println("</th>");
                out.println("</tr>");
                
                while(completed.next()){
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(completed.getString("ModuleName"));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(completed.getString("ModuleCode"));
                    out.println("</td>");
                    String moduleCode = completed.getString("ModuleCode");
                    out.println("<td>");
                    out.println(completed.getString("Institution"));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(completed.getString("School"));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(completed.getString("AcademicYear"));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(completed.getString("PublishedBy"));
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\"+moduleCode+".pdf'>"+moduleCode+" Exam</a>");
                    out.println("</td>");             
                    out.println("</tr>");
                    
                }
                out.println("</table>");
                
                out.println("<br>");
                
                out.println("<div align='center'>");
                out.println("<form name='Back' action='SchoolOfficeDashboard.jsp'>");
                out.println("<input type='submit' value='Back to Dashboard' name='backBtn' />");  
                out.println("</form>");
                out.println("</div>");
                
            }
            catch(Exception e)
            {
                
            }
    
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


