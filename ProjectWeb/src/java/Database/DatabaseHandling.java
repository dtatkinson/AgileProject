package Database;
import java.sql.*;  
/**
 * Class that handles all database operations
 * @author oliversimpson and lenardguant
 * Code reviewed by matthewmchale
 */
public class DatabaseHandling {
 
    static private Connection con;
    
    
    /**
     * Constructor, sets up connection for the methods
     */
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
   public ResultSet getChange(String username){
       try{
           java.sql.Statement stmt = con.createStatement();
           ResultSet rs = stmt.executeQuery("SELECT * FROM Exam WHERE Changes = 1 AND PublishedBy='" + username + "'");
           return rs;
       }
       catch(Exception e){
           
       }
       return null;
   }  
   public void setChanges(int change, int id) throws Exception{
      
        java.sql.Statement stmt = con.createStatement();
        stmt.execute("update Exam set Changes = "+change+" WHERE ExamID = "+id+";");
      //stmt.execute("update Staff set StaffName = '"+newName+"' where StaffName = '"+username+"';");

   }
    /**
     * method to search table and returns resultset
     * @param search  string containing the search string and
     * @param tableName String containing the name of a table to list
     * @param columnName  string containing the column to search
     * @return rs Result set of the search
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
  
    /**
     * Method to return a list of the table
     * @param tableName String containing the name of a table to list
     * @return Result set of the table
     * @Author LenardGaunt
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
  
  /**
   * Method to return list of table given where param
   * @param tableName Name of the table to search
   * @param columnName Name of the column name
   * @param where field value
   * @return result set
   */
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
  public ResultSet listTableWhereI(String tableName, String columnName, int where){
      try{
        java.sql.Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE " + columnName + "='" + where + "'");
        return rs;
      }
      catch(Exception e){
          
      }
      
      return null;
  }
  
  /**
   * Method that selects distinct statements
   * @param tableName name of the table
   * @param columnName name of the column
   * @param where the field value
   * @return result set
   */
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
  
  public ResultSet test(String tableName, String columnName, boolean where){
      try{
        java.sql.Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE " + columnName + "=" + where + "");
        return rs;
      }
      catch(Exception e){
          
      }
      
      return null;
  }
  
   public ResultSet getAllPastExams(String tableName){
      try{
        java.sql.Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from "+tableName+" where AcademicYear != year(CURDATE());");
        return rs;
      }
      catch(Exception e){
          
      }
      
      return null;
  }
  
   /**
   * Method to add staff to the data base
   * @param username staff members username
   * @param name staff members name
   * @param role staff members role
   * @param pswd staff members password
   * @throws Exception 
   */
   public void addStaff(String username, String name, String role, String pswd) throws Exception
    {
        Statement stmt=con.createStatement(); 
        stmt.execute("insert into Staff (StaffName, Name, Role, StaffPassword) values ('"+username+"','"+name+"','"+role+"', '"+pswd+"');");
    }

   /**
    * Method to remove a staff member from the database
    * @param username staff members username
    * @throws Exception 
    */
  public void removeStaff(String username) throws Exception
  {
       Statement stmt=con.createStatement();  
       stmt.execute("delete from Staff where StaffName = '"+username+"';");
  }
  
