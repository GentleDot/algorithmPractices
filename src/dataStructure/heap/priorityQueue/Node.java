package dataStructure.heap.priorityQueue;

public class Node {
    private String value;
    private int priority;

    public Node(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("value='").append(value).append('\'');
        sb.append(", priority=").append(priority);
        sb.append('}');
        return sb.toString();
    }
}
