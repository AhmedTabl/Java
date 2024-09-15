import java.util.LinkedList;
import java.util.ArrayList;

public class Main
{
	public static void main(String[] args) {
    	
    	vertex v0 = new vertex(0);
    	vertex v1 = new vertex(1);
    	vertex v2 = new vertex(2);
    	vertex v3 = new vertex(3);
    	vertex v4 = new vertex(4);
    	vertex v5 = new vertex(5);
    	vertex v6 = new vertex(6);
    	
    	
    	addEdge(v0,v6);
    	addEdge(v1,v2);
    	addEdge(v1,v5);
    	addEdge(v2,v3);
    	addEdge(v2,v4);
    	addEdge(v2,v5);
    	addEdge(v3,v4);
    	addEdge(v4,v5);
    	addEdge(v4,v6);
    	
    
        DFS(v5);
        
        System.out.println("");
        
     	BFS bfs = new BFS(v5);
        bfs.traverse();
        
        System.out.println(degreeVertex(v3));
        
    	
	}  
	
	
	
	
	public static void DFS(vertex a){
	    
	    ArrayList<vertex> visitedNodes = new ArrayList<vertex>();
	    
	    DFSUtil(a, visitedNodes);
	    
	    
	    
	    for(int i = 0; i < visitedNodes.size(); i++){
	        
	        System.out.print(visitedNodes.get(i).getNode_num());
	    }
	    
	}
	
	public static void DFSUtil(vertex v, ArrayList<vertex> visitedNodes){
	    
	    visitedNodes.add(v);
	    v.setIsVisited(true);
	    
	    for(vertex adj: v.getAdjacentNodes()){
	        
	        if(!adj.getIsVisited()){
	            
	            DFSUtil(adj, visitedNodes);
	        }
	        
	    }
	    
	    
	}
	
	
    public static void addEdge(vertex a, vertex b){
    	    
    	    a.getAdjacentNodes().add(b);
    	    b.getAdjacentNodes().add(a);
    	    
    	}
    	
    public static int degreeVertex(vertex a){
        
        return a.getAdjacentNodes().size();
        
        
    }
    
    public static void printAdjVertices(vertex a){
        
        System.out.println("Adjacent vertices to node" + a.getNode_num());
        
        for(int i = 0; i < a.getAdjacentNodes().size(); i++){
            
            System.out.println(a.getAdjacentNodes().get(i).getNode_num());
        }
        
    }
    	
	}
	
