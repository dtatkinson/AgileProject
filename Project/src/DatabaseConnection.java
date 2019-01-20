import java.sql.*;  

public class DatabaseConnection {
  
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
       addStaff();
  }
  
  static public boolean addStaff() throws Exception
    {
        Statement stmt=con.createStatement();  
        boolean rs=stmt.execute("insert into Staff (StaffID, StaffName, Role, StaffPassword) values (1, 'James Vara','Admin', 'German Wife');");
        return true;
    }


 static public void killCon() throws Exception
    {
        con.close();
    }
}

//find a way to have it be object orianted 
//


