package dataStructure.heap.maxBinaryHeap;

import java.util.ArrayList;
import java.util.List;

public class MaxBinaryHeap {
    List<Integer> values;

    public MaxBinaryHeap() {
        this.values = new ArrayList<>();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MaxBinaryHeap{");
        sb.append("values=").append(values);
        sb.append('}');
        return sb.toString();
    }

    public void insert(int element) {
        // - heap에 value를 push
        this.values.add(element);
        bubbleUp();
    }

    private void bubbleUp() {
        // - index를 length - 1 로 설정, index value 변수 element 생성
        int index = this.values.size() - 1;
        Integer element = this.values.get(index);

        // - parent와 비교했을 때 element가 작을 때까지 loop
        while (true) {
            // - 입력 node의 parent index ((index - 1) / 2) 값 변수 parent 생성
            int parentIndex = (index - 1) / 2;
            Integer parent = this.values.get(parentIndex);

            // - element가 parent보다 큰 경우 parentIndex는 element로 elementIndex는 parent로 위치 변경
            // - index를 parentIndex로 변경
            if (element > parent) {
                this.values.set(index, parent);
                this.values.set(parentIndex, element);
                index = parentIndex;
            } else {
                break;
            }
        }
    }
}
