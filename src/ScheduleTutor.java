package src;

import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.SpinnerValueFactory.ListSpinnerValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.collections.ObservableList;

public class ScheduleTutor extends PageTemplate {

  //Text
  Text scheduleTutorTitle = new Text("Schedule a Tutor");
  Label subjectLabel = new Label("Choose a Subject:");
  Label tutorLabel = new Label("Choose a Tutor:");
  Label dateLabel = new Label("Choose a Date:");
  Label timeLabel = new Label("Choose a Time:");
  //Drop Downs & Choices
  ChoiceBox<String> subjectDropDown = new ChoiceBox<>(); // Must be only one datatype(can't mix)
  ChoiceBox<String> tutorDropDown = new ChoiceBox<>();
  DatePicker appointmentCalendar = new DatePicker(); // Creates calendar date picker
  Spinner<Integer> hourSpinner = new Spinner<Integer>(); // Creates spinner
  ObservableList<Integer> hoursList = // makes list for spinner to use. Arrays don't work :(
      FXCollections.observableArrayList(1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12);

  ScheduleTutor(Stage scheduleTutorStage) {
    //Header
    scheduleTutorTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20)); // Changes font
    pageTempGrid.add(scheduleTutorTitle, 0, 0); // adds title to grid
    //Choose Subject
    pageTempGrid.add(subjectLabel, 0, 1);
    subjectDropDown.getItems().addAll("Programming", "Physics", "Mathematics", "Biology");
    pageTempGrid.add(subjectDropDown, 1, 1);
    //Choose Professor
    pageTempGrid.add(tutorLabel, 0, 2);
    tutorDropDown.getItems().addAll("Dr. Amos", "Dr. Ligma", "Dr. Sawcon");
    pageTempGrid.add(tutorDropDown, 1, 2);
    //Choose Date
    pageTempGrid.add(dateLabel, 0, 3);
    pageTempGrid.add(appointmentCalendar, 1, 3);
    //Choose Time
    pageTempGrid.add(timeLabel, 0, 4);
    SpinnerValueFactory<Integer> spinnerHoursValFact = // Value Factory takes in values from observablelist
        new ListSpinnerValueFactory<Integer>(hoursList);
    spinnerHoursValFact.setValue(12); // then sets default value
    hourSpinner.setValueFactory(spinnerHoursValFact); // spinner then takes in info of factory
    pageTempGrid.add(hourSpinner, 1, 4);

    Scene homePageScene = new Scene(pageTempGrid, 1000, 600); // Sets size of window
    scheduleTutorStage.setScene(homePageScene);
  }
}
