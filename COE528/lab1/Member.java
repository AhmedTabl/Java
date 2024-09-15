package coe528.lab1;

/**
 *
 * @author ahmed
 */
public class Member extends Passenger{
    
    int yearsOfMembership;

    public Member(String name, int age) {
        super(name, age);
    }
    
    
    @Override
    public double applyDiscount(double p){
        
        if(this.yearsOfMembership > 5){
            
            return p/2.0;
        
        }else if(this.yearsOfMembership <=5 && this.yearsOfMembership > 1){
        
            return p -(p*10.0/100.0);
            
        }else{
            
            return p;
        
        }
    }

    public void setYearsOfMembership(int yearsOfMembership) {
        this.yearsOfMembership = yearsOfMembership;
    }

    public int getYearsOfMembership() {
        return yearsOfMembership;
    }
}
