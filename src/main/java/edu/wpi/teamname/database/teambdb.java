package edu.wpi.teamname.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class teambdb {

  public static void main(String[] args) {

    Connection connect = null;

    try {
      Class.forName("teambdb@database.cs.wpi.edu");
      connect =
          DriverManager.getConnection(
              "jdbc:postgresql://database.cs.wpi.edu:5432/teambdb", "teamb", "teamb20");

    } catch (Exception e) {
      e.printStackTrace();
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      return;
    }

    System.out.println("Connection Successful");
  }
}
