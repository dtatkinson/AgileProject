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
@WebServlet(name = "AdminSetDeadlinesServlet", urlPatterns = {"/AdminSetDeadlinesServlet"})
public class AdminSetDeadlinesModulesServlet extends HttpServlet {

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
                       
            out.println("</head>");
            out.println("<body>");
            DatabaseHandling conn = new DatabaseHandling();
            String year; 
                year  = ""+Year.now().getValue();
                out.print(year);
                ResultSet moduleList = conn.listTableWhere("Exam", "AcademicYear", year);
            out.println("<form action='SetDeadlineServlet' method='POST'>");
                out.println("<select name='Modules' width='150'>");
                
                try{
                    while(moduleList.next()){
                        out.println("<option name='Module' value=" + moduleList.getString("ModuleCode") + ":" + moduleList.getString("ExamID") + ">"+ moduleList.getString("ModuleCode") +"</option>");
                    }
                }
                catch(Exception e){

                }
                out.println("</select>");
                out.println(" Internal:");
                out.println("<input type='date' name='IMdeadline'>");
                out.println(" Commitee:");
                out.println("<input type='date' name='ECdeadline'>");
                out.println(" External:");
                out.println("<input type='date' name='EMdeadline'>");
                out.println("<input type='submit' value='Select' name='select'>");
            out.println("</form>");
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
