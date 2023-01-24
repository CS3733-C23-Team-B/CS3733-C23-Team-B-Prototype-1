package edu.wpi.teamname.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class GetOriginalData {

  public ArrayList<Node> getNodesFromCSV() throws FileNotFoundException {


    File file = new File("./OriginalData.L1Nodes.csv");
    Scanner scan = new Scanner(file);
    scan.useDelimiter(" ");
    ArrayList<Node> csvNodes = new ArrayList<Node>();
    while (scan.hasNext()) {
      String nodeID = scan.next();
      System.out.println("nodeID");
    }

    return csvNodes;
  }

  /*public ArrayList<Edge> getEdgesFromCSV() throws FileNotFoundException {

    File file = new File("./OriginalData.L1Edges.csv");
    FileReader fr = new FileReader(file);
    ArrayList<Edge> csvEdges = new ArrayList<Edge>();

    return csvEdges;


  }*/
}
