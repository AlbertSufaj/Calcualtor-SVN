package uk.ac.rhul.cs2800;

import java.util.Objects;

/**
 * To dictate what the user inputs when using the calculator.
 * 
 * @author Albert Sufaj
 */
public class Entry {
  //Below I've assigned all variables to their fail states.
  float number = 0;
  Symbol which = Symbol.INVALID; 
  String str = "";
  Type type = Type.INVALID; 

  /**
   * Constructor passing numbers inputed by the user.
   * 
   * @param number float number used for numbers in calculator
   */
  public Entry(float number) {
    this.number = number;
    this.type = Type.NUMBER;
  }

  /**
   * Constructor passing any symbols in calculator used by the user.
   * 
   * @param which Symbol variable used for opcodes of a calculator
   */
  public Entry(Symbol which) {
    this.which = which;
    this.type = Type.SYMBOL;
  }

  /**
   * Constructor passing any strings inputed by the user.
   * 
   * @param str string variable for string inputs
   */
  public Entry(String str) {
    this.str = str;
    this.type = Type.STRING;
  }

  /**
   * Getter for any number used by the user.
   * 
   * @return float:number in the calculator.
   * 
   * @throws BadTypeException when number is 0
   */
  public float getNumber() throws BadTypeException {
    if (number == 0) {
      throw new BadTypeException();
    }
    return number;
  }

  /**
   * Getter for any string inputs from calculator.
   * 
   * @return String:str for any string inputs
   * 
   * @throws BadTypeException when str is an empty string
   */
  public String getString() throws BadTypeException {
    if (str == "") {
      throw new BadTypeException();
    }
    return str;
  }


  /**
   * Getter for any symbols used by the user.
   * 
   * @return variable Symbol:which for Symbols
   * 
   * @throws BadTypeException when which is INVALID
   */
  public Symbol getSymbol() throws BadTypeException { 
    if (which == Symbol.INVALID) {
      throw new BadTypeException();
    }
    return which;
  }

  /**
   * Getter for the enums Type used to dictate what type of data has been inputted.
   * 
   * @return variable Type:type for types 
   * 
   * @throws BadTypeException when the type is INVALID
   */
  public Type getType() throws BadTypeException {
    if (type == Type.INVALID) { //INVALID being the incorrect input
      throw new BadTypeException();
    }
    return type;
  }

  /**
   *Hash code method used to apply hash function to both str and type.
   * 
   *@return hash function for str and type
   */
  @Override
  public int hashCode() {
    return Objects.hash(str, type); //return hash value for str & type
  }

  /**
   *Equals method used to check if two strings are equal on str and type.
   *@return boolean depending if the values are equal
   */
  @Override //equals class for str & type.
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof Entry)) {
      return false;
    }
    Entry other = (Entry) obj;
    return Objects.equals(str, other.str) && type == other.type;
  }

}
