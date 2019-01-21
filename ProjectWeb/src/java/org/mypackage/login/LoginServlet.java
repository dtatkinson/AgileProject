
package org.mypackage.login;

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
 * @author lenardgaunt
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
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
            
        out.println("<!DOCTYPE html>");
            
        String username = request.getParameter("staffID");
        String password = request.getParameter("passwd");
        
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        
        DatabaseHandling conn = new DatabaseHandling();
        
        boolean flag = false;
        try{

            ResultSet rs = conn.listStaff();
            while(rs.next())
            {
                boolean validU = processUsername(rs.getString("StaffName"), username);
                if(validU == true){
                    boolean validP = processPassword(rs.getString("StaffPassword"), password);
                    if(validP == true){
                        
                        HttpSession session = request.getSession();
                        session.setAttribute("username", username);
                        
                        if(rs.getString("Role").equals("Admin")){
                            response.sendRedirect("AdminDashboard.jsp");
                        }
                        else if(rs.getString("Role").equals("IM")){
                            response.sendRedirect("StaffDashboard.jsp");
                        }
                        else if(rs.getString("Role").equals("ES")){
                            response.sendRedirect("#");
                        }
                        else if(rs.getString("Role").equals("EM")){
                            response.sendRedirect("StaffDashboard.jsp");
                        }
                        else if(rs.getString("Role").equals("EC")){
                            response.sendRedirect("StaffDashboard.jsp");
                        }
                        else if(rs.getString("Role").equals("SO")){
                            response.sendRedirect("#");
                        }
                        flag = true;
                        break;
                    }
                    flag = false;
                    break;
                }
            }
            
            if(flag == false){
                out.print("Wrong credentials, idiot");
            }   
        }
        catch (Exception e){    
        }
        
    }  
}
    public boolean processUsername(String data, String username){
        
        if (data.equals(username)){
            return true;
        }
        return false;
    }
    
    public boolean processPassword(String data, String password){
        if (data.equals(password)){
            return true;
        }
        return false;
    }

}
