package coe528.lab1;
/**
 *
 * @author ahmed
 */
public class Flight {
   
    //Initialize Instance Variables
    int flightNumber, capacity, numberOfSeatsLeft;
    String origin, destination, departureTime;
    double originalPrice;
   
    //Constructor
    public Flight (int flightNumber, int capacity, String origin, String destination, String departureTime, double originalPrice ){
        
        if(origin == destination){
        
            throw new IllegalArgumentException("Origin and destination cannot be the same!");
        }else{
            
            this.origin = origin;
            this.destination = destination;
        
        }
        
        this.flightNumber = flightNumber;
        this.capacity = capacity;
        this.numberOfSeatsLeft = this.capacity;
        this.departureTime = departureTime;
        this.originalPrice = originalPrice;
        
        
        
    }
    
    
    public boolean bookASeat(){
    
        if(this.numberOfSeatsLeft > 0){
            
            this.numberOfSeatsLeft--;
            return true;
            
        }else{
        
            return false;
        }
    }
    
    @Override
    public String toString(){
        
        return "Flight " + this.flightNumber + ", " + this.origin + " to " + this.destination + ", " + this.departureTime + ", " + "Original Price: " + this.originalPrice  + "$";
    }
    
    
    
    //Getters for each instance variable
    public int getFlightNumber(){
        return this.flightNumber;
    }
    public int getCapacity(){
        return this.capacity;
    }
    public int getNumberOfSeatsLeft(){
        return this.numberOfSeatsLeft;
    }
    public String getOrigin(){
        return this.origin;
    }
    public String getDestination(){
        return this.destination;
    }
    public String getDepartureTime(){
        return this.departureTime;
    }
    public double getOriginalPrice(){
        return this.originalPrice;
    }
   
    //Setters for each instance variable
    public void setFlightNumber(int flightNumb){
       this.flightNumber = flightNumb;
    }
    public void setCapacity(int newCapacity){
        this.capacity = newCapacity;
    }
    public void setNumberOfSeats(int seats){
       this.numberOfSeatsLeft = seats;
    }
    public void setOrigin (String orig){
       this.origin = orig;
    }
    public void setDestination(String dest){
       this.destination = dest;
    }
    public void setDepartureTime(String depTime){
       this.departureTime = depTime;
    }
    public void setOriginalPrice(double price){
        
        this.originalPrice = price;
       
    }
}