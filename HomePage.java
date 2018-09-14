package sample;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class HomePage extends sample.PageTemplate {

  // Global variables for HomePage Class
  Text homePageTitle = new Text("Homepage");
  Button scheduleTutor = new Button("Schedule Tutoring Session");
  Button reviewTutor = new Button("Tutor Reviews");
  Button gradesAttend = new Button("Grades and Attendance");
  Button calendar = new Button("Calendar");

  // Constructor
  HomePage(Stage homePageStage) {
    homePageTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20)); // Changes font
    pageTempGrid.add(homePageTitle, 0, 0, 2, 1); // adds title to grid
    pageTempGrid.add(scheduleTutor, 1, 4); // adds buttons to grid
    pageTempGrid.add(reviewTutor, 1, 5);
    pageTempGrid.add(gradesAttend, 2, 4);
    pageTempGrid.add(calendar, 2, 5);
    Scene homePageScene = new Scene(pageTempGrid, 1000, 600); // Sets size of window
    homePageStage.setScene(homePageScene);
  }
}
