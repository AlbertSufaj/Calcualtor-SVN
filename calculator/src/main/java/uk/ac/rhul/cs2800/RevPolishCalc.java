package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * The magic class of Reverse Polish Notation, here calculations are made using this notation.
 * @author Albert Sufaj
 *
 */
public class RevPolishCalc implements Calculator {
  
  private NumStack values;
  
  /**
   * Constructor initialising values as NumStack.
   */
  public RevPolishCalc() {
    setValues(new NumStack());
  }
  
  /**
   * Where the magic happens (calculation is made in reverse polish notation).
   * @throws BadTypeException when the type used is incorrect
   * @throws EmptyStackException when the NumStack is empty
   * @throws InvalidExpression when the expression used is incorrect
   */
  public float evaluate(String what) throws InvalidExpression, EmptyStackException, 
      BadTypeException {
    
    String[] op = new String[what.length()]; 
    //op = what.split("(?<=[-+*/\\\\(\\\\)])|(?=[-+*/\\\\(\\\\)])");
    float num1;
    float num2;
    for (int i = 0; i < op.length; i++) { 
      op[i] = Character.toString(what.charAt(i));
      switch (op[i]) {
        case "+":
          values.push(values.pop() + values.pop());
          break;
        case "-":
          num1 = values.pop();
          num2 = values.pop();
          values.push(num2 - num1);
          break;
        case "*":
          values.push(values.pop() * values.pop());
          break;
        case "/":
          num1 = values.pop();
          num2 = values.pop();
          values.push(num2 / num1);
          break;
        default:
          //int pass1 = Integer.parseInt(op[i]);
          float pass = Float.parseFloat(op[i]);
          values.push(pass);
      }
    }
    return values.pop();
  }

  /**
   * Simple getter used to get NumStack:values.
   * @return values of type NumStack
   */
  public NumStack getValues() {
    return values;
  }

  /**
   * Simple setter to assign values.
   * @param values of type NumStack to be set
   */
  public void setValues(NumStack values) {
    this.values = values;
  }

}
