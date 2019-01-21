package Database;
import java.sql.*;  

public class DatabaseHandling {
 
    static private Connection con;
    
    //Constructor, sets up connection for the methods
    public DatabaseHandling()
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
    //sets up MYSQL driver which is in properties of the project, throws error if not there
    static {
      try {
         Class.forName("com.mysql.jdbc.Driver");
         } 

      catch(Exception ex) {
         System.err.println("Unable to find driver");
      }
    }
  /* Method to return a list of all usernames
  // 
  */
  public ResultSet listStaff(){
      try{
        java.sql.Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Staff");
        return rs;
      }
      catch(Exception e){
          
      }
      
      return null;
  }
   //Staff Methods
   //Add, remove, edit specific records
   //After multiple testing we discovered we need to have staff id generate a acceptable id
   //As to stop insertion errors
   //same fix for createExam
   public void addStaff(String name, String role, String pswd) throws Exception
    {
        Statement stmt=con.createStatement(); 
        stmt.execute("insert into Staff (StaffName, Role, StaffPassword) values ('"+name+"','"+role+"', '"+pswd+"');");
    }

  public void removeStaff(String name) throws Exception
  {
       Statement stmt=con.createStatement();  
       stmt.execute("delete from Staff where StaffName = '"+name+"';");
  }
  
  public void editStaffName(String name, String newName) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Staff set StaffName = '"+newName+"' where StaffName = '"+name+"';");
  }
  
  public void editStaffRole(String name, String newRole) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Staff set Role = '"+newRole+"' where StaffName = '"+name+"';");
  }

  public void editStaffPassword(String name, String newPswd) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Staff set StaffPassword = '"+newPswd+"' where StaffName = '"+name+"';");
  }
  
  //Exam methods
  //Create, Delete, Edits, Sign
  public void createExam(String name, String code, String place, String school, String year) throws Exception
  {
      Statement stmt=con.createStatement();  
      ResultSet rs = stmt.executeQuery("select ExamID from Exam where ExamID = (select max(ExamID) from Exam)");
      int id = 1;
      while(rs.next())
      {
        id = rs.getInt("ExamID")+1;
      }
      stmt.execute("insert into Exam (ExamID, ModuleName, ModuleCode, Institution, School, AcademicYear, PublishedBy) values("+id+",'"+name+"','"+code+"','"+place+"','"+school+"','"+year+"','Lenard');");
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
   
  public void internalAssignExam(int id, int signid) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Exam set InternalSignID = "+signid+" where ExamID = "+id+";");
  }
  
  public void internalSignExam(int id) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set InternalSign = true where ExamID = "+id+";"); 
     stmt.execute("update Exam set InternalSignDate = CURDATE() where ExamID = "+id+";");
  }
   
  public void examCommiteeAssignExam(int id, int signid) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Exam set CommiteeSignID = "+signid+" where ExamID = "+id+";");
  }
  
  public void examCommiteeSignExam(int id) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set CommiteeSign = true where ExamID = "+id+";"); 
     stmt.execute("update Exam set CommiteeSignDate = CURDATE() where ExamID = "+id+";");
  }
    
   public void externalAssignExam(int id, int signid) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Exam set ExternalSignID = "+signid+" where ExamID = "+id+";"); 
  }
  
  public void externalSignExam(int id) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set ExternalSign = true where ExamID = "+id+";");   
     stmt.execute("update Exam set ExternalSignDate = CURDATE() where ExamID = "+id+";");
  }
  
  //kills self
   static public void killCon() throws Exception
    {
        con.close();
    }

}

