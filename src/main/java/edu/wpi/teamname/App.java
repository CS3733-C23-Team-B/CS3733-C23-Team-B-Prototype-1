package edu.wpi.teamname;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App extends Application {

  @Override
  public void init() {
    log.info("Starting Up");
  }

  @Override
  public void start(Stage primaryStage) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("views/SignIn.fxml"));
    primaryStage.setScene(new Scene(root, 600, 600));
    primaryStage.setTitle("Hospital Service");
    primaryStage.show();
  }

  @Override
  public void stop() {
    log.info("Shutting Down");
  }
}
