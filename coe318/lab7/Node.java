/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe318.lab7;
/**
 * Represents a node in an electrical circuit.
 * 
 * <p>
 * A node is a point in the circuit where two or more circuit elements are connected.
 * Each node is assigned a unique identifier.
 * </p>
 * 
 * @author atabl
 */
public class Node {
    
    /**
     * Static variable to keep track of the next available identifier for a node.
     */
    private static int ID = 0;
    
    /**
     * Unique identifier for each individual node.
     */
    private int individual_ID;
    
    /**
     * Constructs a Node with the specified identifier.
     * 
     * @param idNum The identifier for the node.
     */
    public Node(int idNum){
        individual_ID = idNum;
        ID++;
    }
    
    /**
     * Returns a string representation of the node.
     * 
     * @return A string containing the unique identifier of the node.
     */
    public String toString(){
        return Integer.toString(this.individual_ID);
    }
    
}
