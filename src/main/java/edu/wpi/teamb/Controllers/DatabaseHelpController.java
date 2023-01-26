package edu.wpi.teamb.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class DatabaseHelpController {

  @FXML Button backButton;

  public void initialize() {
    backButton.setOnAction((actionEvent) -> backToScene());
  }

  private void backToScene() {
    BorderPane b = (BorderPane) backButton.getScene().getRoot();
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamb/views/DatabaseUI.fxml"));
    Parent root = null;
    try {
      root = loader.load();
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
    b.setCenter(root);
  }
}
