package edu.wpi.teamname.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DatabaseHelpController {

  @FXML Button backButton;

  public void initialize() {
    backButton.setOnAction((actionEvent) -> backToScene());
  }

  private void backToScene() {
    Stage stage = new Stage();
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamname/views/DatabaseUI.fxml"));
    Parent root = null;
    try {
      root = loader.load();
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
    root.setId("pane");
    Scene scene = new Scene(root, 800, 600);
    stage.setScene(scene);
    stage.show();
  }
}
