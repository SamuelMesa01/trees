package GFG;

import java.util.ArrayList;
import java.util.List;

// Node structure for tree
class Node {
    int data;
    List<Node> children;

    Node(int x) {
        data = x;
        children = new ArrayList<>();
    }
}

class GFG {
    // Function to add a child to a node
    static void addChild(Node parent, Node child) {
        parent.children.add(child);
    }

    // Function to print parents of each node
    static void printParents(Node node, Node parent) {
        if (parent == null)
            System.out.println(node.data + " -> NULL");
        else
            System.out.println(node.data + " -> " + parent.data);

        for (Node child : node.children)
            printParents(child, node);
    }

    // Function to print children of each node
    static void printChildren(Node node) {
        System.out.print(node.data + " -> ");
        for (Node child : node.children)
            System.out.print(child.data + " ");
        System.out.println();

        for (Node child : node.children)
            printChildren(child);
    }

    // Function to print leaf nodes
    static void printLeafNodes(Node node) {
        if (node.children.isEmpty()) {
            System.out.print(node.data + " ");
            return;
        }
        for (Node child : node.children)
            printLeafNodes(child);
    }

    // Function to print degrees of each node 
    static void printDegrees(Node node, Node parent) {
        int degree = node.children.size();
        if (parent != null)
            degree++;
        System.out.println(node.data + " -> " + degree);

        for (Node child : node.children)
            printDegrees(child, node);
    }

    public static void main(String[] args) {
        
        // ÁRBOL ORIGINAL
        
        System.out.println("---ÁRBOL ORIGINAL---");
        
        Node root = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        addChild(root, n2);
        addChild(root, n3);
        addChild(n2, n4);
        addChild(n2, n5);

        System.out.println("Parents of each node:");
        printParents(root, null);

        System.out.println("Children of each node:");
        printChildren(root);

        System.out.print("Leaf nodes: ");
        printLeafNodes(root);
        System.out.println();

        System.out.println("Degrees of nodes:");
        printDegrees(root, null);
        
        // ---NUEVO ÁRBOL (EL DE LA IMAGEN)---
        System.out.println("\n--- NUEVO ARBOL ---");
        Node root2 = new Node(5);
        Node n7 = new Node(7);
        Node n0 = new Node(0);
        Node n17 = new Node(17);
        Node n3b = new Node(3); // nombre diferente para no chocar
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);

        addChild(root2, n7);
        addChild(root2, n0);

        addChild(n7, n17);
        addChild(n7, n3b);

        addChild(n0, n9);
        addChild(n0, n10);

        addChild(n9, n11);

        System.out.println("Parents of each node:");
        printParents(root2, null);

        System.out.println("Children of each node:");
        printChildren(root2);

        System.out.print("Leaf nodes: ");
        printLeafNodes(root2);
        System.out.println();

        System.out.println("Degrees of nodes:");
        printDegrees(root2, null);
    }
}