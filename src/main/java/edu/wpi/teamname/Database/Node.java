package edu.wpi.teamname.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List; // import java.util.stream.Stream;
import java.util.Map;

public class Node {

  public static final String tableName = "Node";
  private String nodeID;
  private int xcoord;
  private int ycoord;
  private String floor;
  private String building;
  private String nodeType;
  private String longName;
  private String shortName;

  public Node(
      int xcoord, int ycoord, String floor, String building,
      String nodeType, String longName, String shortName) {

    this.nodeID = null;
    this.xcoord = xcoord;
    this.ycoord = ycoord;
    this.floor = floor;
    this.building = building;
    this.nodeType = nodeType;
    this.longName = longName;
    this.shortName = shortName;
  }

  public Node(
          String nodeID,
          int xcoord, int ycoord, String floor, String building,
          String nodeType, String longName, String shortName) {

    this.nodeID = nodeID;
    this.xcoord = xcoord;
    this.ycoord = ycoord;
    this.floor = floor;
    this.building = building;
    this.nodeType = nodeType;
    this.longName = longName;
    this.shortName = shortName;
  }

  public static void initTable() throws SQLException {
    String sql =
            String.join(
                    " ",
                    "CREATE TABLE Node",
                    "(nodeID char(10),",
                    "xcoord integer,",
                    "ycoord integer,",
                    "floor varchar(4),",
                    "building varchar(15),",
                    "nodeType char(4),",
                    "longName varchar(70)",
                    "shortName varchar(40));");
    Bdb.processUpdate(sql);
  }

  public static Map<String, Node> getAll() throws SQLException {
    HashMap<String, Node> Nodes = new HashMap<String, Node>();
    String sql = "SELECT * FROM Node;";
    ResultSet rs = Bdb.processQuery(sql);
    while (rs.next()) {
      Nodes.put(rs.getString("nodeID"), new Node(rs.getString("nodeID"), rs.getInt("xcoord"), rs.getInt("ycoord"),
              rs.getString("floor"), rs.getString("building"), rs.getString("nodeType"),
              rs.getString("longName"), rs.getString("shortName")));
    }
    return Nodes;
  }

  public void insert() throws SQLException {
    String sql = "INSERT INTO Node (nodeID, xcoord, ycoord, floor, building, nodeType, longName, shortName) " +
            "VALUES (?,?,?,?,?,?,?,?);";
    PreparedStatement ps = Bdb.prepareKeyGeneratingStatement(sql);
    ps.setString(1, nodeID);
    ps.setInt(2, xcoord);
    ps.setInt(3, ycoord);
    ps.setString(4, floor);
    ps.setString(5, building);
    ps.setString(6, nodeType);
    ps.setString(7, longName);
    ps.setString(8, shortName);

    /// not sure how we will deal with generating new nodeID yet but left at string for now
    /// so ignore duplicate in update() for now

    ps.executeUpdate();
  }

  public void update() throws SQLException {
    String sql = "UPDATE Node SET NodeID = ?, xcoord = ?, ycoord = ?, floor = ?, " +
            "building = ?, nodeType = ?, longName = ?, shortName = ?;";
    PreparedStatement ps = Bdb.prepareStatement(sql);
    ps.setString(1, nodeID);
    ps.setInt(2, xcoord);
    ps.setInt(3, ycoord);
    ps.setString(4, floor);
    ps.setString(5, building);
    ps.setString(6, nodeType);
    ps.setString(7, longName);
    ps.setString(8, shortName);
    ps.executeUpdate();
  }

  public void delete() throws SQLException {
    String sql = "DELETE FROM Node WHERE nodeID = ?";
    PreparedStatement ps = Bdb.prepareStatement(sql);
    ps.setString(1, nodeID);
    ps.executeUpdate();
  }

  public static String getTableName() {
    return tableName;
  }

  public String getID() {
    return nodeID;
  }

  public int getXcoord() {
    return xcoord;
  }

  public int getYcoord() {
    return ycoord;
  }

  public String getFloor() {
    return floor;
  }
}
