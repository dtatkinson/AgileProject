package Database;
import java.sql.*;  

public class DatabaseHandling {
  
    static private Connection con;
    
    //sets up MYSQL driver which is in properties of the project, throws error if not there
    static {
      try {
         Class.forName("com.mysql.jdbc.Driver");
         } 

      catch(Exception ex) {
         System.err.println("Unable to find driver");
      }
    }
  
  static public void main(String[] args) throws Exception
  {
       String jdbcUrl = "jdbc:mysql://silva.computing.dundee.ac.uk/18agileteam3db?user=18agileteam3&password=7854.at3.4587";
        
       con = DriverManager.getConnection(jdbcUrl);
       System.out.println("Connected!");
    
       //runs a statement using the connection
  }
  
  //kills self
   public void killCon() throws Exception
    {
        con.close();
    }
  
   //Staff Methods
   //Add, remove, edit specific records
  static public void addStaff() throws Exception
    {
        Statement stmt=con.createStatement();  
        boolean rs=stmt.execute("insert into Staff (StaffID, StaffName, Role, StaffPassword) values (1, 'James Vara','Admin', 'German Wife');");
    }

  static public void removeStaff() throws Exception
  {
      
  }
  
  static public void editStaffName() throws Exception
  {
      
  }
  
  static public void editStaffRole() throws Exception
  {
      
  }

  static public void editStaffPassword() throws Exception
  {
      
  }
  
  //Exam methods
  //Create, Delete, Edits, Sign
  static public void createExam() throws Exception
  {
        
  }
  
  static public void deleteExam() throws Exception
  {
        
  }
  
  static public void editExamStatus() throws Exception
  {
        
  }
   
  static public void editExamModuleName() throws Exception
  {
        
  }
    
  static public void editExamModuleCode() throws Exception
  {
        
  }
     
  static public void editExamInstitution() throws Exception
  {
        
  }
      
  static public void editExamSchool() throws Exception
  {
        
  }
       
  static public void editExamAcedmeicYear() throws Exception
  {
        
  }
   
  static public void internalSignExam() throws Exception
  {
        
  }
  
  static public void internalDateEdit() throws Exception
  {
        
  }
   
  static public void examCommiteeSignExam() throws Exception
  {
        
  }
  
  static public void examCommiteeDateEdit() throws Exception
  {
        
  }
    
  static public void externalSignExam() throws Exception
  {
        
  }
  
  static public void externalDateEdit() throws Exception
  {
        
  }
  
  

}

