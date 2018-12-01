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
  public TabPane tabpane;

  @FXML
  private Tab dashboard;

  @FXML
  private Tab settings;

  @FXML
  private Tab calendar;

  @FXML
  private Tab quizzes;

  @FXML
  public Tab schedule;

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

  //Sets hover over element to display grade for class 1
  Label class1Label = new Label("Grade: 100%");
  VBox vbox = new VBox(class1Label);
  PopOver popOver = new PopOver(vbox);

  //Sets hover over element to display grade for class 2
  Label class2Label = new Label("Grade: 100%");
  VBox vbox2 = new VBox(class2Label);
  PopOver popOver2 = new PopOver(vbox2);

  //Sets hover over element to display grade for class 3
  Label class3Label = new Label("Grade: 100%");
  VBox vbox3 = new VBox(class3Label);
  PopOver popOver3 = new PopOver(vbox3);


  /**
   * Display class 1 grades element on hover
   */
  @FXML
  void class1Hover(MouseEvent event) throws Exception {
    vbox.setPrefHeight(45);
    vbox.setPrefWidth(75);
    class1Label.setWrapText(true);
    vbox.setStyle("-fx-background-color: #ffccbb;" + "-fx-alignment: CENTER");
    popOver.show(class1);
  }

  /**
   * Hides grades upon leaving hover element
   */
  @FXML
  void class1Exit(MouseEvent event) throws Exception {
    popOver.hide();
  }

  /**
   * Display class 2 grades element on hover
   */
  @FXML
  void class2Hover(MouseEvent event) throws Exception {
    vbox2.setPrefHeight(45);
    vbox2.setPrefWidth(75);
    class2Label.setWrapText(true);
    vbox2.setStyle("-fx-background-color: #6eb5c0;" + "-fx-alignment: CENTER");
    popOver2.show(class2);
  }

  /**
   * Hides grades upon leaving hover element
   */
  @FXML
  void class2Exit(MouseEvent event) throws Exception {
    popOver2.hide();
  }

  /**
   * Display class 3 grades element on hover
   */
  @FXML
  void class3Hover(MouseEvent event) throws Exception {
    vbox3.setPrefHeight(45);
    vbox3.setPrefWidth(75);
    class3Label.setWrapText(true);
    vbox3.setStyle("-fx-background-color: #006c84;" + "-fx-alignment: CENTER");
    popOver3.show(class3);
  }

  /**
   * Hides grades upon leaving hover element
   */
  @FXML
  void class3Exit(MouseEvent event) throws Exception {
    popOver3.hide();
  }

  /******************************************
   * DASHBOARD METHODS
   ******************************************/

  /**
   * Goes to appointment scheduler
   */
  @FXML
  private void goToScheduleTutoringCenter(ActionEvent event) throws IOException {
    SingleSelectionModel<Tab> selectionModel = tabpane.getSelectionModel();
    selectionModel.select(schedule);
  }

  /**
   * Goes to grades and attendance graph representation
   */
  @FXML
  private void goToGradesAttendance(ActionEvent event) throws IOException {
    Stage stage = Main.getPrimaryStage();

    Parent root = FXMLLoader.load(getClass().getResource("grades.fxml"));

    stage.setScene(new Scene(root, 600, 440));

    stage.show();
  }

  /**
   * Goes to appointment scheduler
   */
  @FXML
  private void goToReviewTutorsDashboard(ActionEvent event) throws IOException {
    SingleSelectionModel<Tab> selectionModel = tabpane.getSelectionModel();
    selectionModel.select(reviewTutors);
  }

  /**
   * Goes to user profile page
   */
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


  /**
   * Updates appointments scheduled by user
   */
  @FXML
  private void updateAssignments(ActionEvent event) throws IOException {

    // Adds "Subject" column
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

    // Adds "Tutor" column
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

    // Adds "Comment" column
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

    // Adds "Date" column
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

    // Adds "Time" column
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

    // Adds "Location" column
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

    // Adds default events to the schedule list
    ObservableList<Schedule> Schedule = FXCollections.observableArrayList();
    Schedule
        .add(new Schedule("Calculus 2", "Carlos", "Integrals", "11/28/18", "3:00", "Library 203"));
    Schedule.add(
        new Schedule("Calculus 1", "Hunter", "Derivatives", "11/28/18", "4:00", "Library 204"));
    Schedule
        .add(new Schedule("Physics", "Brian", "2D movement", "12/03/18", "5:30", "Library 205"));
    Schedule.add(new Schedule("Software", "Martin", "Loops", "12/04/18", "15:00", "Library 206"));

    // Temporary variables for dynamic appending to the ObservableList "Schedule" for archived appointments
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

  // Class containing appointment elements
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

  /**
   * Goes to Class 1 Quiz
   */
  @FXML
  private void goToClass1Quiz(ActionEvent event) throws IOException {
    Stage stage = Main.getPrimaryStage();
    Parent root = FXMLLoader.load(getClass().getResource("quiz.fxml"));
    stage.setScene(new Scene(root, 600, 440));
    stage.show();
  }

  /**
   * Goes to Class 2 Quiz
   */
  @FXML
  private void goToClass2Quiz(ActionEvent event) throws IOException {
    Stage stage = Main.getPrimaryStage();
    Parent root = FXMLLoader.load(getClass().getResource("quiz.fxml"));
    stage.setScene(new Scene(root, 600, 440));
    stage.show();
  }

  /**
   * Goes to Class 3 Quiz
   */
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

  /**
   * Executes default code for tutor review submission
   */
  @FXML
  private void submitTutorReview(ActionEvent event) throws IOException {
    System.out.println(newLogin.HardCode.toString());
    newLogin.HardCode = true;
    System.out.println(newLogin.HardCode.toString());
  }

  /**
   * Goes to tutor reviews
   */
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

  // Temporary ObservableList containing archived appointments to be appended in update in updateAssignments()
  ObservableList<Schedule> temporary = FXCollections.observableArrayList();

  /**
   * Takes information from appointment scheduler form and appends the appointment list
   */
  @FXML
  private void scheduleTutor(ActionEvent event) throws IOException {
    String subject = SubjectPicked.getValue().toString();
    String tutor = TutorPicked.getValue().toString();
    String comment = Comment.getText();
    String date = DatePicked.getValue().toString();
    String time = TimePicked.getValue().toString();
    String location = Location.getText();
    temporary.add(new Schedule(subject, tutor, comment, date, time, location));
    newLogin.currentUserUser
        .createAppointment(newLogin.getUserNumber(), subject, tutor, date, location, "");
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

  /**
   * Updates user email
   */
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

  /**
   * Updates user username
   */
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

  /**
   * Updates user password
   */
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

  /**
   * Updates all of the user set profile elements
   */
  @FXML
  private void updateProfile(ActionEvent event) throws IOException {
    newLogin.currentUserUser.setAboutMeText(newLogin.getUserNumber(), aboutMeTextArea.getText());
    newLogin.currentUserUser.setMajor(newLogin.getUserNumber(), aboutMeTextArea.getText());
    newLogin.currentUserUser
        .setRole(newLogin.getUserNumber(), profileComboBox.getValue().toString());
  }

  /**
   * Updates user's profile icon
   */
  @FXML
  private void updateProfileIcon(ActionEvent event) throws IOException {
    /*
     * ENTER FUNCTIONALITY
     * */

  }

  /**
   * Logs user out of the Tutoring Center application
   */
  @FXML
  private void logout(ActionEvent event) throws IOException {
        /*login system needs to search for the last JSON OBJECT before implementation
        System.out.println("attempting email update");
        //creates new date object
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        newLogin.currentUserUser.setLogout(newLogin.getUserNumber(), date);
        */

        /*
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        newLogin.currentUserUser.setLogout(0, formatter.format(date));
        */

    Stage stage = Main.getPrimaryStage();
    Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
    stage.setScene(new Scene(root, 600, 440));
    stage.show();
  }

  /**
   * Executes default code when dashboard is called
   */
  @FXML
  public void initialize() {
    //while(newLogin.currentUserUser.getTotalNumberOfAccounts()){}
    for(int i=0;i<=newLogin.currentUserUser.getTotalNumberOfAccounts()-1;i++){
      String role = newLogin.currentUserUser.getRole(i);
      String tutorName=newLogin.currentUserUser.getFirstName(i);
      if(role.equals("Tutor")){
        //need to add tutors to an array of strings
        //System.out.println("adding");
        TutorPicked.getItems().addAll(tutorName);
        roleDropDownOne.getItems().addAll(tutorName);
      }
    }
    SubjectPicked.getItems().setAll("Biology", "Chemistry", "Math", "OOP");
    roleDropDownTwo.getItems().setAll("Biology", "Chemistry", "Math", "OOP");

    emailTextField.setText(newLogin.currentUserUser.getUserEmail(newLogin.getUserNumber()));
    usernameTextField.setText(newLogin.currentUserUser.getUsername(newLogin.getUserNumber()));
    passwordTextField.setText(newLogin.currentUserUser.getPassword(newLogin.getUserNumber()));
    aboutMeTextArea.setText(newLogin.currentUserUser.getaboutMeText(newLogin.getUserNumber()));
    majorTextArea.setText(newLogin.currentUserUser.getMajor(newLogin.getUserNumber()));
    //this code will set the profile tab's information to be displayed automatically
    profileComboBox.getItems().setAll("Student", "Tutor");
    if (newLogin.currentUserUser.getRole(newLogin.getUserNumber()).equals("Student")) {
      profileComboBox.getSelectionModel().selectFirst();
    }
    if (newLogin.currentUserUser.getRole(newLogin.getUserNumber()).equals("Tutor")) {
      profileComboBox.getSelectionModel().selectLast();
    }
  }

  /******************************************
   * TUTOR ASSIGNMENT METHODS
   ******************************************/

  @FXML
  JFXTreeTableView<Assignment> tableTutor;


  /**
   * Updates assignments scheduled by user
   */
  @FXML
  private void updateAssignmentsTutor(ActionEvent event) throws IOException {

    JFXTreeTableColumn<Assignment, String> assignmentName = new JFXTreeTableColumn("Assign. Name");
    assignmentName.setPrefWidth(100);

    assignmentName.setCellValueFactory(
        new Callback<CellDataFeatures<Assignment, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(
              CellDataFeatures<Assignment, String> param) {
            return param.getValue().getValue().assignmentName;
          }
        });

    JFXTreeTableColumn<Assignment, String> datePicked = new JFXTreeTableColumn("Due Date");
    datePicked.setPrefWidth(100);

    datePicked.setCellValueFactory(
        new Callback<CellDataFeatures<Assignment, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(
              CellDataFeatures<Assignment, String> param) {
            return param.getValue().getValue().datePicked;
          }
        });

    JFXTreeTableColumn<Assignment, String> timePicked = new JFXTreeTableColumn("Time Due");
    timePicked.setPrefWidth(100);

    timePicked.setCellValueFactory(
        new Callback<CellDataFeatures<Assignment, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(
              CellDataFeatures<Assignment, String> param) {
            return param.getValue().getValue().timePicked;
          }
        });

    JFXTreeTableColumn<Assignment, String> Comments = new JFXTreeTableColumn("Comments");
    Comments.setPrefWidth(100);

    Comments.setCellValueFactory(
        new Callback<CellDataFeatures<Assignment, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(
              CellDataFeatures<Assignment, String> param) {
            return param.getValue().getValue().Comments;
          }
        });

    JFXTreeTableColumn<Assignment, String> pointsReceived = new JFXTreeTableColumn("Points Received");
    pointsReceived.setPrefWidth(100);

    pointsReceived.setCellValueFactory(
        new Callback<CellDataFeatures<Assignment, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(
              CellDataFeatures<Assignment, String> param) {
            return param.getValue().getValue().pointsReceived;
          }
        });

    JFXTreeTableColumn<Assignment, String> maxPoints = new JFXTreeTableColumn("Max Received");
    maxPoints.setPrefWidth(100);

    maxPoints.setCellValueFactory(
        new Callback<CellDataFeatures<Assignment, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(
              CellDataFeatures<Assignment, String> param) {
            return param.getValue().getValue().maxPoints;
          }
        });

    JFXTreeTableColumn<Assignment, String> assignmentType = new JFXTreeTableColumn("Assign. Type");
    assignmentType.setPrefWidth(100);

    assignmentType.setCellValueFactory(
        new Callback<CellDataFeatures<Assignment, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(
              CellDataFeatures<Assignment, String> param) {
            return param.getValue().getValue().assignmentType;
          }
        });

    JFXTreeTableColumn<Assignment, String> selectedStudent = new JFXTreeTableColumn("Student");
    selectedStudent.setPrefWidth(100);

    selectedStudent.setCellValueFactory(
        new Callback<CellDataFeatures<Assignment, String>, ObservableValue<String>>() {

          @Override
          public ObservableValue<String> call(
              CellDataFeatures<Assignment, String> param) {
            return param.getValue().getValue().selectedStudent;
          }
        });

    ObservableList<Assignment> assignment = FXCollections.observableArrayList();
    assignment
        .add(new Assignment("Read Ch5", "100", "", "30 mins", "11/1/18", "23:59", "Reading", "Brian"));
    assignment.add(
        new Assignment("Read Ch6", "100", "", "30 mins", "11/5/18", "23:59", "Reading", "Brian"));
    assignment
        .add(new Assignment("Read Ch7", "100", "", "30 mins", "11/9/18", "23:59", "Reading", "Brian"));
    assignment.add(new Assignment("Read Ch8", "100", "", "30 mins", "11/13/18", "23:59", "Reading", "Brian"));

    // Temporary variables for dynamic appending to the ObservableList "Schedule" for archived appointments
    int temporarySize = temporary2.size();

    for (int i = 0; i < temporarySize; i++) {
      assignment.add(temporary2.get(i));
    }

    final TreeItem<Assignment> root = new RecursiveTreeItem<Assignment>(assignment,
        RecursiveTreeObject::getChildren);
    tableTutor.getColumns().setAll(assignmentName, maxPoints, pointsReceived, Comments, datePicked, timePicked, assignmentType, selectedStudent);
    tableTutor.setRoot(root);
    tableTutor.setShowRoot(false);
  }

  // Temporary ObservableList containing archived appointments to be appended in update in updateAssignments()
  ObservableList<Assignment> temporary2 = FXCollections.observableArrayList();

  /**
   *
   */
  @FXML
  private void removeAssignment(ActionEvent event) throws IOException {

  }

  /**
   *
   */
  @FXML
  private void createAssignment(ActionEvent event) throws IOException {
    Stage stage = Main.getPrimaryStage();
    Parent root = FXMLLoader.load(getClass().getResource("createAssignment.fxml"));
    stage.setScene(new Scene(root, 600, 440));
    stage.show();
  }

}

// Class containing appointment elements
class Assignment extends RecursiveTreeObject<Assignment> {

  StringProperty assignmentName;
  StringProperty maxPoints;
  StringProperty pointsReceived;
  StringProperty Comments;
  StringProperty datePicked;
  StringProperty timePicked;
  StringProperty assignmentType;
  StringProperty selectedStudent;

  public Assignment(String assignmentName, String maxPoints, String pointsReceived, String Comments, String datePicked,
      String timePicked, String assignmentType, String selectedStudent) {
    this.assignmentName = new SimpleStringProperty(assignmentName);
    this.maxPoints = new SimpleStringProperty(maxPoints);
    this.pointsReceived = new SimpleStringProperty(pointsReceived);
    this.Comments = new SimpleStringProperty(Comments);
    this.datePicked = new SimpleStringProperty(datePicked);
    this.timePicked = new SimpleStringProperty(timePicked);
    this.assignmentType = new SimpleStringProperty(assignmentType);
    this.selectedStudent = new SimpleStringProperty(selectedStudent);
  }


}