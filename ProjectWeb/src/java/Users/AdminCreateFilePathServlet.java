/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Database.DatabaseHandling;
import FileHandling.FileHandling;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jdk.nashorn.internal.objects.NativeString;

/**
 *
 * @author matthewmchale
 */
@WebServlet(name = "AdminCreateFilePathServlet", urlPatterns = {"/AdminCreateFilePathServlet"})
public class AdminCreateFilePathServlet extends HttpServlet {

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
        //String search = request.getParameter("Search");
        DatabaseHandling conn = new DatabaseHandling();
        FileHandling file = new FileHandling();
        String modCode;
        String year = "\\2019\\";
        
        try{
            ResultSet moduleList = conn.listTable("Exam");
            while(moduleList.next()){
                modCode = moduleList.getString("ModuleCode");
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
       
        }catch(Exception e){}
            
        
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
