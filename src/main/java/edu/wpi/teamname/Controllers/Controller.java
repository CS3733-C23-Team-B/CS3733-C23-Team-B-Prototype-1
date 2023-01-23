package edu.wpi.teamname.Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Controller {
  @FXML Button ClickButton; // fx:ID of the button in the ExampleFXML
  @FXML private Button featureOneButton;
  @FXML private Button featureTwoButton;
  @FXML private Button featureThreeButton;
  @FXML private Button homeButton;
  @FXML private Button exitButton;
  @FXML private BorderPane border;
  @FXML private Button signInButton;

  private Connection connection = null; // connection to database

  /** Method run when controller is initializes */
  public void initialize() {
    // if connection is successful
    //    if (this.connectToDB()) {
    //      this.createTable();
    //    }
  }

  /**
   * When the button is clicked, the method will log the data in the terminal and database
   *
   * @param actionEvent event that triggered method
   * @throws IOException
   */
  public void buttonClicked(ActionEvent actionEvent) throws IOException {
    System.out.println("Button was clicked");
    System.out.println(this.logData() ? "Data logged" : "Data NOT logged");
  }

  public void signInButtonClicked() throws IOException {
    Stage stage = (Stage) signInButton.getScene().getWindow();
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamname/views/Navigation.fxml"));
    Parent root = loader.load();
    stage.setScene(new Scene(root, 600, 600));
    stage.show();
  }

  public void featureOneButtonClicked() throws IOException {
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamname/views/Feature1.fxml"));
    Parent root = loader.load();
    border.setCenter(root);
  }

  public void featureTwoButtonClicked() throws IOException {
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamname/views/Feature2.fxml"));
    Parent root = loader.load();
    border.setCenter(root);
  }

  public void featureThreeButtonClicked() throws IOException {
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamname/views/Feature3.fxml"));
    Parent root = loader.load();
    border.setCenter(root);
  }

  public void homeButtonClicked() throws IOException {
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamname/views/HomeScreen.fxml"));
    Parent root = loader.load();
    border.setCenter(root);
  }

  public void exitButtonClicked() throws IOException {
    Stage stage = (Stage) exitButton.getScene().getWindow();
    stage.close();
  }

  /**
   * Generates connection to server on localhost at default port (1521) be aware of the username and
   * password when testing
   *
   * @return True when connection is successful, False when failed
   */
  private boolean connectToDB() {

    try {
      Class.forName(
          "org.apache.derby.jdbc.ClientDriver"); // Check that proper driver is packaged for Apache
      // Derby
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("NO DRIVER");
      return false;
    }
    try {
      // create Connection at specified URL
      this.connection =
          DriverManager.getConnection(
              "jdbc:derby://localhost:1527/testDB;create=true",
              "app",
              "derbypass"); // This will change for each team as their DB is developed
      if (this.connection != null) {
        System.out.println("Connected to the database!");
      } else {
        System.out.println("Failed to make connection!");
      }
    } catch (SQLException e) {
      System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
      return false;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }

    // connection successful, return true
    return true;
  }

  /**
   * generates a table to store button click information
   *
   * @return true when table is successfully created or already exists, false otherwise
   */
  private boolean createTable() {

    boolean table_exists = false;

    if (this.connection != null) {
      String createQuery =
          "CREATE TABLE APP.buttonClicks("
              + "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
              + "btn_name VARCHAR(50), "
              + "time_stamp TIMESTAMP NOT NULL, "
              + "PRIMARY KEY(id) )";
      try {
        Statement statement = this.connection.createStatement();
        statement.execute(createQuery);

        table_exists = true;
      } catch (SQLException e) {
        // Error code 955 is "name is already used by an existing object", so this table name
        // already exists
        if (e.getErrorCode() == 955 || e.getMessage().contains("already exists"))
          table_exists = true;
        else e.printStackTrace();
      }
    }
    return table_exists;
  }

  /**
   * Stores button click data to database
   *
   * @return true if data is stored successfully, false otherwise
   */
  private boolean logData() {
    if (connection != null) {
      String writeQuery =
          "INSERT INTO APP.buttonClicks(btn_name, time_stamp) VALUES ( 'ClickButton', CURRENT_TIMESTAMP ) ";
      try {
        Statement statement = this.connection.createStatement();
        statement.execute(writeQuery);
        return true;
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return false;
  }
}
