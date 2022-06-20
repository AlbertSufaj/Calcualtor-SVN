package uk.ac.rhul.cs2800;

import java.io.IOException;
import java.util.EmptyStackException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * G.
 * @author Albert Sufaj
 *
 */
public class GuiView extends Application {
  
  CalcModel model;
  boolean isinfix = true;
  
  /**
   * Constructor initialising model attribute.
   */
  public GuiView() {
    model = new CalcModel();
  }
  
  @FXML
  private TextField input;
  @FXML
  private Text textChange;
  @FXML
  private Button calcButton;
  @FXML
  private RadioButton reverseCheck;
  
  /**
   * Launches GUI.
   * @param args to launch
   */
  public static void main(String[] args) {
    launch(args);
  }
  
  @Override
  public void start(Stage primaryStage) throws IOException {
    AnchorPane page = (AnchorPane) FXMLLoader.load(GuiView.class.getResource("GuiView.fxml"));
    Scene s = new Scene(page);
    primaryStage.setScene(s);
    primaryStage.setTitle("Albert's Magical Calculator");
    primaryStage.show();
  }
  
  /**
   * Retrieves input from textbox.
   * @return String containing expression
   */
  public String getInput() {
    return input.getText();
  }
  
  /**
   * Sets text to final calcualtion.
   * @param ans final answer
   */
  public void setText(String ans) {
    textChange.setText(ans);
  }
  
  @FXML
  void isPressed(ActionEvent action) throws EmptyStackException, InvalidExpression, 
      BadTypeException {
    textChange.setText(valueReturn(getInput()));
  }
  
  void isSelected(ActionEvent action) {
    if (reverseCheck.isSelected() == true) {
      isinfix = false;
    }
  }
  
  /**
   * Activates the button.
   */
  public void menu() {
    calcButton.setDisable(false);
  }
  
  /**
   * Used to retrieve the expression to be calculated.
   * @param exp expression is passed through
   * @return String of expression
   * @throws EmptyStackException when the stack is empty
   * @throws InvalidExpression when the expression is incorrect
   * @throws BadTypeException when a wrong type is used
   */
  public String valueReturn(String exp) throws EmptyStackException, InvalidExpression, 
      BadTypeException {
    String temp = Float.toString(model.evaluate(exp, isinfix));
    return temp;
  }
  
}
