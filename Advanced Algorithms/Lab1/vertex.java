import java.util.LinkedList;

public class vertex{
    
    private LinkedList<vertex> adjacentNodes;
    private int node_num;
    private boolean isVisited;
    
    public vertex(int num){
        
        adjacentNodes = new LinkedList<vertex>();
        this.node_num = num;
        isVisited = false;
        
    }
    
    public int getNode_num(){
        
        return node_num;
        
    }
    
    public LinkedList<vertex> getAdjacentNodes(){
        
        return adjacentNodes;
        
    }
    
    public boolean getIsVisited(){
        
        return isVisited;
        
    }
    
    public void setIsVisited(boolean b){
        
        isVisited = b;
        
    }
    
    
}