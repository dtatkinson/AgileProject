/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import Database.DatabaseHandling;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
@WebServlet(name = "AdminAddStaffServlet", urlPatterns = {"/AdminAddStaffServlet"})
public class AdminAddStaffServlet extends HttpServlet {

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
        
        String username = request.getParameter("StaffName"); //Gets the username the was posted to this servlet
        String name = request.getParameter("Name"); //Gets the name the was posted to this servlet
        String password = request.getParameter("StaffPassword"); //Gets the password the was posted to this servlet
        String role = request.getParameter("Role"); //Gets the role the was posted to this servlet
        
        boolean tryit = checkStaff(username);
        
        if(tryit == true)
        {
            response.sendRedirect("AddStaffError.jsp");
        }
        else
        {
        addStaff(username, name, password,role);
        response.sendRedirect("AdminDashboard.jsp");
        }
    }
    
    //Method that calls the add staff method in the database handling class
    public void addStaff(String username, String name, String password, String role){
        DatabaseHandling conn = new DatabaseHandling();
        try{
            conn.addStaff(username, name, role, password);
            
        }
        catch(Exception e){
            
        }
    }
    
    public boolean checkStaff(String username)
    {
        DatabaseHandling conn = new DatabaseHandling();
        try{
            ResultSet StaffList = conn.listTable("Staff"); //Returns a result list containing the entire staff table
            while(StaffList.next())
            {
                if(username.equals(StaffList.getString("StaffName")))
                {
                    return true;
                }
            }
           
        }
        catch(Exception e){
    }
         return false;
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
