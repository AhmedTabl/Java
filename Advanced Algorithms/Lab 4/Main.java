import java.util.LinkedList;
import java.util.Queue;


public class Main {

	public static void main(String[] args) {
		
		vertex S = new vertex(0);
		vertex T = new vertex(13);
		
		//Applicant nodes
		vertex a1 = new vertex(1);
		vertex a2 = new vertex(2);
		vertex a3 = new vertex(3);
		vertex a4 = new vertex(4);
		vertex a5 = new vertex(5);
		vertex a6 = new vertex(6);
		
		//Job nodes
		vertex j1 = new vertex(7);
		vertex j2 = new vertex(8);
		vertex j3 = new vertex(9);
		vertex j4 = new vertex(10);
		vertex j5 = new vertex(11);
		vertex j6 = new vertex(12);
		
		//Connecting the source node to all the applicant nodes
		addEdge(S,a1);
		addEdge(S,a2);
		addEdge(S,a3);
		addEdge(S,a4);
		addEdge(S,a5);
		addEdge(S,a6);
		
		//Connecting all the job nodes to the sink node
		addEdge(j1,T);
		addEdge(j2,T);
		addEdge(j3,T);
		addEdge(j4,T);
		addEdge(j5,T);
		addEdge(j6,T);
		
		//Connecting applicants to their desired jobs
		addEdge(a1,j2);
		addEdge(a1,j3);
		
		addEdge(a3,j1);
		addEdge(a3,j4);
		
		addEdge(a4,j3);
		
		addEdge(a5,j3);
		addEdge(a5,j4);
		
		addEdge(a6,j6);
                
                //building matrix for graph
                int[][] matrix = buildMatrix();
                //calculating MaxFlow with Ford Fulkerson
                int maxFlow = fordFulkerson(matrix, 0, 13);
                
                
                System.out.println("The maximum number of applicants matching for the job is " + maxFlow+".");
                
		
	}
	//Add edges between vertecies
	    public static void addEdge(vertex a, vertex b){
    	    
    	    a.getAdjacentNodes().add(b);
    	    
    	}
            //building capacity matrix
private static int[][] buildMatrix(){
    //number of nodes
    int n=14;
    int[][] capacity = new int[n][n];
    
    //capacities for edges (s to applicants)
        capacity[0][1] = 1;
        capacity[0][2] = 1;
        capacity[0][3] = 1;
        capacity[0][4] = 1;
        capacity[0][5] = 1;
        capacity[0][6] = 1;

        
        //capacities for edges (jobs to t)
        capacity[7][13] = 1;
        capacity[8][13] = 1;
        capacity[9][13] = 1;
        capacity[10][13] = 1;
        capacity[11][13] = 1;
        capacity[12][13] = 1;

        //capacities for edges (applicants to jobs)
        capacity[1][8] = 1;
        capacity[1][9] = 1;

        capacity[3][7] = 1;
        capacity[3][10] = 1;

        capacity[4][9] = 1;

        capacity[5][9] = 1;
        capacity[5][10] = 1;

        capacity[6][12] = 1;

        return capacity;
    }

//bfs search is used to find AUGMENTING PATH
private static boolean bfs(int[][] capacity, int[][] capacityResidual, int s, int t, int[] prev){
    boolean[] visited = new boolean[capacity.length];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);
    visited[s]=true;
    
    while(!queue.isEmpty()){
        int u = queue.poll(); //note poll() returns frontmost value at queue
        
        for (int v = 0; v<capacity.length; v++){
            if(!visited[v] && capacityResidual[u][v]>0){
                queue.add(v);
                visited[v]=true;
                prev[v]=u;
                
                if(v==t){
                    return true;
                }
            }
        }
    }
    return false;
}

//FORD FULKERSON METHOD!! CALCULATES MAXFLOW in graph
    private static int fordFulkerson(int[][] capacity, int s, int t){
        int u;
        int v;
        int[][] capacityResidual = new int[capacity.length][capacity.length];
        
        //initializing capacities (residual, aka backwards)
        for(u=0;u<capacity.length;u++){
            for(v=0;v<capacity[u].length;v++){
                capacityResidual[u][v] = capacity[u][v];
            }
        }
        int[] prev = new int[capacity.length];
        int maxFlow = 0;
        
        //augmenting flow while path exists from s to t
        while(bfs(capacity, capacityResidual, s,t,prev)){
            int pathFlow = Integer.MAX_VALUE;
            
            for (v = t; v != s; v = prev[v]) {
                u = prev[v];
                pathFlow = Math.min(pathFlow, capacityResidual[u][v]);
            }
            for (v = t; v != s; v = prev[v]) {
                u = prev[v];
                capacityResidual[u][v] -= pathFlow;
                capacityResidual[v][u] += pathFlow;
            }
            maxFlow += pathFlow;
        }
        return maxFlow;
    }
}