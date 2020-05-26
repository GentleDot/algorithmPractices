package dataStructure.linkedList;

public class Queue {
    Node first;
    Node last;
    int size;

    public Queue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void traverse() {
        Node current = first;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    public int enqueue(String value) {
        // - 전달된 값으로 새 node를 생성
        Node node = new Node(value);

        // - queue에 node가 없는 경우 새 node를 first와 last로 설정
        if (first == null) {
            first = node;
            last = node;
        } else {
            // - 그 외에는
            //     - last node의 next를 새 node로 설정
            //     - 새 node를 last로 설정
            last.setNext(node);
            last = node;
        }

        // - size +1
        return ++size;
    }

    public Node dequeue() {
        // - first가 null 이라면 null을 반환
        if (first == null) {
            return null;
        }

        // - first node를 temp 변수에 보관
        Node temp = first;

        // - size 가 1이라면 first와 last를 null로 설정
        if (size == 1) {
            first = null;
            last = null;
        } else {
            // - 그 외에는
            //     - first를 temp의 next로 설정
            first = temp.getNext();
        }

        // - size -1
        size--;

        // - temp의 next를 null로 설정
        // - 처리된 node인 temp를 반환
        temp.setNext(null);
        return temp;
    }
}
