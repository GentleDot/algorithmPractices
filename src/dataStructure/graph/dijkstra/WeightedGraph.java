package dataStructure.graph.dijkstra;

import java.util.HashMap;
import java.util.Map;

public class WeightedGraph {
    private Map<String, Map<String, Integer>> adjacencyList;

    public WeightedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WeightedGraph{");
        sb.append("adjacencyList=").append(adjacencyList);
        sb.append('}');
        return sb.toString();
    }

    public void addVertex(String vertex) {
        if (!this.adjacencyList.containsKey(vertex)) {
            this.adjacencyList.put(vertex, new HashMap<>());
        }
    }

    public void addEdge(String vertex1, String vertex2, int weight) {
        if (this.adjacencyList.containsKey(vertex1) &&
                this.adjacencyList.containsKey(vertex2)) {
            this.adjacencyList.get(vertex1).put(vertex2, weight);
            this.adjacencyList.get(vertex2).put(vertex1, weight);
        }
    }
}
