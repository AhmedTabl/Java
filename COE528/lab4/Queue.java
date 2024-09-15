package coe528.lab4;

import java.util.ArrayList;

/**
 *
 * @author ahmed
 */
public class Queue<T> {
// Overview: queue is a collection of elements where the first added element is the first to be removed. It follows
//the FIFO (First-In-First-Out) principle
//
// The abstraction function is: The arraylist(elements) represents a queue where the tip
// of the queue is the first element of elements and the tail of the queue
// is the last element of elements. Enqueing(adding) an element represents adding it to the tail, 
//while dequeing(removing) an element represents removing it from the tip. 
//Each element is of the same type T.
//
//
//
//The rep invariant is: The arraylist(elements) is not null and does not contain null elements.
//
//
//
//
    
// An ArrayList to store the queue elements
    private ArrayList<T> elements = new ArrayList<>();

    // Method to add an element to the queue
    public void enqueue(T elem){
        // Adding the element to the end of the ArrayList
        elements.add(elem);
    }
    
    // Method to remove and return the first element from the queue
    public T dequeue(){
        // Storing the first element
        T tip = elements.get(0);
        
        // Removing the first element from the ArrayList
        elements.remove(0);
        
        // Returning the removed element
        return tip;
    }
    
    // Method to check if the queue is empty
    public boolean isEmpty(){
        // Checking the rep invariant, and returning true if it's not satisfied
        if (!(this.repOK())) {
            return true;
        } else {
            return false;
        }
    }
    
    // Method to return a string representation of the queue
    public String toString(){
        // Initializing an empty string
        String q = "";
        
        // Iterating over all elements in the ArrayList
        for (int i = 0; i < elements.size(); i++) {
            // Concatenating each element to the string
            q += elements.get(i);
        }
        
        // Returning the concatenated string
        return q;
    }

    // Method to check the representation invariant of the queue
    public boolean repOK(){
        // Checking if the ArrayList is not null
        if (elements == null) {
            return false;
        }
        
        // Checking if any element in the ArrayList is null
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) == null) {
                return false;
            }
        }
        
        // If the ArrayList and its elements are not null, return true
        return true;
    }
}
