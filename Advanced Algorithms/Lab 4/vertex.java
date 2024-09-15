import java.util.LinkedList;

public class vertex{
    
    private final LinkedList<vertex> adjacentNodes;
    private final int node_num;
    private boolean isVisited;
    private int capacity;
    
    public vertex(int num){
        
        adjacentNodes = new LinkedList<>();
        this.node_num = num;
        isVisited = false;
        
    }
    
    public int getNode_num(){
        
        return node_num;
        
    }
    
    public LinkedList<vertex> getAdjacentNodes(){
        
        return adjacentNodes;
        
    }
    
    //getter for visited flag
    public boolean getIsVisited(){
        
        return isVisited;
        
    }
    
    //setter for visited flag
    public void setIsVisited(boolean b){
        
        isVisited = b;
        
    }
    
    //setter for capacity
    public void setCapacity(int cap){
        
        capacity = cap;
    }
    
    //getter for capacity
    public int getCapacity(){
        
        return capacity;
        
    }
    
    
}