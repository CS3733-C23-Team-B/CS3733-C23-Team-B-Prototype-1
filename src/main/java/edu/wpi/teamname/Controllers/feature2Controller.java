package edu.wpi.teamname.Controllers;

import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class feature2Controller {
  // Lists for choiceboxes
  ObservableList<String> cleanUpLocationList =
      FXCollections.observableArrayList("107", "204", "302");
  ObservableList<String> urgencyList =
      FXCollections.observableArrayList("low", "moderate", "high", "needs immediate attention");
  ObservableList<String> typeOfCleanUpList =
      FXCollections.observableArrayList("spill", "vancant room", "bathroom");
  ObservableList<String> areaOfCleanUpList =
      FXCollections.observableArrayList(
          "patient room",
          "hallway",
          "bathroom",
          "cafeteria",
          "break room",
          "stock room",
          "public space",
          "other");

  // page attributes from fxml
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

  @FXML
  public void initialize() {
    // intialization goes here
    cleanUpLocation.setItems(cleanUpLocationList);
    urgency.setItems(urgencyList);
    typeOfCleanUp.setItems(typeOfCleanUpList);
    areaOfCleanUp.setItems(areaOfCleanUpList);
  }

  public void clearButtonClicked() throws IOException {
    // Stuff to handle the clearing of fields goes here
  };

  public void submitButtonClicked() throws IOException {
    // Stuff to handle submitting
  }
}
