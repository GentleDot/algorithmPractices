package dataStructure.linkedList;

public class Node {
    private String val;
    private Node prev;
    private Node next;

    public Node(String val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }

    public String getVal() {
        return val;
    }

    public Node getPrev() {
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
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
