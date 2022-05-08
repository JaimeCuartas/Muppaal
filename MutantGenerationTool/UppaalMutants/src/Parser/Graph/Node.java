package Parser.Graph;

import Parser.Mutation.ClockType;

import java.util.HashSet;

public class Node {
    private String name;
    private int id;
    private HashSet<Node> edge;
    //Set of nodes with more than one edge
    private HashSet<Node> multiplicity;
    public Node(String nameIn, int idIn){
        this.name = nameIn;
        this.id = idIn;
        this.edge = new HashSet<Node>();
        this.multiplicity = new HashSet<Node>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashSet<Node> getEdge() {
        return edge;
    }

    public void setEdge(HashSet<Node> edge) {
        this.edge = edge;
    }

    //Return true if this set did not has already the edge
    public boolean addEdge(Node nodeIn){
        if(this.edge.contains(nodeIn)){
            this.multiplicity.add(nodeIn);
            return false;
        }
        return this.getEdge().add(nodeIn);
    }

    public HashSet<Node> getMultiplicity() {
        return multiplicity;
    }

    public void setMultiplicity(HashSet<Node> multiplicity) {
        this.multiplicity = multiplicity;
    }
}
