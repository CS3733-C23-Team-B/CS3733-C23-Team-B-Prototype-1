package edu.wpi.teamname.Controllers;

import edu.wpi.teamname.Database.Node;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DatabaseController {
  @FXML Button nodeSearchButton;
  @FXML ChoiceBox nodeChange;
  @FXML Button submitChange;

  /** Method run when controller is initialized */
  public void initialize() {
    nodeSearchButton.setOnAction((actionEvent) -> getData());
    nodeChange.setItems(getNodes());
    submitChange.setOnAction((actionEvent) -> changeCoords());
  }

  /** Inserts thing into database */
  private void changeCoords() {
    //    //Node thing = new Node();
    //    try {
    //     thing.insert();
    //    } catch (SQLException e) {
    //      e.printStackTrace();
    //    }

    System.out.println("bruhhh");
  }

  /** Queries data from database, displays in list */
  private void getData() {
    BorderPane bor = new BorderPane();
    VBox nodeBox = new VBox();
    List<Node> nodes;
    try {
      nodes = Node.getAll();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    nodeBox.getChildren().clear();
    nodeBox.getChildren().add(new Label("Current Nodes:"));
    for (Node node : nodes) {
      nodeBox.getChildren().add(new Label(node.getInfo()));
    }
    bor.setCenter(nodeBox);
    Button b = new Button();
    b.setText("Back");
    b.setOnAction(
        e -> {
          Stage stage = (Stage) nodeBox.getScene().getWindow();
          FXMLLoader loader =
              new FXMLLoader(getClass().getResource("/edu/wpi/teamname/views/Navigation.fxml"));
          Parent root = null;
          try {
            root = loader.load();
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
          root.setId("pane");
          Scene scene = new Scene(root, 800, 600);
          scene
              .getStylesheets()
              .addAll(this.getClass().getResource("/css/style.css").toExternalForm());
          // locking the stage size
          stage.setMinHeight(600);
          stage.setMinWidth(800);
          stage.setMaxHeight(600);
          stage.setMaxWidth(800);

          stage.setScene(scene);
          stage.show();

          FXMLLoader homeLoader =
              new FXMLLoader(getClass().getResource("/edu/wpi/teamname/views/DatabaseUI.fxml"));
          BorderPane borderPane = (BorderPane) root;
          try {
            borderPane.setCenter(homeLoader.load());
          } catch (IOException ex) {
            throw new RuntimeException(ex);
          }
        });
    bor.setBottom(b);
    Scene scene = new Scene(bor, 1000, 900);

    Stage stage = (Stage) nodeSearchButton.getScene().getWindow();
    stage.setScene(scene);

    stage.show();
  }

  static ObservableList<String> getNodes() {
    ObservableList<String> list = FXCollections.observableArrayList();
    List<Node> nodes;
    try {
      nodes = Node.getAll();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    for (Node node : nodes) {
      list.add(node.getID());
    }
    return list;
  }
}