package edu.wpi.teamname.Pathfinding;

import edu.wpi.teamname.Database.Edge;
import edu.wpi.teamname.Database.Node;

import java.sql.SQLException;
import java.util.*;

public class Pathfinding {


  private static List<Edge> edges;
  private static Map<String, Node> nodes;

  static {
    try {
      edges = Edge.getAll();
//      nodes = Node.getAll();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
//    System.out.println(generatePath("a", "g"));
  }

  public static String generatePath(String currLocation, String destination) {
    return getShortestPath(currLocation, destination);
  }

  private static ArrayList<String> getDirectPaths(String node) {
    ArrayList<String> retList = new ArrayList<String>();
    for (Edge edge : edges) {
      if (edge.getStartNode().equals(node))
        retList.add(edge.getEndNode());
      else if (edge.getEndNode().equals(node))
        retList.add(edge.getStartNode());
    }
    return retList;
  }

  private static String pathToString(ArrayList<String> path) {
    String retStr = "";

    for (String a : path)
      retStr += a + " -> ";

    retStr = retStr.substring(0, retStr.length() - 4);
    return retStr;
  }

  private static String getShortestPath(String start, String end) {
    boolean done = false;
    HashMap<String, String> cameFrom = new HashMap<String, String>();

    ArrayList<String> toExpand = new ArrayList<String>();
    toExpand.add(start);

    while (toExpand.size() > 0) {

      // Breadth-first:
      String current = toExpand.remove(0);
      // Depth-first:
      //      String current = toExpand.remove(toExpand.size() - 1);

      ArrayList<String> directPaths = getDirectPaths(current);
      for (String path : directPaths) {
        if (path.equals(end)) {
          cameFrom.put(path, current);
          done = true;
          break;
        }
        if (!cameFrom.containsKey(path)) {
          cameFrom.put(path, current);
          toExpand.add(path);
        }
      }

      if (done) break;
    }

    if (!done) return "PATH NOT FOUND";

    ArrayList<String> path = new ArrayList<>();
    path.add(start);

    String current = end;
    while (!current.equals(start)) {
      path.add(1, current);
      current = cameFrom.get(current);
    }

    return pathToString(path);
  }
}
