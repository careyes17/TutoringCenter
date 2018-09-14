package sample;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }


  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Gutterboyz & Son Tutoring Center"); // Sets title on top of window

    GridPane grid = new GridPane(); // Initializes new grid used to organize elements in window
    grid.setAlignment(Pos.CENTER); // Default position of grid set to center instead of top left
    grid.setHgap(10); // Spacing between rows and columns
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25)); // padding on INSIDE of window

    Text scenetitle = new Text("Gutterboyz & Son Tutoring Center"); // Sets title in window
    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20)); // Changes font
    grid.add(scenetitle, 0, 0, 2, 1); // add to grid and location

    Label userName = new Label("Username:"); // Adds label to textbox used for username
    grid.add(userName, 0, 1); // adds to grid and location
    TextField userTextField = new TextField(); // same but with textfield
    grid.add(userTextField, 1, 1);
    Label pw = new Label("Password:");
    grid.add(pw, 0, 2);
    PasswordField pwBox = new PasswordField(); // creates password field (different from normal textbox)
    grid.add(pwBox, 1, 2); // adds to gird and location

    Button btn = new Button("Sign in");
    HBox hbBtn = new HBox(10);
    hbBtn.setAlignment(Pos.BOTTOM_RIGHT); // sets hbBtn to bottom right position
    hbBtn.getChildren().add(btn); // sets btn to hbBtn
    grid.add(hbBtn, 1, 4); // adds to grid and location

    final Text actiontarget = new Text();
    grid.add(actiontarget, 1, 6);

    btn.setOnAction(new EventHandler<ActionEvent>() {

      @Override
      public void handle(ActionEvent e) { // creates event that happens when button is pressed
        actiontarget.setFill(Color.FIREBRICK);
        actiontarget.setText("Sign in button pressed");
        //Checks if the account is in the text document, then takes you to homepage
        if (sample.BackEnd.logInAuth(userTextField.getText(),pwBox.getText()) == true) {
            //loading to homepage
            sample.HomePage scene2 = new sample.HomePage(primaryStage);
        }
        try {
          sample.BackEnd.addUser(userTextField.getText(),pwBox.getText());
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }
    });
    Scene scene = new Scene(grid, 500, 275); // sets size of window
    primaryStage.setScene(scene);
    primaryStage.show();

  }
}