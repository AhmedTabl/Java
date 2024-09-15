/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author atabl
 */
public class Node {
    
    private static int ID = 0;
    private int individual_ID;
    
    public Node(){
        
        individual_ID = ID;
        ID++;
    }
    
    public String toString(){
        
        return Integer.toString(this.individual_ID);
        
    }
    
}
