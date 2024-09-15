package coe528.lab3;

/**
 *
 * @author ahmed
 */
public class DigitCounter extends AbstractCounter{
    
    public DigitCounter(){
    
        super();
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
        }
    }
    
    @Override
    public void decrement(){
    
        if(this.value > 0){
            
            this.value--;
        
        }else{
        
            this.value = 9;
        }
    }
    
    @Override
    public void reset(){
        
        this.value = 0;
    
    
    }
}
