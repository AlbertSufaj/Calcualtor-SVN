package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Used as buffer to call both expression classes.
 * @author Albert Sufaj
 *
 */
public class CalcModel {
  RevPolishCalc revPolish;
  StandardCalc standard;
  
  /**
   * Constructor used to initialised the attributes of CalcModel.
   */
  public CalcModel() {
    this.revPolish = new RevPolishCalc();
    this.standard = new StandardCalc();
  }

  /**
   * RevPolishClac and StandardCalc are called using the expression.
   * @param exp the expression to be worked out
   * @param infix boolean stating if its infix or not 
   * @return a float containing the final answer
   * @throws EmptyStackException when stack is empty
   * @throws InvalidExpression when the incorrect expression is used
   * @throws BadTypeException when the wrong type is used
   */
  public float evaluate(String exp, boolean infix) throws EmptyStackException, InvalidExpression, 
      BadTypeException {
    if (infix == true) {
      return standard.evaluate(exp);
    } else {
      return revPolish.evaluate(exp);
    }
  }
}
