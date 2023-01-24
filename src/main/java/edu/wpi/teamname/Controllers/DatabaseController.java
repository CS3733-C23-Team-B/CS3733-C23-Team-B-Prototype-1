package edu.wpi.teamname.Controllers;

import edu.wpi.teamname.Database.Node;
import java.sql.SQLException;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DatabaseController {
  @FXML Button nodeSearchButton;
  /** Method run when controller is initialized */
  public void initialize() {
    nodeSearchButton.setOnAction((actionEvent) -> getData());
  }

  /** Inserts thing into database */
  private void addData() {
    //    //Node thing = new Node();
    //    try {
    //     thing.insert();
    //    } catch (SQLException e) {
    //      e.printStackTrace();
    //    }
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
    for (Node thing : nodes) {
      System.out.println("Node Id:" + thing.getID());
      nodeBox
          .getChildren()
          .add(new Label("Node:  " + thing.getID() + "  Floor:  " + thing.getFloor()));
    }
    bor.setCenter(nodeBox);
    Button b = new Button();
    b.setText("Back");
    
    bor.setBottom(b);
    Scene scene = new Scene(bor, 800, 900);

    Stage stage = (Stage) nodeSearchButton.getScene().getWindow();
    stage.setScene(scene);

    stage.show();
  }
}
