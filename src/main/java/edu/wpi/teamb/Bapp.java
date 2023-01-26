package edu.wpi.teamb;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Bapp extends Application {

  @Override
  public void init() {
    log.info("Starting Up");
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("views/SignIn.fxml"));
    root.setId("pane");
    Scene scene = new Scene(root, 800, 600);
    scene.getStylesheets().addAll(this.getClass().getResource("/css/style.css").toExternalForm());

    // locking the stage size
    primaryStage.setMinHeight(600);
    primaryStage.setMinWidth(800);
    primaryStage.setMaxHeight(600);
    primaryStage.setMaxWidth(800);

    primaryStage.setScene(scene);
    primaryStage.setTitle("Badger Crossing Health Clinic");
    primaryStage.show();
  }

  @Override
  public void stop() {
    log.info("Shutting Down");
  }
}
