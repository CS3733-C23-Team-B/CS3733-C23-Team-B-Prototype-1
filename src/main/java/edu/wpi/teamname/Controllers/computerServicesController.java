package edu.wpi.teamname.Controllers;

import edu.wpi.teamname.csvWriter;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class computerServicesController {
  // Lists for choiceboxes
  ObservableList<String> typeOfIssueList =
      FXCollections.observableArrayList("Low", "Moderate", "High", "Requires Immediate Attention");
  ObservableList<String> typeOfCleanUpList =
      FXCollections.observableArrayList("Bathroom", "Spill", "Vacant Room");

  // page attributes from fxml
  @FXML private BorderPane computerServiceBorderPane;
  @FXML private TextField firstNameField;
  @FXML private TextField lastNameField;
  @FXML private TextField employeeIDField;
  @FXML private TextField emailField;
  @FXML private TextField roomNumberField;
  @FXML private TextField notesField;
  @FXML private ChoiceBox typeOfIssueBox;
  @FXML private ChoiceBox typeOfDeviceBox;
  @FXML private Button clearButton;
  @FXML private Button submitButton;
  @FXML private Button helpButton;
  @FXML private Button cancelButton;

  @FXML
  public void initialize() {
    // intialization goes here
    typeOfIssueBox.setItems(typeOfIssueList);
    typeOfDeviceBox.setItems(typeOfCleanUpList);
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
    roomNumberField.clear();
    notesField.clear();
  }

  private void resetChoiceBoxes() throws IOException {
    // clear choices
    // not sure if this function is the right one to clear it yet
    typeOfIssueBox.valueProperty().set(null);
    typeOfDeviceBox.valueProperty().set(null);
  }

  private void helpButtonClicked() {
    // stuff for help button goes here
  }

  public void cancelButtonClicked() throws IOException {
    Stage stage = (Stage) cancelButton.getScene().getWindow();
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamname/views/Navigation.fxml"));
    Parent root = loader.load();
    root.setId("pane");
    Scene scene = new Scene(root, 800, 600);
    scene.getStylesheets().addAll(this.getClass().getResource("/css/style.css").toExternalForm());
    // locking the stage size
    stage.setMinHeight(600);
    stage.setMinWidth(800);
    stage.setMaxHeight(600);
    stage.setMaxWidth(800);

    stage.setScene(scene);
    stage.show();

    FXMLLoader homeLoader =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamname/views/HomeScreen.fxml"));
    computerServiceBorderPane = (BorderPane) root;
    computerServiceBorderPane.setCenter(homeLoader.load());
  }

  @FXML
  public void submitButtonClicked() throws IOException {
    // handle retrieving values and saving

    // retrieve text field values
    String firstName = firstNameField.getText();
    String lastName = lastNameField.getText();
    String employeeID = employeeIDField.getText();
    String email = emailField.getText();
    String location = roomNumberField.getText();
    String notes = notesField.getText();

    // retrieve choicebox values
    String urgency = (String) typeOfIssueBox.getValue();
    String typeOfCleanUp = (String) typeOfDeviceBox.getValue();

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
    csvWriter writer = new csvWriter();
    writer.writeCsv("computerService", saveInfo);

    //    System.out.println(saveInfo);
    //    String[] saveInfo = {firstName, lastName, employeeID, email, location, urgency,
    // typeOfCleanUp};
    // save this to csv

  }
}
