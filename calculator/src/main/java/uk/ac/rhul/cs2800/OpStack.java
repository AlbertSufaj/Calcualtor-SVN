package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Class used as a facade for reverse polish notation on symbols.
 * @author Albert Sufaj
 */
public class OpStack {
  
  private Stack opStack; //opStack is instantiated here first.
   
  /**
   * Constructor to initialise OpStack with a stack.
   */
  public OpStack() {
    setOpStack(new Stack()); //opStack relies on stack class
  }
  
  /**
   * Push function used to add symbols to the opStack stack.
   * @param symbol Enum:symbol to be pushed onto the stack
   */
  public void push(Symbol symbol) {
    Entry symPush = new Entry(symbol);
    //To push correctly, Entry must be instantiated using the float constructor.
    getOpStack().push(symPush);
  }

  /**
   * Used to remove the top item from the opStack stack.
   * @return symbol which has been popped
   * @throws BadTypeException if the wrong is used
   * @throws EmptyStackException when pop() is called when stack is empty.
   */
  public Symbol pop() throws BadTypeException, EmptyStackException {
    return getOpStack().pop().getSymbol();
  }

  /**
   * Used to return if opStack is empty or not.
   * @return boolean determining if stack is empty
   */
  public boolean isEmpty() {
    if (getOpStack().size() != 0) {
      return false; //returns false whenever size is not 0 (not empty)
    } else {
      return true;
    }
  }

  /**
   * Simple getter so that private fields can be used.
   * @return opStack - the Stack used for operations
   */
  public Stack getOpStack() {
    return opStack;
  }

  /**
   * Simple setter so that opStack can change values.
   * @param opStack - the Stack used for operations
   */
  public void setOpStack(Stack opStack) {
    this.opStack = opStack;
  }
  
}
