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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 *
 * @author camerontaylor
 */
@WebServlet(name = "ViewAdditionalUploads", urlPatterns = {"/ViewAdditionalUploads"})
public class ViewAdditionalUploads extends HttpServlet {

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
        DatabaseHandling conn = new DatabaseHandling();
        
        out.println("<html>");
 
       out.println("<head>");
       out.println(" <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/regular.css\" integrity=\"sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4\" crossorigin=\"anonymous\">\n" +
                        "        <link rel=\"stylesheet\" href=\"CSS.css\">\n" +
                        "        <link href=\"//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\n" +
                        "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n" +
                        "  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n" +
                        "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>");
                        
        out.println("</head>");
        
        out.println("<body>");
          
        
        String modcode = request.getParameter("ModuleCode");
        String year = request.getParameter("AcademicYear");
        FileHandling listoffile = new FileHandling();
        listoffile.defaultPath = getPath();
        List<String> results = listoffile.getListofFiles(modcode, year);
        
        
        
        out.println("<div align='center'>");
                
                
        out.println("<br>");
        out.println("<br>");
        out.println("<table>");
        out.println("<tr>");
        out.println("<th>");
        out.println("File Name");
        out.println("</th>");
        out.println("<th>");
        out.println("Download");
        out.println("</th>");
        out.println("</tr>");
        String relativePath = getServletContext().getRealPath("");
        for(int i = 0; i < results.size();i++)
        {
            out.println("<tr>");
            out.println("<th>");
            out.println(results.get(i));
            out.println("</th>");
            out.println("<th>");
            String pdfPath = modcode+"\\"+year+"\\additonalUploads\\" + results.get(i);          
            out.println("<a href="+pdfPath +">"+results.get(i)+"</a>");
            out.println("</th>");
            out.println("</tr>");
          
            
        }
          out.println("</table>");
          out.println("</div>");
        }
        
        catch(Exception e)
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

