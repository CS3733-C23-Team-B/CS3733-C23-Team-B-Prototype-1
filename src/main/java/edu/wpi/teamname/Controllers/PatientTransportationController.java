package edu.wpi.teamname.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class PatientTransportationController {
  @FXML private TextField firstName;
  @FXML private TextField lastName;
  @FXML private TextField employeeID;
  @FXML private TextField email;
  @FXML private ChoiceBox equipmentNeeded;
  @FXML private ChoiceBox urgency;
  @FXML private TextField patientLocation;
  @FXML private TextField patientDestination;
  @FXML private TextField patientID;
  @FXML private TextField notes;
  @FXML private Button cancelButton;
  @FXML private Button helpButton;
  @FXML private Button clearButton;
  @FXML private Button submitButton;

  /**
   * Initialize the page by declaring choicebox options
   */
  public void initialize() {
    // TODO: initialize choicebox options
  }

  /**
   * Return to the home screen without saving form data
   * @throws IOException
   */
  public void cancelButtonClicked() throws IOException {
    // TODO: copy nav bar home screen button
  }

  /**
   * Display the help page
   * @throws IOException
   */
  public void helpButtonClicked() throws IOException {
    // TODO: stuff to handle help screen
    // Delete?
  }

  /**
   * Remove all inputted data from the form
   * @throws IOException
   */
  public void clearButtonClicked() throws IOException {
    // TODO: set element values to empty
  };

  /**
   * Store the data from the form in a csv file and return to home screen
   * @throws IOException
   */
  public void submitButtonClicked() throws IOException {
    String[] inputInfo = {firstName.getText(),
            lastName.getText(),
            employeeID.getText(),
            email.getText(),
            (String) equipmentNeeded.getValue(),
            (String) urgency.getValue(),
            patientLocation.getText(),
            patientDestination.getText(),
            patientID.getText(),
            notes.getText()};

    // TODO: save to CSV, return to home screen or show confirmation page
  }
}
