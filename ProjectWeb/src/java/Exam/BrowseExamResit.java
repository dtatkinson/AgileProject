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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author David Atkinson
 */
@WebServlet(name = "BrowseExamResit", urlPatterns = {"/BrowseExamResit"})
public class BrowseExamResit extends HttpServlet {

    public String expandRole(String role){
        if(role.equals("ES")){
            return "Exam Setter";
        }
        else if(role.equals("IM")){
            return "Internal Moderator";
        }
        else if(role.equals("EC")){
            return "Exam Commitee";
        }
        else if(role.equals("EX")){
            return "External Moderator";
        }
        return null;
    }
    public boolean signSig(String role, String username, int id){
        
        DatabaseHandling conn = new DatabaseHandling();
        if(role.equals("IM")){ 
            ResultSet rs = conn.listTableWhereI("Exam", "ExamID", id);
            try{
                while(rs.next()){
                    if(rs.getBoolean("InternalSign")){
                        return false;
                    }
                    else{
                        return true;
                        }
                    }
            }
            catch(Exception e){
                
            }
        }
        else if(role.equals("EC")){
            ResultSet rs = conn.listTableWhereI("Exam", "ExamID", id);
            try{
                while(rs.next()){
                    if(rs.getBoolean("CommiteeSign")){
                        return false;
                    }
                    else{
                        return true;
                        }
                    }
            }
            catch(Exception e){
                
            }
        }
        
        else if(role.equals("EX")){
            ResultSet rs = conn.listTableWhereI("Exam", "ExamID", id);
            try{
                while(rs.next()){
                if(rs.getBoolean("ExternalSign")){
                    return false;
                }
                else{
                    return true;
                    }
                }
            }
            catch(Exception e){
                
            }
        }
        
        return false;
    }
    
