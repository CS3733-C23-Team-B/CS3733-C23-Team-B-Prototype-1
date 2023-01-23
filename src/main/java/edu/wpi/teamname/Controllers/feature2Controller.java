package edu.wpi.teamname.Controllers;

import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import java.lang.String;

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
  @FXML private MFXTextField firstNameField;
  @FXML private MFXTextField lastNameField;
  @FXML private MFXTextField employeeIDField;
  @FXML private MFXTextField emailField;
  @FXML private ChoiceBox cleanUpLocationBox;
  @FXML private ChoiceBox urgencyBox;
  @FXML private ChoiceBox typeOfCleanUpBox;
  @FXML private ChoiceBox areaOfCleanUpBox;
  @FXML private Button clearButton;
  @FXML private Button submitButton;

  @FXML
  public void initialize() {
    // intialization goes here
    cleanUpLocationBox.setItems(cleanUpLocationList);
    urgencyBox.setItems(urgencyList);
    typeOfCleanUpBox.setItems(typeOfCleanUpList);
    areaOfCleanUpBox.setItems(areaOfCleanUpList);
  }

  public void clearButtonClicked() throws IOException {
    // Stuff to handle the clearing of fields goes here
  };

  public void submitButtonClicked() throws IOException {
    // handle retriving values and saving

    //retrieve text field values
    String firstName = firstNameField.getText();
    String lastName = lastNameField.getText();
    String employeeID = employeeIDField.getText();
    String email = emailField.getText();

    // retrive choicebox values
    String cleanUpLocation = (String) cleanUpLocationBox.getValue();
    String urgency = (String) urgencyBox.getValue();
    String typeOfCleanUp = (String) typeOfCleanUpBox.getValue();
    String areaOfCleanUp = (String) areaOfCleanUpBox.getValue();

  }
}
