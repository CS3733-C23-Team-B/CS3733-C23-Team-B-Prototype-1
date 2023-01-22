package edu.wpi.teamname.Controllers;

import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class feature2Controller {
  @FXML private MFXTextField firstName;
  @FXML private MFXTextField lastName;
  @FXML private MFXTextField employeeID;
  @FXML private MFXTextField email;
  @FXML private ChoiceBox cleanUpLocation;
  @FXML private ChoiceBox urgency;
  @FXML private ChoiceBox typeOfCleanUp;
  @FXML private ChoiceBox areaOfCleanUp;
  @FXML private Button clearButton;
  @FXML private Button submitButton;

  public void initialize() {
    // intialization goes here
  }

  public void clearButtonClicked() throws IOException {
    // Stuff to handle the clearing of fields goes here
  };

  public void submitButtonClicked() throws IOException {
    // Stuff to handle submitting
  }
}
