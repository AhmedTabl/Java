import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    
    private final vertex startTraverse;


    public BFS(vertex startTraverse){
        this.startTraverse = startTraverse;
    }

    public void traverse(){
        Queue<vertex> queue = new LinkedList<>();
        LinkedList<vertex> visitedVertices = new LinkedList<>();

        queue.add(startTraverse);

        while(!queue.isEmpty()){
            vertex presentVal = queue.poll();

            boolean isVisited = false;
            for (vertex v:visitedVertices){
            if(v.getNode_num() == presentVal.getNode_num()){
                isVisited=true;
                break;
            }}

            if(!isVisited){
                visitedVertices.add(presentVal);
                presentVal.setIsVisited(true);
                System.out.print(presentVal.getNode_num());

                for (vertex nodeNum : presentVal.getAdjacentNodes()) {
                    boolean alreadyInQueue = false;
                    for (vertex v : queue) {
                        if (v.getNode_num() == nodeNum.getNode_num()) {
                            alreadyInQueue = true;
                            break;
                        }
                    }

                    if (!alreadyInQueue) {
                        queue.add(nodeNum);
                    }
                      }
            }
                 }
    }
    }