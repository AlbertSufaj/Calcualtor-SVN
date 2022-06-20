package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

/**
 * @author Albert Sufaj
 * 
 */
class TestSymbol {
  //Test 1 - Testing if all enums are in class by adding them to the to a set (no duplicates) and making sure they're 7
  //(for all 7 enums in Symbol)
  @SuppressWarnings("unchecked")
  @Test 
  void Symbol() {
    @SuppressWarnings("rawtypes")
    HashSet h = new HashSet();
    for (@SuppressWarnings("unused") uk.ac.rhul.cs2800.Symbol var : Symbol.values()) {
      h.add(Symbol.values());
    }
    assertEquals(h.size(), 7, "There are 7 enums, therefore there will be 7 items in the set");
  }
}
