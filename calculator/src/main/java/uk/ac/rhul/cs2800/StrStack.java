package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Separate class to be used as a facade on string values.
 * @author Albert Sufaj
 *
 */
public class StrStack {
  
  private Stack strStack; //strStack is instantiated here first.
  
  /**
   * Constructor initialising strStack as stack.
   */
  public StrStack() {
    setStrStack(new Stack()); //strStack relies on Stack class
  }
  
  /**
   * Method used to push the string onto the stack strStack.
   * @param s - the string passed through to be pushed
   */
  public void push(String s) {
    Entry strPush = new Entry(s); 
    //To push correctly, Entry must be instantiated using the string constructor.
    getStrStack().push(strPush);
  }

  /**
   * Used to remove the top item of the strStack stack.
   * @return a string value which was at top of stack
   * @throws BadTypeException when type used is not in Type Enum
   * @throws EmptyStackException when the stack is empty after pop, exception thrown
   */
  public String pop() throws BadTypeException, EmptyStackException {
    return getStrStack().pop().getString(); 
  }

  /** Used to determine if strStack is empty or not.
   * @return boolean stating if strStack is empty or not
   */
  public boolean isEmpty() {
    if (getStrStack().size() != 0) {
      return false; //returns false whenever size is not 0 (not empty)
    } else {
      return true;
    }
  }
  
  /**
   * Simple getter (for strStack) so that private fields can be used.
   * @return strStack - the Stack used for strings
   */
  public Stack getStrStack() {
    return strStack;
  }

  /**
   * Simple setter so that strStack can change values.
   * @param strStack - the Stack used for strings
   */
  public void setStrStack(Stack strStack) {
    this.strStack = strStack;
  }
}
