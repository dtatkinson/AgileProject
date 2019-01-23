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
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author owenkelbie
 */
@WebServlet(name = "BrowseExamS", urlPatterns = {"/BrowseExamS"})
public class BrowseExamS extends HttpServlet {

    
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
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
                String username = (String) session.getAttribute("username");
                DatabaseHandling instance = new DatabaseHandling();

                ResultSet setter = instance.listTableWhereD("Exam", "PublishedBy", "Lenard");

                while(setter.next()){
                    out.println(setter.getString("ModuleCode"));
                    String moduleCode = setter.getString("ModuleCode");
                    out.println("<div>");
                    out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\"+moduleCode+".pdf'>"+moduleCode+" Exam</a>");
                    out.println("</div>");
                }
           //out.print("TTTTTTTTTTTT");
       
            }catch (Exception e){
                
            }
            out.println("</body>");
            out.println("</html>");        
            
            /* TODO output your page here. You may use following sample code. */
            
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
