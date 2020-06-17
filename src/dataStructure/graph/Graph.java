package dataStructure.graph;

import howToSolve.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static howToSolve.Main.log;

public class Graph {
    private Map<String, List<String>> adjacencyList;
    private ArrayList<String> result;
    private HashMap<String, Boolean> visited;

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

    public List<String> depthFirstRecursive(String startVertex) {
        // - 최종 결과를 저장할 list를 생성 (= result)
        // - 방문한 vertex를 저장할 map 생성 (= visited)
        // 해당 list와 map은 다른 method에서도 참조할 수 있도록 field로 설정
        result = new ArrayList<>();
        visited = new HashMap<>();

        // - vertex를 방문하는 helper function을 실행 (시작 vertex를 parameter로 전달)
        helperDfs(startVertex);

        // - helper 실행이 마무리 된 뒤에 결과 list인 result를 반환
        return result;
    }

    private void helperDfs(String vertex) {
        log.info("======");
        log.info("방문한 vertex : {}", vertex);
        // - vertex가 null 이라면 return (base case)
        if (vertex == null) {
            return;
        }

        // - visited에 해당 vertex를 방문 기록 : put(vertex, true)
        // - result에 해당 vertex를 기록 : add(vertex)
        visited.put(vertex, true);
        result.add(vertex);

        // - 인접 목록 중 vertex와 연결된 모든 vertex (neighbor)를 반복
        adjacencyList.get(vertex).forEach(neighbor -> {

            // - 해당 vertex가 visited에 방문 기록되어 있지 않다면 helper를 호출 : helper(neighbor)
            if (!visited.containsKey(neighbor)) {
                log.info("대상 vertex : {} / 이웃 vertex : {}", vertex, adjacencyList.get(vertex));
                helperDfs(neighbor);
            }
        });
    }
}