  /**
   * Method to edit a staff members username
   * @param username current username
   * @param newName new username
   * @throws Exception 
   */
  public void editStaffUserName(String username, String newName) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Staff set StaffName = '"+newName+"' where StaffName = '"+username+"';");
  }
  
  /**
   * Method to edit staff members name
   * @param name current name
   * @param newName new name
   * @throws Exception 
   */
  public void editStaffName(String name, String newName) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Staff set Name = '"+newName+"' where StaffName = '"+name+"';");
  }
  
  /**
   * Method to edit staff members role
   * @param name staff members name
   * @param newRole staff members new role
   * @throws Exception 
   */
  public void editStaffRole(String name, String newRole) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Staff set Role = '"+newRole+"' where StaffName = '"+name+"';");
  }

  /**
   * Method to edit staff members password
   * @param name Staff members name
   * @param newPswd new password
   * @throws Exception 
   */
  public void editStaffPassword(String name, String newPswd) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Staff set StaffPassword = '"+newPswd+"' where StaffName = '"+name+"';");
  }
  
  //Exam methods
  //Create, Delete, Edits, Sign
  /**
   * Method to create a new exam on the database
   * @param name Module Name
   * @param code Module code
   * @param place Institution
   * @param school School
   * @param year year exam is to be sat
   * @param pubBy author of the exam
   * @throws Exception 
   */
  public void createExam(String name, String code, String place, String school, String year, String pubBy) throws Exception
  {
      Statement stmt=con.createStatement();  
      ResultSet rs = stmt.executeQuery("select ExamID from Exam where ExamID = (select max(ExamID) from Exam)");
      stmt.execute("insert into Exam (ModuleName, ModuleCode, Institution, School, AcademicYear, PublishedBy) values('"+name+"','"+code+"','"+place+"','"+school+"','"+year+"','"+pubBy+"');");
  }
  
  /**
   * Method to delete exam from the database
   * @param id exam ID
   * @throws Exception 
   */
  public void deleteExam(int id) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("delete from Exam where ExamID = "+id+";");
  }
  
  /**
   * Method to edit exams status (new, in progress, complete)
   * @param id exam ID
   * @param newStatus Exams new status to be set
   * @throws Exception 
   */
  public void editExamStatus(int id, String newStatus) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Exam set ExamStatus = '"+newStatus+"' where ExamID = "+id+";");  
  }
   
  /**
   * Method to edit the module name
   * @param id exam ID
   * @param newName New module name
   * @throws Exception 
   */
  public void editExamModuleName(int id, String newName) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Exam set ModuleName = '"+newName+"' where ExamID = "+id+";"); 
  }
    
  /**
   * Method to edit module code
   * @param id exams ID
   * @param newCode new module code
   * @throws Exception 
   */
  public void editExamModuleCode(int id, String newCode) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set ModuleCode = '"+newCode+"' where ExamID = "+id+";");   
  }
     
  /**
   * Method to edit exam institution
   * @param id Exams ID
   * @param newIN new institution
   * @throws Exception 
   */
  public void editExamInstitution(int id, String newIN) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set Institution = '"+newIN+"' where ExamID = "+id+";");    
  }
      
  /**
   * Method to edit exam school
   * @param id ID of the exam
   * @param newSchool new school to be set
   * @throws Exception 
   */
  public void editExamSchool(int id, String newSchool) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set School = '"+newSchool+"' where ExamID = "+id+";");  
  }
       
  /**
   * Method to edit the academic year
   * @param id Exam ID
   * @param newYear New year that will be set
   * @throws Exception 
   */
  public void editExamAcademicYear(int id, String newYear) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set AcademicYear = '"+newYear+"' where ExamID = "+id+";");   
  }
   
  /**
   * Method to assign a member of staff as the internal moderator
   * @param id Id of the exam
   * @param staffName Name of the staff member that will be internal moderator
   * @throws Exception 
   */
  public void internalAssignExam(int id, String staffName) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Exam set InternalSignID = '"+staffName+"' where ExamID = "+id+";");
  }
  
  /**
   * Method to mark the internal moderators deadline
   * @param id Id of the exam
   * @param dead deadline that will be set on the DB
   * @throws Exception 
   */
   public void internalAssignExamDeadline(int id, String dead) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Exam set InternalSignDeadlineDate = '"+dead+"' where ExamID = "+id+";");
  }
  
   /**
    * Method to mark that the internal moderator has signed off on the exam
    * @param id Id of the exam
    * @throws Exception 
    */
  public void internalSignExam(int id) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set InternalSign = true where ExamID = "+id+";"); 
     stmt.execute("update Exam set InternalSignDate = CURDATE() where ExamID = "+id+";");
  }
   
  /**
   * Method to assign an Exam vetting committe to an exam
   * @param id Id of the exam
   * @param staffName name of the staff member that will be signing as the EVC
   * @throws Exception 
   */
  public void examCommiteeAssignExam(int id, String staffName) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Exam set CommiteeSignID = '"+staffName+"' where ExamID = "+id+";");
  }
  
  /**
   * method to mark the exam as signed by the EVC
   * @param id ID of the exam
   * @throws Exception 
   */
  public void examCommiteeSignExam(int id) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set CommiteeSign = true where ExamID = "+id+";"); 
     stmt.execute("update Exam set CommiteeSignDate = CURDATE() where ExamID = "+id+";");
  }
 
  /**
   * method to set the deadline for the EVC 
   * @param id ID of the exam
   * @param dead deadline that will be set
   * @throws Exception 
   */
    public void examCommiteeAssignExamDeadline(int id, String dead) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Exam set CommiteeSignDeadlineDate = '"+dead+"' where ExamID = "+id+";");
  }
    
    /**
     * Method to assign a staff member as the external moderator
     * @param id ID of the exam
     * @param staffName name of the member of staff that will be assigned to EM
     * @throws Exception 
     */
   public void externalAssignExam(int id, String staffName) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Exam set ExternalSignID = '"+staffName+"' where ExamID = "+id+";"); 
  }
  
   /**
    * Method that marks the exam as signed by the EM
    * @param id ID of the exam
    * @throws Exception 
    */
  public void externalSignExam(int id) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Exam set ExternalSign = true where ExamID = "+id+";");   
     stmt.execute("update Exam set ExternalSignDate = CURDATE() where ExamID = "+id+";");
  }
  
  /**
   * Method to set the deadline for the EM
   * @param id ID of the exam
   * @param dead deadline that will be set for the EM
   * @throws Exception 
   */
    public void externalAssignExamDeadline(int id, String dead) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Exam set ExternalSignDeadlineDate = '"+dead+"' where ExamID = "+id+";");
  }
    
     public void createResitExam(String name, String code, String place, String school, String year, String pubBy) throws Exception
  {
      Statement stmt=con.createStatement();  
      ResultSet rs = stmt.executeQuery("select ExamID from Resit where ExamID = (select max(ExamID) from Exam)");
      stmt.execute("insert into Resit (ModuleName, ModuleCode, Institution, School, AcademicYear, PublishedBy) values('"+name+"','"+code+"','"+place+"','"+school+"','"+year+"','"+pubBy+"');");
  }
  
  /**
   * Method to delete exam from the database
   * @param id exam ID
   * @throws Exception 
   */
  public void deleteResitExam(int id) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("delete from Resit where ExamID = "+id+";");
  }
  
  /**
   * Method to edit exams status (new, in progress, complete)
   * @param id exam ID
   * @param newStatus Exams new status to be set
   * @throws Exception 
   */
  public void editResitExamStatus(int id, String newStatus) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Resit set ExamStatus = '"+newStatus+"' where ExamID = "+id+";");  
  }
   
  /**
   * Method to edit the module name
   * @param id exam ID
   * @param newName New module name
   * @throws Exception 
   */
  public void editResitExamModuleName(int id, String newName) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Resit set ModuleName = '"+newName+"' where ExamID = "+id+";"); 
  }
    
  /**
   * Method to edit module code
   * @param id exams ID
   * @param newCode new module code
   * @throws Exception 
   */
  public void editResitExamModuleCode(int id, String newCode) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Resit set ModuleCode = '"+newCode+"' where ExamID = "+id+";");   
  }
     
  /**
   * Method to edit exam institution
   * @param id Exams ID
   * @param newIN new institution
   * @throws Exception 
   */
  public void editResitExamInstitution(int id, String newIN) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Resit set Institution = '"+newIN+"' where ExamID = "+id+";");    
  }
      
  /**
   * Method to edit exam school
   * @param id ID of the exam
   * @param newSchool new school to be set
   * @throws Exception 
   */
  public void editResitExamSchool(int id, String newSchool) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Resit set School = '"+newSchool+"' where ExamID = "+id+";");  
  }
       
  /**
   * Method to edit the academic year
   * @param id Exam ID
   * @param newYear New year that will be set
   * @throws Exception 
   */
  public void editResitExamAcademicYear(int id, String newYear) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Resit set AcademicYear = '"+newYear+"' where ExamID = "+id+";");   
  }
   
  /**
   * Method to assign a member of staff as the internal moderator
   * @param id Id of the exam
   * @param staffName Name of the staff member that will be internal moderator
   * @throws Exception 
   */
  public void internalAssignResitExam(int id, String staffName) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Resit set InternalSignID = '"+staffName+"' where ExamID = "+id+";");
  }
  
  /**
   * Method to mark the internal moderators deadline
   * @param id Id of the exam
   * @param dead deadline that will be set on the DB
   * @throws Exception 
   */
   public void internalAssignResitExamDeadline(int id, String dead) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Resit set InternalSignDeadlineDate = '"+dead+"' where ExamID = "+id+";");
  }
  
   /**
    * Method to mark that the internal moderator has signed off on the exam
    * @param id Id of the exam
    * @throws Exception 
    */
  public void internalSignResitExam(int id) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Resit set InternalSign = true where ExamID = "+id+";"); 
     stmt.execute("update Resit set InternalSignDate = CURDATE() where ExamID = "+id+";");
  }
   
  /**
   * Method to assign an Exam vetting committe to an exam
   * @param id Id of the exam
   * @param staffName name of the staff member that will be signing as the EVC
   * @throws Exception 
   */
  public void examCommiteeAssignResitExam(int id, String staffName) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Resit set CommiteeSignID = '"+staffName+"' where ExamID = "+id+";");
  }
  
  /**
   * method to mark the exam as signed by the EVC
   * @param id ID of the exam
   * @throws Exception 
   */
  public void examCommiteeSignResitExam(int id) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Resit set CommiteeSign = true where ExamID = "+id+";"); 
     stmt.execute("update Resit set CommiteeSignDate = CURDATE() where ExamID = "+id+";");
  }
 
  /**
   * method to set the deadline for the EVC 
   * @param id ID of the exam
   * @param dead deadline that will be set
   * @throws Exception 
   */
    public void examCommiteeAssignResitExamDeadline(int id, String dead) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Resit set CommiteeSignDeadlineDate = '"+dead+"' where ExamID = "+id+";");
  }
    
    /**
     * Method to assign a staff member as the external moderator
     * @param id ID of the exam
     * @param staffName name of the member of staff that will be assigned to EM
     * @throws Exception 
     */
   public void externalAssignResitExam(int id, String staffName) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Resit set ExternalSignID = '"+staffName+"' where ExamID = "+id+";"); 
  }
  
   /**
    * Method that marks the exam as signed by the EM
    * @param id ID of the exam
    * @throws Exception 
    */
  public void externalSignResitExam(int id) throws Exception
  {
     Statement stmt=con.createStatement();  
     stmt.execute("update Resit set ExternalSign = true where ExamID = "+id+";");   
     stmt.execute("update Resit set ExternalSignDate = CURDATE() where ExamID = "+id+";");
  }
  
  /**
   * Method to set the deadline for the EM
   * @param id ID of the exam
   * @param dead deadline that will be set for the EM
   * @throws Exception 
   */
    public void externalAssignResitExamDeadline(int id, String dead) throws Exception
  {
      Statement stmt=con.createStatement();  
      stmt.execute("update Resit set ExternalSignDeadlineDate = '"+dead+"' where ExamID = "+id+";");
  }
  
  /**
   * Method that kills the connection to the database
   * @throws Exception 
   */
   static public void killCon() throws Exception
    {
        con.close();
    }

}

