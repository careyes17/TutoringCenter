package src;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ratereviewController extends Main{
  @FXML
  Label tutorValue;
  @FXML
  JFXButton RateUp;
  @FXML
  JFXButton RateDown;
  @FXML
  ComboBox roleDropDownOne;
  @FXML
  ComboBox roleDropDownTwo;
  @FXML
  JFXTextArea reviewText;


  public void initialize() {

    assert roleDropDownOne
        != null : "fx:id=\"roledropdown\" was not injected";
    roleDropDownOne.getItems().setAll("Hunter","Carlos","Brian","Martin");

    assert roleDropDownTwo
        != null : "fx:id=\"roledropdown\" was not injected";
    roleDropDownTwo.getItems().setAll("Biology","Chemistry","Math","OOP","Biology");

  }

  @FXML
  private void goToDashboard(ActionEvent event) throws IOException {
    Stage stage = Main.getPrimaryStage();

    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

    stage.setScene(new Scene(root, 600, 440));

    stage.show();
  }

  @FXML
  private void submit(ActionEvent event) throws IOException {
    if(roleDropDownOne.getValue().toString()=="Hunter"){
      if(roleDropDownTwo.getValue().toString()=="Biology"){
        tutorValue.setText("15");
        reviewText.setText("Hunter was very relaxed and taught me things from even before the semester. Very chill guy!");
      }
      else if(roleDropDownTwo.getValue().toString()=="Chemistry"){
        tutorValue.setText("15");
        reviewText.setText(" Hunter helped get me through electron diagrams like it was nothing. Very good for visual learners!");
      }
      else if(roleDropDownTwo.getValue().toString()=="Math"){
        reviewText.setText("No Reviews Yet!");
      }
      else if(roleDropDownTwo.getValue().toString()=="OOP"&& newLogin.HardCode==true){
        reviewText.setText("Test Review");
      }
      else if(roleDropDownTwo.getValue().toString()=="OOP"){
        reviewText.setText("No Reviews Yet!");
      }
      else if(roleDropDownTwo.getValue().toString()=="Biology"){
        reviewText.setText("No Reviews Yet!");
      }
    }
    if(roleDropDownOne.getValue().toString()=="Carlos"){
      if(roleDropDownTwo.getValue().toString()=="Biology"){
        reviewText.setText("No Reviews Yet!");
      }
      else if(roleDropDownTwo.getValue().toString()=="Chemistry"){
        reviewText.setText("No Reviews Yet!");
      }
      else if(roleDropDownTwo.getValue().toString()=="Math"){
        reviewText.setText("No Reviews Yet!");
      }
      else if(roleDropDownTwo.getValue().toString()=="OOP"){
        reviewText.setText("Carlos got me out of some tough spots! Helped me re-learn early concepts like recursion that I didn't understand well.");
      }
      else if(roleDropDownTwo.getValue().toString()=="Biology"){
        reviewText.setText("No Reviews Yet!");
      }
    }
    if(roleDropDownOne.getValue().toString()=="Brian"){
      if(roleDropDownTwo.getValue().toString()=="Biology"){
        reviewText.setText("No Reviews Yet!");
      }
      else if(roleDropDownTwo.getValue().toString()=="Chemistry"){
        reviewText.setText("No Reviews Yet!");
      }
      else if(roleDropDownTwo.getValue().toString()=="Math"){
        reviewText.setText("No Reviews Yet!");
      }
      else if(roleDropDownTwo.getValue().toString()=="OOP"){
        reviewText.setText("No Reviews Yet!");
      }
      else if(roleDropDownTwo.getValue().toString()=="Biology"){
        reviewText.setText("Brian was a bit slow working with me, didn't seem to completely understand what the book was talking about, but walked me through everything.");
      }
    }
    if(roleDropDownOne.getValue().toString()=="Martin"){
      if(roleDropDownTwo.getValue().toString()=="Biology"){
        reviewText.setText("No Reviews Yet!");
      }
      else if(roleDropDownTwo.getValue().toString()=="Chemistry"){
        reviewText.setText("No Reviews Yet!");
      }
      else if(roleDropDownTwo.getValue().toString()=="Math"){
        reviewText.setText("No Reviews Yet!");
      }
      else if(roleDropDownTwo.getValue().toString()=="OOP"){
        reviewText.setText("No Reviews Yet!");
      }
      else if(roleDropDownTwo.getValue().toString()=="Biology"){
        reviewText.setText("Martin was a bit slow working with me, didn't seem to completely understand what the book was talking about, but walked me through everything.");
      }
    }
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
  int temp=1;
  @FXML
  private void rateUp(ActionEvent event) throws IOException {
    this.temp--;
    String number=tutorValue.getText();
    int result = Integer.parseInt(number);
    result++;
    String newresult = Integer.toString(result);
    tutorValue.setText(newresult);
    if(temp==1){
      RateUp.visibleProperty().setValue(Boolean.TRUE);
      RateDown.visibleProperty().setValue(Boolean.TRUE);
    }
    if(temp==0){
      RateUp.visibleProperty().setValue(Boolean.FALSE);
      RateDown.visibleProperty().setValue(Boolean.TRUE);
    }
    if(temp==2){
      RateUp.visibleProperty().setValue(Boolean.FALSE);
      RateDown.visibleProperty().setValue(Boolean.TRUE);
    }
  }

  @FXML
  private void rateDown(ActionEvent event) throws IOException {
    String number=tutorValue.getText();
    int result = Integer.parseInt(number);
    result--;
    String newresult = Integer.toString(result);
    tutorValue.setText(newresult);
    this.temp++;
    if(temp==1){
      RateUp.visibleProperty().setValue(Boolean.TRUE);
      RateDown.visibleProperty().setValue(Boolean.TRUE);
    }
    if(temp==0){
      RateUp.visibleProperty().setValue(Boolean.FALSE);
      RateDown.visibleProperty().setValue(Boolean.TRUE);
    }
    if(temp==2){
      RateUp.visibleProperty().setValue(Boolean.TRUE);
      RateDown.visibleProperty().setValue(Boolean.FALSE);

    }
  }

}
