package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStandard {

  StandardCalc stan;

  @BeforeEach
  void start() {
    stan = new StandardCalc();
  }
  
  //Test 1 - testing plus operation.
  @Test
  void testEval() throws EmptyStackException, BadTypeException, InvalidExpression {
    assertEquals(stan.evaluate("3+4"), 7, "3 + 4 is 7 testing method.");
  }
  
  //Test 2 - testing minus operation.
  @Test
  void testMinus() throws EmptyStackException, BadTypeException, InvalidExpression {
    assertEquals(stan.evaluate("9-5"), 4, "9 - 5 is 4 testing method.");
  }
  
  //Test 3 - testing multiplication operation.
  @Test
  void testMult() throws EmptyStackException, BadTypeException, InvalidExpression {
    assertEquals(stan.evaluate("3*3"), 9, "3 * 3 is 9 testing method.");
  }
  
  //Test 4 - test division operation.
  @Test
  void testDiv() throws EmptyStackException, BadTypeException, InvalidExpression {
    assertEquals(stan.evaluate("9/3"), 3, "9 / 3 is 3 testing method.");
  }
}
