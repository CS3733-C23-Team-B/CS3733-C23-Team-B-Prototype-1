package edu.wpi.teamname.Database;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class setDBOriginalData {

  public void runSQL(File sqlCsv) throws FileNotFoundException, SQLException {

    Scanner scan = new Scanner(sqlCsv);
    while (scan.hasNext()) {
      String sql = scan.next();
      PreparedStatement ps = Bdb.prepareStatement(sql);
      ps.executeUpdate();
    }
    scan.close();
  }

  public void setData() throws SQLException, FileNotFoundException {

    File nodeFile = new File("./OriginalData.L1NodesSQL.csv");
    File edgeFile = new File("./OriginalData.L1EdgesSQL.csv");
    runSQL(nodeFile);
    runSQL(edgeFile);
  }
}
