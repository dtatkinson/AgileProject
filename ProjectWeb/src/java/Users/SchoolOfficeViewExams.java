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
        String url = request.getServletPath();
        
        url = url + "../../../2018-agileteam3/";
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
       out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
       out.println("<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/regular.css\" integrity=\"sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4\" crossorigin=\"anonymous\">\n" +
                        "        <link rel=\"stylesheet\" href=\"CSS.css\">\n" +
                        "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">" +
                        "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "  <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
                        "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
                        "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>");
                   
        out.println("</head>");
            out.println("<body>");
            try{
                HttpSession session = request.getSession();
                DatabaseHandling instance = new DatabaseHandling();

                ResultSet completed = instance.listTableWhere("Exam", "ExamStatus", "Complete");
                ResultSet completedr = instance.listTableWhere("Resit", "ExamStatus", "Complete");
                out.println("<nav class=\"navbar navbar-expand-lg bg-dark navbar-dark sticky-top\">\n" +
"                          <a class=\"navbar-brand\" href=\"SchoolOfficeViewExams\">School Office Dashboard</a>\n" +
"                        </nav>");
              
                out.println("<h1 class='strokeme' align='center'>Exams</h1>");
              
                out.println("<div align='center'");
                
                
                out.println("<br>");
                out.println("<br>");
                out.println("<table style='width: 50%' border='1' align='center' class='table table-dark' >");
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
                    String path = url +  moduleCode + "\\"+completed.getString("AcademicYear")+"\\" + moduleCode + ".pdf";
                    out.println("<a href="+path+">"+moduleCode+" Exam</a>");
                    out.println("</td>");             
                    out.println("</tr>");
                    
                }
                out.println("</table>");
                out.println("</div>");
           
                out.println("<h1 class='strokeme' align='center'>Resits</h1>");
              
                out.println("<div align='center'");
                
                
                out.println("<br>");
                out.println("<br>");
               out.println("<table style='width: 50%' border='1' align='center' class='table table-dark' >");
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
                
                while(completedr.next()){
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(completedr.getString("ModuleName"));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(completedr.getString("ModuleCode"));
                    out.println("</td>");
                    String moduleCode = completedr.getString("ModuleCode");
                    out.println("<td>");
                    out.println(completedr.getString("Institution"));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(completedr.getString("School"));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(completedr.getString("AcademicYear"));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(completedr.getString("PublishedBy"));
                    out.println("</td>");
                    out.println("<td>");
                    String path = url +  moduleCode + "\\"+completedr.getString("AcademicYear")+"\\" + moduleCode + "Resit.pdf";
                    out.println("<a href="+path+">"+moduleCode+" Exam</a>");
                    out.println("</td>");             
                    out.println("</tr>");
                    
                }
                out.println("</table>");
                out.println("</div>");
                
                out.println("<br>\n" +
                            "          <div align='center'>\n" + 
                            "        <div align=\"center\" class=\"btn btn-danger center-block\">\n" +
                            "            <a href=\"index.jsp\">\n" +
                            "            <form  name=\"logoutForm\" action=\"LogoutServlet\">\n" +
                            "            <img src=\"Logout.png\" width=\"20\" height=\"20\" alt=\"Logout\"/>\n" +
                            "             </a>\n" +
                            "      \n" +
                            "    </form>\n" +
                            "               \n" +
                            "      \n" +
                            "            <br>\n" +
                           
                            
                            "            ");
                out.print("Hello, ");
                out.print(session.getAttribute("username"));
                out.println("</div>");
                out.println("</div>");
                out.print("</body>");
             
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


