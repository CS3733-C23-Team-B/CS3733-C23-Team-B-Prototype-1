package edu.wpi.teamname.Controllers;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class feature2Controller {
    @FXML private MFXTextField firstName;
    @FXML private MFXTextField lastName;
    @FXML private MFXTextField employeeID;
    @FXML private MFXTextField email;
    @FXML private MFXTextField cleanUpLocation;
    @FXML private ChoiceBox urgency;
    @FXML private ChoiceBox typeOfCleanUp;
    @FXML private ChoiceBox areaOfCleanUp;
    public void initialize() {
        // intialization goes here
    }
    
}
