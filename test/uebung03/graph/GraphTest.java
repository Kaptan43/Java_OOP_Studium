package uebung03.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class GraphTest {

    private final Node nodeA = new Node("A");
    private final Node nodeB = new Node("B");
    private final Node nodeC = new Node("C");
    private final Node nodeD = new Node("D");
    private final Node nodeE = new Node("E");
    private final Node nodeF = new Node("F");
    private final Node nodeG = new Node("G");
    private final Node nodeH = new Node("H");
    private final Graph graph = new Graph();

    @Before
    public void setup() {
        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);
        graph.addNode(nodeG);
        nodeA.addEdge(new Edge(3, nodeB));
        nodeB.addEdge(new Edge(7, nodeD));
        nodeD.addEdge(new Edge(1, nodeE));
        nodeE.addEdge(new Edge(2, nodeC));
        nodeE.addEdge(new Edge(2, nodeH));
        nodeE.addEdge(new Edge(4, nodeA));
        nodeF.addEdge(new Edge(3, nodeG));
        nodeH.addEdge(new Edge(6, nodeB));
    }

    @Test
    public void testBreadthFirstGraphE() {
        final Set<Node> result = new HashSet<>(graph.breadthFirst(nodeE));
        assertEquals(Set.of(nodeA, nodeB, nodeC, nodeD, nodeE, nodeH), result);
    }

    @Test
    public void testBreadthFirstGraphF() {
        final Set<Node> result = new HashSet<>(graph.breadthFirst(nodeF));
        assertEquals(Set.of(nodeF, nodeG), result);
    }

    @Test
    public void testBreadthFirstGraphC() {
        final ArrayList<Node> result = graph.breadthFirst(nodeC);
        assertEquals(List.of(nodeC), result);
    }

    @Test
    public void testDepthFirstGraphE() {
        final Set<Node> result = new HashSet<>(graph.depthFirst(nodeE));
        assertEquals(Set.of(nodeA, nodeB, nodeC, nodeD, nodeE, nodeH), result);
    }

    @Test
    public void testDepthFirstGraphF() {
        final Set<Node> result = new HashSet<>(graph.depthFirst(nodeF));
        assertEquals(Set.of(nodeF, nodeG), result);
    }

    @Test
    public void testDepthFirstGraphC() {
        final ArrayList<Node> result = graph.depthFirst(nodeC);
        assertEquals(List.of(nodeC), result);
    }
}
