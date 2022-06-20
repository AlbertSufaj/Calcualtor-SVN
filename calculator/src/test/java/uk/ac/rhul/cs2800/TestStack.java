package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

class TestStack {
  //Below are the variables used throughout the tests
  private Stack stack;
  private Entry entry;
  private Entry entry1;
  private Entry entry2;

  @BeforeEach //Test 1 - Not really a test but by being able to initialise the class therefore the constructors are working.
  public void first() {
    stack = new Stack();
    entry = new Entry("+");
    entry1 = new Entry(1);
    entry2 = new Entry(Symbol.PLUS);
  }

  @Test //Test 2 - Testing if the stack size returns the correct size
  public void testSize() {
    assertEquals(stack.size(), 0, "Test for new stack to see if size is zero/stack is empty.");
  }

  @Test //Test 3 - Testing if I can add an item to the stack
  public void testPush() {
    stack.push(entry);
    assertEquals(stack.size(), 1, "Test for new value added to stack increases stack size > 0");
  }

  @Test //Test 4 - Testing if I can pop an empty stack
  public void testPop() {
    assertThrows(EmptyStackException.class, () -> stack.pop(), "Cannot pop an empty stack.");
  }

  @Test //Test 5 - Testing for the top functionality (looking at the top item)
  void testTop() throws BadTypeException {
    stack.push(entry1);
    
    assertEquals(stack.top().getNumber(), 1, "Pushed 1, top should return 1");
    
    assertEquals(stack.size(), 1, "Test used to check the item has not been removed but indeed just peeked at");
  }
  @Test //Test 6 - Test for pushing multiple items and checking if the top shows the top item
  void testTwoTop() throws BadTypeException {
    stack.push(entry);
    stack.push(entry2);
    assertEquals(stack.top().getSymbol(), Symbol.PLUS, "Last item added was PLUS, therefore when topped it should return PLUS");
    
    assertEquals(stack.size(), 2, "Test used to check the item has not been removed but indeed just peeked at");
  }

  @Test //Test 7 - Test for pushing an item and then removing it 
  public void testPushPop() throws BadTypeException {
    stack.push(entry1);
    
    assertEquals(stack.size(), 1, "size should 1 because the item is pushed.");
    
    assertEquals(stack.pop().getNumber(), 1, "Test if pop() has successfully return the value.");
    
    assertEquals(stack.size(), 0, "Pushing then poping with one value should make stack empty.");
    
    assertThrows(EmptyStackException.class, () -> stack.pop(), "After push then pop, an empty stack should throw an exception");
  }

  @Test //Test 8 - Testing for multiple pushes and pops
  public void testPushMoreThanOnce() throws BadTypeException {
    stack.push(entry);
    stack.push(entry1);
    stack.push(entry2);
    assertEquals(stack.size(), 3, "size should 3 because three items have been pushed.");
  
    assertEquals(stack.pop().getSymbol(), Symbol.PLUS, "Last value added to stack is Symbol:PLUS, pop should return this first");
    
    assertEquals(stack.size(), 2, "size should 2 because one item has been popped.");
    
    assertEquals(stack.pop().getNumber(), 1, "Next to pop is the float:1 as it was pushed second");
    
    assertEquals(stack.size(), 1, "size should 1 because two items have been popped.");
    
    assertEquals(stack.pop().getString(), "+", "Last to pop is Symbol/String:+ as it was the last to be pushed");
    
    assertEquals(stack.size(), 0, "Everything has been popped therefore the stack should be empty (returns 0).");
    
    assertThrows(EmptyStackException.class, () -> stack.pop(), "No more in stack, an empty stack should throw an exception");
  }
}
