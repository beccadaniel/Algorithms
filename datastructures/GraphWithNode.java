package datastructures;

import java.util.LinkedList;

public class GraphWithNode {

    public Node[] nodes;

    /**
     * checks if there is a path between the src and dest node (BFS)
     * @param graph
     * @param src
     * @param dest
     */
    boolean search(GraphWithNode graph, Node src, Node dest) {
        if (src == dest) {
            return true;
        }

        LinkedList<Node> queue = new LinkedList<>();

        for (Node g: graph.nodes) {
            g.state = Node.State.Unvisited;
        }

        src.state = Node.State.Visited;
        queue.add(src);

        while (!queue.isEmpty()) {

        }
        return false;
    }

    static class Node {
        public String name;
        public Node[] children;
        public State state;

        enum State {
            Unvisited, Visited, Visiting;
        }
    }
}
