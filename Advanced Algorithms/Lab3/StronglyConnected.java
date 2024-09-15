// /*
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
//  */

// /**
//  *
//  * @author maheenashraf
//  */

// import java.util.ArrayList;
// import java.util.Random;
// import java.util.List;


// public class StronglyConnected {

//     public static void main(String[] args) {
//     //number of antenna and cables
//     int n = 6;
//     int e = 7;
    
//     // int n = 4;
//     // int e = 4;
    
//     //graph edges/vertex values
//     int[][] edges = {{0,1},{0,2},{2,4},{3,1},{3,5},{4,5},{5,0}};
//     // int[][] edges = {{0,1},{1,2},{2,3},{3,0}};
    
//     System.out.println(strongConfirm(n,e,edges)?"yes":"no");
    
//     }
    
//     public static boolean strongConfirm(int n, int e, int[][] edges){
        
//         //fwd graph and reverse graphs
//         List<Integer>[] graph = new ArrayList[n];
//         List<Integer>[] reverseGraph = new ArrayList[n];
        
//         //initializing fwd and reverse arrays 
//         for(int i=0; i<n; i++){
//             graph[i]= new ArrayList<>();
//             reverseGraph[i] = new ArrayList<>();
//         }
        
//         //arrays added to graph
//         for(int[] edge: edges){

//             graph[edge[0]].add(edge[1]);
//             reverseGraph[edge[1]].add(edge[0]);
//         }
        
//         //keeping track of visited vertecies, start from random node
//         boolean[] visited = new boolean[n];
//         Random rand = new Random();
//         int startNode = rand.nextInt(n);
        
//         //run dfs for fwd graph
//         DFS(graph, startNode, visited);
        
//         //checking to see if visited or not
//         for (boolean visit: visited){
//             if(!visit){
//                 return false;
//             }
//         }
//         visited = new boolean[n];
        
//         //run dfs for reverse graph
//         DFS(reverseGraph, startNode, visited);
        
//         //checking to see if visited or not
//         for(boolean visit: visited){
//             if(!visit){
//                 return false;
//             }
//         }
//             return true;

//     }
    
//     //dfs going through list of values
//     public static void DFS(List<Integer>[] graph, int v, boolean[] visited){
//         visited[v] = true;
        
//         for(int i: graph[v]){
//             if(!visited[i]){
//                 DFS(graph, i, visited);
//             }
//         }
//     }
        
// }