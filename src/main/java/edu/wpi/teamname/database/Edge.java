package edu.wpi.teamname.database;

public class Edge {

  private String edgeID;

  private Node startNode;

  private Node endNode;

  public Edge(String edgeID, Node startNode, Node endNode) {

    this.edgeID = edgeID;
    this.startNode = startNode;
    this.endNode = endNode;
  }
}
