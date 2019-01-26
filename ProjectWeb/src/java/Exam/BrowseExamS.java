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
import java.sql.SQLException;
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
    public boolean signSig(String role, String username){
        DatabaseHandling conn = new DatabaseHandling();
        if(role.equals("IM")){ 
            ResultSet rs = conn.listTableWhereD("Exam", "InternalSignID", username);
            return true;
        }
        else if(role.equals("EC")){
            ResultSet rs = conn.listTableWhereD("Exam", "CommiteeSignID", username);
            return true;
        }
        else if(role.equals("EX")){
            ResultSet rs = conn.listTableWhereD("Exam", "ExternalSignID", username);
            return true;
        }
        return false;
    }
    
    public ResultSet getResultSet(String role, String username){
        DatabaseHandling conn = new DatabaseHandling();
        if(role.equals("ES")){
            ResultSet rs = conn.listTableWhereD("Exam", "PublishedBy", username);
            return rs;
        }
        else if(role.equals("IM")){
            ResultSet rs = conn.listTableWhereD("Exam", "InternalSignID", username);
            return rs;
        }
        else if(role.equals("EC")){
            ResultSet rs = conn.listTableWhereD("Exam", "CommiteeSignID", username);
            return rs;
        }
        else if(role.equals("EX")){
            ResultSet rs = conn.listTableWhereD("Exam", "ExternalSignID", username);
            return rs;
        }
        return null;   
    }
    public void refactor(PrintWriter out, String username, ResultSet rs, String role){
        
        
        
        
        
        out.println("<html>");
 
        out.println("<head>");
        out.println("<link rel='stylesheet' href='CSS.css'>");
        out.println("<!-- Latest compiled and minified CSS -->\n" +
"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
        out.println("</head>");
        
        out.println("<body>");
        
        out.println("<h1 align='center'>"+role+"</h1>");
        out.println("<table style='width: 50%' border='4' align='center' >");
        
            out.println("<tr>");
            out.println("<th>");
                out.println("Module code");
            out.println("</th>");
            out.println("<th>");
            out.println("Exam paper");
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
            
            out.println("</tr>");
            //Table headings
            try{
                while(rs.next()){
                    String moduleCode = rs.getString("ModuleCode");
                    out.println("<tr>");
                    
                       out.println("<td>");
                            out.println(moduleCode);
                       out.println("</td>");
                       //Module
                       out.println("<td>");
                            out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\"+moduleCode+".pdf'>"+moduleCode+" Exam</a>");
                       out.println("</td>");
                       //Exam
                       out.println("<td>");
                            out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\comments.txt'>"+moduleCode+" Comments</a>");
                       out.println("</td>");
                       //Exam comments
                       
                       out.println("<td>");
                            out.println("<form action='BrowseExamsSContainer' method='POST'>");
                                out.println("<input type=\"text\" name = 'inputbox'>");
                                out.println("<input type='hidden' name ='modcode'  value ="+moduleCode+">");
                                out.println("<input type='hidden' name ='role'  value ='Exam setter'>");
                       out.println("</td>");
                       
                       out.println("<td>");
                                out.println("<input type=\"submit\" value='Add Comment'>");
                            out.println("</form>");
                       out.println("</td>");
                       
                       if(!role.equals("ES")){
                            out.println("<td>");
                                if(signSig(role, username)){ //POLICE, THIS LINE RIGHT HERE
                                    
                                   int id = rs.getInt("ExamID");
                                   out.println("<form action='SignExamServlet' method='POST'>");

                                   out.println("<input type='hidden' name ='modcode'  value ="+moduleCode+">");


                                   out.println("<input type=\"submit\" value='Sign'>");
                                   out.println("<input type='hidden' name ='id'  value ="+id+">");
                                   
                                   out.println("<input type='hidden' name ='role'  value =" + expandRole(role) + ">");
                                   out.println("</form>");
                                }
                                else{
                                    out.println("X");
                                }
                           out.println("</td>");
                        }
                    out.println("</tr>");
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
                
                out.println( "<div class ='img'>");
                out.println("<a href='StaffDashboard.jsp'>");
                out.println("<img src='DundeeUniLogo.png' width='100' height='125' alt='DundeeLogo' vertical-align='center' ></img>");
                out.println("</a>");
                out.println("</div>");
                
                ResultSet rs = getResultSet("ES", username);
                refactor(out, username, rs, "ES");
                
                ResultSet rs2 = getResultSet("IM", username);
                refactor(out, username, rs2, "IM");
                
                ResultSet rs3 = getResultSet("EC", username);
                refactor(out, username, rs3, "EC");
                
                ResultSet rs4 = getResultSet("EX", username);
                refactor(out, username, rs4, "EX");
                
                out.println("<br>");
                out.println("<div align='center'>");
                out.println("<form name='Back ' action='StaffDashboard.jsp'>");
                out.println("<input type='submit' value='<- Go Back' name='backBtn' />");
                out.println("</form>");  
                out.println("</div>");
                /*
                out.println("<table style='width: 50%' border='1' align:'center' >");
                out.println("<tr>");
                out.println("<th>");
                out.println("Module code");
                out.println("</th>");
                out.println("<th>");
                out.println("Exam paper");
                out.println("</th>");
                out.println("<th>");
                out.println("Comments");
                out.println("</th>");
               
                out.println("<th>");
                out.println("Input comment");
                out.println("</th>");
                out.println("<th>");
                out.println("Send Comment");
               
                 out.println("</tr>");
                while(setter.next()){
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(setter.getString("ModuleCode"));
                    out.println("</td>");
                    String moduleCode = setter.getString("ModuleCode");
                   
                    out.println("<td>");
                    out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\"+moduleCode+".pdf'>"+moduleCode+" Exam</a>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\comments.txt'>"+moduleCode+" Comments</a>");
                    out.println("</td>");
                    out.println("<form action='BrowseExamsSContainer' method='POST'>");
                    out.println("<td>");
                    out.println("<input type=\"text\" name = 'inputbox'>");
                    out.println("<input type='hidden' name ='modcode'  value ="+moduleCode+">");
                    out.println("<input type='hidden' name ='role'  value ='Exam setter'>");
                    out.println("</td>");
                    out.println("<td>");
                    
                    out.println("<input type=\"submit\" value='Add Comment'>");
                    out.println("</form>");
                    
                    out.println("</td>");
                    out.println("</tr>");
                    
                }
                out.println("<h1>Setter</h1>");
                
           
                ResultSet internal = instance.listTableWhereD("Exam", "InternalSignID", username);
                    
                
                out.println("<table style='width:50%' border='1'>");
                out.println("<tr>");
                out.println("<th>");
                out.println("Module code");
                out.println("</th>");
                out.println("<th>");
                out.println("Exam paper");
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
                out.println("<th>");
                out.println("Sign Exam");
                out.println("</th>");
                 out.println("</tr>");
                while(internal.next()){
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(internal.getString("ModuleCode"));
                    out.println("</td>");
                    String moduleCode = internal.getString("ModuleCode");
                   
                    int id = internal.getInt("ExamID");
                    
                    out.println("<td>");
                    out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\"+moduleCode+".pdf'>"+moduleCode+" Exam</a>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\comments.txt'>"+moduleCode+" Comments</a>");
                    out.println("</td>");
                    out.println("<form action='BrowseExamsSContainer' method='POST'>");
                    out.println("<td>");
                    out.println("<input type=\"text\" name = 'inputbox'>");
                    out.println("<input type='hidden' name ='modcode'  value ="+moduleCode+">");
                    out.println("<input type='hidden' name ='role'  value ='Internal Moderator'>");
                    out.println("</td>");
                    
                   
                    out.println("<td>");
                    out.println("<input type=\"submit\" value='Add Comment'>");
                    out.println("</form>");
                    out.println("<td>");
                    if(!internal.getBoolean("InternalSign")){
                        
                    
                        out.println("<form action='SignExamServlet' method='POST'>");
                       
                       out.println("<input type='hidden' name ='modcode'  value ="+moduleCode+">");


                       out.println("<input type=\"submit\" value='Sign'>");
                       out.println("<input type='hidden' name ='id'  value ="+id+">");
                       out.println("<input type='hidden' name ='role'  value ='Internal Moderator'>");
                       out.println("</form>");
                    }
                    else{
                        out.println("X");
                    }
                   out.println("</td>");
                    out.println("</tr>");
                    
                }

                out.println("<h1>Internal</h1>");
                
                ResultSet commitee = instance.listTableWhereD("Exam", "CommiteeSignID", username);

              
                out.println("<table style='width:50%' border='1'>");
                out.println("<tr>");
                out.println("<th>");
                out.println("Module code");
                out.println("</th>");
                out.println("<th>");
                out.println("Exam paper");
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
                out.println("<th>");
                out.println("Sign Exam");
                out.println("</th>");
                out.println("</tr>");
                 
                while(commitee.next()){
                    if(commitee.getBoolean(("InternalSign"))){
                        out.println("<tr>");
                        out.println("<td>");
                        out.println(commitee.getString("ModuleCode"));
                        out.println("</td>");
                        String moduleCode = commitee.getString("ModuleCode");
                       int id = commitee.getInt("ExamID");
                        out.println("<td>");
                        out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\"+moduleCode+".pdf'>"+moduleCode+" Exam</a>");
                        out.println("</td>");
                        out.println("<td>");
                        out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\comments.txt'>"+moduleCode+" Comments</a>");
                        out.println("</td>");
                        out.println("<form action='BrowseExamsSContainer' method='POST'>");
                        out.println("<td>");
                        out.println("<input type=\"text\" name = 'inputbox'>");
                        out.println("<input type='hidden' name ='modcode'  value ="+moduleCode+">");
                        out.println("<input type='hidden' name ='role'  value ='Exam Vetting Commitee'>");
                        out.println("</td>");
                        out.println("<td>");

                        out.println("<input type=\"submit\" value='Add Comment'>");
                        out.println("</form>");
                        out.println("<td>");
                        if(!commitee.getBoolean("CommiteeSign")){
                            out.println("<form action='SignExamServlet' method='POST'>");
                            
                            
                            
                            out.println("<input type='hidden' name ='modcode'  value ="+moduleCode+">");


                            out.println("<input type=\"submit\" value='Sign'>");
                            out.println("<input type='hidden' name ='role'  value ='Exam Commitee'>");
                            out.println("<input type='hidden' name ='id'  value ="+id+">");
                            out.println("</form>");
                        }
                        else{
                            out.println("X");
                        }
                        out.println("</td>");
                        out.println("</tr>");
                    }
                }

                  out.println("<h1>Commitee</h1>");
                
                ResultSet external = instance.listTableWhereD("Exam", "ExternalSignID", username);

               
                out.println("<table style='width:50%' border='1'>");
                out.println("<tr>");
                out.println("<th>");
                out.println("Module code");
                out.println("</th>");
                out.println("<th>");
                out.println("Exam paper");
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
                out.println("<th>");
                out.println("Sign Exam");
                out.println("</th>");
                out.println("</tr>");
                
                while(external.next()){
                    if(external.getBoolean(("CommiteeSign"))){
                    out.println("<tr>");
                    out.println("<td>");
                    out.println(external.getString("ModuleCode"));
                    out.println("</td>");
                    String moduleCode = external.getString("ModuleCode");
                   int id = external.getInt("ExamID");
                    out.println("<td>");
                    out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\"+moduleCode+".pdf'>"+moduleCode+" Exam</a>");
                    out.println("</td>");
                    out.println("<td>");
                    out.println("<a href='http:\\\\silva.computing.dundee.ac.uk\\2018-agileteam3\\"+moduleCode+"\\2019\\comments.txt'>"+moduleCode+" Comments</a>");
                    out.println("</td>");
                    out.println("<form action='BrowseExamsSContainer' method='POST'>");
                    out.println("<td>");
                    out.println("<input type=\"text\" name = 'inputbox'>");
                    out.println("<input type='hidden' name ='modcode'  value ="+moduleCode+">");
                    out.println("<input type='hidden' name ='role'  value ='External Moderator'>");
                    out.println("</td>");
                    out.println("<td>");
                    
                    out.println("<input type=\"submit\" value='Add Comment'>");
                   out.println("</td>");
                    out.println("</form>");
                    
                    out.println("<td>");
                    if(!external.getBoolean("ExternalSign")){
                        out.println("<form action='SignExamServlet' method='POST'>");
                        
                       
                        
                        out.println("<input type='hidden' name ='modcode'  value ="+moduleCode+">");
                        out.println("<input type='hidden' name ='id'  value ="+id+">");

                        out.println("<input type=\"submit\" value='Sign'>");
                        out.println("<input type='hidden' name ='role'  value ='External Moderator'>");
                        out.println("</form>");
                    }
                    else{
                        out.println("X");
                    }
                    out.println("</td>");
                    out.println("</tr>");  
                    } 
                    
                }
                //printExam(out, "Test");
             
                 out.println("<h1>External</h1>"); 
           //out.print("TTTTTTTTTTTT");
       
            }catch (Exception e){
                
            }
            
            out.println("</body>");
            
            
            out.println("</html>");    
            
            /* TODO output your page here. You may use following sample code. */
            
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
