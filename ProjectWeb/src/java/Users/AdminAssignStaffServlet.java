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

/**
 *
 * @author oliversimpson
 */
@WebServlet(name = "AdminAssignStaffServlet", urlPatterns = {"/AdminAssignStaffServlet"})
public class AdminAssignStaffServlet extends HttpServlet {

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
      /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='CSS.css'>");
           out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js'></script>");
                out.println("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js'></script>");
                out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css'>");
                out.println("</head>");
                out.println("<body>");

                out.println("<nav class='navbar fixed-bottom navbar-inverse' >");
                out.println("<div class='container-fluid'>");
                out.println("<div class='navbar-header'>");
                out.println("<a class='navbar-brand' href='ViewNewExams'>Admin Staff Dashboard</a>");
                out.println("</div>");
                out.println("<ul class='nav navbar-nav'>");
                out.println("<li><a href='AddStaff.jsp'>Add Staff</a></li>");
                out.println("<li><a href='DeleteStaff.jsp'>Delete Staff</a></li>");
                out.println("<li><a href='AssignStaff.jsp'>Assign Staff New role</a></li>");
                out.println("<li><a href='ViewStaff.jsp'>View Staff</a></li>");
                out.println("<li><a href='AdminSetDeadlineServlet'>Set Deadlines</a></li>");
                out.println("<li><a href='AdminAssignToExam'>Assign Staff to new exam</a></li>");
                out.println("<li><a href='AdminCreateFilePathServlet'>Create folders for next year</a></li>");
                out.println("</ul>");
                out.println("</div>");
                out.println("</nav>");
                
            out.println( "<div class ='img'>");
            out.println("<a href='AdminDashboard.jsp'>");
            out.println("<img src='DundeeUniLogo.png' width='100' height='125' alt='DundeeLogo' vertical-align='center' ></img>");
            out.println("</a>");
            out.println("</div>");
            
            DatabaseHandling conn = new DatabaseHandling();
           
                out.println("<div align='center'>");
            
                out.println("<h2>Assign Staff New Role</h2>");
                
                
                out.println("<form action='AdminChangeStaffRole' method='POST'>");
              
                out.println("<h4>Staff:</h4>");
                
                out.println("<select name='StaffName' width='150'>");
                
                ResultSet StaffList = conn.listTable("Staff"); //Returns a result list containing the entire staff table
               
                try{
                    while(StaffList.next()){
                        out.println("<option name='IMStaffName' value=" + StaffList.getString("StaffName")+">" + StaffList.getString("Name")+ "</option>");
                    }
                }
                catch(Exception e){
                    
                }
                out.println("</select>");
                
            out.println("<h4>Enter New Staff Role:</h4>");
            out.println("<select name='NewStaffRoles' size='6'>");
            out.println("<option value='ES'>Exam Setter</option>");
            out.println("<option value='IM'>Internal Moderator</option>");
            out.println("<option value='EC'>Exam Commitee</option>");
            out.println("<option value='EM'>External Moderator</option>");
            out.println("<option value='SO'>School Office</option>");
            out.println("<option value='Admin'>Admin</option>");
            out.println("</select>");
            out.println("<br>");
            out.println("<input type='submit' value='Select' name='select'>");
            out.println("</form>");
            
            out.println("<br>");
           
            out.println("</div>");
           
            out.println("</body>");
            out.println("</html>");
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

