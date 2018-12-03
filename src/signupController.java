/*package src;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.PopOver;
import javafx.scene.control.Label;

import java.io.IOException;

public class signupController {

    @FXML
    Label label = new Label();

    Label lblName = new Label("Error Message");
    VBox vbox = new VBox(lblName);
    PopOver popOver = new PopOver(vbox);

    @FXML
    void button1Pressed(MouseEvent event) throws Exception {
        vbox.setPrefHeight(75);
        vbox.setPrefWidth(75);
        lblName.setWrapText(true);
        vbox.setStyle("-fx-background-color: #66bbcc;");
        popOver.show(label);
    }

    @FXML
    void button2Pressed(MouseEvent event) throws Exception {
        popOver.hide();
    }

}*/

package src;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class signupController extends Main {

  @FXML
  TextField passwordtxt;

  @FXML
  TextField usernametxt;
  @FXML
  TextField firstnametxt;
  @FXML
  TextField lastnametxt;
  @FXML
  TextField emailtxt;
  @FXML
  ComboBox roledropdown;
  @FXML
  Label errortxt;

  /**
   * Populates the role combo box with "Student" and "Tutor"
   */
  public void initialize() {
    roledropdown.getItems().setAll("Student", "Tutor");
  }

  /**
   * Performs sign up functionality and takes the user to the sign in page to sign in
   */
  @FXML
  private void button1Pressed(ActionEvent event) throws IOException {

    boolean passed = true;
    if (firstnametxt.getText().isEmpty() || lastnametxt.getText().isEmpty() || emailtxt.getText()
        .isEmpty() || roledropdown.getValue() == null) {
      errortxt.setText("Please fill all of the fields");
      passed = false;
    } else if (passwordtxt.getText().length() + 1 <= 6
        || passwordtxt.getText().length() - 1 >= 32) {
      errortxt.setText("Username or password needs to be 6-32 characters long");
      passed = false;
    } else if (usernametxt.getText().length() + 1 <= 6
        || usernametxt.getText().length() - 1 >= 32) {
      errortxt.setText("Username or password needs to be 6-32 characters long");
      passed = false;
    }
    if (passed == true) {
      //check the last parameter to see if it gets the value from the drop down
      newLogin.createUserInformation(usernametxt.getText(), passwordtxt.getText(),
          firstnametxt.getText(), lastnametxt.getText(),
          emailtxt.getText(), roledropdown.getValue().toString());
      Stage stage = Main.getPrimaryStage();
      Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
      stage.setScene(new Scene(root, 600, 440));
      stage.show();
    }
  }

  /**
   * Takes user to dashboard
   */
  @FXML
  private void goToDashboard(ActionEvent event) throws IOException {
    Stage stage = Main.getPrimaryStage();
    Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
    stage.setScene(new Scene(root, 600, 440));
    stage.show();
  }
}

