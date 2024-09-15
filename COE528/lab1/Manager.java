package coe528.lab1;

/**
 *
 * @author ahmed
 */
public class Manager {
    
    
    public Flight[] flights = new Flight[100];
    public Ticket[] tickets = new Ticket[1000];
    
    
    
    public void createFlights(){
        
        for(int i = 0; i < flights.length; i++){
        
            
            flights[i] = new Flight((i+1),100,"o","d","",0);
        }
    
    }
    
    
    public void displayAvailableFlights(String origin, String destination){
        
         System.out.println("Available Flights: ");
    
        for(int i = 0; i < flights.length; i++){
            
            if(flights[i].getOrigin().equals(origin) && flights[i].getDestination().equals(destination) && flights[i].getNumberOfSeatsLeft() > 0){
                
               
                System.out.println(flights[i]);
            }
            
        }
    
    }
    
    
    public Flight getFlight(int flightNumber){
        
        boolean flightExists = false;
        int flightIndex = 0;
        
        for(int i = 0; i < flights.length; i++){
            
            if(flights[i].getFlightNumber() == flightNumber){
                
                flightExists = true;
                flightIndex = i;
            }
            
        }
        
        if(flightExists){
        
            return flights[flightIndex];
            
        }else{
        
            return null;
        }
    
    }
    
    public void bookSeat(int flightNumber, Passenger p){
    
        if(this.getFlight(flightNumber) != null && this.getFlight(flightNumber).getNumberOfSeatsLeft() > 0){
        
            this.getFlight(flightNumber).bookASeat();
            
            if(p instanceof Member){
                
                System.out.println("Members Price: " + p.applyDiscount(this.getFlight(flightNumber).getOriginalPrice()));
            
            }else if(p instanceof NonMember){
            
                System.out.println("NonMembers Price: "+ p.applyDiscount(this.getFlight(flightNumber).getOriginalPrice()));
            }
            
        }
        
        
        
    }
    
    
    public static void main(String args[]){
        
        Manager manager = new Manager();
        manager.createFlights();
        
        manager.getFlight(1).setOrigin("Toronto");
        manager.getFlight(1).setDestination("Montreal");
        manager.getFlight(1).setOriginalPrice(130);
        manager.getFlight(1).setDepartureTime("12:00 am");
        
        manager.getFlight(2).setOrigin("Egypt");
        manager.getFlight(2).setDestination("Canada");
        manager.getFlight(2).setOriginalPrice(350);
        manager.getFlight(2).setDepartureTime("10:00 am");
        
        manager.getFlight(3).setOrigin("China");
        manager.getFlight(3).setDestination("North Korea");
        manager.getFlight(3).setOriginalPrice(240);
        manager.getFlight(3).setDepartureTime("7:00 pm");
        
        manager.getFlight(4).setOrigin("Toronto");
        manager.getFlight(4).setDestination("Montreal");
        manager.getFlight(4).setOriginalPrice(110);
        manager.getFlight(4).setDepartureTime("1:00 pm");
        
        manager.displayAvailableFlights("Toronto", "Montreal");
        
        
        
        Member p1 = new Member("ahmed",18);
        p1.yearsOfMembership = 8;
        manager.bookSeat(3, p1);
        System.out.println(manager.getFlight(3).getNumberOfSeatsLeft());
        
        
        NonMember p2 = new NonMember("makeenudeen",67);
        manager.bookSeat(3, p2);
        System.out.println(manager.getFlight(3).getNumberOfSeatsLeft());
        
        
        
    
    }
}
