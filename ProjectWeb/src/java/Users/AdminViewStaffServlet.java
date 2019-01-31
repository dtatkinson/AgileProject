/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Database.DatabaseHandling;
import java.io.PrintWriter;
import java.sql.ResultSet;
/**
 *
 * @author camerontaylor
 */
@WebServlet(name = "AdminViewStaffServlet", urlPatterns = {"/AdminViewStaffServlet"})
public class AdminViewStaffServlet extends HttpServlet {

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
       
        String search = request.getParameter("SearchT");
        
        DatabaseHandling conn = new DatabaseHandling();
        
        try (PrintWriter out = response.getWriter()) {
            
            try{
                ResultSet staffList  = conn.searchTable(search, "Staff", "StaffName");
                out.println("<html>");
                out.println("<head>");
                out.println("<link rel='stylesheet' href='CSS.css'>");
                out.println("<!-- Latest compiled and minified CSS -->\n" +
"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
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
                out.println("<li><a href='AdminAssignStaffServlet'>Assign Staff New role</a></li>");
                out.println("<li><a href='ViewStaff.jsp'>View Staff</a></li>");
                out.println("<li><a href='AdminSetDeadlineServlet'>Set Deadlines</a></li>");
                out.println("<li><a href='AdminAssignToExam'>Assign Staff to new exam</a></li>");
                out.println("<li><a href='AdminCreateFilePathServlet'>Create folders for next year</a></li>");
                out.println("</ul>");
                out.println("</div>");
                out.println("</nav>");

                
                
                out.println( "<div class ='img'>");
                out.println("<a href='ViewNewExams'>");
                out.println("<img src='DundeeUniLogo.png' width='100' height='125' alt='DundeeLogo' vertical-align='center' ></img>");
                out.println("</a>");
                out.println("</div>");
   
                out.println("<h1 align='center'>All Staff</h1>");
                
               out.println("<table style='width: 50%' border='4' align='center' >");

                out.println("<tr>");
                out.println("<th>");
                out.println("Staff Username");
                out.println("</th>");
                out.println("<th>");
                out.println("Staff Role");
                out.println("</th>");
                out.println("</tr>");
                        
                while(staffList.next()){
                        response.setContentType("text/html");
                        
                        
                       
                        out.println("<tr>");
                            out.println("<td>");
                            out.println(staffList.getString("StaffName"));
                            out.println("</td>");
                            out.println("<td>");
                            out.println(staffList.getString("Role"));
                            out.println("</td>");
                        out.println("</tr>");
                        
                        
                    
                }
                out.println("</table>");
      
                
                out.println("</body>");
                out.println("</html>");
            }
            catch(Exception e){
            
        }
        }
        catch(Exception e){

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
