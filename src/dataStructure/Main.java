package dataStructure;

import dataStructure.linkedList.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        handleSinglyLinkedList();
//        handleDoublyLinkedList();
//        handleStack();
//        queueStructureWithArray();
        Queue queue = new Queue();
        queue.enqueue("라면 봉지를 뜯는다.");
        queue.enqueue("물 550ml를 넣고");
        queue.enqueue("건더기 스프, 양념 스프를 넣고");
        queue.enqueue("3분 정도 끓인 뒤");
        queue.enqueue("면을 넣고");
        queue.enqueue("2분 정도 더 끓인다.");
        queue.enqueue("5분 라면 완성");
        queue.traverse();
        System.out.println("======");
        System.out.println(queue.dequeue());
        System.out.println("======");
        queue.traverse();

    }

    private static void queueStructureWithArray() {
        ArrayList<String> list = new ArrayList<>();
        list.add(0, "첫 번째");
        list.add(0, "두 번째");
        list.add(0, "세 번째");
        System.out.println(list);
        list.remove(list.size() - 1);
        System.out.println(list);
    }

    private static void handleStack() {
        Stack stack = new Stack();
        stack.push("first");
        stack.push("second");
        System.out.println(stack.push("third"));
        System.out.println("======");
        stack.pop();
        stack.traverse();
    }

    private static void handleDoublyLinkedList() {
        DoublyLinkedList favoriteFoodList = new DoublyLinkedList();
        favoriteFoodList.push("자장면");
        favoriteFoodList.traverse();
        favoriteFoodList.push("자장밥");
        favoriteFoodList.traverse();
        Node poppedNode = favoriteFoodList.pop();
        System.out.println(poppedNode);
        System.out.println(poppedNode.getPrev());
        favoriteFoodList.push("짬뽕");
        favoriteFoodList.push("짬뽕밥");
        Node shiftedNode = favoriteFoodList.shift();
        System.out.println(shiftedNode + " ! shifted.");
        favoriteFoodList.traverse();
        favoriteFoodList.unshift("깐쇼새우");
        favoriteFoodList.traverse();
        System.out.println(favoriteFoodList.get(1));
        favoriteFoodList.set(0, "울면");
        System.out.println("======");
        favoriteFoodList.traverse();
        favoriteFoodList.insert(3, "스테이크 피자");
        System.out.println("======");
        favoriteFoodList.traverse();
        System.out.println(favoriteFoodList.remove(1));
        System.out.println("======");
        favoriteFoodList.traverse();
        System.out.println("=======");
        favoriteFoodList.reverse();
        favoriteFoodList.traverse();
    }

    private static void handleSinglyLinkedList() {
        SinglyLinkedList list = new SinglyLinkedList();
        list.push("Hello");
        list.push("World");
        list.push("!!!");
        list.traverse();
        System.out.println(list.pop());
        list.traverse();
        list.shift();
        list.traverse();
        list.unshift("create new");
        list.traverse();
        System.out.println(list.get(0));
        System.out.println(list.set(5, "없는 index에 값 설정"));
        System.out.println(list.set(-1, "-index에는 값을 설정하지 못함"));
        System.out.println("======");
        list.insert(0, "this is");
        list.insert(3, "program.");
        list.insert(3, "simulator");
        list.traverse();
        list.remove(3);
        list.traverse();
        System.out.println(list.getList());
        list.reverse();
        System.out.println(list.getList());
    }
}
