package edu.wpi.teamb.Controllers;

import edu.wpi.teamb.Database.Login;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controller {
  @FXML private Button homeButton;
  @FXML private BorderPane border;
  @FXML private Button signInButton;
  @FXML private TextField username;
  @FXML private TextField password;
  @FXML private CheckBox newAccount;
  @FXML private Label prompt;

  private final String USER = "bodacious";
  private final String PASS = "badgers";

  private Map<String, Login> users;

  {
    try {
      users = Login.getAll();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public void handleKeyPress(KeyEvent event) throws IOException, SQLException {
    if (event.getCode().equals(KeyCode.ENTER)) signInButtonClicked();
  }

  public boolean validateLogin() throws SQLException {
    if (username.getText().equals(USER) && password.getText().equals(PASS)) return true;
    else if (users.containsKey(username.getText())
        && users.get(username.getText()).getPassword().equals(password.getText())) return true;
    else if (newAccount.isSelected()) {
      Login newLogin = new Login(username.getText(), password.getText(), "");
      newLogin.insert();
      return true;
    }
    prompt.setText("\tInvalid login");
    prompt.setTextFill(Color.RED);
    username.clear();
    password.clear();
    return false;
  }

  public void signInButtonClicked() throws IOException, SQLException {
    if (!validateLogin()) return;
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
        new FXMLLoader(getClass().getResource("/edu/wpi/teamb/views/PatientTransportation.fxml"));
    Parent root = loader.load();
    border.setCenter(root);
  }

  public void featureTwoButtonClicked() throws IOException {
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamb/views/sanitationService.fxml"));
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

  public void exitButtonClicked() {
    Stage stage = (Stage) homeButton.getScene().getWindow();
    stage.close();
  }
}
