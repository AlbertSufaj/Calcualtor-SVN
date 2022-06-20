package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Where the expression is converted, reversed so that infix can be used inside the calculator.
 * @author Albert Sufaj
 *
 */
public class StandardCalc implements Calculator {
  OpStack values;
  RevPolishCalc rpCalc;
  
  /**
   * Constructor initialising both attributes.
   */
  public StandardCalc() {
    this.values = new OpStack();
    this.rpCalc = new RevPolishCalc();
  }
  
  /**
   * Where the magic happens, values are then passed into RevPolishCalc.
   * @throws BadTypeException when the wrong type is used
   * @throws EmptyStackException when the stack is empty
   * @throws InvalidExpression whenever theres an invalid expression
   *
   */
  public float evaluate(String what) throws EmptyStackException, 
      BadTypeException, InvalidExpression {
    
    //String[] op = new String[what.length()];
    String[] op;
    op = what.split("(?<=[-+*/\\(\\)])|(?=[-+*/\\(\\)])");
    StrStack str = new StrStack();
    int count = 0;
    for (int i = 0; i < op.length; i++) {
      //op[i] = Character.toString(what.charAt(i));
      switch (op[i]) {
        //All the cases for different operation types.
        case "+":
          values.push(Symbol.PLUS);
          break;
        case "-":
          //count is used an indication that the stack must be reversed.
          count = 1;
          values.push(Symbol.MINUS);
          break;
        case "*":
          values.push(Symbol.TIMES);
          break;
        case "/":
          count = 1;
          values.push(Symbol.DIVIDE);
          break;
        default:
          str.push(op[i]);
      }
    }
    String full = "";
    if (count == 1) {
      str = reverse(str);
      
    }
    count = 0;
    for (int x = 0; x <= str.getStrStack().size; x++) {
      full += str.pop();
    }
    String opStr = values.pop().getValue();
    full += opStr;
    return rpCalc.evaluate(full);
  }

  /**
   * Used to reverse the entry of the stack when dividing and subtracting.
   * @param str StrStack which contains the numbers
   * @return a stack containing the reverse stack
   * @throws EmptyStackException when the stack is empty
   * @throws BadTypeException when a bad type is used
   */
  private StrStack reverse(StrStack str) throws EmptyStackException, BadTypeException {
    StrStack tempStack = new StrStack();
    String[] reverseA = new String[str.getStrStack().size];
   
    for (int x = 0; x <= str.getStrStack().size; x++) {
      reverseA[x] = str.pop();
    }
    //Iterated once into a string array
    //then the array is iterated over and then pushed into tempStack
    for (int y = 0; y <= reverseA.length - 1; y++) {
      tempStack.push(reverseA[y]);
    }
    //tempStack is returned
    return tempStack;
  }
}
