package src;

import java.io.IOException;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.validation.base.ValidatorBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class gradesController extends Main {

  @FXML
  PieChart pieChart;

  @FXML
  JFXComboBox<String> pieChartTypeSelector;


  /**
   * Takes the user to the dashboard
   */
  @FXML
  private void goToDashboard(ActionEvent event) throws IOException {
    Stage stage = Main.getPrimaryStage();

    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

    stage.setScene(new Scene(root, 600, 440));

    stage.show();
  }

  /**
   * Updates the graph according to the selection from the combo box
   */
  @FXML
  private void update() {
    System.out.println("attempting update");

    // If the combo box has "Grades" selected
    if (pieChartTypeSelector.getValue().equals("Grades")) {
      int A=0;
      int B=0;
      int C=0;
      int D=0;
      int F=0;
      int counter=0;
      while (counter<newLogin.currentUserUser.getNumberOfAssignments(newLogin.getUserNumber())){
        double Calculation = ((double)newLogin.currentUserUser.getAssignmentPointsReceived(newLogin.getUserNumber(),counter) / (double) newLogin.currentUserUser.getAssignmentMaxPoints(newLogin.getUserNumber(),counter));
        if(Calculation>=0.90){
          A++;
        }
        if(Calculation<0.90 && Calculation>=0.80){
          B++;
        }
        if(Calculation<0.80 && Calculation>=0.70){
          C++;
        }
        if(Calculation<0.70 && Calculation>=0.60){
          D++;
        }
        if(Calculation<0.60 && Calculation>=0.50){
          F++;
        }
        counter++;
      }

      // Loads grade elements
      ObservableList<PieChart.Data> pieChartData =
          FXCollections.observableArrayList(
              new PieChart.Data("A", A),
              new PieChart.Data("B", B),
              new PieChart.Data("C", C),
              new PieChart.Data("D", D),
              new PieChart.Data("F", F)
          );
      pieChart.setData(pieChartData);
      pieChart.setTitle("Grades");

      // Displays grade elements
      Main.getPrimaryStage().show();
    }

    if (pieChartTypeSelector.getValue().equals("Attendance")) {
      // Loads attendance elements
      //Late, ontime, Absent
      int Late=0;
      int ontime=0;
      int Absent=0;
      int counter=0;
      while(counter<newLogin.currentUserUser.getNumberOfAppointments(newLogin.getUserNumber())){
        if(newLogin.currentUserUser.getAppointmentAttendance(newLogin.getUserNumber(),counter).equals("Late")){
          Late++;
        }
        if(newLogin.currentUserUser.getAppointmentAttendance(newLogin.getUserNumber(),counter).equals("ontime")){
          ontime++;
        }
        if(newLogin.currentUserUser.getAppointmentAttendance(newLogin.getUserNumber(),counter).equals("Absent")){
          Absent++;
        }
        counter++;
      }

      ObservableList<PieChart.Data> pieChartData =
          FXCollections.observableArrayList(
              new PieChart.Data("Present",ontime),
              new PieChart.Data("Late", Late ),
              new PieChart.Data("Absent", Absent)
          );
      pieChart.setData(pieChartData);
      pieChart.setTitle("Attendance");

      // Displays attendance elements
      Main.getPrimaryStage().show();
    }


  }


}
