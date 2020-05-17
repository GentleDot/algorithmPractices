package dataStructure.linkedList;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void traverse() {
        Node current = this.head;
        while (current != null) {
            System.out.println(current.getVal());
            current = current.getNext();
        }
    }

    public SinglyLinkedList push(String value) {
        // 전달된 value로 새로운 node 생성
        Node node = new Node(value);

        // head == null 이면 생성된 node를 head로 설정
        // 아니면 tail의 Node에 next를 생성된 node로 설정
        // tail을 생성된 node로 설정
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            tail.setNext(node);
            this.tail = node;
        }
        // 길이를 +1 증가
        this.length++;

        // list 반환
        return this;
    }
}
