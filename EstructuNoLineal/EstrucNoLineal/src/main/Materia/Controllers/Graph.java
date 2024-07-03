package main.Materia.Controllers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.Materia.Models.NodeGraph;
import main.Materia.Models.Node;

public class Graph {
    private List<NodeGraph> nodes;

    public Graph(){
        this.nodes = new ArrayList<>();
    }

    public int getValue(int value){
        return value;
    }

    public NodeGraph addNode(int value) {
        NodeGraph newNode = new NodeGraph(value);
        nodes.add(newNode);
        return newNode;
    }

    public void addEdge(NodeGraph src, NodeGraph dest) {
        src.addNeighbor(dest);
        dest.addNeighbor(src);
    }

    public void printGraph() {
        for (NodeGraph node : nodes) {
            System.out.print("Vertice " + node.getValue() + ":");
            for (NodeGraph neighbor : node.getNeighbors()) {
                System.out.print(" -> " + neighbor.getValue());
            }
            System.out.println();
        }
    }

    public void getDFS(Node startNode){
        boolean[] visited = new boolean[nodes.size()];
        getDFSUtil(startNode, visited);
    }

    private void getDFSUtil(Node node, boolean[] visited){
        int index = nodes.indexOf(node);
        visited[index] = true;
      
    }
}