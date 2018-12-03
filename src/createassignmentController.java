package src;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTimePicker;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

public class createassignmentController extends Main {

  @FXML
  JFXDatePicker datepicked;

  @FXML
  JFXTimePicker timepicked;

  @FXML
  JFXTextArea assignmentname;

  @FXML
  JFXTextArea maxpoints;

  @FXML
  JFXTextArea pointsreceived;

  @FXML
  JFXTextArea assignmenttype;

  @FXML
  JFXTextArea comments;

  @FXML
  JFXComboBox selectedstudent;

  /**
   *
   */
  @FXML
  private void createAssignment(ActionEvent event) throws IOException {
    //Pull from fields
    //Write to JSONDATA.txt
    newLogin.currentUserUser.createAssignment(newLogin.getUserNumber()
        , newLogin.currentUserUser.getAssignmentName(newLogin.getUserNumber(), 4)
        , newLogin.currentUserUser.getAssignmentType(newLogin.getUserNumber(), 4)
        , newLogin.currentUserUser.getAssignmentComments(newLogin.getUserNumber(), 4)
        , newLogin.currentUserUser.getAssignmentMaxPoints(newLogin.getUserNumber(), 4)
        , newLogin.currentUserUser.getAssignmentPointsReceived(newLogin.getUserNumber(), 4)
        , newLogin.currentUserUser.getAssignmentDatePicked(newLogin.getUserNumber(), 4)
        , newLogin.currentUserUser.getAssignmentTimePicked(newLogin.getUserNumber(), 4)
        , newLogin.currentUserUser.getAssignmentSelectedStudent(newLogin.getUserNumber(), 4));
    //then tutor can update their assignments
  }

  // Temporary ObservableList containing archived assignments to be appended in update in updateAssignments()
  ObservableList<Assignment> temporary2 = FXCollections.observableArrayList();

  private void createAssignment(int userNumber, String assignmentName,
      String assignmentType, String assignmentComments, String assignmentMaxPoints,
      String assignmentPointsReceived, String assignmentDatePicked,
      String assignmentTimePicked, String assignmentSelectedStudent) throws IOException {
    String assignmentName = assignmentname.getText();
    String maxPoints = maxpoints.getText();
    String pointsReceived = pointsreceived.getText();
    String Comments = comments.getText();
    String datePicked = datepicked.getValue().toString();
    String timePicked = timepicked.getValue().toString();
    String assignmentType = assignmenttype.getText();
    String selectedStudent = selectedstudent.getValue().toString();
    temporary2.add(
        new Assignment(assignmentName, maxPoints, pointsReceived, Comments, datePicked, timePicked,
            assignmentType, selectedStudent));
    newLogin.currentUserUser
        .createAssignment(newLogin.getUserNumber(), assignmentName, maxPoints, "", Comments,
            datePicked, timePicked, assignmentType, selectedStudent);
  }

  @FXML
  private void goToDashboard(ActionEvent event) throws IOException {
    Stage stage = Main.getPrimaryStage();
    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
    stage.setScene(new Scene(root, 600, 440));
    stage.show();
  }

  /**
   * Executes default code when createAssignment is called
   */
  @FXML
  public void initialize() {

    for (int i = 0; i <= newLogin.currentUserUser.getTotalNumberOfAccounts() - 1; i++) {
      String role = newLogin.currentUserUser.getRole(i);
      String tutorName = newLogin.currentUserUser.getFirstName(i);
      if (role.equals("Student")) {
        selectedstudent.getItems().addAll(tutorName);
      }
    }
  }

}
