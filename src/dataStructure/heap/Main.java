package dataStructure.heap;

import dataStructure.heap.binaryHeap.MaxBinaryHeap;
import dataStructure.heap.priorityQueue.PriorityQueue;

public class Main {
    public static void main(String[] args) {
//        handleBinaryHeap();
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.enqueue("41", 10);
        priorityQueue.enqueue("39", 9);
        priorityQueue.enqueue("33", 8);
        priorityQueue.enqueue("18", 5);
        priorityQueue.enqueue("27", 7);
        priorityQueue.enqueue("12", 3);
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
