package coe528.lab1;

/**
 *
 * @author ahmed
 */
public class NonMember extends Passenger{
    
    public NonMember(String name, int age){
        
        super(name,age);
    
    }
    
    @Override
    public double applyDiscount(double p){
        
        if(this.age > 65){
            
            return p -(p*10.0/100.0);
            
        }else{
            return p;
        }
        
    
    }
    
}
