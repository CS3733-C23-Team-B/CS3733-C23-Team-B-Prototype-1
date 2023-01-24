package edu.wpi.teamname;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class csvWriter {
  public void csvWriter() {}

  public static void writeCsv(String fileName, String data) throws IOException {

    String path = fileName + ".csv";
    File csvFile = new File(path);
    FileWriter fileWriter = new FileWriter(csvFile, true);
    fileWriter.write(data);
    fileWriter.close();
  }
}
