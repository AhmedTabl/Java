public class Account{
    
    private String name;
    private double balance;
    private int number;
    
    public Account(String name, int number, double initialBalance){
        
        this.name = name;
        this.number= number;
        this.balance = initialBalance;
        
    }
    
    public String getName(){
        
        return this.name;
    }
    
    public int getNumber(){
        
        return this.number;
        
    }
    
    public double getBalance(){
        
        return this.balance;
        
    }
    
    public boolean deposit(double amount){
        
        if(amount > 0){
            
            this.balance += amount;
            return true;
        }else{
            
         return false;   
        }
    }
    
    public boolean withdraw (double amount){
        
        if(amount > 0 && amount <= this.balance){
            
            this.balance -= amount;
            return true;
        }else{
            
         return false;   
        }
    }
    
    @Override
    public String toString() {//DO NOT MODIFY
    
        return "(" + getName() + ", " + getNumber() + ", " +
        String.format("$%.2f", getBalance()) + ")";
    
    }
    
    
}