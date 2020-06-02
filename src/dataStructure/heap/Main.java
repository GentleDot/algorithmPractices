package dataStructure.heap;

import dataStructure.heap.binaryHeap.MaxBinaryHeap;
import dataStructure.heap.priorityQueue.PriorityQueue;

public class Main {
    public static void main(String[] args) {
//        handleBinaryHeap();
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enqueue("12", 12);
        priorityQueue.enqueue("18", 18);
        priorityQueue.enqueue("23", 23);
        priorityQueue.enqueue("29", 29);
        priorityQueue.enqueue("51", 51);
        priorityQueue.enqueue("44", 44);
        System.out.println(priorityQueue);
        System.out.println("======");
        System.out.println(priorityQueue.dequeue());
        System.out.println("======");
        System.out.println(priorityQueue);
    }

    private static void handleBinaryHeap() {
        MaxBinaryHeap binaryHeap = new MaxBinaryHeap();
        binaryHeap.insert(41);
        binaryHeap.insert(39);
        binaryHeap.insert(33);
        binaryHeap.insert(18);
        binaryHeap.insert(27);
        binaryHeap.insert(12);
        System.out.println(binaryHeap);
        binaryHeap.insert(55);
        System.out.println("======");
        System.out.println(binaryHeap);
        System.out.println(binaryHeap.remove());
        System.out.println("======");
        System.out.println(binaryHeap);
    }
}
