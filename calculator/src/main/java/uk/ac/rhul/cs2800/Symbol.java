package uk.ac.rhul.cs2800;

/**
 * The Symbol class for all opcode of a calculator.
 * 
 * @author Albert Sufaj
 */
public enum Symbol {
  LEFT_BRACKET("("), RIGHT_BRACKET(")"), TIMES("*"), DIVIDE("/"), PLUS("+"), MINUS("-"), INVALID(
      "%");

  private String symbol;

  Symbol(String symbol) {
    this.symbol = symbol;
  }

  /**
   * Getter to get string symbol.
   * @return String:symbol
   */
  public final String getValue() {
    return symbol;
  }
}
