package src;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class quizController extends Main {

  @FXML
  JFXRadioButton Answer1;
  @FXML
  JFXRadioButton Answer2;
  @FXML
  JFXRadioButton Answer3;
  @FXML
  JFXRadioButton Answer4;
  @FXML
  JFXTextArea QuizQuestion;
  @FXML
  ToggleGroup right;
  @FXML
  JFXButton nextQuestionButton;

  int i = 0;
  public String[] Questions = {"Question 1?", "Question2?", "Question3"};
  public String[] answerA = {"Answer A 1?", "Answer A 2?", "Answer A 3"};
  public String[] answerB = {"Answer B 1?", "Answer B 2?", "Answer B 3"};
  public String[] answerC = {"Answer C 1?", "Answer C 2?", "Answer C 3"};
  public String[] answerD = {"Answer D 1?", "Answer D 2?", "Answer D 3"};


  @FXML
  public void initialize() {
    QuizQuestion.setText(this.Questions[i]);
    Answer1.setText(this.answerA[i]);
    Answer2.setText(this.answerB[i]);
    Answer3.setText(this.answerC[i]);
    Answer4.setText(this.answerD[i]);
      /*QuizQuestion.setText(newLogin.currentUserUser.getQuizQuestion(newLogin.getUserNumber(),0));
      Answer1.setText(newLogin.currentUserUser.getAnswerOne(newLogin.getUserNumber(),0));
      Answer2.setText(newLogin.currentUserUser.getAnswerTwo(newLogin.getUserNumber(),0));
      Answer3.setText(newLogin.currentUserUser.getAnswerThree(newLogin.getUserNumber(),0));
      Answer4.setText(newLogin.currentUserUser.getAnswerFour(newLogin.getUserNumber(),0));*/
      /*assert roledropdown
        != null : "fx:id=\"roledropdown\" was not injected: check your FXML file 'signup.fxml'.";
    // populate the fruit combo box with item choices.
    roledropdown.getItems().setAll("User", "Tutor");*/
  }

  @FXML
  private void goToNextQuestion(ActionEvent event) throws IOException {
    /*
     * ENTER FUNCTIONALITY
     * */
    this.i++;
    System.out.println(Questions);
    if (this.i < Questions.length) {
      if (Answer1.isSelected()) {
        System.out.println(Answer1.getText());
      }
      if (Answer2.isSelected()) {
        System.out.println(Answer2.getText());
        //newLogin.currentUserUser.setUserAnswer(newLogin.getUserNumber(),0,b);
      }
      if (Answer3.isSelected()) {
        System.out.println(Answer3.getText());
        //newLogin.currentUserUser.setUserAnswer(newLogin.getUserNumber(),0,b);
      }
      if (Answer4.isSelected()) {
        System.out.println(Answer4.getText());
        //newLogin.currentUserUser.setUserAnswer(newLogin.getUserNumber(),0,b);
      }

      QuizQuestion.setText(this.Questions[i]);
      Answer1.setText(this.answerA[i]);
      Answer2.setText(this.answerB[i]);
      Answer3.setText(this.answerC[i]);
      Answer4.setText(this.answerD[i]);
      System.out.println(this.i);

      if (this.i == (Questions.length) - 1) {
        nextQuestionButton.setText("Submit");
      }
    } else {

      if (Answer1.isSelected()) {
        System.out.println(Answer1.getText());
      }
      if (Answer2.isSelected()) {
        System.out.println(Answer2.getText());
        //newLogin.currentUserUser.setUserAnswer(newLogin.getUserNumber(),0,b);
      }
      if (Answer3.isSelected()) {
        System.out.println(Answer3.getText());
        //newLogin.currentUserUser.setUserAnswer(newLogin.getUserNumber(),0,b);
      }
      if (Answer4.isSelected()) {
        System.out.println(Answer4.getText());
        //newLogin.currentUserUser.setUserAnswer(newLogin.getUserNumber(),0,b);
      }
      Stage stage = Main.getPrimaryStage();
      stage
          .setScene(new Scene(FXMLLoader.load(getClass().getResource("dashboard.fxml")), 600, 440));
      stage.show();
    }
  }

  @FXML
  private void goToLastQuestion(ActionEvent event) throws IOException {
    if (this.i > 0) {
      this.i--;
      QuizQuestion.setText(this.Questions[i]);
      Answer1.setText(this.answerA[i]);
      Answer2.setText(this.answerB[i]);
      Answer3.setText(this.answerC[i]);
      Answer4.setText(this.answerD[i]);
    }
  }

  @FXML
  private void returnToDashboard() throws Exception {
    Stage stage = Main.getPrimaryStage();
    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("dashboard.fxml")), 600, 440));
    stage.show();
  }

}
