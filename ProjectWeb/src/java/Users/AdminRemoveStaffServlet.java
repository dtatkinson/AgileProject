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
@WebServlet(name = "AdminRemoveStaffServlet", urlPatterns = {"/AdminRemoveStaffServlet"})
public class AdminRemoveStaffServlet extends HttpServlet {

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
        
        String username = request.getParameter("staffName");
        DatabaseHandling conn = new DatabaseHandling();
        try{
            ResultSet staffList = conn.searchTable(username, "Staff", "StaffName");
            try (PrintWriter out = response.getWriter()) {
                out.println("<HTML>");
                out.println("<BODY>");

                out.println("<table style='width:100%' border='1'");

                out.println("<tr>");
                    out.println("<th>");
                    out.println("Staff Username");
                    out.println("</th>");
                    out.println("<th>");
                    out.println("Staff Role");
                    out.println("</th>");
                    out.println("<th>");
                    out.println("Delete?");
                    out.println("</th>");
                out.println("</tr>");
                out.println("<form action='RemoveStaffContainerServlet' method='POST'>");
                while(staffList.next()){
                        response.setContentType("text/html");
                        
                        
                       
                        out.println("<tr>");
                            out.println("<td>");
                            out.println(staffList.getString("StaffName"));
                            String name = staffList.getString("StaffName");
                            out.println("</td>");
                            out.println("<td>");
                            out.println(staffList.getString("Role"));
                            out.println("</td>");
                            out.println("<td>");
                            out.println("<label>");
                                out.println("<input type='radio' name='user' value=" + name + ">");
                            out.println("</label>");
                            out.println("</td>");
                        out.println("</tr>");
                        
                        
                    
                }
                
                out.println("</table>");
                out.println("<input type='submit' value='Delete' name='Delete'>");
                out.println("</form>");
                out.println("</BODY>");
                out.println("</HTML>");
            }
            catch(Exception e){
                
            }
            
            
        }
        catch(Exception e){
            
        }
        
        //removeStaff(username);      
    }
    
    //Method that calls the remove staff method in the database handling class
    public void removeStaff(String name){
        DatabaseHandling conn = new DatabaseHandling();
        try{
            conn.removeStaff(name);
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

