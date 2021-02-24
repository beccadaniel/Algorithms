package datastructures;

public class Tree {

    Node root;

    static class Node<T> {
        T data;
        Node[] children;

        Node(T val) {
            this.data = val;
        }
    }
}
