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
                out.println("<html>");
                 out.println("<head>");
                   out.println(" <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/regular.css\" integrity=\"sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4\" crossorigin=\"anonymous\">\n" +
                        "        <link rel=\"stylesheet\" href=\"CSS.css\">\n" +
                        "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n" +
                        "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "  <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
                        "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
                        "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>"
            );

                out.println("</head>");
                out.println("<body>");

                out.println("<nav class=\"navbar navbar-expand-lg bg-dark navbar-dark sticky-top\">\n" +
                        "  <a class=\"navbar-brand\" href=\"#\">Admin Staff Dashboard</a>\n" +
                        "<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
                        "    <span class=\"navbar-toggler-icon\"></span>\n" +
                        "  </button>"+
                        "<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n"+
                        "<ul class=\"navbar-nav\">"+
                        "<li class=\"nav-item\">"+
                        "  <a class=\"nav-link\" href=\"AddStaff.jsp\">Add Staff</a>\n" +
                        "</li>"+
                        "<li class=\"nav-item\">"+
                        "  <a class=\"nav-link\" href=\"DeleteStaff.jsp\">Delete Staff</a>\n" +
                        "</li>"+
                        "<li class=\"nav-item\">"+
                        "  <a class=\"nav-link\" href=\"AdminAssignStaffServlet\">Assign Staff New Role</a>\n" +
                        "</li>"+
                        "<li class=\"nav-item\">"+
                        "  <a class=\"nav-link\" href=\"ViewStaff.jsp \">View Staff</a>\n" +
                        "</li>"+
                        "<li class=\"nav-item\">"+
                        "  <a class=\"nav-link\" href=\"AdminSetDeadlineServlet\">Set Deadlines</a>\n" +
                        "</li>"+
                        "<li class=\"nav-item\">"+
                        "  <a class=\"nav-link\" href=\"AdminAssignToExam\">Assign Staff To New Exam</a>\n" +
                        "</li>"+
                        "<li class=\"nav-item\">"+
                        "  <a class=\"nav-link\" href=\"AdminCreateFilePathServlet\">Create Folders</a>\n" +
                        "</li>"+
                        "</ul>"+
                        "</div>"+
                        "</nav>");
                
                out.println( "<div class ='img'>");
                out.println("<a href='ViewNewExams'>");
         
                out.println("</a>");
                out.println("</div>");
                out.println("<tr>");
                
                out.println("<h1 align='center'>Remove Staff</h1>");
                
           //     out.println("<table style='width:100%' border='1'"); //Creates a html table
             //   out.println("<h1 align='center'>"+role+"</h1>");
       out.println("<table style='width: 50%' border='1' align='center' class='table table-dark' >");
                
                    out.println("<th>");
                    out.println("Staff Username"); //Sets one of the row headings to "Staff Username"
                    out.println("</th>");
                    out.println("<th>");
                    out.println("Staff Role"); //Sets one of the row headings to "Staff Role"
                    out.println("</th>");
                    out.println("<th>");
                    out.println("Delete?"); //Sets one of the row headings to "Delete?"
                    out.println("</th>");
                out.println("</tr>");
                out.println("<form action='RemoveStaffContainerServlet' method='POST'>");
                while(staffList.next()){
                        response.setContentType("text/html");
                        
                        
                       
                        out.println("<tr>");
                            out.println("<td>");
                            out.println(staffList.getString("StaffName")); //Sets the value of one of the rows to the staff username
                            String name = staffList.getString("StaffName");
                            out.println("</td>");
                            out.println("<td>");
                            out.println(staffList.getString("Role")); //Sets the value of one of the rows to the staff role
                            out.println("</td>");
                            out.println("<td>");
                            out.println("<label>");
                                out.println("<input type='radio' name='user' value=" + name + ">"); //Sets the value of one of the rows to a radio button
                            out.println("</label>");
                            out.println("</td>");
                        out.println("</tr>");
                        
                        
                    
                }
                
                out.println("</table>");
                out.println("<div align='center'>");
                out.println("<br>");
                out.println("<input type='submit' value='Delete' name='Delete'>");
                out.println("</div>");
                out.println("</form>");
                out.println("<br>");
              
                out.println("</body>");
                out.println("</html>");
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

