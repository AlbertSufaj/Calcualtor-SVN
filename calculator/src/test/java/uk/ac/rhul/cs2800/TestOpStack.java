package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOpStack {
  
  OpStack opStack;
  
  @BeforeEach
  void testClass() {
    opStack = new OpStack();
    
  }
  
  //(Actual)Test 1 - Testing push() method by adding a value.
  @Test
  void testOpPush() {
    opStack.push(Symbol.DIVIDE);
    assertEquals(opStack.getOpStack().size(), 1, "Test for new value added to stack increases stack size > 0");
  }
  
  //Test 2 - Testing if adding and removing works as intended.
  @Test
  void testPop() throws BadTypeException{
    opStack.push(Symbol.DIVIDE);
    assertEquals(opStack.pop(), Symbol.DIVIDE, "When popped, DIVIDE should be returned too");
    assertEquals(opStack.getOpStack().size(), 0, "Once popped the size of opStack should be 0");
  }
  
  //Test 3 - Testing if an empty stack throws an exception if the stack is empty.
  @Test
  void testPopOnly() throws EmptyStackException{
    assertThrows(EmptyStackException.class, () -> opStack.pop(), "Poping an empty stack should show an error.");
  }
  
  //Test 4 - Testing for errors when multiple items are pushed and then popped once.
  @Test
  void pushMultiple() throws EmptyStackException, BadTypeException {
    opStack.push(Symbol.DIVIDE);
    opStack.push(Symbol.MINUS);
    opStack.push(Symbol.PLUS);
    assertEquals(opStack.getOpStack().size(), 3, "Stack size must be 3 after added three items.");
    opStack.pop();
    assertEquals(opStack.getOpStack().size(), 2, "Stack must decreased by 1 to 2 after popping an item.");
  }
  
  //Test 5 - Testing if the stack is empty or not when stack is already empty.
  @Test
  void testIsEmpty() {
    assertEquals(opStack.isEmpty(), true, "Nothing in stack, isEmpty() should return true.");
  }
  
  //Test 6 - Testing if the isEmpty() method returns false when not empty.
  @Test
  void testIsEmptyAfterPush() throws EmptyStackException, BadTypeException {
    opStack.push(Symbol.DIVIDE);
    assertEquals(opStack.isEmpty(), false, "After pushing stack is not empty, therefore should return false.");
    opStack.pop();
    assertEquals(opStack.isEmpty(), true, "Nothing in stack, isEmpty() should return true.");
  }
}
