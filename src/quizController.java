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

  // Default values for the quizzes
  int currentQuestionIndex = 0;
  public String[] Questions = {"Question 1?", "Question2?", "Question3"};
  public String[] answerA = {"Answer A 1?", "Answer A 2?", "Answer A 3"};
  public String[] answerB = {"Answer B 1?", "Answer B 2?", "Answer B 3"};
  public String[] answerC = {"Answer C 1?", "Answer C 2?", "Answer C 3"};
  public String[] answerD = {"Answer D 1?", "Answer D 2?", "Answer D 3"};

  /**
   * Uses current quiz number index in order to get the quiz question and answers
   */
  @FXML
  public void initialize() {
    QuizQuestion.setText(Questions[currentQuestionIndex]);
    Answer1.setText(answerA[currentQuestionIndex]);
    Answer2.setText(answerB[currentQuestionIndex]);
    Answer3.setText(answerC[currentQuestionIndex]);
    Answer4.setText(answerD[currentQuestionIndex]);
  }

  /**
   * Loads and displays new questions
   */
  @FXML
  private void goToNextQuestion(ActionEvent event) throws IOException {
    if (currentQuestionIndex == (Questions.length) - 1) {
      // Takes user to the dashboard when submission is pressed
      Stage stage = Main.getPrimaryStage();
      stage
          .setScene(new Scene(FXMLLoader.load(getClass().getResource("dashboard.fxml")), 600, 440));
      stage.show();
    } else {
      nextQuestionButton.setText("Next");
      currentQuestionIndex++;
    }

    // Sets unselects previous selection upon entering new question
    Answer1.setSelected(false);
    Answer2.setSelected(false);
    Answer3.setSelected(false);
    Answer4.setSelected(false);

    QuizQuestion.setText(Questions[currentQuestionIndex]);
    Answer1.setText(answerA[currentQuestionIndex]);
    Answer2.setText(answerB[currentQuestionIndex]);
    Answer3.setText(answerC[currentQuestionIndex]);
    Answer4.setText(answerD[currentQuestionIndex]);
    System.out.println(currentQuestionIndex);

    // If the last question is being viewed, the "Next" button becomes "Submit"
    if (currentQuestionIndex == (Questions.length) - 1) {
      nextQuestionButton.setText("Submit");
    }
  }

  /**
   * Goes to the last question in the question array
   */
  @FXML
  private void goToLastQuestion(ActionEvent event) throws IOException {
    // If the user is viewing any question that is not the first question
    if (currentQuestionIndex > 0) {
      currentQuestionIndex--;
      QuizQuestion.setText(Questions[currentQuestionIndex]);
      Answer1.setText(answerA[currentQuestionIndex]);
      Answer2.setText(answerB[currentQuestionIndex]);
      Answer3.setText(answerC[currentQuestionIndex]);
      Answer4.setText(answerD[currentQuestionIndex]);
      // If the last question is not being viewed, the "Next" button becomes "Submit"
      nextQuestionButton.setText("Next");
    }
  }

  /**
   * Lets the user return to the dashboard at any point during the quiz
   */
  @FXML
  private void returnToDashboard() throws Exception {
    Stage stage = Main.getPrimaryStage();
    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("dashboard.fxml")), 600, 440));
    stage.show();
  }

}
