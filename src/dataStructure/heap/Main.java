package dataStructure.heap;

import dataStructure.heap.maxBinaryHeap.MaxBinaryHeap;

public class Main {
    public static void main(String[] args) {
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
    }
}
