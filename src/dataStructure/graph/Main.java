package dataStructure.graph;

import dataStructure.graph.dijkstra.PriorityQueue;
import dataStructure.graph.dijkstra.WeightedGraph;

public class Main {
    public static void main(String[] args) {
//        handleGraph();
        /*WeightedGraph graph = new WeightedGraph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("A", "B", 9);
        graph.addEdge("A", "C", 5);
        graph.addEdge("B", "C", 7);

        System.out.println(graph);*/

        /*PriorityQueue queue = new PriorityQueue();
        queue.enqueue("B", 3);
        queue.enqueue("C", 5);
        queue.enqueue("D", 2);
        queue.enqueue("Q", 1);

        System.out.println(queue);*/

        WeightedGraph graph = new WeightedGraph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", "B", 4);
        graph.addEdge("A", "C", 2);
        graph.addEdge("B", "E", 3);
        graph.addEdge("C", "D", 2);
        graph.addEdge("C", "F", 4);
        graph.addEdge("D", "E", 3);
        graph.addEdge("D", "F", 1);
        graph.addEdge("E", "F", 1);

        System.out.println(graph);

        System.out.println(graph.getShortestDistanceWithDijkstra("A", "E"));
        System.out.println(graph.getShortestDistanceWithDijkstra("A", "F"));
        System.out.println(graph.getShortestDistanceWithDijkstra("A", "D"));
        System.out.println(graph.getShortestDistanceWithDijkstra("B", "F"));
    }

    private static void handleGraph() {
        /*Graph graph = new Graph();

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        log.info("graph 확인 : {}", graph);

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("A", "AA");
        log.info("graph 확인 : {}", graph);

        graph.removeEdge("A", "C");
        log.info("graph 확인 : {}", graph);

        graph.removeVertex("B");
        log.info("graph 확인 : {}", graph);*/

        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");
        graph.addEdge("D", "E");
        graph.addEdge("D", "F");
        graph.addEdge("E", "F");

        System.out.println(graph);

        System.out.println(graph.depthFirstRecursive("A"));
        System.out.println("======================================");
        System.out.println(graph.depthFirstIterative("A"));
        System.out.println("======================================");
        System.out.println(graph.breadthFirstIterative("A"));
    }
}

