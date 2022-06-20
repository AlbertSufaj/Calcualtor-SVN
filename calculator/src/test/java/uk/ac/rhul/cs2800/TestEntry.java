package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestEntry {
  //Variables are intialised here to be used later
  Entry entry;
  Entry entry1;
  Entry entry2;

  @BeforeEach //Before anything the constructors are 'tested' to be used within the test class
  public void first() {
    entry = new Entry("+");
    entry1 = new Entry(Symbol.DIVIDE);
    entry2 = new Entry(1);
  }

  @Test // Test 1 - Testing for the first of the constructors passing a float value.
  void testConstructor1() {
    @SuppressWarnings("unused")
    Entry entry = new Entry((float) 2.1);
  }

  @Test // Test 2 - Testing for the second constructor passing a symbol
  void testConstructor2() {
    @SuppressWarnings("unused")
    Entry entry = new Entry(Symbol.DIVIDE);
  }

  @Test // Test 3 - Testing for last constructor passing a string
  void testConstructor3() {
    @SuppressWarnings("unused")
    Entry entry = new Entry("hello");
  }

  @Test // Test 4 - Testing the getter for the variable:number whilst also testing BadTypeException
  void testGetNumber() throws BadTypeException {
    assertEquals(entry2.getNumber(), 1,
        "variable:entry passes float:1 through its constructor so the getnumber should be 1");
    assertThrows(BadTypeException.class, () -> entry.getNumber(), "If the Number is 0");
  }

  @Test // Test 5 - Testing the gettter for any string value inputed whilst also testing BadTypeException
  void testGetString() throws BadTypeException {
    assertEquals(entry.getString(), "+",
        "This is a test for the getter passing the correct values");
    assertThrows(BadTypeException.class, () -> entry1.getString(), "If the string is null");
  }

  @Test // Test 6 - testing the getter for any symbol used whilst also testing BadTypeException
  void testGetSymbol() throws BadTypeException {
    assertEquals(entry1.getSymbol(), Symbol.DIVIDE,
        "enum:DIVIDE was passed through contructor therefore testing for Symbol:DIVIDE");
    assertThrows(BadTypeException.class, () -> entry.getSymbol(),
        "If the symbol isn't of one of the Symbol enums");
  }

  @Test // Test 7 - testing the getter for any type used whilst also testing BadTypeException
  void testGetType() throws BadTypeException {
    assertEquals(entry.getType(), Type.STRING,
        "entry uses a string therefore the return should be String.");
  }
}
