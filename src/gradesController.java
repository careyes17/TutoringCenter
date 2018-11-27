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

public class gradesController {

  @FXML
  PieChart pieChart;

  @FXML
  JFXComboBox<String> pieChartTypeSelector;

  @FXML
  private void goToDashboard(ActionEvent event) throws IOException {
    Stage stage = Main.getPrimaryStage();

    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

    stage.setScene(new Scene(root, 600, 440));

    stage.show();
  }

  @FXML
  private void update() {
    System.out.println("attempting update");

    if (pieChartTypeSelector.getValue().equals("Grades")) {
      ObservableList<PieChart.Data> pieChartData =
          FXCollections.observableArrayList(
              new PieChart.Data("A", 13),
              new PieChart.Data("B", 25),
              new PieChart.Data("C", 6),
              new PieChart.Data("D", 1)
          );
      pieChart.setData(pieChartData);
      pieChart.setTitle("Grades");

      Main.getPrimaryStage().show();
    }

    if (pieChartTypeSelector.getValue().equals("Attendance")) {
      ObservableList<PieChart.Data> pieChartData =
          FXCollections.observableArrayList(
              new PieChart.Data("Present", 13),
              new PieChart.Data("Late", 2),
              new PieChart.Data("Absent", 1)
          );
      pieChart.setData(pieChartData);
      pieChart.setTitle("Attendance");

      Main.getPrimaryStage().show();
    }


  }


}
