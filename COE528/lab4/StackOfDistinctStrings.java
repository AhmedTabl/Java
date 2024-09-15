package coe528.lab4;

/**
 *
 * @author ahmed
 */
import java.util.ArrayList;
public class StackOfDistinctStrings {
// Overview: StacksOfDistinctStrings are mutable, bounded
// collection of distinct strings that operate in
// LIFO (Last-In-First-Out) order.
//
// The abstraction function is:
// a) Write the abstraction function here
// The abstraction function is: The arraylist(items) represents a stack where the bottom
// of the stack is the first element of items and the top of the stack
// is the last element of items. Each element is a distinct string.
//
//
//
// The rep invariant is:
// b) Write the rep invariant here
//The rep invariant is: The arraylist(items) contains no null elements and no duplicate
// strings. The arraylist itself is not null.
//
//
//
//
private ArrayList<String> items;
// constructor
public StackOfDistinctStrings() {
// EFFECTS: Creates a new StackOfDistinctStrings object
items = new ArrayList<String>();
}
public void push(String element) throws Exception {
// MODIFIES: this
// EFFECTS: Appends the element at the top of the stack
// if the element is not in the stack, otherwise
// does nothing.
if(element == null) throw new Exception();
if(false == items.contains(element))
items.add(element);
}
public String pop() throws Exception {
// MODIFIES: this
// EFFECTS: Removes an element from the top of the stack
if (items.size() == 0) throw new Exception();
return items.remove(items.size()-1);
}

public boolean repOK() {
// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
// c) Write the code for the repOK() here
if(items == null){
return false;
}

for(int i = 0; i<items.size();i++){
    
    for(int j = i+1; j < items.size(); j++){
        
        if(items.get(i).equals(items.get(j)) || items.get(i) == null || items.get(j) == null){
        
        return false;
    }
    
    }  

}

return true;

}
public String toString() {
// EFFECTS: Returns a string that contains the strings in the
// stack and the top element. Implements the
// abstraction function.
// d) Write the code for the toString() here

String stack = "";

for(int i = 0; i<items.size();i++){

    
    stack += items.get(i);
    if(i<items.size()-1){
        stack += ", ";
    }
}

return stack;
}
}
