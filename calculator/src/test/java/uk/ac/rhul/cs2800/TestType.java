package uk.ac.rhul.cs2800;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class TestType {
 
  //Test 1 - Testing if all enums are in class by adding them to the to a set (no duplicates) and making sure they're 4
  //(for 4 enums in Type)
  @SuppressWarnings({"unchecked", "rawtypes", "unused"})
  @Test 
  void type() {
    HashSet h = new HashSet();
    for (uk.ac.rhul.cs2800.Type var : Type.values()) {
      h.add(Type.values());
    }
    assertEquals(h.size(), 4);
  }
} 
