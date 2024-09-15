/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author atabl
 */
public class Circuit {
    
  private static Circuit instance = null;
  ArrayList<Resistor> resistors = new ArrayList<Resistor>();
 
  public static Circuit getInstance()
  {
    if (instance == null){
        
	    instance = new Circuit();
	    
      }
      
    return instance;
  }
  
  private Circuit(){}
  
  
  public void add(Resistor r){
        
        this.resistors.add(r);
        
    }
    
    
    @Override
    public String toString(){
        
        String s = "";
        
        for(Resistor res: this.resistors){
            
            s += res.toString()+"\n";
            
        }
        
        return s;
    
    }
    
    
    public static void main(String[] args) {
        Circuit cir = Circuit.getInstance();
        
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        
        Resistor r1 = new Resistor(2,n1,n1);
        Resistor r2 = new Resistor(100,n2,n3);
        Resistor r3 = new Resistor(1000,n3,n4);
        
        cir.add(r1);
        cir.add(r2);
        cir.add(r3);
        
        System.out.println(cir);
        
    }
    
}
