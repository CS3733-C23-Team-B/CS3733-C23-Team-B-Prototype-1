package edu.wpi.teamname.database;

public class Node {

  private String nodeID;
  private int xcoord;
  private int ycoord;
  private String floor;
  private String building;
  private String nodeType;
  private String longName;
  private String shortName;

  public Node(
      String nodeID,
      int xcoord,
      int ycoord,
      String floor,
      String building,
      String nodeType,
      String longName,
      String shortName) {

    this.nodeID = nodeID;
    this.xcoord = xcoord;
    this.ycoord = ycoord;
    this.floor = floor;
    this.building = building;
    this.nodeType = nodeType;
    this.longName = longName;
    this.shortName = shortName;
  }
}
