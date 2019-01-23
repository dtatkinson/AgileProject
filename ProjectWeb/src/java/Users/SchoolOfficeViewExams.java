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
            out.println("</head>");
            out.println("<body>");
            try{
                HttpSession session = request.getSession();
                DatabaseHandling instance = new DatabaseHandling();

                ResultSet completed = instance.listTableWhere("Exam", "ExamStatus", "Complete");
                
                 out.println("<table style='width: 50%' border='1' align:'center' >");
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
                out.println("<h1>Setter</h1>");
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


