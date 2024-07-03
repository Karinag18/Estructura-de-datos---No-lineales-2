package main;

import main.Materia.Controllers.Graph;
import main.Materia.Controllers.Sets;
import main.Materia.Models.NodeGraph;

/*
 *                  1
 *       2                    3
 *    4           5                  6
 *7         8 
 * 
 */
public class App {
    public static void main(String[] args) throws Exception {

        runGraph();
        runSets();
        /*
        ArbolBinario arbolBinario = new ArbolBinario();
        Node nodeRaiz = new Node(1);
        nodeRaiz.setLeft(new Node(2));
        nodeRaiz.setRight(new Node(3));

        nodeRaiz.getLeft().setLeft(new Node(4));
        nodeRaiz.getLeft().setRight(new Node(5));

        nodeRaiz.getRight().setRight(new Node(6));
        
        nodeRaiz.getLeft().getLeft().setLeft(new Node(7));
        nodeRaiz.getLeft().getRight().setLeft(new Node(8));
    
        System.out.println("Preorder");
        arbolBinario.preOrderLoop(nodeRaiz);

        System.out.println("\nPreOrder Recursivo" );
        arbolBinario.preOrderRecursivo(nodeRaiz);

        System.out.println("\nPostOrder");
        arbolBinario.postOrderLoop(nodeRaiz);

        System.out.println("\n PostOrder Recursivo");
        arbolBinario.postOrderRecursivo(nodeRaiz);

        System.out.println("\n In Order");
        arbolBinario.inOrderRecursivo(nodeRaiz);

        //Arbol AVR
        AVLTree tree = new AVLTree();

        int[] values = { 10, 20, 15, 24, 9, 8, 21, 23, 50, 25 };

        for (int value : values) {
            tree.insert(value);
            tree.printTree();
        } */
        
    }

    private static void runGraph() {
       Graph graph= new Graph();

       //Agregar nodos

       NodeGraph node1=graph.addNode(1);
       NodeGraph node2=graph.addNode(2);
       NodeGraph node3=graph.addNode(3);
       NodeGraph node4=graph.addNode(4);
       NodeGraph node5=graph.addNode(5);

       //Vecinos nodo 1/* 
       /*graph.addEdge(node1, node2);
       graph.addEdge(node1, node3);
       graph.addEdge(node2, node4);
       graph.addEdge(node4, node5);

       //Imprimir grafo
       graph.printGraph();*/
       

       //Vecinos nodo 1
       node1.addNeighbor(node1);
       node1.addNeighbor(node3);

       //Vecinos nodo 2
       node2.addNeighbor(node1);
       node2.addNeighbor(node4);

       //Vecinos nodo 3
       node3.addNeighbor(node1);

       //Vecinos nodo 4
       node4.addNeighbor(node2);
       node4.addNeighbor(node5);

       //Vecinos nodo 5
       node5.addNeighbor(node4);

       //Imprimir grafo
       graph.printGraph();
    }
    private static void runSets(){
        Sets varibale = new Sets();
    }
}