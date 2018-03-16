package datastructures;

import java.util.Iterator;
import java.util.LinkedList;

/* This class does breadth first search (BFS) traversal from a given source vertex.
*  A collection of a node's neighbouring vertices is known as adjacency list.
* */
public class Graph {
    // no of vertices in the graph
    private int V;
    // adjacency list i.e neighbouring node of a node
    private LinkedList<Integer> adj[];

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);
        g.BFS(2);
    }

    Graph(int v) {
        V = v;
        // creates and adjacency list for all vertices
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // add edge to the graph or neighbours to adjacency list
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // BFS traversal from given source s
    void BFS(int s) {
        // set all vertices to not visited
        boolean visited[] = new boolean[V];

        // queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // mark the current node as visited and put in the queue
        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0) {
            s = queue.poll(); // removes first element in queue
            System.out.println(s + " ");

            // get the adj vertices of vertex s and if any of the adjacent vertex has not been visited,
            // mark it as visited and add to the queue
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
