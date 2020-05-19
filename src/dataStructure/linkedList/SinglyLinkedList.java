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

    public SinglyLinkedList unshift(String value) {
        Node node = new Node(value);

        // list에 node가 없으면 생성된 node를 head와 tail로 설정
        // node가 있는 상태라면 생성된 node의 next를 head로 설정 후 생성된 node를 head로 설정
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            node.setNext(this.head);
            this.head = node;
        }

        // list 길이 증가 (+1)
        this.length++;

        // list 반환환
        return this;
    }

    public Node get(int index) {
        // index가 0보다 작거나 length보다 크거나 같으면 null
        if (index < 0 || index >= this.length) {
            return null;
        }

        // indexCounter가 전달받은 index에 도달할 때까지 loop
        int indexCounter = 0;
        Node current = this.head;

        while (indexCounter != index) {
            current = current.getNext();
            indexCounter++;
        }

        return current;
    }

    public boolean set(int index, String value) {
        Node foundNode = get(index);
        if (foundNode != null) {
            foundNode.setVal(value);
            return true;
        }

        return false;
    }

    public boolean insert(int index, String value) {
        // index가 0보다 작거나 length보다 크다면 false 반환
        if (index < 0 || index > this.length) {
            return false;

            // index가 length와 같다면 list의 끝에 새 node를 push (push() 사용)
        } else if (index == this.length) {
            this.push(value);
            return true;

            // index가 0이라면 list의 시작에 새 node를 unshift (unshift() 사용)
        } else if (index == 0) {
            this.unshift(value);
            return true;
        }

        // index가 처음 또는 끝이 아니라면
        //     - 전달받은 value로 새 node를 생성
        //     - get() 을 통해 index - 1 의 node인 prevNode를 조회
        //     - prevNode.next 를 통해 index node인 tempNode를 확인
        Node node = new Node(value);
        Node prevNode = this.get(index - 1);
        Node tempNode = prevNode.getNext();

        // prevNode의 next를 새 node로 설정
        // 새 node의 next를 tempNode로 설정
        prevNode.setNext(node);
        node.setNext(tempNode);

        // list 길이를 +1 증가
        this.length++;

        // true 반환
        return true;
    }

    public boolean remove(int index) {
        // index가 0보다 작거나 length보다 크다면 false 반환
        if (index < 0 || index > this.length) {
            return false;
        // index가 length - 1과 같다면 마지막 index를 pop
        } else if (index == this.length - 1) {
            this.pop();
            return true;
        // index가 0과 같다면 처음 index를 shift
        } else if (index == 0) {
            this.shift();
            return true;
        }

        // index - 1 node 인 prevNode 조회
        // prevNode.next 를 통해 tempNode 확인
        Node prevNode = this.get(index - 1);
        Node tempNode = prevNode.getNext();

        // prevNode의 next를 tempNode의 next로 설정
        prevNode.setNext(tempNode.getNext());

        // list의 length -1 감소
        this.length--;

        // true 반환
        System.out.println(tempNode + " (이)가 처리되었습니다.");
        return true;
    }
}
