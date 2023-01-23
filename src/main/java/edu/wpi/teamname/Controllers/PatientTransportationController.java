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

  @FXML private TextField notes;

  @FXML private Button cancelButton;

  @FXML private Button helpButton;

  @FXML private Button clearButton;
  @FXML private Button submitButton;

  public void initialize() {
    // intialization goes here
  }

  public void cancelButtonClicked() throws IOException {
    // Stuff to handle moving back to home screen
  }

  public void helpButtonClicked() throws IOException {
    // Stuff to handle help screen
  }

  public void clearButtonClicked() throws IOException {
    // Stuff to handle the clearing of fields goes here
  };

  public void submitButtonClicked() throws IOException {
    // Stuff to handle submitting
  }
}
