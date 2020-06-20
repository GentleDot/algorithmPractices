package dataStructure.graph.dijkstra;

import java.util.*;

public class PriorityQueue {
    List<Map<String, Object>> values;

    public PriorityQueue() {
        this.values = new ArrayList<>();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PriorityQueue{");
        sb.append("values=").append(values);
        sb.append('}');
        return sb.toString();
    }

    public void enqueue(String value, Integer priority) {
        HashMap<String, Object> item = new HashMap<>();
        item.put("value", value);
        item.put("priority", priority);
        this.values.add(item);
        sort();
    }

    public Map<String, Object> dequeue() {
        return this.values.remove(0);
    }

    public void sort() {
        this.values.sort(Comparator.comparingInt(a -> (int) a.get("priority")));
    }
}
