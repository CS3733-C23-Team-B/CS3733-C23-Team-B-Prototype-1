package edu.wpi.teamname;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class csvWriter {
  public void csvWriter() {}

  public static void writeCsv(String fileName, String data) throws IOException {

    File csvFile = new File("./src/main/resources/dataSources/" + fileName + ".csv");
    FileWriter fileWriter = new FileWriter(csvFile, true);
    fileWriter.write(data);
    fileWriter.close();
  }
}
