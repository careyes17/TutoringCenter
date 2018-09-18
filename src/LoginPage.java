package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
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

public class LoginPage {
  LoginPage(Stage primaryStage){
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
        if (logInAuth(userTextField.getText(),pwBox.getText()) == true) {
          //loading to homepage
          src.HomePage scene2 = new src.HomePage(primaryStage);
        }
        try {
          addUser(userTextField.getText(),pwBox.getText());
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }
    });
    Scene scene = new Scene(grid, 500, 275); // sets size of window
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  //below is the functions that are used for the LoginPage.java
  //adds users to the text document
  private static void addUser(String Username, String Password) throws IOException {
    //Referencing Login Text File
    File file = new File("test.txt");
    //Creating scanner object
    Scanner scan1 = new Scanner(file);
    String inputUsername = "Username:" + Username;
    //username found boolean
    boolean found = false;
    //loop looking for username
    while (scan1.hasNextLine()) {

      // Stores initial input in variable for comparison
      String i = scan1.nextLine();

      // Checks the users input in comparison to the first line present in text doc
      if (inputUsername.equals(i)) {
        found = true;
      }
    }
    //if username is not found, create one
    if (!found) {
      //instances PrintWriter
      FileWriter writer = new FileWriter(file, true);
      // Writes to Text doc
      writer.write("Username:" + Username + "\r\n");
      writer.write("Password:" + Password + "\r\n");
      //Closes file an writer object
      writer.close();

      //to call the function you must use the following code
  /*
   try {
          BackEnd.addUser(userTextField.getText(),pwBox.getText());
        } catch (IOException e1) {
          e1.printStackTrace();
        }
   */
    }
  }
  //authenticates users to 
  private static boolean logInAuth(String Username, String Password) {
    File file = new File("test.txt");
    //Creates and initializes the scanner
    //Scanner keyboard = new Scanner(System.in);
    //start of try catch code for file not found exception
    try {
      //creates new scanner
      Scanner Scan = new Scanner(file);

      // Scans the users input for comparison
      // String must be in the text document format to prevent search issues
      String inputUsername = "Username:" + Username;

      // Scans the users input for comparison
      // String must be in the text document format to prevent search issues
      String inputPassword = "Password:" + Password;

      // Scans through text document
      while (Scan.hasNextLine()) {

        // Stores initial input in variable for comparison
        String i = Scan.nextLine();

        // Checks the users input in comparison to the first line present in text doc
        if (inputUsername.equals(i)) {

          // If the Username is correct then it will compare to the password stored below it
          if (Scan.nextLine().equals(inputPassword)) {

            //upon Completion it will prompt a success
            System.out.println("success");
            return true;

            //breaks from while loop upon success
            //break;
          }
        }
      }
      // Closes the Scanner
      Scan.close();
    }
    // Catches FileNotFoundException e
    catch (FileNotFoundException e) {

      // Prints to Stack Trace
      e.printStackTrace();
    }
    //Below is the function that is called inorder for the function to find the text box and then compare the strings
    //BackEnd.logInAuth(userTextField.getText(),pwBox.getText());
    return false;
  }
}
