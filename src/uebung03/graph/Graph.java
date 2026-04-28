package uebung03.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Graph {
    private List<Node> nodes;

    public Graph(){
        this.nodes = new ArrayList<Node>();
    }

    public List<Node> getNodes(){
        return nodes;
    }

    public void addNode(Node n){
        nodes.add(n);
    }

    public ArrayList<Node> depthFirst(Node startNode){
        ArrayList<Node> visited = new ArrayList<>();

        for(Node node : nodes) node.setMarked(false);

        depthFirstHelper(startNode, visited);
        return visited;
    }

    public void depthFirstHelper(Node node, ArrayList<Node> visited){
        node.setMarked(true);
        visited.add(node);
        for(Edge edge : node.getEdges()){
            if(!edge.getTarget().getMarked()){
                depthFirstHelper(edge.getTarget(), visited);
            }
        }
    }

    public ArrayList<Node> breadthFirst(Node startNode){
        ArrayList<Node> visited = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        for(Node node: nodes) node.setMarked(false);

        startNode.setMarked(true);
        queue.add(startNode);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            visited.add(current);
            for(Edge edge : current.getEdges()){
                if(!edge.getTarget().getMarked()){
                    queue.add(edge.getTarget());
                    edge.getTarget().setMarked(true);
                }
            }
        }
        return visited;
    }

    //Tiefensuche: Wenn das gesuchte Element tief im Grpahen liegt - Sie findet es schneller ohne alle Nachbarn zu durchsuchen
    //Breitensuche: Wenn das gesuchte Element nah am Startknoten liegt - Sie findet den kürzesten Weg zum Ziel

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append("Graph =");
        sb.append("\n");

        for(Node node: nodes){
            sb.append(node);
            sb.append(";");
            sb.append("\n");
        }
        return sb.toString();
    }

}
