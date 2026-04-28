package uebung03.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private List<Edge> edges;
    private boolean marked = false;

    public Node(String name) {
        this.name = name;
        this.edges = new ArrayList<Edge>();
    }

    public String getName() {
        return name;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge e) {
        edges.add(e);
    }

    public boolean getMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean firstElement = true;

        sb.append(getName());
        sb.append(": [");

        for (Edge edge : edges) {
            if (!firstElement) sb.append(", ");
            sb.append(edge);
            firstElement = false;

//            if(!firstElement){
//                sb.append(", ");
//            }
//            sb.append(edge);
//            firstElement = false;

        }
        sb.append("]");
        return sb.toString();
    }
}