package edu.wpi.teamname;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class csvWriter {
  public static void writeCsv(String fileName, String[] data) throws IOException {
    File csvFile = new File("./src/main/resources/dataSources/" + fileName + ".csv");
    FileWriter fileWriter = new FileWriter(csvFile, true);
    fileWriter.write(convertToCSV(data));
    fileWriter.close();
  }

  private static String convertToCSV(String[] data) {
    String csv = "";

    for (int i = 0; i < data.length; i++) {
      String s = data[i];

      // Remove special characters
      s = s.replaceAll("\\R", " ");
      if (s.contains(",") || s.contains("\"") || s.contains("'")) {
        s.replace("\"", "\"\"");
        s = "\"" + s + "\"";
      }

      csv = csv + s;
      if (i != data.length - 1) csv = csv + ",";
    }
    return csv;
  }
}
