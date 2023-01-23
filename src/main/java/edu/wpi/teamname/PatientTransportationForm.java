package edu.wpi.teamname;

public class PatientTransportationForm {

  public String convertToCSV(String[] data) {

    return ""; // Stream.of(data).map(this::escapeSpecialCharacters).collect(Collectors.joining(","));
  }

  public void saveToFile(
      String fname,
      String lname,
      String id,
      String email,
      String equipment,
      String urgency,
      String location,
      String destination,
      String notes) {
    if (notes.equals(null)) notes = "None";

    String[] data = new String[9];
    data[0] = fname;
    data[1] = lname;
    data[2] = id;
    data[3] = email;
    data[4] = equipment;
    data[5] = urgency;
    data[6] = location;
    data[7] = destination;
    data[8] = notes;

    String csv = convertToCSV(data);
  }
}
