/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Comment.Comments;
import Database.DatabaseHandling;
import static java.lang.System.out;
import javax.servlet.http.HttpSession;

/**
 *
 * @author davidatkinson
 */
@WebServlet(name = "BrowseExamsSContainer", urlPatterns = {"/BrowseExamsSContainer"})
public class BrowseExamsSContainer extends HttpServlet {

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
             HttpSession session = request.getSession();
                String username = (String) session.getAttribute("username");
                String modcode = request.getParameter("modcode");
                String comment = request.getParameter("inputbox");
                String year = request.getParameter("year");
                String role = request.getParameter("role");
                String temp= request.getParameter("id");
               
                int id = Integer.parseInt(temp);
                
                Comments comm = new Comments();
                DatabaseHandling conn = new DatabaseHandling();
                
                //out.print(getPath());
                //out.println(id);
                if(role.equals("Exam Setter")){
                    comm.ackComments(modcode, comment, username, getPath(), year);
                    //out.print(role);
                    try{
                        conn.setChanges(0, id);
                      
                    }
                    catch(Exception e){
                        
                    }
                }else{
                    
                   out.print(role);
                   comm.writeComment(modcode, comment, username, getPath(), year);
                   try{
                       conn.setChanges(1, id);
                   }
                   catch(Exception e){
                       
                   }
                  
                }
                
                response.sendRedirect("BrowseExamS");
                
           
        }
     
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
