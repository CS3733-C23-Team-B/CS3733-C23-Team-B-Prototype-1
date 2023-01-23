package edu.wpi.teamname.Controllers;

import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

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
  @FXML private TextField firstNameField;
  @FXML private TextField lastNameField;
  @FXML private TextField employeeIDField;
  @FXML private TextField emailField;
  @FXML private ChoiceBox cleanUpLocationBox;
  @FXML private ChoiceBox urgencyBox;
  @FXML private ChoiceBox typeOfCleanUpBox;
  @FXML private ChoiceBox areaOfCleanUpBox;
  @FXML private Button cancelButton;
  @FXML private Button helpButton;
  @FXML private Button clearButton;
  @FXML private Button submitButton;

  public void initialize() {
    // intialization goes here
    cleanUpLocationBox.setItems(cleanUpLocationList);
    urgencyBox.setItems(urgencyList);
    typeOfCleanUpBox.setItems(typeOfCleanUpList);
    areaOfCleanUpBox.setItems(areaOfCleanUpList);
  }

  public void clearButtonClicked() throws IOException {
    // Stuff to handle the clearing of fields goes here
    resetTextFields();
    resetChoiceBoxes();
  };

  private void resetTextFields() {
    // clear text fields
    firstNameField.clear();
    lastNameField.clear();
    employeeIDField.clear();
    emailField.clear();
  }

  private void resetChoiceBoxes() throws IOException {
    // clear choices
    // not sure if this function is the right one to clear it yet
    cleanUpLocationBox.valueProperty().set(null);
    urgencyBox.valueProperty().set(null);
    typeOfCleanUpBox.valueProperty().set(null);
    areaOfCleanUpBox.valueProperty().set(null);
  }

  private void helpButtonClicked() {
    // stuff for help button goes here
  }

  private void cancelButtonClicked() {
    // send to home page not sure how
  }

  public void submitButtonClicked() throws IOException {
    // handle retrieving values and saving

    //    // retrieve text field values
    String firstName = firstNameField.getText();
    String lastName = lastNameField.getText();
    String employeeID = employeeIDField.getText();
    String email = emailField.getText();

    // retrieve choicebox values
    String cleanUpLocation = (String) cleanUpLocationBox.getValue();
    String urgency = (String) urgencyBox.getValue();
    String typeOfCleanUp = (String) typeOfCleanUpBox.getValue();
    String areaOfCleanUp = (String) areaOfCleanUpBox.getValue();

    // may need to clear fields can be done with functions made for clear

    //     prep for CSV file
    String saveInfo =
        firstName
            + ","
            + lastName
            + ","
            + employeeID
            + ","
            + email
            + ","
            + cleanUpLocation
            + ","
            + urgency
            + ","
            + typeOfCleanUp
            + ","
            + areaOfCleanUp
            + "/n";
    resetTextFields();
    resetChoiceBoxes();
    // save this to csv

  }
}
