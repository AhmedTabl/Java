/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe318.lab7;
/**
 * Represents a resistor in an electrical circuit.
 * 
 * <p>
 * A resistor has a resistance value, and it is connected to two nodes in the circuit.
 * Each resistor is assigned a unique identifier.
 * </p>
 * 
 * @author atabl
 */
public class Resistor {
    
    /**
     * Resistance value of the resistor.
     */
    private double resistance;
    
    /**
     * Node representing one end of the resistor.
     */
    private Node node1;
    
    /**
     * Node representing the other end of the resistor.
     */
    private Node node2;
    
    /**
     * Static variable to keep track of the next available identifier for a resistor.
     */
    private static int ID = 1;
    
    /**
     * Unique identifier for each individual resistor.
     */
    private int individual_ID;
    
    /**
     * Constructs a Resistor with the specified resistance and connected nodes.
     * 
     * @param resistance The resistance value of the resistor. Must be greater than 0.
     * @param node1 The first node to which the resistor is connected.
     * @param node2 The second node to which the resistor is connected.
     * 
     * @throws IllegalArgumentException If the resistance is not greater than 0
     *                                  or if node1 is equal to node2 (invalid node connection).
     */
    public Resistor(double resistance, Node node1, Node node2){
        if(resistance > 0){
            this.resistance = resistance;
        }else{
            throw new IllegalArgumentException("Invalid resistance value!");
        }
        
        if(node1 != node2){
            this.node1 = node1;
            this.node2 = node2;
        }else{
            throw new IllegalArgumentException("Invalid node connection!");
        }
        
        individual_ID = ID;
        ID++;
    }
    
    /**
     * Gets the nodes to which the resistor is connected.
     * 
     * @return An array containing the two nodes connected to the resistor.
     */
    public Node[] getNodes(){
        Node[] n = {this.node1, this.node2};
        return n;
    }
    
    /**
     * Returns a string representation of the resistor.
     * 
     * @return A string containing the resistor's unique identifier,
     *         connected nodes, and resistance value.
     */
    
    public int getIndividualID(){
    
        return individual_ID;
        
    }
    
    public double getResistance(){
    
        return resistance;
        
    }
    @Override
    public String toString(){
        return "R" + this.individual_ID + " " + this.node1.toString() + " " + this.node2.toString() + " " + this.resistance;
    }
    
}
