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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
        new Callback<CellDataFeatures<Schedule, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(
              CellDataFeatures<Schedule, String> param) {
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
              CellDataFeatures<Schedule, String> param) {
            return param.getValue().getValue().tutor;
          }
        });

    JFXTreeTableColumn<Schedule, String> comment = new JFXTreeTableColumn("Comment");
    comment.setPrefWidth(100);

    comment.setCellValueFactory(
        new Callback<CellDataFeatures<Schedule, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(
              CellDataFeatures<Schedule, String> param) {
            return param.getValue().getValue().comment;
          }
        });

    JFXTreeTableColumn<Schedule, String> date = new JFXTreeTableColumn("Date");
    date.setPrefWidth(100);

    date.setCellValueFactory(
        new Callback<CellDataFeatures<Schedule, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(
              CellDataFeatures<Schedule, String> param) {
            return param.getValue().getValue().date;
          }
        });

    JFXTreeTableColumn<Schedule, String> time = new JFXTreeTableColumn("Time");
    time.setPrefWidth(100);

    time.setCellValueFactory(
        new Callback<CellDataFeatures<Schedule, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(
              CellDataFeatures<Schedule, String> param) {
            return param.getValue().getValue().time;
          }
        });

    JFXTreeTableColumn<Schedule, String> location = new JFXTreeTableColumn("Location");
    location.setPrefWidth(100);

    location.setCellValueFactory(
        new Callback<CellDataFeatures<Schedule, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(
              CellDataFeatures<Schedule, String> param) {
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
    /*System.out.println(newLogin.currentUserUser.getUserEmail(0));
    System.out.println(newLogin.currentUserUser.getRole(0));
    System.out.println(newLogin.currentUserUser.getMajor(0));
    System.out.println(newLogin.currentUserUser.getProfileIcon(0));

    newLogin.currentUserUser.setUserEmail(0,"Generic Email");
    newLogin.currentUserUser.setUsername(0,"Generic Username");
    newLogin.currentUserUser.setPassword(0,"Generic Password");
    newLogin.currentUserUser.setFirstName(0,"Generic First Name");
    newLogin.currentUserUser.setLastName(0,"Generic Last Name");
    newLogin.currentUserUser.setMajor(0,"Generic Major");
    newLogin.currentUserUser.setAboutMeText(0,"Generic About Me");
    newLogin.currentUserUser.setProfileIcon(0,"Generic Location of Profile Pic");*/

    /** APPOINTMENTS FUNCTIONS Black box testing DONE SUCCESSFUL
    newLogin.currentUserUser.createAppointment(0, "Generic Subject", "Generic Tutor Name", "Generic Appointment Date", "Generic Location", "");
    System.out.println(newLogin.currentUserUser.getAppointmentDate(0,0));
    System.out.println(newLogin.currentUserUser.getAppointmentSubject(0,0));
    System.out.println(newLogin.currentUserUser.getAppointmentLocation(0,0));
    System.out.println(newLogin.currentUserUser.getAppointmentTutor(0,0));
    System.out.println(newLogin.currentUserUser.getAppointmentAttendance(0,0));

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    Date date = new Date();


    newLogin.currentUserUser.setAppointmentDate(0, 0, formatter.format(date));
    newLogin.currentUserUser.setAppointmentSubject(0,0,"OOP");
    newLogin.currentUserUser.setAppointmentAttendance(0,0,"Late");
    newLogin.currentUserUser.setAppointmentTutor(0,0,"Hunter");
    newLogin.currentUserUser.setAppointmentLocation(0,0,"Library 404");

    System.out.println(newLogin.currentUserUser.getAppointmentDate(0,0));
    System.out.println(newLogin.currentUserUser.getAppointmentSubject(0,0));
    System.out.println(newLogin.currentUserUser.getAppointmentLocation(0,0));
    System.out.println(newLogin.currentUserUser.getAppointmentTutor(0,0));
    System.out.println(newLogin.currentUserUser.getAppointmentAttendance(0,0));
    */
    /** ASSIGNMENT FUNCTIONS Black box testing DONE SUCCESSFUL
    //newLogin.currentUserUser.createAssignment(0, "Generic Assignment Name", "Generic Assignment Type", "Generic Comments", 0, 0);
    //print current assignment
    System.out.println(newLogin.currentUserUser.getAssignmentName(0,0));
    System.out.println(newLogin.currentUserUser.getAssignmentMaxPoints(0,0));
    System.out.println(newLogin.currentUserUser.getAssignmentPointsReceived(0,0));
    System.out.println(newLogin.currentUserUser.getAssignmentComments(0,0));
    System.out.println(newLogin.currentUserUser.getAssignmentType(0,0));

    //setters
    newLogin.currentUserUser.setAssignmentName(0, 0, "Generic Assignment Name 2");
    newLogin.currentUserUser.setMaxPoints(0, 0, 8);
    newLogin.currentUserUser.setPointsReceived(0, 0, 10);
    newLogin.currentUserUser.setComments(0, 0, "Generic Comment 2");
    newLogin.currentUserUser.setAssignmentType(0, 0, "Generic Assignment Type 2");

    System.out.println(newLogin.currentUserUser.getAssignmentName(0,0));
    System.out.println(newLogin.currentUserUser.getAssignmentMaxPoints(0,0));
    System.out.println(newLogin.currentUserUser.getAssignmentPointsReceived(0,0));
    System.out.println(newLogin.currentUserUser.getAssignmentComments(0,0));
    System.out.println(newLogin.currentUserUser.getAssignmentType(0,0));
    */

    //newLogin.currentUserUser.createReview(0, "Generic Tutor Name", "Generic Student Name", "Generic Comment", false, 0);
    //setters
    /*newLogin.currentUserUser.setReviewTutor(0, 0, "Generic Assignment Name");
    newLogin.currentUserUser.setReviewStudent(0, 0, 0);
    newLogin.currentUserUser.setReviewComment(0, 0, "Generic Comment");
    newLogin.currentUserUser.setReviewFlagged(0, 0, "Generic Assignment Type");
    newLogin.currentUserUser.setReviewValue(0, 0, "Generic Assignment Type");*/
    /**
     * quiz stuff

    newLogin.currentUserUser.createQuiz("Generic Question q", "Generic Answer1", "Generic Answer2", "Generic Answer3", "Generic Answer4", "Generic Answer aaa", "Generic Answer uaaa");
    System.out.println(newLogin.currentUserUser.getQuizQuestion(0, 0));
    System.out.println(newLogin.currentUserUser.getAnswerOne(0, 0));
    System.out.println(newLogin.currentUserUser.getAnswerTwo(0, 0));
    System.out.println(newLogin.currentUserUser.getAnswerThree(0, 0));
    System.out.println(newLogin.currentUserUser.getAnswerFour(0, 0));
    System.out.println(newLogin.currentUserUser.getQuestionAnswer(0, 0));
    System.out.println(newLogin.currentUserUser.getUserAnswer(0, 0));

    newLogin.currentUserUser.setQuizQuestion(0, 0, "Generic Question1");
    newLogin.currentUserUser.setAnswerOne(0, 0, "Generic Answer11"); // ????
    newLogin.currentUserUser.setAnswerTwo(0, 0, "Generic Answer22");
    newLogin.currentUserUser.setAnswerThree(0, 0, "Generic Answer33");
    newLogin.currentUserUser.setAnswerFour(0, 0, "Generic Answer44");
    newLogin.currentUserUser.setQuestionAnswer(0, 0, "Generic a");
    newLogin.currentUserUser.setUserAnswer(0, 0, "Generic a");


    System.out.println(newLogin.currentUserUser.getQuizQuestion(0, 0));
    System.out.println(newLogin.currentUserUser.getAnswerOne(0, 0));
    System.out.println(newLogin.currentUserUser.getAnswerTwo(0, 0));
    System.out.println(newLogin.currentUserUser.getAnswerThree(0, 0));
    System.out.println(newLogin.currentUserUser.getAnswerFour(0, 0));
    System.out.println(newLogin.currentUserUser.getQuestionAnswer(0, 0));
    System.out.println(newLogin.currentUserUser.getUserAnswer(0, 0));
     */

    //newLogin.currentUserUser.createLoginObject(0, new Date());
    //newLogin.currentUserUser.setLogout(0, new Date());

    /*Stage stage = Main.getPrimaryStage();
    Parent root = FXMLLoader.load(getClass().getResource("quiz.fxml"));
    stage.setScene(new Scene(root, 600, 440));
    stage.show();*/
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
    newLogin.currentUserUser.createAppointment(newLogin.getUserNumber(), subject, tutor, date, location, "");
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
  JFXComboBox profileComboBox;
  @FXML
  JFXTextArea aboutMeTextArea;
  @FXML
  JFXTextArea majorTextArea;
  @FXML
  private void updateProfile(ActionEvent event) throws IOException {
    newLogin.currentUserUser.setAboutMeText(newLogin.getUserNumber(),aboutMeTextArea.getText());
    newLogin.currentUserUser.setMajor(newLogin.getUserNumber(),aboutMeTextArea.getText());
    newLogin.currentUserUser.setRole(newLogin.getUserNumber(),profileComboBox.getValue().toString());
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

  @FXML
  public void initialize() {

    TutorPicked.getItems().setAll("Hunter", "Carlos", "Brian", "Martin");

    SubjectPicked.getItems().setAll("Biology", "Chemistry", "Math", "OOP");

    roleDropDownTwo.getItems().setAll("Biology","Chemistry","Math","OOP");

    roleDropDownOne.getItems().setAll("Hunter","Carlos","Brian","Martin");

    //this code will set the profile tab's information to be displayed automatically
    profileComboBox.getItems().setAll("Student","Tutor");
    aboutMeTextArea.setText(newLogin.currentUserUser.getaboutMeText(newLogin.getUserNumber()));
    //System.out.println(newLogin.currentUserUser.getaboutMeText(newLogin.getUserNumber()));
    majorTextArea.setText(newLogin.currentUserUser.getMajor(newLogin.getUserNumber()));
    //System.out.println(newLogin.currentUserUser.getMajor(newLogin.getUserNumber()));
    //System.out.println(newLogin.currentUserUser.getRole(newLogin.getUserNumber()));
    if( newLogin.currentUserUser.getRole(newLogin.getUserNumber()).equals("Student")){
      profileComboBox.getSelectionModel().selectFirst();
    }
    if( newLogin.currentUserUser.getRole(newLogin.getUserNumber()).equals("Tutor")){
      profileComboBox.getSelectionModel().selectLast();
    }

  }

}