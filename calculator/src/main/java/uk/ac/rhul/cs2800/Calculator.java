package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Used to allow calculations of string expressions.
 * @author Albert Sufaj
 */
public interface Calculator {
  
  /**
   * To be called in other classes.
   * @param what string value to be used within the calculator
   * @return a float value which is the answer entered by user
   * @throws BadTypeException when a bad type is used
   * @throws EmptyStackException when the stack is empty
   * @throws InvalidExpression when the wrong expression is used
   */
  public float evaluate(String what) throws InvalidExpression, EmptyStackException, 
      BadTypeException;
  
}
