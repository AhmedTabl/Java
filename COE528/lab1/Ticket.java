package coe528.lab1;

/**
 *
 * @author ahmed
 */
public class Ticket {
    
    Passenger passenger;
    Flight flight;
    double price;
    static int number = 0;
    
    public Ticket(Passenger passenger, Flight flight, double price){
    
        this.passenger = passenger;
        this.flight = flight;
        this.price = price;
        this.number++;
        
    }

    
    @Override
    public String toString(){
    
        return this.passenger.getName() + ", " + this.flight.toString() + ", Ticket Price: " + this.price + "$";
    }
    
    //Getters
    public Passenger getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public double getPrice() {
        return price;
    }

    public static int getNumber() {
        return number;
    }

    
    //Setters
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void setNumber(int number) {
        Ticket.number = number;
    }
    
    
    
    
    
}
