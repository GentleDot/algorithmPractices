package dataStructure.linkedList;

public class Node {
    private String val;
    private Node next;

    public Node(String val) {
        this.val = val;
        this.next = null;
    }

    public String getVal() {
        return val;
    }

    public Node getNext() {
        return next;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Node{");
        sb.append("val='").append(val).append('\'');
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }
}
