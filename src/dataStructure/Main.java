package dataStructure;

import dataStructure.linkedList.DoublyLinkedList;
import dataStructure.linkedList.Node;
import dataStructure.linkedList.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
//        handleSinglyLinkedList();
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
