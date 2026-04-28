package uebung03.graph;

public class GraphDemo {

    public static void main(String[] args) {
        Graph graph = new Graph();

        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        a.addEdge(new Edge(2, b));
        a.addEdge(new Edge(4, d));
        b.addEdge(new Edge(2, a));
        b.addEdge(new Edge(2, c));
        b.addEdge(new Edge(4, e));
        c.addEdge(new Edge(2, b));
        d.addEdge(new Edge(4, a));
        d.addEdge(new Edge(2, e));
        e.addEdge(new Edge(4, b));
        e.addEdge(new Edge(2, d));

        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);

        System.out.println("\n");
        System.out.println(graph);

        System.out.println("\n");
        System.out.println(graph.depthFirst(a));
        System.out.println(graph.breadthFirst(a));
    }
}
