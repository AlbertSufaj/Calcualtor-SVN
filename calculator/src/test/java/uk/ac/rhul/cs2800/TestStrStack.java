package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStrStack {

  StrStack strStack;
  
  @BeforeEach
  void testClass() {
    strStack = new StrStack();
  }
  //Test 1 - testing if push() method works by pushing "Hello".
  @Test
  void testPush() {
    strStack.push("Hello");
    assertEquals(strStack.getStrStack().size(), 1, "Test for new value added to stack increases stack size > 0");
  }
  
  //Test 2 - testing pop() method by pushing and the popping.
  @Test
  void testPop() throws BadTypeException{
    strStack.push("Hello");
    assertEquals(strStack.pop(), "Hello", "When popped, 'Hello' should be returned too");
    assertEquals(strStack.getStrStack().size(), 0, "Once popped the size of strStack should be 0");
  }
  
  //Test 3 - testing if pop() throws when the stack is empty.
  @Test
  void popOnly() throws EmptyStackException{
    assertThrows(EmptyStackException.class, () -> strStack.pop(), "Poping an empty stack should show an error.");
  }
  
  //Test 4 - testing if stack still works when pushing and popping multiple items.
  @Test
  void pushMultiple() throws EmptyStackException, BadTypeException {
    strStack.push("Hello");
    strStack.push("World");
    strStack.push("!");
    assertEquals(strStack.getStrStack().size(), 3, "Stack size must be 3 after added three items.");
    strStack.pop();
    assertEquals(strStack.getStrStack().size(), 2, "Stack must decreased by 1 to 2 after popping an item.");
  }
  
  //Test 5 - testing if isEmpty() method returns true if empty.
  @Test
  void testIsEmpty() {
    assertEquals(strStack.isEmpty(), true, "Nothing in stack, isEmpty() should return true.");
  }
  
  //Test 6 - testing if isEmpty() works when items have been pushed.
  @Test
  void testIsEmptyAfterPush() throws EmptyStackException, BadTypeException {
    strStack.push("Hello");
    assertEquals(strStack.isEmpty(), false, "After pushing stack is not empty, therefore should return false.");
    strStack.pop();
    assertEquals(strStack.isEmpty(), true, "Nothing in stack, isEmpty() should return true.");
  }
}
