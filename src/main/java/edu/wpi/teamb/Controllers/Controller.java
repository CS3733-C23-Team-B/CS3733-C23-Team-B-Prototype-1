package edu.wpi.teamb.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Controller {
  @FXML private Button homeButton;
  @FXML private BorderPane border;
  @FXML private Button signInButton;

  public void signInButtonClicked() throws IOException {
    Stage stage = (Stage) signInButton.getScene().getWindow();
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
        new FXMLLoader(getClass().getResource("/edu/wpi/teamb/views/HomeScreen.fxml"));
    border = (BorderPane) root;
    border.setCenter(homeLoader.load());
  }

  public void featureOneButtonClicked() throws IOException {
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamb/views/Feature1.fxml"));
    Parent root = loader.load();
    border.setCenter(root);
  }

  public void featureTwoButtonClicked() throws IOException {
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamb/views/Feature2.fxml"));
    Parent root = loader.load();
    border.setCenter(root);
  }

  public void pathfindingClicked() throws IOException {
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamb/views/Pathfinding.fxml"));
    Parent root = loader.load();
    border.setCenter(root);
  }

  public void homeButtonClicked() throws IOException {
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamb/views/HomeScreen.fxml"));
    Parent root = loader.load();
    border.setCenter(root);
  }

  public void databaseButtonClicked() throws IOException {
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamb/views/DatabaseUI.fxml"));
    Parent root = loader.load();
    border.setCenter(root);
  }

  public void exitButtonClicked() throws IOException {
    Stage stage = (Stage) homeButton.getScene().getWindow();
    stage.close();
  }
}
