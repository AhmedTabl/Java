package coe528.lab3;

/**
 *
 * @author ahmed
 */
public interface Counter {
    
    //The current value of this Counter as a String of digits.
    public String count();
    //Increment this Counter.
    public void increment();
    //Decrement this Counter.
    public void decrement();
    //Reset this Counter.
    public void reset();
    
}
