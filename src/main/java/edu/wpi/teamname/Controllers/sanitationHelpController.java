package edu.wpi.teamname.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class sanitationHelpController {

  @FXML private Button backButton;

  public void backButtonClicked() throws IOException {
    FXMLLoader loader2 =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamname/views/sanitationService.fxml"));
    Parent root2 = loader2.load();
    BorderPane b = (BorderPane) backButton.getScene().getRoot();
    b.setCenter(root2);
  }
}
