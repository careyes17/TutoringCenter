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

  public void initialize() {

    assert roledropdown
        != null : "fx:id=\"roledropdown\" was not injected: check your FXML file 'signup.fxml'.";
    // populate the fruit combo box with item choices.
    roledropdown.getItems().setAll("User", "Tutor");
  }

  @FXML
  private void button1Pressed(ActionEvent event) throws IOException {

    if (usernametxt.getText().isEmpty() || passwordtxt.getText().isEmpty()) {
      errortxt.setStyle("-fx-text-fill: One of the submission fields are empty");
    } else {
      //check the last parameter to see if it gets the value from the drop down
      newLogin.createUserInformation(usernametxt.getText(), passwordtxt.getText(),
          firstnametxt.getText(), lastnametxt.getText(),
          emailtxt.getText(), roledropdown.getValue().toString());

    }
  }

  @FXML
  private void goToDashboard(ActionEvent event) throws IOException {
    Stage stage = Main.getPrimaryStage();
    Parent root = FXMLLoader.load(getClass().getResource("signin.fxml"));
    stage.setScene(new Scene(root, 600, 440));
    stage.show();
  }
}

