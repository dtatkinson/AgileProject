/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import javax.swing.JOptionPane;

/**
 *
 * @author owenkelbie
 */
public class DetailHandler {
    private String staffID;
    private String passwd;
   
   
       
    public String IDHandler()
    {
        setstaffID(null);
        return getstaffID();
    }
    /**
     * 
     * passwd constructor 
     */
    public String PassHandler()
    {
        setpasswd(null);
        return getpasswd();
    }

    /**
     * @return the StaffID
     */
    public String getstaffID() {
        return staffID;
    }

    /**
     * @param staffID the StaffID to set
     */
    public void setstaffID(String staffID) {
        this.staffID = staffID;
    }

    /**
     * @return the passwd
     */
    public String getpasswd() {
        return passwd;
    }

    /**
     * @param passwd the passwd to set
     */
    public void setpasswd(String passwd) {
        this.passwd = passwd;
    }
    
    public String compareDetails(){
         System.out.println("hello");
        if(staffID == "user" && passwd == "pass"){
          System.out.println("afsadgda");
            return("response.jsp");
           
        }
        return "null";
    }
}