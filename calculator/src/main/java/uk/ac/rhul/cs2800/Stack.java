package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * The main Stack class where the magic happens (entries from user are stored).
 * 
 * @author Albert Sufaj
 * 
 */
public class Stack {
  int size; // assign size to 0, items in stack
  List<Entry> entries; // ArrayList to take Entry class types.
  
  /**
   * Constructor to initialise the stack class with the size and list.
   */
  public Stack() {
    this.size = 0;
    this.entries = new ArrayList<Entry>();
  }
  
  /**
   * To find the size of the stack.
   * 
   * @return the size of the stack as an integer
   */
  public int size() {
    return size;
  }

  /**
   * Push/adds Entry items to the stack. Size increase by 1;
   * 
   * @param i the entry from the user via Entry class
   */
  public void push(Entry i) {
    entries.add(i); // adds Entry:i to the ArrayList
    size++; // increments size of stack by 1 after item is added
  }

  /**
   * Removes the item from stack top. Decreases size by 1.
   * 
   * @return the item from stack top
   */
  public Entry pop() {
    Entry temp; // Assign temp value for- the item.
    if (size == 0) {
      throw new EmptyStackException();
    }
    temp = entries.get(size - 1); // The item set as variable temp
    entries.remove(size - 1); // The item is removed from ArrayList
    size--; // Size decrease by 1.
    return temp; // Returns temp value.
  }

  /**
   * Peeks the stack top by looking at last index.
   * 
   * @return item at the top of stack
   */
  public Entry top() {
    return entries.get(size - 1); // Same as pop, but not removed. Just peeking init.
  }
}
