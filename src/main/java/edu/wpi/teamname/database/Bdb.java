package edu.wpi.teamname.database;

import java.sql.*;

public class Bdb {

  private Connection c;
  private static Bdb db;

  public static void main(String[] args) {

    try {
      Class.forName("org.postgresql.Driver");

    } catch (ClassNotFoundException e) {
      System.out.println("Driver Not Found, Add Classpath To Module");
      e.printStackTrace();
      return;
    }

    System.out.println("Driver Registered");
    Connection connect = null;

    try {
      connect =
          DriverManager.getConnection(
              "jdbc:postgresql://database.cs.wpi.edu:5432/teambdb", "teamb", "teamb20");

    } catch (Exception e) {
      System.out.println("Connection Failed");
      e.printStackTrace();
      return;
    }

    System.out.println("Connection Successful");
  }

  public void getNode() {};

  public void updateNode() {};

  public void deleteNode() {};

  public void getEdge() {};

  public void updateEdge() {};

  public void deleteEdge() {};
}
