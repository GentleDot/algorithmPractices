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

    public void setNext(Node node) {
        this.next = node;
    }
}
