package src;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ratereviewController {

  @FXML
  private void goToDashboard(ActionEvent event) throws IOException {
    Stage stage = Main.getPrimaryStage();

    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

    stage.setScene(new Scene(root, 600, 440));

    stage.show();
  }

  @FXML
  private void submit(ActionEvent event) throws IOException {
    /*
     * ENTER FUNCTIONALITY
     * */
  }

  @FXML
  private void nextReview(ActionEvent event) throws IOException {
    /*
     * ENTER FUNCTIONALITY
     * */
  }

  @FXML
  private void report(ActionEvent event) throws IOException {
    Stage stage = Main.getPrimaryStage();

    Parent root = FXMLLoader.load(getClass().getResource("reportreview.fxml"));

    stage.setScene(new Scene(root, 600, 440));

    stage.show();
  }

  @FXML
  private void rateUp(ActionEvent event) throws IOException {
    /*
     * ENTER FUNCTIONALITY
     * */
  }

  @FXML
  private void rateDown(ActionEvent event) throws IOException {
    /*
     * ENTER FUNCTIONALITY
     * */
  }

}
