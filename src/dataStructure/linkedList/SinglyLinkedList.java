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

    public SinglyLinkedList pop() {
        // list에 node가 없으면 null을 반환
        //     - head에 node가 없으면 list에 node가 없는 것으로 판단
        if (this.head == null) {
            return null;
        }

        // tail까지 loop
        Node current = this.head;
        Node targetNode = current;
        while (current.getNext() != null) {
            targetNode = current;
            current = current.getNext();
        }
        // 마지막 node의 이전 node인 targetNode의 next를 null로 설정
        targetNode.setNext(null);

        // targetNode를 tail로 설정
        this.tail = targetNode;

        // 길이를 1 감소
        this.length--;

        // node가 없는 경우에는 head, tail의 node는 null
        if (this.length == 0) {
            this.head = null;
            this.tail = null;
        }

        // list 반환
        System.out.println(current + " (이)가 처리되었습니다.");
        return this;
    }

    public SinglyLinkedList shift() {
        // list에 node가 없으면 null을 반환
        //     - head에 node가 없으면 list에 node가 없는 것으로 판단
        if (this.head == null) {
            return null;
        }

        // head node를 확인
        Node current = this.head;

        // head node의 다음 node를 head로 설정
        this.head = current.getNext();

        // list의 길이 감소 (-1)
        this.length--;

        // node가 head만 있다면 tail node도 head node와 같은 값으로 설정
        // node가 없다면 tail = null 설정
        if (this.length == 1) {
            this.tail = head;
        } else if (this.length == 0) {
            this.tail = null;
        }

        // list 반환
        System.out.println(current + " (이)가 처리되었습니다.");
        return this;
    }

}
