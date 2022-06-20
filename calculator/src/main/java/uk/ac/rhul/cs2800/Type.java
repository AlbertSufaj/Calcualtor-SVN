package uk.ac.rhul.cs2800;

/**
 * Enum class to dictate what data type is being used whilst using the calculator.
 * 
 * @author Albert Sufaj
 */
public enum Type {
  NUMBER, SYMBOL, STRING, INVALID;

  private Type type;

  Type(Type type) {
    this.type = type;
  }

  Type() {}

  /**
   * Getter for the type used.
   * 
   * @return Type:type used
   */
  public final Type getType() {
    return type;
  }
}
