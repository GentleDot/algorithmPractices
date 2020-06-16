package dataStructure.graph;

import static howToSolve.Main.log;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

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
        log.info("graph 확인 : {}", graph);
    }
}

