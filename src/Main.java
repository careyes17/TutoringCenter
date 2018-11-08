package src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage primaryStage) {
    LoginPage Login = new LoginPage(primaryStage);

  private static Stage primaryStage;

  @Override
  public void start(Stage primaryStage) throws Exception {
    setPrimaryStage(primaryStage);
    Parent root = FXMLLoader.load(getClass().getResource("settings.fxml"));
    //primaryStage.setResizable(false);
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


  public static void main(String[] args) {

    launch(args);
  }

}
