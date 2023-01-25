package edu.wpi.teamname.Controllers;

import edu.wpi.teamname.Database.Edge;
import edu.wpi.teamname.Database.Node;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DatabaseController {
  @FXML Button nodeSearchButton;
  @FXML Button edgeQuery;
  @FXML ChoiceBox nodeChange;
  @FXML Button submitChange;
  @FXML TextField xCoord;
  @FXML TextField yCoord;
  @FXML TextField locationField;
  @FXML Button dataHelp;
  @FXML Button exit;

  /** Method run when controller is initialized */
  public void initialize() {
    nodeSearchButton.setOnAction((actionEvent) -> getNodeData());
    edgeQuery.setOnAction((actionEvent) -> getEdgeData());
    dataHelp.setOnAction((actionEvent) -> changeToHelp());
    exit.setOnAction(
        (actionEvent) -> {
          try {
            exitButtonClicked();
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
        });

    nodeChange.setItems(getNodes());
    submitChange.setOnAction(
        (actionEvent) -> {
          try {
            changeCoords();
            changeLocation();
          } catch (SQLException e) {
            throw new RuntimeException(e);
          }
        });
  }

  /** Inserts thing into database */
  private void changeCoords() throws SQLException {
    Map<String, Node> nodes;
    try {
      nodes = Node.getAll();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    System.out.println(nodeChange.getValue());
    Node n = nodes.get(nodeChange.getValue());

    n.setCoords(Integer.parseInt(xCoord.getText()), Integer.parseInt(yCoord.getText()));
    System.out.println("coordinates changed.");
  }

  public void exitButtonClicked() throws IOException {
    Stage stage = (Stage) exit.getScene().getWindow();
    stage.close();
  }

  private void changeToHelp() {
    Stage stage = new Stage();
    FXMLLoader loader =
        new FXMLLoader(getClass().getResource("/edu/wpi/teamname/views/DatabaseHelp.fxml"));
    Parent root = null;
    try {
      root = loader.load();
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
    root.setId("pane");

    Scene scene = new Scene(root, 800, 600);
    scene.getStylesheets().addAll(this.getClass().getResource("/css/style.css").toExternalForm());
    stage.setScene(scene);
    stage.show();
  }

  private void changeLocation() throws SQLException {
    Map<String, Node> nodes;
    try {
      nodes = Node.getAll();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    System.out.println(nodeChange.getValue());
    Node n = nodes.get(nodeChange.getValue());
    String newLoc = locationField.getText();
    if (newLoc.length() > 0) {
      n.setShortName(newLoc);
      System.out.println("Location Changed");
    } else System.out.println("No new Location String");
  }

  /** Queries data from database, displays in list */
  private void getNodeData() {
    BorderPane bor = new BorderPane();
    VBox nodeBox = new VBox();
    Map<String, Node> nodes;
    try {
      nodes = Node.getAll();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    nodeBox.getChildren().clear();
    nodeBox.getChildren().add(new Label("Current Nodes:"));
    nodes.forEach(
        (key, value) -> {
          Label label = new Label(value.getInfo());
          nodeBox.getChildren().add(label);
          label.setFont(new Font("Arial", 10));
        });
    bor.setCenter(nodeBox);
    Button b = new Button();
    b.setText("Back");
    b.setOnAction(
        e -> {
          Stage stage = (Stage) nodeBox.getScene().getWindow();
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
        });
    nodeBox.getChildren().add(b);
    Scene scene = new Scene(bor, 800, 800);

    Stage stage = (Stage) nodeSearchButton.getScene().getWindow();
    stage.setScene(scene);

    stage.show();
  }

  static ObservableList<String> getNodes() {
    ObservableList<String> list = FXCollections.observableArrayList();
    Map<String, Node> nodes;
    try {
      nodes = Node.getAll();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    nodes.forEach((key, value) -> list.add(key));

    return list;
  }

  private void getEdgeData() {
    BorderPane bor = new BorderPane();
    VBox edgeBox = new VBox();
    List<Edge> edges;
    try {
      edges = Edge.getAll();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    edgeBox.getChildren().clear();
    edgeBox.getChildren().add(new Label("Current Nodes:"));
    for (Edge e : edges) {
      Label label = new Label(e.getInfo());
      edgeBox.getChildren().add(label);
      label.setFont(new Font("Arial", 10));
    }
    bor.setCenter(edgeBox);
    Button b = new Button();
    b.setText("Back");
    b.setOnAction(
        e -> {
          Stage stage = (Stage) edgeBox.getScene().getWindow();
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
        });
    edgeBox.getChildren().add(b);
    Scene scene = new Scene(bor, 800, 800);

    Stage stage = (Stage) nodeSearchButton.getScene().getWindow();
    stage.setScene(scene);

    stage.show();
  }
}
