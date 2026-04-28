package uebung03.graph;

public class Edge {
    private int length;
    private Node target;

    public Edge(int length, Node target) {
        this.length = length;
        this.target = target;
    }

    public int getLength() {
        return length;
    }

    public Node getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return ("-" + length + "->" + target.getName());
    }
}