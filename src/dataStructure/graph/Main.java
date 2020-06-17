package dataStructure.graph;

import static howToSolve.Main.log;

public class Main {
    public static void main(String[] args) {
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

        System.out.println(graph.depthFirstRecursive("A"));
    }
}

