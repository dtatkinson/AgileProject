
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
import java.util.Calendar;
import java.util.Date;
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
        String url = request.getServletPath();
        
        url = url + "../../../2018-agileteam3/";
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           try{   
            HttpSession session = request.getSession();
                String username = (String) session.getAttribute("username");
                DatabaseHandling instance = new DatabaseHandling();
                
                out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println(" <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/regular.css\" integrity=\"sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4\" crossorigin=\"anonymous\">\n" +
                        "        <link rel=\"stylesheet\" href=\"CSS.css\">\n" +
                        "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
                        "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "  <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
"<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>");
                        
            out.println("</head>");
            out.println("<body>");
            
            out.println(" <nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">\n" +
"  <a class=\"navbar-brand\" href=\"#\">Logo</a>\n" +
"  ...\n" +
"</nav> ");
                Date today = new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(today);
                ResultSet newones = instance.listTableWhere("Exam","AcademicYear",""+cal.get(Calendar.YEAR));
                
                Boolean ExtS;
                Boolean CmtS;
                Boolean IntS;
                
              
                
                out.println("<h1 align='center'><u>Exam Progress</u></h1>");
                
                out.println("<table style='width: 50%' border='1' align='center' class='table table-dark' >");
                out.println("<tr>");
                out.println("<th>");
                out.println("Module Name");
                out.println("</th>");
                out.println("<th>");
                out.println("Module code");
                out.println("</th>");
                out.println("<th>");
                out.println("Institution");
                out.println("</th>");
                out.println("<th>");
                out.println("School");
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
                out.println("<th>");
                out.println("Progress");
                out.println("</th>");
                out.println("</tr>");
                while(newones.next()){
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(newones.getString("ModuleName"));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(newones.getString("ModuleCode"));
                    out.println("</td>");
                    String moduleCode = newones.getString("ModuleCode");
                    out.println("<td>");
                    out.println(newones.getString("Institution"));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(newones.getString("School"));
                    out.println("</td>");
                    
                    
                    out.println("<td>");
                    String path = url +  moduleCode + "\\"+newones.getString("AcademicYear")+"\\" + moduleCode + ".pdf";
                    out.println("<a href="+path+">"+moduleCode+" Exam</a>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println(newones.getString("AcademicYear"));
                    out.println("</td>");
                    out.println("<td>");
                    out.println(newones.getString("PublishedBy"));
                    out.println("</td>");
                    out.println("<td width=25%>");
                    ExtS=newones.getBoolean("ExternalSign");
                    CmtS=newones.getBoolean("CommiteeSign");
                    IntS=newones.getBoolean("InternalSign");
                    if(ExtS){
                      
                    out.println("<div class=\"progress\">\n" +
                                "  <div class=\"progress-bar progress-bar-striped progress-bar-animated bg-success\" role=\"progressbar\" aria-valuenow=\"100\"\n" +
                                "  aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:100%\">\n" +
                                "    Completed\n" +
                                "  </div>\n" +
                                "</div>");
                    }
                    else if(CmtS){
                      
                    out.println("<div class=\"progress\">\n" +
                                "  <div class=\"progress-bar progress-bar-striped progress-bar-animated bg-info\" role=\"progressbar\" aria-valuenow=\"75\"\n" +
                                "  aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:75%\">\n" +
                                "    75%\n" +
                                "  </div>\n" +
                                "</div>");
                    }else if(IntS){
                       
                    out.println("<div class=\"progress\">\n" +
                                "  <div class=\"progress-bar progress-bar-striped progress-bar-animated bg-warning\" role=\"progressbar\" aria-valuenow=\"50\"\n" +
                                "  aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:50%\">\n" +
                                "    50%\n" +
                                "  </div>\n" +
                                "</div>");
                    }else{
                        
                    out.println("<div class=\"progress\">\n" +
                                "  <div class=\"progress-bar progress-bar-striped progress-bar-animated bg-danger\" role=\"progressbar\" aria-valuenow=\"25\"\n" +
                                "  aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:25%\">\n" +
                                "    25%\n" +
                                "  </div>\n" +
                                "</div>");
                    }
                    out.println("</td>");
                    
                    
                    out.println("</tr>");
                    
                }
                out.println("</table>");
                
                
                
                out.println("<br>\n" +
                            "        <div align=\"center\" class=\"plain\">\n" +
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
                out.print("</body>");
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
