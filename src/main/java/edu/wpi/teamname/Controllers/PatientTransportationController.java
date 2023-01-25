package edu.wpi.teamname.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

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
  @FXML private BorderPane feature1Border;

  // List of all text fields and choice boxes for flexibility; when adding new input components to
  // form, add to this list
  private ArrayList<Control> components;
  private ArrayList<TextField> textFields;
  private ArrayList<ChoiceBox> choiceBoxes;

  ObservableList<String> equipmentOptions =
      FXCollections.observableArrayList("Stretcher", "Wheelchair", "Restraints", "Stair Chair");
  ObservableList<String> urgencyOptions =
      FXCollections.observableArrayList("Low", "Moderate", "High", "Requires Immediate Attention");

  /** Initialize the page by declaring choicebox options */
  public void initialize() {
    // Create list of components
    Control[] cl = {
      firstName,
      lastName,
      employeeID,
      email,
      equipmentNeeded,
      urgency,
      patientLocation,
      patientDestination,
      patientID,
      notes
    };
    components = new ArrayList<>(Arrays.asList(cl));
    textFields = new ArrayList<>();
    choiceBoxes = new ArrayList<>();

    // Create lists of text fields and choice boxes
    for (Control c : components) {
      if (c instanceof TextField) textFields.add((TextField) c);
      if (c instanceof ChoiceBox) choiceBoxes.add((ChoiceBox) c);
    }

    equipmentNeeded.setItems(equipmentOptions);
    urgency.setItems(urgencyOptions);
    // TODO: initialize choicebox options
  }

  /**
   * Return to the home screen without saving form data
   *
   * @throws IOException
   */
  public void cancelButtonClicked() throws IOException {
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamname/views/HomeScreen.fxml"));
    Parent root = loader.load();
    feature1Border.setCenter(root);
    // TODO: copy nav bar home screen button
  }

  /**
   * Display the help page
   *
   * @throws IOException
   */
  public void helpButtonClicked() throws IOException {
    // TODO: stuff to handle help screen
    // Delete?
  }

  /**
   * Remove all inputted data from the form
   *
   * @throws IOException
   */
  public void clearButtonClicked() throws IOException {
    for (TextField t : textFields) t.clear();

    for (ChoiceBox c : choiceBoxes) c.getSelectionModel().clearSelection();
  }

  /**
   * Store the data from the form in a csv file and return to home screen
   *
   * @throws IOException
   */
  public void submitButtonClicked() throws IOException {
    String[] inputInfo = new String[components.size()];

    // Add all input components to the list of data
    for (int i = 0; i < components.size(); i++) {
      Control c = components.get(i);
      if (c instanceof TextField) inputInfo[i] = ((TextField) c).getText();
      if (c instanceof ChoiceBox) inputInfo[i] = (String) ((ChoiceBox) c).getValue();
    }
    // TODO: save to CSV, return to home screen or show confirmation page
  }
}
