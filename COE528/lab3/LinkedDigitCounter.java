package coe528.lab3;

/**
 *
 * @author ahmed
 */
public class LinkedDigitCounter extends AbstractCounter{
    
        Counter leftNeighbor;
        
        public LinkedDigitCounter(Counter c){
            
            super();
            this.leftNeighbor = c;
        
        }
        
    @Override
    public String count(){
        
        return Integer.toString(this.value);
    }
    
    @Override
    public void increment(){
    
        if(this.value < 9){
            
            this.value++;
        
        }else{
        
            this.value = 0;
            leftNeighbor.increment();
        }
    }
    
    @Override
    public void decrement(){
        
        if(this.value > 0){
            
            this.value--;
        
        }else{
        
            value = 9;
            leftNeighbor.decrement();
        }
    
    
    }
    
    @Override
    public void reset(){
        
        this.value = 0;
    
    }
    
}
