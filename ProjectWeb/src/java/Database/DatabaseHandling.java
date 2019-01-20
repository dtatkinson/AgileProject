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
      try {
       String jdbcUrl = "jdbc:mysql://silva.computing.dundee.ac.uk/18agileteam3db?user=18agileteam3&password=7854.at3.4587";
       con = DriverManager.getConnection(jdbcUrl);
       //runs a statement using the connection
      }
      catch(Exception e){
          System.out.println("Failed to connect");
      }
     
  }
  
   //Staff Methods
   //Add, remove, edit specific records
   public void addStaff(int id, String name, String role, String pswd) throws Exception
    {
        Statement stmt=con.createStatement();  
        stmt.execute("insert into Staff (StaffID, StaffName, Role, StaffPassword) values ('"+id+"', '"+name+"','"+role+"', '"+pswd+"');");
    }

  public void removeStaff(int id) throws Exception
  {
       Statement stmt=con.createStatement();  
       stmt.execute("delete from Staff where StaffID = "+id+";");
  }
  
  public void editStaffName(int id, String newName) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Staff set StaffName = '"+newName+"' where StaffID = "+id+";");
  }
  
  public void editStaffRole(int id, String newRole) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Staff set Role = '"+newRole+"' where StaffID = "+id+";");
  }

  public void editStaffPassword(int id, String newPswd) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Staff set StaffPassword = "+newPswd+" where StaffID = "+id+";");
  }
  
  //Exam methods
  //Create, Delete, Edits, Sign
  public void createExam(int id, String name, String code, String place, String school, String year) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("insert into Exam (ExamID, ModuleName, ModuleCode, Institution, School, AcademicYear, PublishedBy) values("+id+",'"+name+"','"+code+"','"+place+"','"+school+"','"+year+"',1);");
  }
  
  public void deleteExam(int id) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("delete from Exam where ExamID = "+id+";");
  }
  
  public void editExamStatus(int id, String newStatus) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Exam set ExamStatus = '"+newStatus+"' where ExamID = "+id+";");  
  }
   
  public void editExamModuleName(int id, String newName) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Exam set ModuleName = '"+newName+"' where ExamID = "+id+";"); 
  }
    
  public void editExamModuleCode(int id, String newCode) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set ModuleCode = '"+newCode+"' where ExamID = "+id+";");   
  }
     
  public void editExamInstitution(int id, String newIN) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set Institution = '"+newIN+"' where ExamID = "+id+";");    
  }
      
  public void editExamSchool(int id, String newSchool) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set School = '"+newSchool+"' where ExamID = "+id+";");  
  }
       
  public void editExamAcademicYear(int id, String newYear) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set AcademicYear = '"+newYear+"' where ExamID = "+id+";");   
  }
   
  public void internalSignExam(int id, int signid) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set InternalSign = true where ExamID = "+id+";"); 
     stmt.execute("update Exam set InternalSignID = "+signid+" where ExamID = "+id+";");
  }
  
  public void internalDateEdit() throws Exception
  {
        
  }
   
  public void examCommiteeSignExam(int id, int signid) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set CommiteeSign = true where ExamID = "+id+";"); 
     stmt.execute("update Exam set CommiteeSignID = "+signid+" where ExamID = "+id+";");; 
  }
  
  public void examCommiteeDateEdit() throws Exception
  {
        
  }
    
  public void externalSignExam(int id, int signid) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set ExternalSign = true where ExamID = "+id+";"); 
     stmt.execute("update Exam set ExternalSignID = "+signid+" where ExamID = "+id+";");    
  }
  
  public void externalDateEdit() throws Exception
  {
        
  }
  
  //kills self
   static public void killCon() throws Exception
    {
        con.close();
    }

}

