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
    
    /* Method to return a resultset of the contents of a table according to the search term supplied
  // 
  //@param String containing the name of a table to list, string containing the search string and a string containing the column to search
  //@return Result set of the table 
  //@Author Lenard Gaunt
  */
    public ResultSet searchTable(String search, String tableName, String columnName){
      try{
        java.sql.Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM "  + tableName + " WHERE " + columnName + " LIKE '%" + search + "%'");
        return rs;
      }
      catch(Exception e){
          
      }
      
      return null;
    }
  /* Method to return a resultset of the contents of a table
  // 
  //@param String containing the name of a table to list
  //@return Result set of the table 
  //@Author Lenard Gaunt
  */
  public ResultSet listTable(String tableName){
      try{
        java.sql.Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);
        return rs;
      }
      catch(Exception e){
          
      }
      
      return null;
  }
  public ResultSet listTableWhere(String tableName, String columnName, String where){
      try{
        java.sql.Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE " + columnName + "='" + where + "'");
        return rs;
      }
      catch(Exception e){
          
      }
      
      return null;
  }
  
  public ResultSet listTableWhereD(String tableName, String columnName, String where){
      try{
        java.sql.Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT DISTINCT * FROM " + tableName + " WHERE " + columnName + "='" + where + "'");
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
   public void addStaff(String username, String name, String role, String pswd) throws Exception
    {
        Statement stmt=con.createStatement(); 
        stmt.execute("insert into Staff (StaffName, Name, Role, StaffPassword) values ('"+username+"','"+name+"','"+role+"', '"+pswd+"');");
    }

  public void removeStaff(String username) throws Exception
  {
       Statement stmt=con.createStatement();  
       stmt.execute("delete from Staff where StaffName = '"+username+"';");
  }
  
  public void editStaffUserName(String username, String newName) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Staff set StaffName = '"+newName+"' where StaffName = '"+username+"';");
  }
  
  public void editStaffName(String name, String newName) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Staff set Name = '"+newName+"' where StaffName = '"+name+"';");
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
  public void createExam(String name, String code, String place, String school, String year, String pubBy) throws Exception
  {
      Statement stmt=con.createStatement();  
      ResultSet rs = stmt.executeQuery("select ExamID from Exam where ExamID = (select max(ExamID) from Exam)");
      stmt.execute("insert into Exam (ModuleName, ModuleCode, Institution, School, AcademicYear, PublishedBy) values('"+name+"','"+code+"','"+place+"','"+school+"','"+year+"','"+pubBy+"');");
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
   
  public void internalAssignExam(int id, String staffName) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Exam set InternalSignID = '"+staffName+"' where ExamID = "+id+";");
  }
  
   public void internalAssignExamDeadline(int id, String dead) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Exam set InternalSignDeadlineDate = '"+dead+"' where ExamID = "+id+";");
  }
  
  public void internalSignExam(int id) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set InternalSign = true where ExamID = "+id+";"); 
     stmt.execute("update Exam set InternalSignDate = CURDATE() where ExamID = "+id+";");
  }
   
  public void examCommiteeAssignExam(int id, String staffName) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Exam set CommiteeSignID = '"+staffName+"' where ExamID = "+id+";");
  }
  
  public void examCommiteeSignExam(int id) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set CommiteeSign = true where ExamID = "+id+";"); 
     stmt.execute("update Exam set CommiteeSignDate = CURDATE() where ExamID = "+id+";");
  }
  
    public void examCommiteeAssignExamDeadline(int id, String dead) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Exam set CommiteeSignDeadlineDate = '"+dead+"' where ExamID = "+id+";");
  }
    
   public void externalAssignExam(int id, String staffName) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Exam set ExternalSignID = '"+staffName+"' where ExamID = "+id+";"); 
  }
  
  public void externalSignExam(int id) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set ExternalSign = true where ExamID = "+id+";");   
     stmt.execute("update Exam set ExternalSignDate = CURDATE() where ExamID = "+id+";");
  }
  
    public void externalAssignExamDeadline(int id, String dead) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Exam set ExternalSignDeadlineDate = '"+dead+"' where ExamID = "+id+";");
  }
  
  //kills self
   static public void killCon() throws Exception
    {
        con.close();
    }

}

