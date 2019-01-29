/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exam;

import Database.DatabaseHandling;
import FileHandling.FileHandling;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author camerontaylor
 */
@WebServlet(name = "CreateResitExamServlet", urlPatterns = {"/CreateResitExamServlet"})
  
 
public class CreateResitExamServlet extends HttpServlet {

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
            throws ServletException, IOException{
        try (PrintWriter out = response.getWriter()) {
        response.setContentType("text/html;charset=UTF-8");
        
            HttpSession session = request.getSession();

            String moduleName = request.getParameter("ModName");
            String moduleCode = request.getParameter("ModCode");
            String institution = request.getParameter("Inst");
            String school = request.getParameter("School");
            String academicYear = request.getParameter("Year");
            String publishedBy = (String)session.getAttribute("username");

            createResitExam(moduleName, moduleCode, institution, school, academicYear, publishedBy);
            createFile(moduleCode,getPath());

            session.setAttribute("moduleCode", moduleCode);
            response.sendRedirect("CreateResitExamUPLD.jsp");
        
        }
    }
    
    public void createResitExam(String moduleName, String moduleCode, String institution, String school, String academicYear, String publishedBy){
        DatabaseHandling conn = new DatabaseHandling();
            
            try{
            conn.createResitExam(moduleName, moduleCode, institution, school, academicYear, publishedBy);
            
           
         }
        catch(Exception e)
        {
            
        }
        
    }
    
    public void createFile(String modCode ,String lenardPath)
    {
        String year = "\\2019\\";
        
        FileHandling file = new FileHandling();
        file.defaultPath = lenardPath;
        try{
            if(!file.checkIfFileExists(modCode)){
                    file.createDirectory(modCode,year);
                    file.createDirectory(modCode+year, "additionalUploads");
                    file.createFile(modCode+year, "comments.txt");
                }else if (file.checkIfFileExists(modCode) && !file.checkIfFileExists(modCode+year)){
                    file.createDirectory(modCode, year);
                    file.createFile(modCode+year, "comments.txt");
                    file.createDirectory(modCode+year, "additionalUploads");
                }else if(file.checkIfFileExists(modCode+year) && !file.checkIfFileExists(modCode+year+"comments.txt")){
                    file.createFile(modCode+year, "comments.txt");
                }
                if(file.checkIfFileExists(modCode+year)&& !file.checkIfFileExists(modCode+year+"additionalUploads")){
                    file.createDirectory(modCode+year, "additionalUploads");
                }
                      
        }
        catch(IOException e)
                {
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
