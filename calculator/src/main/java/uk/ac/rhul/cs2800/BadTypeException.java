package uk.ac.rhul.cs2800;

/**
 * BadTypeException class used in all other calculator classes whenever the user inputs 
 * an incorrect value.
 * 
 * @author Albert Sufaj
 *
 */
public class BadTypeException extends Exception {
  /**
   * Serial version ID for BadTypeException.
   */
  private static final long serialVersionUID = -2189216694685277734L;
  static String error = "BadTypeException";

  /**
   * Constructor containing the error message.
   */
  public BadTypeException() {
    super(error);
  }
}
