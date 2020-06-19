package dataStructure.graph;

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

    public List<String> depthFirstIterative(String startVertex) {
        // - vertex 추적에 용이하도록 stack list 생성
        // - vertex 방문 기록을 위한 map 생성 (visited)
        // - 최종 결과를 저장할 list 생성 (result)
        ArrayList<String> stack = new ArrayList<>();
        result = new ArrayList<>();
        visited = new HashMap<>();

        // - stack에 start vertex 추가 : add()
        // - start vertex를 방문 기록 : put(vertex, true)
        stack.add(startVertex); // push
        visited.put(startVertex, true);

        // - stack이 비어있지 않는 동안 loop
        while (!stack.isEmpty()) {
            // - stack에서 vertex 꺼내기 : pop()
            String currentVertex = stack.remove(stack.size() - 1); // pop

            // - result list에 꺼낸 vertex를 추가 : add()
            result.add(currentVertex);

//            this.adjacencyList.get(currentVertex).forEach(stack::add);
//            stack.addAll(this.adjacencyList.get(currentVertex));

            // - 꺼낸 vertex의 이웃을 전부 처리
            this.adjacencyList.get(currentVertex).forEach(neighbor -> {
                // - 꺼낸 vertex가 아직 방문한 상태가 아니라면
                if (!visited.containsKey(neighbor)) {
                    // - vertex를 방문 기록 put(vertex, true)
                    // - vertex의 모든 이웃 (neighbors)을 stack에 push
                    visited.put(neighbor, true);
                    stack.add(neighbor);
                    log.info("대상 vertex : {} / 이웃 vertex : {} / stack : {}", currentVertex, adjacencyList.get(currentVertex), stack);
                }
            });
        }

        // - result list를 반환
        return result;
    }

    public List<String> breadthFirstIterative(String startVertex) {
        // - 대기열 (queue)를 list로 생성하고 starting vertex를 enqueue
        ArrayList<String> queue = new ArrayList<>();
        queue.add(startVertex);
        // - 방문한 vertex를 결과로 저장할 list 생성
        // - 방문 내역을 기록할 visited map 생성
        result = new ArrayList<>();
        visited = new HashMap<>();
        // - starting vertex를 방문 기록
        visited.put(startVertex, true);
        // - queue의 item이 있는 동안 loop
        while (!queue.isEmpty()){
            // - dequeue 로 vertex를 꺼내고
            String targetVertex = queue.remove(0);
            // - 방문 결과 list에 add
            result.add(targetVertex);

            // - 인접 목록 (adjacency list)내 모든 vertex를 처리
            this.adjacencyList.get(targetVertex).forEach(neighbor -> {
                // - 방문 기록이 없는 vertex라면
                if (!visited.containsKey(neighbor)) {
                    // - 해당 vertex를 방문 기록
                    // - queue에 enqueue
                    visited.put(neighbor, true);
                    queue.add(neighbor);
                    log.info("대상 vertex : {} / 이웃 vertex : {} / stack : {}", targetVertex, adjacencyList.get(targetVertex), queue);
                }
            });
        }

        // - 방문 결과인 list를 반환
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
