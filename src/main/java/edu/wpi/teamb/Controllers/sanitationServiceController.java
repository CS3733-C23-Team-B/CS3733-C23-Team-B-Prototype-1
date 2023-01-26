package edu.wpi.teamb.Controllers;

import edu.wpi.teamb.CSVWriter;
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
  // Lists for checkboxes
  ObservableList<String> urgencyList =
      FXCollections.observableArrayList("Low", "Moderate", "High", "Requires Immediate Attention");
  ObservableList<String> typeOfCleanUpList =
      FXCollections.observableArrayList("Bathroom", "Spill", "Vacant Room", "Blood", "Chemicals");
  @FXML private TextField firstNameField;
  @FXML private TextField lastNameField;
  @FXML private TextField employeeIDField;
  @FXML private TextField emailField;
  @FXML private TextField cleanUpLocationField;
  @FXML private ChoiceBox urgencyBox;
  @FXML private ChoiceBox typeOfCleanUpBox;
  @FXML private TextField additionalNotesField;
  @FXML private Button helpButton;
  @FXML private Button cancelButton;

  @FXML
  public void initialize() {
    // initialization goes here
    urgencyBox.setItems(urgencyList);
    typeOfCleanUpBox.setItems(typeOfCleanUpList);
  }

  public void clearButtonClicked() throws IOException {
    // Stuff to handle the clearing of fields goes here
    resetTextFields();
    resetChoiceBoxes();
  }

  private void resetTextFields() {
    // clear text fields
    firstNameField.clear();
    lastNameField.clear();
    employeeIDField.clear();
    emailField.clear();
    cleanUpLocationField.clear();
    additionalNotesField.clear();
  }

  private void resetChoiceBoxes() throws IOException {
    // clear choices
    // not sure if this function is the right one to clear it yet
    urgencyBox.valueProperty().set(null);
    typeOfCleanUpBox.valueProperty().set(null);
  }

  public void helpButtonClicked() throws IOException {
    FXMLLoader loader2 =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamb/views/sanitationHelpPage.fxml"));
    Parent root2 = loader2.load();
    root2.setId("pane");
    helpButton.getScene().setRoot(root2);
  }

  public void cancelButtonClicked() throws IOException {
    FXMLLoader loader2 =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamb/views/HomeScreen.fxml"));
    Parent root2 = loader2.load();
    BorderPane b = (BorderPane) cancelButton.getScene().getRoot();
    b.setCenter(root2);
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
    String notes = additionalNotesField.getText();

    // retrieve choice-box values
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
            + ","
            + notes
            + "\n";
    CSVWriter writer = new CSVWriter();
    writer.writeCsv("sanitationService", new String[] {saveInfo});

    //    System.out.println(saveInfo);
    //    String[] saveInfo = {firstName, lastName, employeeID, email, location, urgency,
    // typeOfCleanUp, notes};
    // save this to csv

  }
}
