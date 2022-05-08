package Parser.Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph {
    private HashMap<String, Node> nodes;
    private HashMap<Integer, Node> nodesId;
    private String initialNode;

    public Graph(){
        this.nodes = new HashMap<String, Node>();
        this.nodesId = new HashMap<Integer, Node>();
        this.initialNode = null;
    }

    public String getInitialNode() {
        return initialNode;
    }

    public void setInitialNode(String nameIn) {
        this.initialNode = nameIn;
    }

    public boolean addNode(String nameIn){
        int numNode = this.nodes.size();
        Node node = new Node(nameIn, numNode);
        //putIfAbsent returns null if nameIn not exists, otherwise returns the value that already had
        nodesId.putIfAbsent(numNode, node);
        return nodes.putIfAbsent(nameIn, node) == null;
    }

    public boolean addEdge(String sourceIn, String targetIn){
        Node nodeSource = nodes.get(sourceIn);
        Node nodeTarget = nodes.get(targetIn);
        nodeSource.addEdge(nodeTarget);

        return true;
    }

    public ArrayList<ArrayList<Integer>> getNumericGraph(){

        ArrayList<ArrayList<Integer>> listGraph = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<this.nodes.size(); i++){
            listGraph.add(new ArrayList<Integer>());
        }
        int i=0;
        for(Node node: this.nodes.values()){
            for(Node edge: node.getEdge()){
                listGraph.get(node.getId()).add(edge.getId());
            }
            i++;
        }

        return listGraph;
    }

    //Returns true if the target location only has one previous location to end in target location
    public boolean samePreviousNode(ArrayList<ArrayList<Integer>> listGraph, String nameTarget){
        int numSourceNode = this.nodes.get(this.initialNode).getId();

        Node nodeTarget = this.nodes.get(nameTarget);
        int numTargetNode = nodeTarget.getId();

        int numPreviousNode = BFS(listGraph, numSourceNode, numTargetNode);

        //Not same previous node but is un reachable, is the same remove the location
        if(numPreviousNode == -1){
            return true;
        }

        Node nodePrevious = this.nodesId.get(numPreviousNode);

        if(nodePrevious.getMultiplicity().contains(nodeTarget)){
            return false;
        }

        listGraph.get(numPreviousNode).remove(Integer.valueOf(numTargetNode));

        int newPreviousNode = BFS(listGraph, numSourceNode, numTargetNode);
        listGraph.get(numPreviousNode).add(numTargetNode);
        return newPreviousNode==-1;
    }

    //BFS algorithm to return the name of the previous node to the destination


    public int BFS(ArrayList<ArrayList<Integer>> numGraph, int source, int target){
        //stores distance of i from s

        LinkedList<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[this.nodes.size()];
        for(int i=0; i<this.nodes.size(); i++){
            visited[i]=false;
        }
        visited[source]=true;
        queue.add(source);

        while(!queue.isEmpty()){

            int currentNode = queue.remove();

            for(int edge: numGraph.get(currentNode)){
                if(!visited[edge]){
                    visited[edge]=true;
                    queue.add(edge);
                    if(edge==target){
                        return currentNode;
                    }
                }
            }
        }
        return -1;
    }
}
