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
 * @author David Atkinson
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

                ResultSet setter = instance.listTableWhereD("Exam", "PublishedBy", username);
                
                out.println("<table style='width: 50%' border='1' align:'center' >");
                out.println("<tr>");
                out.println("<th>");
                out.println("Module code");
                out.println("</th>");
                out.println("<th>");
                out.println("Exam paper");
                out.println("</th>");
                out.println("<th>");
                out.println("Comments");
                out.println("</th>");
               
                out.println("<th>");
                out.println("Input comment");
                out.println("</th>");
                out.println("<th>");
                out.println("Send Comment");
                out.println("</th>");
                 out.println("</tr>");
                while(setter.next()){
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(setter.getString("ModuleCode"));
                    out.println("</td>");
                    String moduleCode = setter.getString("ModuleCode");
                   
                    out.println("<td>");
                    out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\"+moduleCode+".pdf'>"+moduleCode+" Exam</a>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\comments.txt'>"+moduleCode+" Comments</a>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<input type=\"text\">");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<input type=\"button\">");
                    out.println("</td>");
                    out.println("</tr>");
                    
                }
                out.println("<h1>Setter</h1>");
                
               
                
                ResultSet internal = instance.listTableWhereD("Exam", "InternalSignID", username);
                    
                
                out.println("<table style='width:50%' border='1'>");
                out.println("<tr>");
                out.println("<th>");
                out.println("Module code");
                out.println("</th>");
                out.println("<th>");
                out.println("Exam paper");
                out.println("</th>");
                out.println("<th>");
                out.println("Comments");
                out.println("</th>");
               
                out.println("<th>");
                out.println("Input comment");
                out.println("</th>");
                out.println("<th>");
                out.println("Send Comment");
                out.println("</th>");
                 out.println("</tr>");
                while(internal.next()){
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(internal.getString("ModuleCode"));
                    out.println("</td>");
                    String moduleCode = internal.getString("ModuleCode");
                   
                    out.println("<td>");
                    out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\"+moduleCode+".pdf'>"+moduleCode+" Exam</a>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\comments.txt'>"+moduleCode+" Comments</a>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<input type=\"text\">");
                    out.println("</td>");
                      out.println("<td>");
                    out.println("<input type=\"button\">");
                    out.println("</td>");
                    out.println("</tr>");
                    
                }

                out.println("<h1>Internal</h1>");
                
                ResultSet commitee = instance.listTableWhereD("Exam", "CommiteeSignID", username);

              
                out.println("<table style='width:50%' border='1'>");
                out.println("<tr>");
                out.println("<th>");
                out.println("Module code");
                out.println("</th>");
                out.println("<th>");
                out.println("Exam paper");
                out.println("</th>");
                out.println("<th>");
                out.println("Comments");
                out.println("</th>");
               
                out.println("<th>");
                out.println("Input comment");
                out.println("</th>");
                out.println("<th>");
                out.println("Send Comment");
                out.println("</th>");
                out.println("</tr>");
                 
                while(commitee.next()){
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(commitee.getString("ModuleCode"));
                    out.println("</td>");
                    String moduleCode = commitee.getString("ModuleCode");
                   
                    out.println("<td>");
                    out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\"+moduleCode+".pdf'>"+moduleCode+" Exam</a>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\comments.txt'>"+moduleCode+" Comments</a>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<input type=\"text\">");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<input type=\"button\">");
                    out.println("</td>");
                    out.println("</tr>");
                    
                }

                  out.println("<h1>Commitee</h1>");
                
                ResultSet external = instance.listTableWhereD("Exam", "ExternalSignID", username);

               
                out.println("<table style='width:50%' border='1'>");
                out.println("<tr>");
                out.println("<th>");
                out.println("Module code");
                out.println("</th>");
                out.println("<th>");
                out.println("Exam paper");
                out.println("</th>");
                out.println("<th>");
                out.println("Comments");
                out.println("</th>");
               
                out.println("<th>");
                out.println("Input comment");
                out.println("</th>");
                out.println("<th>");
                out.println("Send Comment");
                out.println("</th>");
                out.println("</tr>");
                
                while(external.next()){
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(external.getString("ModuleCode"));
                    out.println("</td>");
                    String moduleCode = external.getString("ModuleCode");
                   
                    out.println("<td>");
                    out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\"+moduleCode+".pdf'>"+moduleCode+" Exam</a>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\comments.txt'>"+moduleCode+" Comments</a>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<input type=\"text\"width:'100%'>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<input type=\"button\">");
                    out.println("</td>");
                    out.println("</tr>");  
                }
                
             
                 out.println("<h1>External</h1>");
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