    public ResultSet getResultSet(String role, String username){
        DatabaseHandling conn = new DatabaseHandling();
        if(role.equals("ES")){
            ResultSet rs = conn.listTableWhereD("Resit", "PublishedBy", username);
            return rs;
        }
        else if(role.equals("IM")){
            ResultSet rs = conn.listTableWhereD("Resit", "InternalSignID", username);
            return rs;
        }
        else if(role.equals("EC")){
            ResultSet rs = conn.listTableWhereD("Resit", "CommiteeSignID", username);
            return rs;
        }
        else if(role.equals("EX")){
            ResultSet rs = conn.listTableWhereD("Resit", "ExternalSignID", username);
            return rs;
        }
        return null;   
    }
    public void refactor(PrintWriter out, String username, ResultSet rs, String role, String url){
        
                Boolean ExtS;
                Boolean CmtS;
                Boolean IntS;
        
        
        
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
        
        
        out.println("<h1 align='center' style='color:white;'>"+expandRole(role)+"</h1>");
        out.println("<div align='center'>");
        out.println("<table  border='4' align='center' class='btn btn-dark' >");
        
            out.println("<tr>");
            out.println("<th>");
                out.println("Module code");
            out.println("</th>");
            out.println("<th>");
            out.println("Exam paper");
            out.println("</th>");
            out.println("<th>");
             if(role.equals("ES"))
            {
            out.println("Upload new version");
            }
            else
            {
                 out.println("Upload additonal");
            }
              if(role.equals("ES"))
            {
                out.println("<th>");
                out.println("Upload Solution paper");
                out.println("</th>");
            }
            out.println("</th>");
            out.println("<th>");
                out.println("Comments");
            out.println("</th>");

            out.println("<th>");
                out.println("Input comment");
            out.println("</th>");
            out.println("<th>");
                out.println("Send Comment");
            out.println("</th>");
            if(!role.equals("ES")){
                out.println("<th>");
                    out.println("Sign?");
                out.println("</th>"); 
            }
            out.println("<th>");
                out.println("Progress");
            out.println("</th>");
            
            out.println("</tr>");
            //Table headings
            try{
                while(rs.next()){
                    String moduleCode = rs.getString("ModuleCode");
                     String year = rs.getString("AcademicYear");
                    out.println("<tr>");
                    
                       out.println("<td>");
                            out.println(moduleCode);
                       out.println("</td>");
                       //Module
                       out.println("<td>");
                       String pdfPath = url + moduleCode + "\\"+rs.getString("AcademicYear")+"\\" + moduleCode + "Resit.pdf";
                            out.println("<a href="+pdfPath + ">"+moduleCode+ "Exam</a>");
                         
                            //out.println("<button type=\"submit\">Download!</button>");
                            //out.println("</form>");
                       out.println("</td>");
                       //Exam
                       
                       if(role.equals("ES"))
                       {
                            out.println("<td>");
                            out.println("<form name='Upload ' action='ReUploadResit.jsp'>");
                            out.println("<input type='submit' value='Upload' name='backBtn' />");
                            out.println("</form>");
                            out.println("</td>");
                       }
                       else
                       {
                            out.println("<td>");
                            out.println("<form name='Upload ' action='ReUploadAdditonal.jsp'>");
                            out.println("<input type='submit' value='Upload' name='backBtn' />");
                            out.println("</form>");
                            out.println("</td>"); 
                       }
                       
                        if(role.equals("ES"))
                       {
                           out.println("<td>");
                           out.println("<form name='Upload ' action='ReUploadAdditonal.jsp'>");
                           out.println("<input type='submit' value='Upload' name='backBtn' />");
                           out.println("<input type='hidden' name ='modcode'  value ="+moduleCode+">");
                           out.println("<input type='hidden' name ='year'  value ="+year+">");
                           out.println("</form>");
                           out.println("</td>"); 
                       }
                       
                       //Exam reupload
                       out.println("<td>");
                       String comPath = url + moduleCode + "\\"+rs.getString("AcademicYear")+"\\" + "comments.txt";
                       out.println("<a href="+comPath+">"+moduleCode+" Comments</a>");
                            //out.println("<a href=" + getPath()  + moduleCode+"\\2019\\comments.txt>"+moduleCode+" Comments</a>");
                       out.println("</td>");
                       //Exam comments
                       
                       out.println("<td>");
                            out.println("<form action='BrowseExamsSContainer' method='POST'>");
                                out.println("<input type=\"text\" name = 'inputbox'>");
                                out.println("<input type='hidden' name ='modcode'  value ="+moduleCode+">");
                                
                                out.println("<input type='hidden' name ='role'  value ='"+ expandRole(role) + "'>");
                       out.println("</td>");
                       
                       out.println("<td>");
                                out.println("<input type=\"submit\" value='Add Comment'>");
                            out.println("</form>");
                       out.println("</td>");
                       int id = rs.getInt("ExamID");
                       if(!role.equals("ES")){
                            out.println("<td>");
                                if(signSig(role, username, id)){ //POLICE, THIS LINE RIGHT HERE
                                   out.println(signSig(role, username, id));
                                   //int id = rs.getInt("ExamID");
                                   out.println("<form action='SignExamServlet' method='POST'>");

                                   out.println("<input type='hidden' name ='modcode'  value ="+moduleCode+">");


                                   out.println("<input type=\"submit\" value='Sign'>");
                                   out.println("<input type='hidden' name ='id'  value ="+id+">");
                                   
                                   out.println("<input type='hidden' name ='role'  value ='" + expandRole(role) + "'>");
                                   out.println("</form>");
                                }
                                else{
                                    out.println("X");
                                }
                                
                           out.println("</td>");
                       }
                            out.println("<td width=25%>");
                    ExtS=rs.getBoolean("ExternalSign");
                    CmtS=rs.getBoolean("CommiteeSign");
                    IntS=rs.getBoolean("InternalSign");
                    if(ExtS){
                      
                    out.println("<div class=\"progress\">\n" +
                                "  <div class=\"progress-bar progress-bar-success\" role=\"progressbar\" aria-valuenow=\"100\"\n" +
                                "  aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:100%\">\n" +
                                "    Completed\n" +
                                "  </div>\n" +
                                "</div>");
                    }
                    else if(CmtS){
                      
                    out.println("<div class=\"progress\">\n" +
                                "  <div class=\"progress-bar progress-bar-info\" role=\"progressbar\" aria-valuenow=\"75\"\n" +
                                "  aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:75%\">\n" +
                                "    75%\n" +
                                "  </div>\n" +
                                "</div>");
                    }else if(IntS){
                       
                    out.println("<div class=\"progress\">\n" +
                                "  <div class=\"progress-bar progress-bar-info\" role=\"progressbar\" aria-valuenow=\"50\"\n" +
                                "  aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:50%\">\n" +
                                "    50%\n" +
                                "  </div>\n" +
                                "</div>");
                    }else{
                        
                    out.println("<div class=\"progress\">\n" +
                                "  <div class=\"progress-bar progress-bar-info\" role=\"progressbar\" aria-valuenow=\"25\"\n" +
                                "  aria-valuemin=\"0\" aria-valuemax=\"100\" style=\"width:25%\">\n" +
                                "    25%\n" +
                                "  </div>\n" +
                                "</div>");
                    }
                    out.println("</td>");
                        
                    out.println("</tr>");
                    out.println("</div>");
                }
            }
            catch(Exception e){
                
            }
      
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
  

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String url = request.getServletPath();
        
        url = url + "../../../2018-agileteam3/";
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*
            out.println("<!DOCTYPE html>");
            out.println("<html>");
 
            out.println("<head>");
            out.println("</head>");
            
            out.println("<form action='StaffDashboard.jsp'>");
                out.println("<input type='submit' value='Back'>");
            out.println("</form>");
            
            out.println("<body>");
            try{
                
                DatabaseHandling instance = new DatabaseHandling();

                ResultSet setter = instance.listTableWhereD("Exam", "PublishedBy", username);*/
                
                HttpSession session = request.getSession();
                String username = (String) session.getAttribute("username");
                
                out.println("<body>\n" +
                    "      \n" +
                    "        <nav class=\"navbar fixed-bottom navbar-inverse\" >\n" +
                    "  <div class=\"container-fluid\">\n" +
                    "    <div class=\"navbar-header\">\n" +
                    "      <a class=\"navbar-brand\" href=\"StaffDashboard.jsp\">Staff Dashboard</a>\n" +
                    "    </div>\n" +
                    "    <ul class=\"nav navbar-nav\">\n" +
                    "      <li><a href=\"CreateExamDTL.jsp\">Upload an Exam paper</a></li>\n" +
                    "      <li><a href=\"BrowseExamS\">View my Exams</a></li>\n" +
                    "      <li><a href=\"CreateResitExamDTL.jsp\">Upload Resit Exam paper</a></li>\n" +
                    "      <li><a href=\"BrowseExamResit\">View Resit Exam papers</a></li>\n" +
                    "      <li><a href=\"#\">View Past papers</a></li>\n" +
                    "    </ul>\n" +
                    "  </div>\n" +
                    "</nav>");
                
                ResultSet rs = getResultSet("ES", username);
                refactor(out, username, rs, "ES", url);
                
                ResultSet rs2 = getResultSet("IM", username);
                refactor(out, username, rs2, "IM", url);
                
                ResultSet rs3 = getResultSet("EC", username);
                refactor(out, username, rs3, "EC", url);
                
                ResultSet rs4 = getResultSet("EX", username);
                refactor(out, username, rs4, "EX", url);
                
                
                
       
            
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
