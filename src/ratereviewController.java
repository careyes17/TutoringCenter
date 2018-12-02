package src;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ratereviewController extends Main {
  //reviews position acts similar to a pointer
  static int userAccountPointer;
  static int reviewAccountPointer;

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
    //need to populate the total number of tutors to the reviews drop down.
    //need to loop through the users to find the number of tutors
    for(int i=0;i<=newLogin.currentUserUser.getTotalNumberOfAccounts()-1;i++){
      String role = newLogin.currentUserUser.getRole(i);
      String tutorName=newLogin.currentUserUser.getFirstName(i);
      if(role.equals("Tutor")){
        //need to add tutors to an array of strings
        //System.out.println("adding");
        try{roleDropDownOne.getItems().add(tutorName);
        }catch(Exception e){
          System.out.println("nullpointerpresent");

        }
      }
    }


    //then need to add the strings to the drop down
    //Static number of subjects for the tutoring center
    try {
      assert roleDropDownTwo
          != null : "fx:id=\"roledropdown\" was not injected";
      roleDropDownTwo.getItems().setAll("Biology", "Chemistry", "Math", "OOP");
    }catch(Exception e){
      System.out.println("nullpointerpresent");
    }
    /*assert roleDropDownOne
        != null : "fx:id=\"roledropdown\" was not injected";
    roleDropDownOne.getItems().setAll("Hunter","Carlos","Brian","Martin");*/


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
    System.out.println("submit pressed");
    System.out.println("NumberOfAccounts "+newLogin.currentUserUser.getTotalNumberOfAccounts());
    //need to loop through all accounts reviews and find the first review that matches the tutor
    for(int i=0;i<=newLogin.currentUserUser.getTotalNumberOfAccounts()-1;i++){
      //i is the number of the current account in use
      for(int j=0;j<=newLogin.currentUserUser.getNumberOfReview(i)-1;j++){
        System.out.println("NumberOfReviews "+newLogin.currentUserUser.getNumberOfReview(i));
        //j is the number of specific review
        System.out.println("DropDown value T "+roleDropDownOne.getValue().toString());
        System.out.println("Review value T "+newLogin.currentUserUser.getReviewTutor(i,j));

        if(newLogin.currentUserUser.getReviewTutor(i,j).equals(roleDropDownOne.getValue().toString())){
          System.out.println("DropDown2 value S "+roleDropDownTwo.getValue().toString());
          System.out.println("Review value S "+newLogin.currentUserUser.getReviewSubject(i,j));
          if(newLogin.currentUserUser.getReviewSubject(i,j).equals(roleDropDownTwo.getValue().toString())){
            if(newLogin.currentUserUser.getReviewFlagged(i,j)==false) {
              reviewText.setText(newLogin.currentUserUser.getReviewComment(i, j));
              tutorValue.setText(newLogin.currentUserUser.getReviewValue(i, j));
              userAccountPointer = i;
              reviewAccountPointer = j;
              System.out.println("end of sumbit");
              System.out.println(userAccountPointer);
              System.out.println(reviewAccountPointer);
              break;
            }
          }
        }
      }
    }
  }

  @FXML
  private void nextReview(ActionEvent event) throws IOException {
    boolean success=false;
    reviewAccountPointer++;
    //need to loop through all accounts reviews and find the first review that matches the tutor
    while(userAccountPointer<newLogin.currentUserUser.getTotalNumberOfAccounts()){
      //i is the number of the current account in use
      while(reviewAccountPointer<=newLogin.currentUserUser.getNumberOfReview(userAccountPointer)){
        //j is the number of specific review
        if(newLogin.currentUserUser.getReviewTutor(userAccountPointer,reviewAccountPointer).equals(roleDropDownOne.getValue().toString())){
          if(newLogin.currentUserUser.getReviewSubject(userAccountPointer,reviewAccountPointer).equals(roleDropDownTwo.getValue().toString())){
            if(newLogin.currentUserUser.getReviewFlagged(userAccountPointer,reviewAccountPointer)==false) {
              reviewText.setText(newLogin.currentUserUser
                  .getReviewComment(userAccountPointer, reviewAccountPointer));
              tutorValue.setText(newLogin.currentUserUser
                  .getReviewValue(userAccountPointer, reviewAccountPointer));
              success = true;
              break;
            }
          }
        }
        reviewAccountPointer++;
      }
      if(success==true){
        break;
      }
      userAccountPointer++;
    }
  }

  @FXML
  private void report(ActionEvent event) throws IOException {
    Stage stage = Main.getPrimaryStage();

    Parent root = FXMLLoader.load(getClass().getResource("reportreview.fxml"));

    stage.setScene(new Scene(root, 600, 440));

    stage.show();
  }

  int temp = 1;

  @FXML
  private void rateUp(ActionEvent event) throws IOException {
    Integer reviewValueBefore = Integer.parseInt(newLogin.currentUserUser.getReviewValue(userAccountPointer,reviewAccountPointer));
    reviewValueBefore++;
    String reviewValueAfter = Integer.toString(reviewValueBefore);
    newLogin.currentUserUser.setReviewValue(userAccountPointer,reviewAccountPointer,reviewValueAfter);
    tutorValue.setText(newLogin.currentUserUser.getReviewValue(userAccountPointer,reviewAccountPointer));

    this.temp--;
    /*String number = tutorValue.getText();
    int result = Integer.parseInt(number);
    result++;
    String newresult = Integer.toString(result);
    tutorValue.setText(newresult);*/
    if (temp == 1) {
      RateUp.visibleProperty().setValue(Boolean.TRUE);
      RateDown.visibleProperty().setValue(Boolean.TRUE);
    }
    if (temp == 0) {
      RateUp.visibleProperty().setValue(Boolean.FALSE);
      RateDown.visibleProperty().setValue(Boolean.TRUE);
    }
    if (temp == 2) {
      RateUp.visibleProperty().setValue(Boolean.FALSE);
      RateDown.visibleProperty().setValue(Boolean.TRUE);
    }
  }

  @FXML
  private void rateDown(ActionEvent event) throws IOException {
    Integer reviewValueBefore = Integer.parseInt(newLogin.currentUserUser.getReviewValue(userAccountPointer,reviewAccountPointer));
    reviewValueBefore--;
    String reviewValueAfter = Integer.toString(reviewValueBefore);
    newLogin.currentUserUser.setReviewValue(userAccountPointer,reviewAccountPointer,reviewValueAfter);
    tutorValue.setText(newLogin.currentUserUser.getReviewValue(userAccountPointer,reviewAccountPointer));
    this.temp++;
    if (temp == 1) {
      RateUp.visibleProperty().setValue(Boolean.TRUE);
      RateDown.visibleProperty().setValue(Boolean.TRUE);
    }
    if (temp == 0) {
      RateUp.visibleProperty().setValue(Boolean.FALSE);
      RateDown.visibleProperty().setValue(Boolean.TRUE);
    }
    if (temp == 2) {
      RateUp.visibleProperty().setValue(Boolean.TRUE);
      RateDown.visibleProperty().setValue(Boolean.FALSE);

    }
  }

}