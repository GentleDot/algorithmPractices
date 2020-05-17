package dataStructure;

import dataStructure.linkedList.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.push("Hello");
        list.push("World");
        list.push("!!!");
        list.traverse();
    }
}
