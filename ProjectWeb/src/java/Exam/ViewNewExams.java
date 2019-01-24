/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;

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
@WebServlet(name = "ViewNewExams", urlPatterns = {"/ViewNewExams"})
public class ViewNewExams extends HttpServlet {

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
           try{   
            HttpSession session = request.getSession();
                String username = (String) session.getAttribute("username");
                DatabaseHandling instance = new DatabaseHandling();

                ResultSet newones = instance.listTableWhere("Exam", "ExamStatus", "new");
                
                out.println("<table style='width: 50%' border='1' align:'center' >");
                out.println("<tr>");
                out.println("<th>");
                out.println("Module code");
                out.println("</th>");
                out.println("<th>");
                out.println("Exam paper");
                out.println("</th>");
                out.println("<th>");
                out.println("Year");
                out.println("</th>");
                out.println("<th>");
                out.println("Published By");
                out.println("</th>");
                out.println("</tr>");
                while(newones.next()){
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(newones.getString("ModuleCode"));
                    out.println("</td>");
                    String moduleCode = newones.getString("ModuleCode");
                   
                    out.println("<td>");
                    out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\"+moduleCode+".pdf'>"+moduleCode+" Exam</a>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println(newones.getString("AcademicYear"));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(newones.getString("PublishedBy"));
                    out.println("</td>");
                    out.println("</tr>");
                    
                }
                out.println("<h1>New Exams</h1>");
                
                out.println("<form name='Back ' action='AdminNewExamDashboard.jsp'>");
                out.println("<input type='submit' value='<- Go Back' name='backBtn' />");  
                out.println("</form>");
        }
            catch(Exception e)
        {
            
        }
        }
        catch(Exception e)
        {
            
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
