package coe528.lab3;

/**
 *
 * @author ahmed
 */
public class Odometer implements Counter{
    
    int nOfDigits;
    Counter digits[];
            
    public Odometer(int n){
        
        if(n >= 1){
            
            this.nOfDigits = n;
            this.digits = new Counter[this.nOfDigits];
            
            this.digits[0] = new DigitCounter();
            
            for(int i = 1; i < this.digits.length; i++){
                
                this.digits[i] = new LinkedDigitCounter(this.digits[i-1]);
            
            }
            
            
        }else{
        
            throw new IllegalArgumentException("Invalid digit count!");
        }
    
    
    }
    
    
    
    @Override
    public String count(){
        
        String value = "";
        
        for(int i = 0; i < this.digits.length; i++){
                
                value+=this.digits[i].count();
            
            }
        
        return value;
    }
    
    @Override
    public void increment(){
    
        this.digits[this.digits.length-1].increment();
    }
    
    @Override
    public void decrement(){
        
        this.digits[this.digits.length-1].decrement();
    
    }
    
    @Override
    public void reset(){
        
        for(int i = 0; i < this.digits.length; i++){
                
                this.digits[i].reset();
            
            }
    
    }
       
    
}
