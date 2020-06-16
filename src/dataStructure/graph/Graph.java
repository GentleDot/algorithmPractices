package dataStructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    Map<String, List<String>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Graph{");
        sb.append("adjacencyList=").append(adjacencyList);
        sb.append('}');
        return sb.toString();
    }

    public void addVertex(String vertex) {
        if (!this.adjacencyList.containsKey(vertex)) {
            this.adjacencyList.put(vertex, new ArrayList<>());
        }
    }

    public void addEdge(String vertex1, String vertex2) {
        if (this.adjacencyList.containsKey(vertex1) &&
                this.adjacencyList.containsKey(vertex2)) {
            this.adjacencyList.get(vertex1).add(vertex2);
            this.adjacencyList.get(vertex2).add(vertex1);
        }
    }

    public void removeEdge(String vertex1, String vertex2) {
        if (this.adjacencyList.containsKey(vertex1) &&
                this.adjacencyList.containsKey(vertex2)) {
            this.adjacencyList.get(vertex1).removeIf(vertex -> vertex.equals(vertex2));
            this.adjacencyList.get(vertex2).removeIf(vertex -> vertex.equals(vertex1));
        }
    }

    public void removeVertex(String targetVertex) {
        if (this.adjacencyList.containsKey(targetVertex)) {
            this.adjacencyList.get(targetVertex).forEach(vertex -> {
                this.adjacencyList.get(vertex).removeIf(itemVertex -> itemVertex.equals(targetVertex));
            });
            this.adjacencyList.remove(targetVertex);
        }
    }
}
