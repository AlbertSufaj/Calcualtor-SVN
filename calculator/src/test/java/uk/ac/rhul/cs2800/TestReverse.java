package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestReverse {
  RevPolishCalc reverse;
  NumStack values;
  
  @BeforeEach
  void testClass() {
    reverse = new RevPolishCalc();
    //reverse.evaluate("Hello!");
  }
  
  //Test 1 - simple test just to make sure things are in order.
  @Test
  void testEval() throws InvalidExpression, EmptyStackException, BadTypeException {
    assertEquals(reverse.evaluate("34+"), 7, "Testing evaluate method returns a float value.");
  }

  //Test 2 - testing InvalidExpression exception.
  @Test
  void testExc() {
    //assertThrows(InvalidExpression.class, () -> reverse.evaluate(""), "Expecting error to throw.");
    //assertThrows(BadTypeException.class, () -> reverse.evaluate(""), "Expecting error to throw.");
    assertThrows(EmptyStackException.class, () -> reverse.evaluate(""), "Expecting error to throw.");
  }
  
  //Test 3 - testing plus expression.
  @Test
  void testPlus() throws InvalidExpression, EmptyStackException, BadTypeException {
    assertEquals(reverse.evaluate("55+"), 10, "Testing plus expression");
  }
  
  //Test 4 - testing minus expression.
  @Test
  void testMinus() throws InvalidExpression, EmptyStackException, BadTypeException {
    assertEquals(reverse.evaluate("95-"), 4, "Testing minus expression");
  }
  
  //Test 5 - testing division expression.
  @Test
  void testDiv() throws InvalidExpression, EmptyStackException, BadTypeException {
    assertEquals(reverse.evaluate("93/"), 3, "Testing division expression");
  }
  
  //Test 6 - testing multiplication expression.
  @Test
  void testMult() throws InvalidExpression, EmptyStackException, BadTypeException {
    assertEquals(reverse.evaluate("55*"), 25, "Testing evaluate method returns a float value.");
  }
  
}
