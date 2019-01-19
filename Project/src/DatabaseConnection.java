


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oliversimpson
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    
  static {
    try {
      Class.forName("com.mysql.jdbc.Driver");
    } catch(ClassNotFoundException ex) {
      System.err.println("Unable to load MySQL Driver");
    }
  }

  static public void main(String[] args) throws Exception
  {
    String jdbcUrl = "jdbc:mysql://silva.computing.dundee.ac.uk/18agileteam3db?user=18agileteam3&password=7854.at3.4587";
    Connection con = DriverManager.getConnection(jdbcUrl);
    System.out.println("Connected!");
    con.close();
  }
}

