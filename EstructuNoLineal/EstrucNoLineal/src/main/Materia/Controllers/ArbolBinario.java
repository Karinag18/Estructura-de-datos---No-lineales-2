package main.Materia.Controllers;

import java.util.Stack;
import main.Materia.Models.Node;

public class ArbolBinario {

    // Recorrido del arbol de tipo PreOrder
    public void preOrderLoop(Node raiz) {
        if (raiz == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(raiz);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.getValue() + " - ");
            // Agregar los hijos de la derecha a la pila
            if (node.getRight() != null) {
                stack.push(node.getRight());

            }
            // Agregar los hijos de la izquierda a la pila
            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }

    public void preOrderRecursivo(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " - ");
            preOrderRecursivo(node.getLeft());
            preOrderRecursivo(node.getRight());
        }
    }

    public void postOrderLoop(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);

            if (node.getLeft() != null) {
                stack1.push(node.getLeft());
            }
            if (node.getRight() != null) {
                stack1.push(node.getRight());
            }

        }

        while (!stack2.isEmpty()) {
            Node node = stack2.pop();
            System.out.print(node.getValue() + " ");
        }
    }

    public void postOrderRecursivo(Node node) {
        if(node != null){
            postOrderRecursivo(node.getLeft());
            postOrderLoop(node.getRight());
            System.out.print(node.getValue() + " ");
            

        }
  }
  public void inOrderRecursivo(Node node){
    if(node != null){
        inOrderRecursivo(node.getLeft());
        System.out.print(node.getValue() + " ");
        inOrderRecursivo(node.getRight());
    }
  }

}
