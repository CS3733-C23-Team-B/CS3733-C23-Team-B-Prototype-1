package edu.wpi.teamb.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; // import java.util.stream.Stream;

public class Thing {
  private static final String tableName = "thing";
  private String name;
  private String data;
  private Integer id;

  public Thing(String name, String data) {
    this.name = name;
    this.data = data;
    this.id = null; // automatically set on insert
  }

  public Thing(String name, String data, Integer id) {
    this.name = name;
    this.data = data;
    this.id = id;
  }

  public static void initTable() throws SQLException {
    String sql =
        String.join(
            " ",
            "CREATE TABLE thing",
            "(id SERIAL PRIMARY KEY,",
            "name VARCHAR(255),",
            "data VARCHAR(255) );");
    Bdb.processUpdate(sql);
  }

  public static List<Thing> getAll() throws SQLException {
    ArrayList<Thing> things = new ArrayList<>();
    String sql = "SELECT * FROM thing;";
    ResultSet rs = Bdb.processQuery(sql);
    while (rs.next()) {
      things.add(new Thing(rs.getString("name"), rs.getString("data"), rs.getInt("id")));
    }
    return things;
  }

  public void insert() throws SQLException {
    String sql = "INSERT INTO thing (name, data) VALUES (?,?);";
    PreparedStatement ps = Bdb.prepareKeyGeneratingStatement(sql);
    ps.setString(1, name);
    ps.setString(2, data);
    ps.executeUpdate();
    ResultSet rs = ps.getGeneratedKeys();
    if (rs.next()) {
      id = rs.getInt(1);
    }
  }

  public void update() throws SQLException {
    String sql = "UPDATE thing SET id = ?, name = ?, data = ?;";
    PreparedStatement ps = Bdb.prepareStatement(sql);
    ps.setInt(1, id);
    ps.setString(2, name);
    ps.setString(3, data);
    ps.executeUpdate();
  }

  public void delete() throws SQLException {
    String sql = "DELETE FROM thing WHERE id = ?";
    PreparedStatement ps = Bdb.prepareStatement(sql);
    ps.setInt(1, id);
    ps.executeUpdate();
  }

  public static String getTableName() {
    return tableName;
  }

  public Integer getID() {
    return id;
  }
}
