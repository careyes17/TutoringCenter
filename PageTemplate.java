package sample;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class PageTemplate {

  // To-be inherited fields
  GridPane pageTempGrid = new GridPane(); // sets grid for all subclasses

  // Constructor
  PageTemplate() {
    pageTempGrid.setAlignment(Pos.CENTER);
    pageTempGrid.setHgap(10); // Spacing between rows and columns
    pageTempGrid.setVgap(10);
    pageTempGrid.setPadding(new Insets(25, 25, 25, 25));
  }
}
