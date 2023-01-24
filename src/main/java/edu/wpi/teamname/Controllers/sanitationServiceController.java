package edu.wpi.teamname.Controllers;

import edu.wpi.teamname.csvWriter;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class sanitationServiceController {
  // Lists for choiceboxes
  ObservableList<String> urgencyList =
      FXCollections.observableArrayList("Low", "Moderate", "High", "Requires Immediate Attention");
  ObservableList<String> typeOfCleanUpList =
      FXCollections.observableArrayList("Bathroom", "Spill", "Vacant Room");
  /*
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
   */

  // page attributes from fxml
  @FXML private BorderPane feature2BorderPane;
  @FXML private TextField firstNameField;
  @FXML private TextField lastNameField;
  @FXML private TextField employeeIDField;
  @FXML private TextField emailField;
  @FXML private TextField cleanUpLocationField;
  @FXML private ChoiceBox urgencyBox;
  @FXML private ChoiceBox typeOfCleanUpBox;
  @FXML private Button clearButton;
  @FXML private Button submitButton;
  @FXML private Button helpButton;
  @FXML private Button cancelButton;

  @FXML
  public void initialize() {
    // intialization goes here
    urgencyBox.setItems(urgencyList);
    typeOfCleanUpBox.setItems(typeOfCleanUpList);
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
    cleanUpLocationField.clear();
  }

  private void resetChoiceBoxes() throws IOException {
    // clear choices
    // not sure if this function is the right one to clear it yet
    urgencyBox.valueProperty().set(null);
    typeOfCleanUpBox.valueProperty().set(null);
  }

  private void helpButtonClicked() {
    // stuff for help button goes here
  }

  public void cancelButtonClicked() throws IOException {
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamname/views/HomeScreen.fxml"));
    Parent root = loader.load();
    feature2BorderPane.setCenter(root);
  }

  @FXML
  public void submitButtonClicked() throws IOException {
    // handle retrieving values and saving

    // retrieve text field values
    String firstName = firstNameField.getText();
    String lastName = lastNameField.getText();
    String employeeID = employeeIDField.getText();
    String email = emailField.getText();
    String location = cleanUpLocationField.getText();

    // retrieve choicebox values
    String urgency = (String) urgencyBox.getValue();
    String typeOfCleanUp = (String) typeOfCleanUpBox.getValue();

    // may need to clear fields can be done with functions made for clear
    resetChoiceBoxes();
    resetTextFields();
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
            + location
            + ","
            + urgency
            + ","
            + typeOfCleanUp
            + "\n";
    csvWriter writer = new csvWriter();
    writer.writeCsv("sanitationService", saveInfo);

    //    System.out.println(saveInfo);
    //    String[] saveInfo = {firstName, lastName, employeeID, email, location, urgency,
    // typeOfCleanUp};
    // save this to csv

  }
}
