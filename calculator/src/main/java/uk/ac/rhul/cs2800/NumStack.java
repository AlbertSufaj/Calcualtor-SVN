package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Class used as a facade for reverse polish notation class on float values.
 * @author Albert Sufaj
 */
public class NumStack {
  
  private Stack numStack; //numStack is instantiated here first.
  
  /**
   * NumStack constructor which initialises the Stack class in Stack.java.
   */
  public NumStack() {
    setNumStack(new Stack()); //numStack relies on stack class
  }

  /**
   * Method used to push a float value onto numStack class.
   * @param f float value used in calculation.
   */
  public void push(float f) {
    Entry numPush = new Entry(f); 
    //To push correctly, Entry must be instantiated using the float constructor.
    getNumStack().push(numPush);
  }

  /**
   * Used to remove the top item from the numStack class.
   * @return float value representing the top of stack
   * @throws BadTypeException EmptyStackException BTE: bad type used, ESE: if stack is empty
   */
  public float pop() throws EmptyStackException, BadTypeException {
    return getNumStack().pop().getNumber(); 
  }

  /**
   * Method used to determine if the stack is empty or not.
   * @return boolean representing if the stack is empty or not
   */
  public boolean isEmpty() {
    if (getNumStack().size() != 0) {
      return false; //returns false whenever size is not 0 (not empty)
    } else {
      return true;
    }
  }

  /**
   * Simple getter (for numStack) so that private fields can be used.
   * @return numStack - the Stack used for numeric values
   */
  public Stack getNumStack() {
    return numStack;
  }

  /**
   * Simple setter so the Stack numStack can change.
   * @param numStack - the Stack used for numeric values
   */
  public void setNumStack(Stack numStack) {
    this.numStack = numStack;
  }
}

