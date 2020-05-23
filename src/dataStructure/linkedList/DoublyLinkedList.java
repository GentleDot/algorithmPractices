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

    public Node shift() {
        // - length가 0이라면 null 반환
        if (length == 0) {
            return null;
        }

        // - 현재 head를 임시로 temp 변수에 저장
        Node temp = this.head;
        // - 길이가 1인 경우
        //     - head = null, tail = null 설정
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            // - 그 외에는
            //     - head의 next가 head가 되도록 설정
            //     - head의 prev는 null로 설정
            head = head.getNext();
            head.setPrev(null);
        }
        // - temp의 next를 null로 설정
        // - list 길이 -1 감소
        temp.setNext(null);
        length--;

        // - temp 값 반환
        return temp;
    }

    public DoublyLinkedList unshift(String value) {
        // - method에 전달된 value로 새 node 생성
        Node node = new Node(value);

        // - length가 0인 경우
        //     - head, tail을 새 node로 설정
        if (length == 0) {
            head = node;
            tail = node;
        } else {
            // - 그 외에는
            //     - head의 prev를 새 node로 설정
            //     - 새 node의 next를 head로 설정
            //     - 새 node를 head로 설정
            head.setPrev(node);
            node.setNext(head);
            head = node;
        }

        // - list의 길이 +1 증가
        length++;

        // - list 반환
        return this;
    }

    public Node get(int index) {
        Node current;
        int count;

        // - 전달 받는 index가 0보다 작거나 length보다 크거나 같으면 null을 반환
        if (index < 0 || index >= length) {
            return null;
        }
        // length의 절반 확인 (중간값)
        int halfIndex = length / 2;

        // - index가 length의 중간 또는 중간 이하의 값이라면 head부터 목록의 중간까지 next 탐색
        // - index에 해당하는 node를 발견하면 node를 반환
        if (index <= halfIndex) {
            count = 0;
            current = head;
            while (index != count) {
                current = current.getNext();
                count++;
            }
        } else {
            // - index가 length의 중간보다 큰 경우 tail에서 목록의 중간까지 prev 탐색
            // - index에 해당하는 node를 발견하면 node를 반환
            count = length - 1;
            current = tail;
            while (index != count) {
                current = current.getPrev();
                count--;
            }
        }

        return current;
    }

    public boolean set(int index, String value) {
        // 함수에 전달된 index가 0보다 작거나 length보다 크거나 같으면 false 반환
        if (index < 0 || index >= length) {
            return false;
        }

        // - 함수에 전달된 index에 해당하는 node를 get()을 이용해 조회
        Node targetNode = get(index);

        // - 유효한 node가 조회되지 않으면 false 반환
        if (targetNode == null) {
            return false;
        }

        // - get()에서 유효한 node를 반환하면 해당 node 값을 전달받은 값으로 설정
        // - 정상적으로 처리되면 true 반환
        targetNode.setVal(value);
        return true;
    }
}
