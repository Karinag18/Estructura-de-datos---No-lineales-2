package main.Materia.Controllers;
import main.Materia.Models.Node;

public class AVLTree {
    private Node root;

    private int height(Node node){
        if(node == null){
            return 0;
        }
        return node.getHeight();
    }

    private int getBalance(Node node){
        if(node == null){
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }

    public Node insert(Node node, int value){
        if(node == null){
            System.out.println("Insertando nodo con valor: " + value);
            return new Node(value);
        }
        if(value > node.getValue()){
            node.setRight(insert(node.getRight(), value));
        } else if(value < node.getValue()){
            node.setLeft(insert(node.getLeft(), value));
        } else {
            System.out.println("El valor " + value + " ya existe en el árbol.");
            return node;
        }
        
        // Actualizar la altura del ancestro
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        
        // Calcular el balance
        int balance = getBalance(node);
        
        // Si el nodo está desbalanceado se tienen 4 casos de rotaciones
        // Caso izquierda-izquierda
        if (balance > 1 && value < node.getLeft().getValue()) {
            System.out.println("Aplicando rotación derecha en nodo con valor: " + node.getValue());
            return rightRotate(node);
        }
        // Caso derecha-derecha
        if (balance < -1 && value > node.getRight().getValue()) {
            System.out.println("Aplicando rotación izquierda en nodo con valor: " + node.getValue());
            return leftRotate(node);
        }
        
        // Caso izquierda-derecha
        if (balance > 1 && value > node.getLeft().getValue()) {
            System.out.println("Aplicando rotación izquierda seguida de derecha en nodo con valor: " + node.getValue());
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }
        
        // Caso derecha-izquierda
        if (balance < -1 && value < node.getRight().getValue()) {
            System.out.println("Aplicando rotación derecha seguida de izquierda en nodo con valor: " + node.getValue());
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }
        
        // Devolver el nodo sin cambios o rotaciones
        return node;
    }

    private Node rightRotate(Node nodeR){
        System.out.println("Realizando rotación derecha en nodo con valor: " + nodeR.getValue());
        Node x = nodeR.getLeft();
        Node temp = x.getRight();

        // Realizar la rotación
        x.setRight(nodeR);
        nodeR.setLeft(temp);

        // Actualizar alturas
        nodeR.setHeight(Math.max(height(nodeR.getLeft()), height(nodeR.getRight())) + 1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight())) + 1);
        // Devolver nueva raíz
        return x;
    }

    private Node leftRotate(Node nodeR){
        System.out.println("Realizando rotación izquierda en nodo con valor: " + nodeR.getValue());
        Node y = nodeR.getRight();
        Node temp = y.getLeft();

        // Realizar la rotación
        y.setLeft(nodeR);
        nodeR.setRight(temp);

        // Actualizar alturas
        nodeR.setHeight(Math.max(height(nodeR.getLeft()), height(nodeR.getRight())) + 1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight())) + 1);
        // Devolver nueva raíz
        return y;
    }

    public void insert(int value){
        System.out.println("Insertando valor: " + value);
        root = insert(root, value);
        System.out.println("Árbol AVL después de insertar " + value + ":");
        printTree();
        System.out.println();
    }

    public void printTree(){
        printTreeNode(root, "", true);
    }

    private void printTreeNode(Node root, String prefix, boolean isLeft) {
        if (root != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.getValue());
            if (root.getLeft() != null || root.getRight() != null) {
                if (root.getLeft() != null) {
                    printTreeNode(root.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
                } else {
                    System.out.println(prefix + (isLeft ? "│   " : "    ") + "├── null");
                }
                if (root.getRight() != null) {
                    printTreeNode(root.getRight(), prefix + (isLeft ? "│   " : "    "), false);
                } else {
                    System.out.println(prefix + (isLeft ? "│   " : "    ") + "└── null");
                }
            }
        }
    }
}