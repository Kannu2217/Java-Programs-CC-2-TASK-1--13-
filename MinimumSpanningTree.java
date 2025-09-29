import java.util.*;
class Edge implements Comparable<Edge> {
    int source, destination, weight;
    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
}
public class MinimumSpanningTree {
    private int findParent(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return findParent(parent, parent[i]);
    }
    private void union(int[] parent, int[] rank, int x, int y) {
        int xRoot = findParent(parent, x);
        int yRoot = findParent(parent, y);
        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[xRoot] > rank[yRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }
    public List<Edge> findMST(List<Edge> edges, int numberOfVertices) {
        List<Edge> result = new ArrayList<>();
        Collections.sort(edges);
        int[] parent = new int[numberOfVertices];
        int[] rank = new int[numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        int edgeCount = 0, index = 0;
        while (edgeCount < numberOfVertices - 1 && index < edges.size()) {
            Edge nextEdge = edges.get(index++);
            int x = findParent(parent, nextEdge.source);
            int y = findParent(parent, nextEdge.destination);
            if (x != y) {
                result.add(nextEdge);
                union(parent, rank, x, y);
                edgeCount++;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));
        edges.add(new Edge(3, 4, 9));
        int numberOfVertices = 5;
        MinimumSpanningTree mst = new MinimumSpanningTree();
        List<Edge> mstEdges = mst.findMST(edges, numberOfVertices);
        int totalCost = 0;
        System.out.println("Edges in Minimum Spanning Tree:");
        for (Edge edge : mstEdges) {
            System.out.println("(" + edge.source + " - " + edge.destination + ") Weight: " + edge.weight);
            totalCost += edge.weight;
        }
        System.out.println("Total Minimum Cost to Connect All Points: " + totalCost);
    }
}



