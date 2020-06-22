package dataStructure.graph.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static howToSolve.Main.log;

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

    // - 함수가 시작 vertex, 목적지 vertex를 parameter로 전달 받음
    public List<String> getShortestDistanceWithDijkstra(String start, String finish) {
        // - 거리를 저장할 객체를 생성 (map) : distance
        // - privious 객체를 생성 (map)
        PriorityQueue nodeQueue = new PriorityQueue();
        HashMap<String, Integer> distance = new HashMap<>();
        HashMap<String, String> previous = new HashMap<>();
        ArrayList<String> path = new ArrayList<>();

        // - 각 키는 모든 vertex가 되어야 하고 default value는 Integer.MAX로 (JS에는 infinity) 설정
        // - 단, 시작 vertex는 시작 지점이므로 value = 0
        // - distance 객체에 값을 설정한 후 시작 vertex는 0, 그 외 모든 vertex는 MAX_VALUE로 priority queue에 add()
        // - privious 객체에 각 키를 인접한 vertex가 되도록 설정
        this.adjacencyList.keySet().forEach(vertex -> {
            if (vertex.equals(start)) {
                distance.put(vertex, 0);
                nodeQueue.enqueue(vertex, 0);
            } else {
                distance.put(vertex, Integer.MAX_VALUE);
                nodeQueue.enqueue(vertex, Integer.MAX_VALUE);
            }
            previous.put(vertex, null);
        });

        log.info("distance 확인 : {}", distance);
        log.info("nodeQueue 확인 : {}", nodeQueue);
        log.info("previous 확인 : {}", previous);

        // - priority queue 가 비어있지 않을 때까지 loop 진행
        while (!nodeQueue.getValues().isEmpty()) {
            // - queue에서 dequeue로 vertex 빼내기
            String currentVertex = (String) nodeQueue.dequeue().get("value");

            if (currentVertex.equals(finish)) {
                String pathVertex = currentVertex;
                log.info("======");
                log.info("최종 확인!");
                log.info("distance 확인 : {}", distance);
                log.info("previous 확인 : {}", previous);

                while (previous.get(pathVertex) != null) {
                    path.add(pathVertex);
                    pathVertex = previous.get(pathVertex);
                }
                path.add(start);
                path.sort(String::compareTo);
                break;
            }

            // - 그렇지 않다면 해당 vertex의 인접 목록의 vertex를 반복
            if (currentVertex != null || !distance.get(currentVertex).equals(Integer.MAX_VALUE)) {
                this.adjacencyList.get(currentVertex).keySet().forEach(neighborVertex -> {
                    // - 시작 vertex에서 해당 vertex까지의 거리를 계산
                    Integer neighborEdge = this.adjacencyList.get(currentVertex).get(neighborVertex);
                    int calculatedDistance = distance.get(currentVertex) + neighborEdge;

                    // - 거리가 현재 distance 객체에 저장된 거리보다 작은 경우
                    if (calculatedDistance < distance.get(neighborVertex)) {
                        // - distance 객체를 새로운 거리로 업데이트
                        distance.put(neighborVertex, calculatedDistance);

                        // - previous 객체에 해당 vertex를 추가
                        previous.put(neighborVertex, currentVertex);

                        // - queue에 vertex를 enqueue (start vertex에서부터의 거리를 업데이트)
                        nodeQueue.enqueue(neighborVertex, calculatedDistance);
                    }
                });
            }
        }
        return path;
    }
}
