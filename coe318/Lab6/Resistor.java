/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author atabl
 */
public class Resistor {
    
    private double resistance;
    private Node node1;
    private Node node2;
    private static int ID = 1;
    private int individual_ID;
    
    public Resistor(double resistance, Node node1, Node node2){
        
        if(resistance > 0)
        {
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
    
    
    
    public Node[] getNodes(){
        
        Node[] n = {this.node1, this.node2};
        return n;
        
    }
    
    
    @Override
    public String toString(){
        
        
        return "R"+this.individual_ID + " " + this.node1.toString() + " " + this.node2.toString() + " "+ this.resistance;
    
    }
    
}
