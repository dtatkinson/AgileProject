/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;

import Comment.Comments;
import Database.DatabaseHandling;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.stream.events.Comment;
/**
 *
 * @author lenardgaunt
 */
@WebServlet(name = "SignExamServlet", urlPatterns = {"/SignExamServlet"})
public class SignExamServlet extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String modcode = request.getParameter("modcode");
        String role = request.getParameter("role");
        String year = request.getParameter("year");
        int id = Integer.parseInt(request.getParameter("id"));
        DatabaseHandling conn = new DatabaseHandling();
        
        Comments comment = new Comments();
        
        try (PrintWriter out = response.getWriter()) {
            //out.print(id);
        out.println(role);
        if(role.equals("Internal Moderator")){
            try{
                
                if(comment.readComment(modcode, getPath(), year)){
                    
                    conn.internalSignExam(id);
                    conn.setChanges(1,id);
                    session.setAttribute("validSign", true);
                }
                else{
                    session.setAttribute("validSign", false);
                }
            }
            catch(Exception e){
                
            }
        }
        else if(role.equals("Exam Commitee")){
            try{
                if(comment.readComment(modcode, getPath(), year)){
                    conn.examCommiteeSignExam(id);
                    conn.setChanges(1,id);
                    session.setAttribute("validSign", true);
                }
                else{
                    session.setAttribute("validSign", false);
                }
                
            }
            catch(Exception e){
                
            }
        }
        else if(role.equals("External Moderator")){
            try{
                if(comment.readComment(modcode, getPath(), year)){
                    conn.externalSignExam(id);
                //set exam with 3 signs to complete
                conn.editExamStatus(id, "Completed");
                conn.setChanges(1,id);
                session.setAttribute("validSign", true);
                }
                else{
                    session.setAttribute("validSign", false);
                }
                
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
