package dataStructure.linkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList() {
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

    public DoublyLinkedList push(String value) {
        // - value로 새 node를 생성
        Node node = new Node(value);

        // - head == null 인 경우 head와 tail은 새 node로 설정
        if (head == null) {
            head = node;
            tail = node;
        } else {
            // - null이 아니라면
            //     - tail의 next를 새 node로 설정
            //     - 새 node의 prev를 tail로 설정
            //     - 새 node를 tail로 설정
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }
        // - list의 길이 + 1 증가
        length++;

        System.out.println(value + "(이)가 push 되었습니다.");
        return this;
    }

    public Node pop() {
        // - head가 없다면 (=null) null을 반환
        if (head == null) {
            return null;
        }

        // - tail 값을 임시로 temp 변수에 저장
        Node temp = tail;

        // - length가 1인 경우 head, tail은 null로 설정
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            // - tail을 이전 node로 설정
            // - 새로 설정된 tail의 next를 null로 설정
            tail = tail.getPrev();
            tail.setNext(null);
        }

        // - list의 길이 -1 감소
        length--;

        // - 제거한 값 반환
        return temp;
    }
}
