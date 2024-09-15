/**
 *
 * @author Ahmed Tabl
 */
public class Counter {
    //Instance variables here
    int modulus;
    Counter left;
    int digitVal = 0;
    
    public Counter(int modulus, Counter left) {
        this.modulus = modulus;
        this.left= left;
    }


    /**
     * @return the modulus
     */
    public int getModulus() {
        return modulus;
    }

    /**
     * Returns the Counter to the left attached to this
     * Counter.  Returns null if there is no Counter
     * to the left.
     * @return the left
     */
    public Counter getLeft() {
        return left;
    }

    /**
     * @return the digit
     */
    public int getDigit() {
        
        return digitVal;
    }

    /**
     * @param digit the digit to set
     */
    public void setDigit(int digit) {
        
        this.digitVal = digit;
    }

    /**
     * Increment this counter.  If it rolls over,
     * its left Counter is also incremented if it
     * exists.
     */
    public void increment() {
        
        increment(1);
    }
    
    public void increment(int amount) {

    int newCount = getDigit() + amount;
    
    // Handle rollover
    if (newCount <= modulus-1) {
        
        setDigit(newCount);
        
    }else{
        
        if(left == null){
            
            setDigit(0);
            
        }else{
            
            setDigit(0);
            left.setDigit(left.getDigit()+1);
        }
        
    }
}

    /** Return the count of this Counter combined
     * with any Counter to its left.
     *
     * @return the count
     */
    public int getCount() {
        
        if (left == null) {

        return getDigit();
        
    } else {

        return getDigit() + modulus * left.getCount();
    }
}

    /** Returns a String representation of the Counter's
     * total count (including its left neighbour).
     * @return the String representation
     */
    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        return "" + getCount();
    }

}
