package src;


import com.jfoenix.controls.JFXBadge;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.PopOver;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class dashboardController extends Main {

  @FXML
  private TabPane tabpane;

  @FXML
  private Tab dashboard;

  @FXML
  private Tab settings;

  @FXML
  private Tab calendar;

  @FXML
  private Tab quizzes;

  @FXML
  private Tab schedule;

  @FXML
  private Tab reviewTutors;

  @FXML
  private Tab profile;

  @FXML
  JFXBadge class1 = new JFXBadge();

  @FXML
  JFXBadge class2 = new JFXBadge();

  @FXML
  JFXBadge class3 = new JFXBadge();

  Label class1Label = new Label("Grade: 100%");
  VBox vbox = new VBox(class1Label);
  PopOver popOver = new PopOver(vbox);

  Label class2Label = new Label("Grade: 100%");
  VBox vbox2 = new VBox(class2Label);
  PopOver popOver2 = new PopOver(vbox2);

  Label class3Label = new Label("Grade: 100%");
  VBox vbox3 = new VBox(class3Label);
  PopOver popOver3 = new PopOver(vbox3);


  @FXML
  void class1Hover(MouseEvent event) throws Exception {
    vbox.setPrefHeight(45);
    vbox.setPrefWidth(75);
    class1Label.setWrapText(true);
    vbox.setStyle("-fx-background-color: #ffccbb;" + "-fx-alignment: CENTER");
    popOver.show(class1);
  }

  @FXML
  void class1Exit(MouseEvent event) throws Exception {
    popOver.hide();
  }

  @FXML
  void class2Hover(MouseEvent event) throws Exception {
    vbox2.setPrefHeight(45);
    vbox2.setPrefWidth(75);
    class2Label.setWrapText(true);
    vbox2.setStyle("-fx-background-color: #6eb5c0;" + "-fx-alignment: CENTER");
    popOver2.show(class2);
  }

  @FXML
  void class2Exit(MouseEvent event) throws Exception {
    popOver2.hide();
  }

  @FXML
  void class3Hover(MouseEvent event) throws Exception {
    vbox3.setPrefHeight(45);
    vbox3.setPrefWidth(75);
    class3Label.setWrapText(true);
    vbox3.setStyle("-fx-background-color: #006c84;" + "-fx-alignment: CENTER");
    popOver3.show(class3);
  }

  @FXML
  void class3Exit(MouseEvent event) throws Exception {
    popOver3.hide();
  }

  /******************************************
   * DASHBOARD METHODS
   ******************************************/

  @FXML
  private void goToScheduleTutoringCenter(ActionEvent event) throws IOException {
    SingleSelectionModel<Tab> selectionModel = tabpane.getSelectionModel();
    selectionModel.select(schedule);
  }

  @FXML
  private void goToGradesAttendance(ActionEvent event) throws IOException {
    Stage stage = Main.getPrimaryStage();

    Parent root = FXMLLoader.load(getClass().getResource("grades.fxml"));

    stage.setScene(new Scene(root, 600, 440));

    stage.show();
  }

  @FXML
  private void goToReviewTutorsDashboard(ActionEvent event) throws IOException {
    SingleSelectionModel<Tab> selectionModel = tabpane.getSelectionModel();
    selectionModel.select(reviewTutors);
  }

  @FXML
  private void goToProfile(ActionEvent event) throws IOException {
    SingleSelectionModel<Tab> selectionModel = tabpane.getSelectionModel();
    selectionModel.select(profile);
  }

  /******************************************
   * QUIZ METHODS
   ******************************************/

  @FXML
  private void goToClass1Quiz(ActionEvent event) throws IOException {
    Stage stage = Main.getPrimaryStage();
    Parent root = FXMLLoader.load(getClass().getResource("quiz.fxml"));
    stage.setScene(new Scene(root, 600, 440));
    stage.show();
  }

  @FXML
  private void goToClass2Quiz(ActionEvent event) throws IOException {
    Stage stage = Main.getPrimaryStage();
    Parent root = FXMLLoader.load(getClass().getResource("quiz.fxml"));
    stage.setScene(new Scene(root, 600, 440));
    stage.show();
  }

  @FXML
  private void goToClass3Quiz(ActionEvent event) throws IOException {
    Stage stage = Main.getPrimaryStage();
    Parent root = FXMLLoader.load(getClass().getResource("quiz.fxml"));
    stage.setScene(new Scene(root, 600, 440));
    stage.show();
  }

  /******************************************
   * TUTOR REVIEW METHODS
   ******************************************/

  @FXML
  private void submitTutorReview(ActionEvent event) throws IOException {
    /*
     * ENTER FUNCTIONALITY
     * */
  }

  @FXML
  private void goToTutorReviews(ActionEvent event) throws IOException {
    Stage stage = Main.getPrimaryStage();
    Parent root = FXMLLoader.load(getClass().getResource("ratereview.fxml"));
    stage.setScene(new Scene(root, 600, 440));
    stage.show();
  }

  /******************************************
   * SCHEDULE TUTORING METHODS
   ******************************************/

  @FXML
  private void scheduleTutor(ActionEvent event) throws IOException {
    /*
     * ENTER FUNCTIONALITY
     * */
  }

  /******************************************
   * SETTINGS
   ******************************************/

  //SETTINGS FXML ELEMENTS
  @FXML
  TextField emailTextField;
  @FXML
  TextField usernameTextField;
  @FXML
  PasswordField passwordTextField;

  //SETTINGS METHODS
  @FXML
  private void updateEmail(ActionEvent event) throws IOException {
    System.out.println("attempting email update");
    try {
      String newEmail = emailTextField.getText();   //grabs the new email value
      newLogin.currentUserUser.setUserEmail(newLogin.getUserNumber(), newEmail);
      System.out.println("email updated");

    } catch (Exception e) {
      System.out.println("email update failed");
      System.out.println(e);
    }
  }

  @FXML
  private void updateUsername(ActionEvent event) throws IOException {
    System.out.println("attempting username update");
    try {
      String newUsername = usernameTextField.getText();
      newLogin.currentUserUser.setUsername(newLogin.getUserNumber(), newUsername);
      System.out.println("username updated");

    } catch (Exception e) {
      System.out.println("username update failed");
      System.out.println(e);
    }
  }

  @FXML
  private void updatePassword(ActionEvent event) throws IOException {
    System.out.println("attempting password update");
    try {
      String newUsername = passwordTextField.getText();
      newLogin.currentUserUser.setPassword(newLogin.getUserNumber(), newUsername);
      System.out.println("password updated");

    } catch (Exception e) {
      System.out.println("password update failed");
      System.out.println(e);
    }
  }

  /******************************************
   * PROFILE METHODS
   ******************************************/

  @FXML
  private void updateProfile(ActionEvent event) throws IOException {
    /*
     * ENTER FUNCTIONALITY
     * */
  }

  @FXML
  private void updateProfileIcon(ActionEvent event) throws IOException {
    /*
     * ENTER FUNCTIONALITY
     * */
  }

  @FXML
  private void logout(ActionEvent event) throws IOException {
        /*login system needs to search for the last JSON OBJECT before implementation
        System.out.println("attempting email update");
        //creates new date object
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        newLogin.currentUserUser.setLogout(newLogin.getUserNumber(), date);
        */
    Stage stage = Main.getPrimaryStage();
    Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
    stage.setScene(new Scene(root, 600, 440));
    stage.show();
  }

}