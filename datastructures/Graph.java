package datastructures;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * An adjacency list or matrix is used to represent the graph
 */
public class Graph {
    int vertices;
    LinkedList<Integer>[] adjacencyListArray;

    Graph(int v) {
        this.vertices = v;
        adjacencyListArray = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adjacencyListArray[i] = new LinkedList<>();
        }
    }

    // add edge for undirected graph
    public void addUndirectedEdge(int src, int dest) {
        adjacencyListArray[src].add(dest);
        adjacencyListArray[dest].add(src);
    }

    // add edge to directed graph
    public void addDirectedEdge(int src, int dest) {
        adjacencyListArray[src].add(dest);
    }

    /**
     * Breadth First Search of a graph
     */
    public LinkedList<Integer> bfs(int src) {
        LinkedList<Integer> result = new LinkedList<>();

        // Mark all vertices as non-visited
        boolean[] visited = new boolean[vertices];

        // create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();
        // mark current node as visited and enqueue
        visited[src] = true;
        queue.add(src);

        while (!queue.isEmpty()) {
            // dequeue a vertex from the queue
            src = queue.poll();
            result.add(src);

            // get all the adjacent vertex of the dequeue vertex. If it has not been visited,
            // mark it as visited and enqueue
            Iterator<Integer> adjacents = adjacencyListArray[src].iterator();

            while (adjacents.hasNext()) {
                int n = adjacents.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return result;
    }

    /**
     * Depth First Search of a graph
     */
    public LinkedList<Integer> dfsUtil(int src, boolean[] visited, LinkedList<Integer> result) {


        // mark current node as visited
        visited[src] = true;
        result.add(src);

        Iterator<Integer> adjacents = adjacencyListArray[src].iterator();
        while(adjacents.hasNext()) {
            int n = adjacents.next();
            if (!visited[n]) {
                dfsUtil(n, visited, result);
            }
        }
        return result;
    }

    public LinkedList<Integer> dfs(int src) {
        LinkedList<Integer> result = new LinkedList<>();

        boolean[] visited = new boolean[vertices];
        return dfsUtil(src, visited, result);
    }
    public static void main(String args[])
    {
        Graph g = new Graph(4);

        g.addDirectedEdge(0, 1);
        g.addDirectedEdge(0, 2);
        g.addDirectedEdge(1, 2);
        g.addDirectedEdge(2, 0);
        g.addDirectedEdge(2, 3);
        g.addDirectedEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        System.out.println(g.bfs(2));
    }
}
