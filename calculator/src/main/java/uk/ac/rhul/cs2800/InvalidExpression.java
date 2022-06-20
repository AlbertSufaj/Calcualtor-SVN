package uk.ac.rhul.cs2800;

/**
 * Thrown when the user enters an invalid expression into the calculator.
 * 
 * @author Albert Sufaj
 *
 */
public class InvalidExpression extends Exception {
  /**
   * Serial version ID for InvalidExpression.
   */
  private static final long serialVersionUID = -2189216694685277735L;
  static String error = "InvalidExpression";

  /**
   * Constructor containing the error message.
   */
  public InvalidExpression() {
    super(error);
  }
  
}