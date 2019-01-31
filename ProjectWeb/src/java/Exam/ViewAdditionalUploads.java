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
       out.println("  <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/regular.css\" integrity=\"sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4\" crossorigin=\"anonymous\">\n" +
                        "        <link rel=\"stylesheet\" href=\"CSS.css\">\n" +
                        "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
                        "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "  <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
                        "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
                        "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>");
                        
        out.println("</head>");
        
        out.println("<body>");
           out.println(" <nav class=\"navbar navbar-expand-lg bg-dark navbar-dark sticky-top\">\n" +
"                          <a class=\"navbar-brand\" href=\"StaffDashboard.jsp\">Staff Dashboard</a>\n" +
"                        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
"                            <span class=\"navbar-toggler-icon\"></span>\n" +
"                          </button>\n" +
"                        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n" +
"                        <ul class=\"navbar-nav\">\n" +
"                        <li class=\"nav-item\">\n" +
"                          <a class=\"nav-link\" href=\"CreateExamDTL.jsp\">Upload Exam Paper</a>\n" +
"                        </li>\n" +
"                        <li class=\"nav-item\">\n" +
"                          <a class=\"nav-link\" href=\"BrowseExamS\">View My Exams</a>\n" +
"                        </li>\n" +
"                        <li class=\"nav-item\">\n" +
"                          <a class=\"nav-link\" href=\"CreateResitExamDTL.jsp\">Upload Resit Exam</a>\n" +
"                        </li>\n" +
"                        <li class=\"nav-item\">\n" +
"                          <a class=\"nav-link\" href=\"BrowseExamResit\">View Resit Exams</a>\n" +
"                        </li>\n" +
"                        <li class=\"nav-item\">\n" +
"                          <a class=\"nav-link\" href=\"ViewPastPaper\">View Past Papers</a>\n" +
"                        </li>\n" +
"                        </ul>\n" +
"                        </div>\n" +
"                        </nav> ");
        
        String modcode = request.getParameter("ModuleCode");
        String year = request.getParameter("AcademicYear");
        FileHandling listoffile = new FileHandling();
        listoffile.defaultPath = getPath();
        List<String> results = listoffile.getListofFiles(modcode, year);
        
        
        
        out.println("<div align='center'>");
                
                
        out.println("<br>");
        out.println("<br>");
         out.println("<table style='width: 50%' border='1' align='center' class='table table-dark' >");
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

