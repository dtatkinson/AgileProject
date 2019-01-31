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
import java.util.Calendar;
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
@WebServlet(name = "BrowseExamS", urlPatterns = {"/BrowseExamS"})
public class BrowseExamS extends HttpServlet {

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
        Calendar cal = Calendar.getInstance();
        int iYear = cal.get(Calendar.YEAR);
        String year = String.valueOf(iYear);
        //System.out.println(year);
        
        
        DatabaseHandling conn = new DatabaseHandling();
        if(role.equals("ES")){
            ResultSet rs = conn.listTableWhereDY("Exam", "PublishedBy", username, year);
            return rs;
        }
        else if(role.equals("IM")){
            ResultSet rs = conn.listTableWhereDY("Exam", "InternalSignID", username, year);
            return rs;
        }
        else if(role.equals("EC")){
            ResultSet rs = conn.listTableWhereDY("Exam", "CommiteeSignID", username, year);
            return rs;
        }
        else if(role.equals("EX")){
            ResultSet rs = conn.listTableWhereDY("Exam", "ExternalSignID", username, year);
            return rs;
        }
        return null;   
    }
    public void refactor(PrintWriter out, String username, ResultSet rs, String role, String url, boolean sign){
        
                Boolean ExtS;
                Boolean CmtS;
                Boolean IntS;
        
        DatabaseHandling conn = new DatabaseHandling();
        
        out.println("<html>");
 
       out.println("<head>");
       out.println(" <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.6.3/css/regular.css\" integrity=\"sha384-aubIA90W7NxJ+Ly4QHAqo1JBSwQ0jejV75iHhj59KRwVjLVHjuhS3LkDAoa/ltO4\" crossorigin=\"anonymous\">\n" +
                        "        <link rel=\"stylesheet\" href=\"CSS.css\">\n" +
                        "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">" +
                        "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                        "  <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n" +
                        "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n" +
                        "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>");

        out.println("</head>");
        
        out.println("<body>");
          
               
        out.println("<h1 align='center' class='strokeme'>"+expandRole(role)+"</h1>");
                
        
         
        out.println("<div align='center'");
                
                
        out.println("<br>");
        out.println("<br>");
        out.println("<table style='width: 50%' border='1' align='center' class='table table-dark' >");
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
            out.println("</th>");
            if(role.equals("ES"))
            {
                out.println("<th>");
                out.println("Upload Solution paper");
                out.println("</th>");
            }
            
             out.println("<th>");
                out.println("View Additonal");
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
                    //out.println(moduleCode);
                    String year = rs.getString("AcademicYear");
                    
                    out.println("<tr>");
                    
                       out.println("<td>");
                            out.println(moduleCode);
        
                       out.println("</td>");
                       //Module
                       out.println("<td>");
                       String pdfPath = url + moduleCode + "\\"+year+"\\" + moduleCode + ".pdf";
                       
                            out.println("<a href="+pdfPath + ">"+moduleCode+ "Exam</a>");
                            //out.println("<form method='post' action='DownloadServlet'>");
                              //  out.println("<button type='submit' value=" + pdfPath +" name='fileToDownload'>Download Exam</button>");
                          //  out.println("</form>");
                       out.println("</td>");
                       //Exam
                       
                       if(role.equals("ES"))
                       {
                         
                            out.println("<td>");
                            out.println("<form name='Upload ' action='ReUpload.jsp' method='post'>");
                            out.println("<input type='submit' value='Upload' name='upladbtn' />");
                            out.println("<input type='hidden' name ='modcode'  value ='"+moduleCode+"'>");
                            out.println("<input type='hidden' name ='year'  value ='"+year+"'>");
                            out.println("</form>");
                            out.println("</td>");
                       }
                       else
                       {
                           
                            out.println("<td>");
                            out.println("<form name='Upload ' action='ReUploadAdditonal.jsp'>");
                            out.println("<input type='submit' value='Upload' name='upladbtn' />");
                            out.println("<input type='hidden' name ='modcode'  value ='"+moduleCode+"'>");
                            out.println("<input type='hidden' name ='year'  value ='"+year+"'>");
                            out.println("</form>");
                            out.println("</td>"); 
                            
                       }
                       
                       if(role.equals("ES"))
                       {
                           out.println("<td>");
                           out.println("<form name='Upload ' action='ReUploadAdditonal.jsp'>");
                           out.println("<input type='submit' value='Upload' name='upladbtn' />");
                           out.println("<input type='hidden' name ='modcode'  value ='"+moduleCode+"'>");
                           out.println("<input type='hidden' name ='year'  value ='"+year+"'>");
                           out.println("</form>");
                           out.println("</td>"); 
                       }
                       
                        
                           out.println("<td>");
                           out.println("<form name='Uploadd ' action='ViewAdditionalUploads'>");
                           out.println("<input type='submit' value='View' name='upladbtn' />");
                           out.println("<input type='hidden' name ='ModuleCode'  value ='"+moduleCode+"'>");
                           out.println("<input type='hidden' name ='AcademicYear'  value ='"+year+"'>");
                           out.println("</form>");
                           out.println("</td>"); 
                       
                       //Exam reupload
                       int id = rs.getInt("ExamID");
                       out.println("<td>");
                      
                       String comPath = url + moduleCode + "\\"+year+"\\" + "comments.txt";
                       int changes = rs.getInt("Changes");
                       out.println("<a href="+comPath+">"+moduleCode+" Comments</a>");
                       
                       if(role.equals("ES")){
                        if (changes != 0){
                            out.println("<div class='h'><h1 align='center'>!</h1></div>");
                        }
                       
                       }
                            //out.println("<a href=" + getPath()  + moduleCode+"\\2019\\comments.txt>"+moduleCode+" Comments</a>");
                       out.println("</td>");
                       //Exam comments
                      boolean signedExam = signSig(role, username, id);
                      if(signedExam || role.equals("ES")){
                                    out.println("<td>");
                                             out.println("<form action='BrowseExamsSContainer' method='POST'>");
                                             out.println("<input type=\"text\" name = 'inputbox'>");
                                             out.println("<input type='hidden' name ='modcode'  value ="+moduleCode+">");
                                             out.println("<input type='hidden' name ='year'  value ="+year+">");
                                             out.println("<input type='hidden' name ='id'  value ="+id+">");
                                             out.println("<input type='hidden' name ='role'  value ='"+ expandRole(role) + "'>");
                                    out.println("</td>");

                                    out.println("<td>");
                               
                                   out.println("<input type=\"submit\" value='Add Comment'>");
                                   out.println("</form>");
                    }
                    else{
                        out.println("<td>"); 
                        out.println("You have already signed this exam");
                        out.println("</td>");
                        out.println("<td>");
                        out.println("NA");
                        out.println("</td>");
                    }
                            
                       out.println("</td>");
         
                       
               
                       if(!role.equals("ES")){
                           
                            out.println("<td>");
                                if(signSig(role, username, id)){ //POLICE, THIS LINE RIGHT HERE
                             
                                   //int id = rs.getInt("ExamID");
                                   out.println("<form action='SignExamServlet' method='POST'>");

                                   out.println("<input type='hidden' name ='modcode'  value ="+moduleCode+">");


                                   out.println("<input type=\"submit\" value='Sign'>");
                                   out.println("<input type='hidden' name ='id'  value ="+id+">");
                                   out.println("<input type='hidden' name ='year'  value ="+year+">");
                                   
                                   out.println("<input type='hidden' name ='role'  value ='" + expandRole(role) + "'>");
                                   out.println("</form>");
                                }
                                else{
                                    out.println("<div class='u'><h1 align=center>X</h1></div>");
                                  
                                }
                                
                           out.println("</td>");
                       }
           
                            out.println("<td>");
                            
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
            
  out.println("<style> div.h{width: 50px; height: 50px; border-radius: 50%;  background: red;  position: relative;  -webkit-animation: mymove 1s infinite; /* Safari 4.0 - 8.0 */  animation: mymove 2s infinite;}/* Safari 4.0 - 8.0 */@-webkit-keyframes mymove {  0%   {top: 0px; left: 0px; background: red;}25%  {top: 0px; left: 0px; background: orange;}}/* Standard syntax */@keyframes mymove {0%   {top: 0px; left: 0px; background: red;}  25%  {top: 0px; left: 0px; background: orange;}}</style>");
    out.println("<style> div.u{width: 50px; height: 50px; border-radius: 50%;  background: green;  position: relative;  -webkit-animation: mymove 1s infinite; /* Safari 4.0 - 8.0 */  animation: mymove 2s infinite;}/* Safari 4.0 - 8.0 */@-webkit-keyframes mymove {  0%   {top: 0px; left: 0px; background: green;}25%  {top: 0px; left: 0px; background: purple;}}/* Standard syntax */@keyframes mymove {0%   {top: 0px; left: 0px; background: green;}  25%  {top: 0px; left: 0px; background: purple;}}</style>");
           
                HttpSession session = request.getSession();
                String username = (String) session.getAttribute("username");
                
             
                
                out.println("<nav class=\"navbar navbar-expand-lg bg-dark navbar-dark sticky-top\">\n" +
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
"                        </nav>");
                boolean sign = true;
                if(session.getAttribute("validSign") != null){
                   if((boolean) session.getAttribute("validSign") == false){
                       sign = false;
                    } 
                }
                session.setAttribute("validSign", true);
                
                if(sign == false){
                    out.println("Couldn't sign as the number of comments and acknowledgments are unequal");
                }     
                ResultSet rs = getResultSet("ES", username);
                refactor(out, username, rs, "ES", url, sign);
                
                ResultSet rs2 = getResultSet("IM", username);
                refactor(out, username, rs2, "IM", url, sign);
                
                ResultSet rs3 = getResultSet("EC", username);
                refactor(out, username, rs3, "EC", url, sign);
                
                ResultSet rs4 = getResultSet("EX", username);
                refactor(out, username, rs4, "EX", url, sign);
                
                
         
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
