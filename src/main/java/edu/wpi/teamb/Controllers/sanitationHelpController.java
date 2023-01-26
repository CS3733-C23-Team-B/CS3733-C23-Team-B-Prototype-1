package edu.wpi.teamb.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class sanitationHelpController {

  @FXML private Button backButton;

  public void backButtonClicked() throws IOException {
    Stage stage = (Stage) backButton.getScene().getWindow();
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamb/views/Navigation.fxml"));
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
        new FXMLLoader(getClass().getResource("/edu/wpi/teamb/views/sanitationService.fxml"));
    BorderPane border = (BorderPane) root;
    border.setCenter(homeLoader.load());
  }
}
