package dataStructure.linkedList;

public class Stack {
    Node first;
    Node last;
    int size;

    public Stack() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public void traverse() {
        Node current = first;
        while (current != null) {
            System.out.println(current.getVal());
            current = current.getNext();
        }
    }

    public int push(String value) {
        // - value로 새 node를 생성
        Node node = new Node(value);

        // - stack에 node가 없는 경우 first와 last를 새 node로 설정
        if (first == null) {
            first = node;
            last = node;
        } else if (size >= 1) {
            // - size가 1 이상인 경우
            //     - stack의 first를 temp 변수에 임시 저장
            //     - 새 node를 stack의 첫 번째 요소로 설정
            //     - 새 node의 next를 temp로 설정
            // - stack 크기 +1 증가
            Node temp = first;
            first = node;
            node.setNext(temp);

        }

        return ++size;
    }

    public Node pop() {
        // - stack에 node가 없다면 null  반환
        if (first == null) {
            return null;
        }

        // - stack의 first를 저장할 임시 변수 temp 생성
        Node temp = first;

        // - 하나의 node만 있는 경우 first와 last를 null로 설정
        if (size == 1) {
            first = null;

        } else if (size > 1) {
            // - 둘 이상의 node가 있다면 first를 temp의 next로 설정
            first = temp.getNext();
        }

        // - size를 -1 감소
        size--;

        // - 제거된 node temp를 반환
        return temp;
    }

}
