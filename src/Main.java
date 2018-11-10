package src;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        setPrimaryStage(primaryStage);
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        //primaryStage.setResizable(false);
        primaryStage.setTitle("Tutoring App");
        primaryStage.setScene(new Scene(root, 600, 440));
        primaryStage.show();

    }

    private void setPrimaryStage(Stage stage) {
        Main.primaryStage = stage;
    }

    static public Stage getPrimaryStage() {
        return primaryStage;
    }


    public static void main(String[] args) {

        launch(args);
    }

}
