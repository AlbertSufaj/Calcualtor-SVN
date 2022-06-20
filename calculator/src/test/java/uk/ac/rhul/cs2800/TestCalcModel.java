package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCalcModel {
  
  CalcModel model;
  
  @BeforeEach
  void test() {
    model = new CalcModel();
  }
  
  //Test 1 - Passing a boolean value of true with expression infix.
  @Test
  void testInfix() throws EmptyStackException, InvalidExpression, BadTypeException {
    assertEquals(model.evaluate("2+2", true), 4, "testing passing infix expression.");
  }
  
  //Test 2 - passing false and reverse polish expression.
  @Test
  void testPostfix() throws EmptyStackException, InvalidExpression, BadTypeException {
    assertEquals(model.evaluate("22+", false), 4, "testing passing infix expression.");
  }
}
