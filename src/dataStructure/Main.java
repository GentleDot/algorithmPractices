package dataStructure;

import dataStructure.linkedList.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.push("Hello");
        list.push("World");
        list.push("!!!");
        list.traverse();
        list.pop();
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
    }
}
