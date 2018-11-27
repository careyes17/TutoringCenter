package src;


import com.jfoenix.controls.JFXBadge;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTimePicker;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
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
  ComboBox roleDropDownOne;

  @FXML
  ComboBox roleDropDownTwo;

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
   * ASSIGNMENT LISTING METHODS
   ******************************************/

  @FXML
  JFXTreeTableView<Schedule> table;


  @FXML
  private void updateAssignments(ActionEvent event) throws IOException {

    JFXTreeTableColumn<Schedule, String> subject = new JFXTreeTableColumn("Subject");
    subject.setPrefWidth(100);

    subject.setCellValueFactory(
        new Callback<TreeTableColumn.CellDataFeatures<Schedule, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(
              TreeTableColumn.CellDataFeatures<Schedule, String> param) {
            return param.getValue().getValue().subject;
          }
        });

    //subject, tutor, comment, date, time, location

    JFXTreeTableColumn<Schedule, String> tutor = new JFXTreeTableColumn("Tutor");
    tutor.setPrefWidth(100);

    tutor.setCellValueFactory(
        new Callback<CellDataFeatures<Schedule, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(
              TreeTableColumn.CellDataFeatures<Schedule, String> param) {
            return param.getValue().getValue().tutor;
          }
        });

    JFXTreeTableColumn<Schedule, String> comment = new JFXTreeTableColumn("Comment");
    comment.setPrefWidth(100);

    comment.setCellValueFactory(
        new Callback<TreeTableColumn.CellDataFeatures<Schedule, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(
              TreeTableColumn.CellDataFeatures<Schedule, String> param) {
            return param.getValue().getValue().comment;
          }
        });

    JFXTreeTableColumn<Schedule, String> date = new JFXTreeTableColumn("Date");
    date.setPrefWidth(100);

    date.setCellValueFactory(
        new Callback<TreeTableColumn.CellDataFeatures<Schedule, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(
              TreeTableColumn.CellDataFeatures<Schedule, String> param) {
            return param.getValue().getValue().date;
          }
        });

    JFXTreeTableColumn<Schedule, String> time = new JFXTreeTableColumn("Time");
    time.setPrefWidth(100);

    time.setCellValueFactory(
        new Callback<TreeTableColumn.CellDataFeatures<Schedule, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(
              TreeTableColumn.CellDataFeatures<Schedule, String> param) {
            return param.getValue().getValue().time;
          }
        });

    JFXTreeTableColumn<Schedule, String> location = new JFXTreeTableColumn("Location");
    location.setPrefWidth(100);

    location.setCellValueFactory(
        new Callback<TreeTableColumn.CellDataFeatures<Schedule, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(
              TreeTableColumn.CellDataFeatures<Schedule, String> param) {
            return param.getValue().getValue().location;
          }
        });

    ObservableList<Schedule> Schedule = FXCollections.observableArrayList();
    Schedule
        .add(new Schedule("Calculus 2", "Carlos", "Integrals", "11/28/18", "3:00", "Library 203"));
    Schedule.add(
        new Schedule("Calculus 1", "Hunter", "Derivatives", "11/28/18", "4:00", "Library 204"));
    Schedule
        .add(new Schedule("Physics", "Brian", "2D movement", "12/03/18", "5:30", "Library 205"));
    Schedule.add(new Schedule("Software", "Martin", "Loops", "12/04/18", "15:00", "Library 206"));

    int temporarySize = temporary.size();

    for (int i = 0; i < temporarySize; i++) {
      Schedule.add(temporary.get(i));
    }

    final TreeItem<Schedule> root = new RecursiveTreeItem<Schedule>(Schedule,
        RecursiveTreeObject::getChildren);
    table.getColumns().setAll(subject, tutor, comment, date, time, location);
    table.setRoot(root);
    table.setShowRoot(false);
  }

  class Schedule extends RecursiveTreeObject<Schedule> {

    StringProperty subject;
    StringProperty tutor;
    StringProperty comment;
    StringProperty date;
    StringProperty time;
    StringProperty location;

    public Schedule(String subject, String tutor, String comment, String date, String time,
        String location) {
      this.subject = new SimpleStringProperty(subject);
      this.tutor = new SimpleStringProperty(tutor);
      this.comment = new SimpleStringProperty(comment);
      this.date = new SimpleStringProperty(date);
      this.time = new SimpleStringProperty(time);
      this.location = new SimpleStringProperty(location);
    }


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
    System.out.println(newLogin.HardCode.toString());
    newLogin.HardCode = true;
    System.out.println(newLogin.HardCode.toString());
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
  public void initialize() {

    TutorPicked.getItems().setAll("Hunter", "Carlos", "Brian", "Martin");

    SubjectPicked.getItems().setAll("Biology", "Chemistry", "Math", "OOP");

    roleDropDownTwo.getItems().setAll("Biology","Chemistry","Math","OOP");

    roleDropDownOne.getItems().setAll("Hunter","Carlos","Brian","Martin");


  }

  @FXML
  JFXTextArea Comment;
  @FXML
  JFXComboBox TutorPicked;
  @FXML
  JFXComboBox SubjectPicked;
  @FXML
  JFXDatePicker DatePicked;
  @FXML
  JFXTimePicker TimePicked;
  @FXML
  JFXTextArea Location;

  ObservableList<Schedule> temporary = FXCollections.observableArrayList();

  @FXML
  private void scheduleTutor(ActionEvent event) throws IOException {
    String subject = SubjectPicked.getValue().toString();
    String tutor = TutorPicked.getValue().toString();
    String comment = Comment.getText();
    String date = DatePicked.getValue().toString();
    String time = TimePicked.getValue().toString();
    String location = Location.getText();
    temporary.add(new Schedule(subject, tutor, comment, date, time, location));
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