package edu.wpi.teamname.database;

import java.sql.*;

public class Bdb {
  private Connection c;
  private static Bdb db;

  static {
    try {
      db = new Bdb();
      db.init();
    } catch (ClassNotFoundException | SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public Bdb() throws ClassNotFoundException, SQLException {
    Class.forName("org.postgresql.Driver");
    c = DriverManager.getConnection(
            "jdbc:postgresql://database.cs.wpi.edu:5432/teambdb",
            "teamb",
            "teamb20");
  }

  public void init() throws SQLException {
    if (!tableExists(Node.getTableName())) {
      Node.initTable();
    }
    if (!tableExists(Edge.getTableName())) {
      Edge.initTable();
    }
  }

  public static PreparedStatement prepareStatement(String s) throws SQLException {
    return getInstance().c.prepareStatement(s);
  }

  public static PreparedStatement prepareKeyGeneratingStatement(String s) throws SQLException {
    return getInstance().c.prepareStatement(s, Statement.RETURN_GENERATED_KEYS);
  }

  public static ResultSet processQuery(String s) throws SQLException {
    Statement stmt = getInstance().c.createStatement();
    ResultSet rs = stmt.executeQuery(s);
    return rs;
  }

  public static int processUpdate(String s) throws SQLException {
    Statement stmt = getInstance().c.createStatement();
    int numUpdated = stmt.executeUpdate(s);
    return numUpdated;
  }

  public static void closeConnection() throws SQLException {
    getInstance().c.close();
    db = null;
  }

  public static boolean tableExists(String tableName) throws SQLException {
    String query =
            "SELECT EXISTS (\n"
                    + "SELECT FROM\n"
                    + "   pg_tables\n"
                    + "WHERE\n"
                    + "   schemaname = 'public' AND\n"
                    + "   tablename  = ?\n"
                    + ");\n";

    PreparedStatement stmt = getInstance().c.prepareStatement(query);
    stmt.setString(1, tableName);
    ResultSet rs = stmt.executeQuery();
    rs.next();

    return rs.getBoolean(1);
  }

  public static Bdb getInstance() {
    return db;
  }
}

