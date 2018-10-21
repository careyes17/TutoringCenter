package src;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.PopOver;

import java.io.IOException;

import java.io.IOException;

public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

    private static Stage primaryStage;

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
    primaryStage.setResizable(false);
    primaryStage.setTitle("Tutoring App");
    primaryStage.setScene(new Scene(root, 600, 400));
    primaryStage.show();

  }

    private void setPrimaryStage(Stage stage) {
        Main.primaryStage = stage;
    }

    static public Stage getPrimaryStage() {
        return primaryStage;
    }


}