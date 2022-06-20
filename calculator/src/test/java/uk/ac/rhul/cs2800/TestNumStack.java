package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class TestNumStack {
  
  NumStack numStack;
  
  @BeforeEach
  void testClass() {
    numStack = new NumStack();
  }
  
  //(Actual)Test 1 - Testing push() method by adding a value.
  @Test
  void testPush() {
    numStack.push(4.5f);
    assertEquals(numStack.getNumStack().size(), 1, "Test for new value added to stack increases stack size > 0");
  }
  
  //Test 2 - Testing if adding and removing works as intended.
  @Test
  void testPop() throws EmptyStackException, BadTypeException{
    numStack.push(4.5f);
    //numStack.pop();
    assertEquals(numStack.pop(), 4.5f, "Once popped the size of numStack should be 1");
    assertEquals(numStack.getNumStack().size(), 0, "Once popped the size of numStack should be 1");
  }
  //Test 3 - Testing if an empty stack throws an exception if the stack is empty.
  @Test
  void popOnly() throws EmptyStackException{
    assertThrows(EmptyStackException.class, () -> numStack.pop(), "Poping an empty stack should show an error.");
  }
  //Test 4 - Testing for errors when multiple items are pushed and then popped once.
  @Test
  void pushMultiple() throws EmptyStackException, BadTypeException {
    numStack.push(4.5f);
    numStack.push(4.6f);
    numStack.push(4.7f);
    assertEquals(numStack.getNumStack().size(), 3, "Stack size must be 3 after added three items.");
    numStack.pop();
    assertEquals(numStack.getNumStack().size(), 2, "Stack must decreased by 1 to 2 after popping an item.");
  }
  //Test 5 - Testing if the stack is empty or not when stack is already empty.
  @Test
  void testIsEmpty() {
    assertEquals(numStack.isEmpty(), true, "Nothing in stack, isEmpty() should return true.");
  }
  //Test 6 - Testing if the isEmpty() method returns false when not empty.
  @Test
  void testIsEmptyAfterPush() throws EmptyStackException, BadTypeException {
    numStack.push(4.5f);
    assertEquals(numStack.isEmpty(), false, "After pushing stack is not empty, therefore should return false.");
    numStack.pop();
    assertEquals(numStack.isEmpty(), true, "Nothing in stack, isEmpty() should return true.");
  }
}

