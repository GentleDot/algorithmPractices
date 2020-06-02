package dataStructure.heap.priorityQueue;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    List<Node> values;

    public PriorityQueue() {
        this.values = new ArrayList<>();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PriorityQueue{");
        sb.append("values=").append(values);
        sb.append('}');
        return sb.toString();
    }

    public void enqueue(String value, int priority) {
        Node node = new Node(value, priority);
        this.values.add(node);
        bubbleUp();
    }

    private void bubbleUp() {
        // - index를 length - 1 로 설정, index value 변수 element 생성
        int index = this.values.size() - 1;
        Node element = this.values.get(index);

        // - parent와 비교했을 때 element가 작을 때까지 loop
        while (true) {
            // - 입력 node의 parent index ((index - 1) / 2) 값 변수 parent 생성
            int parentIndex = (index - 1) / 2;
            Node parent = this.values.get(parentIndex);

            // - element가 parent보다 작은 경우 parentIndex는 element로 elementIndex는 parent로 위치 변경
            // - index를 parentIndex로 변경
            if (element.getPriority() < parent.getPriority()) {
                this.values.set(parentIndex, element);
                this.values.set(index, parent);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public Node dequeue() {
        int size = this.values.size();
        // - root value를 담은 변수 minValue 생성
        Node minValue = this.values.get(0);
        // - values list에서 마지막 값을 pop()하여 제거하고 제거된 값은 endValue에 담기
        Node endValue = this.values.remove(size - 1);
        if (size > 0) {
            // - values의 root를 endValue로 교체
            this.values.set(0, endValue);
            // root를 올바른 지점으로 이동시키기 위한 sink down을 진행
            sinkDown();
        }

        // maxValue를 return
        return minValue;
    }

    private void sinkDown() {
        // - parentIndex를 0부터 시작 (root), value를 element 변수에 저장
        int parentIndex = 0;
        int size = this.values.size();
        Node element = this.values.get(parentIndex);
        // - child index 확인 (단, list의 범위를 벗어나지 않아야 함)
        // - child 가 element보다 크지 않을 때까지 loop를 반복 (swap 진행)
        while (true) {
            // - parent의 left child를 확인 : leftChildIndex = 2n + 1 = 2 * parentIndex + 1
            int leftChildIndex = 2 * parentIndex + 1;
            // - parent의 right child를 확인 : rightChildIndex = 2n + 2 = 2 * parentIndex + 2
            int rightChildIndex = 2 * parentIndex + 2;
            // - left 또는 right child가 element보다 크다면 위치 swap
            Node leftChild = null;
            Node rightChild = null;
            Integer temp = null;

            //      - leftChildIndex가 size를 넘지 않을 때
            //      - leftChildIndex를 통해 leftChild를 가져오고
            //      - leftChild가 parent보다 작다면 swap 대상을 leftChildIndex로 설정
            if (leftChildIndex < size) {
                leftChild = this.values.get(leftChildIndex);
                if (leftChild.getPriority() < element.getPriority()) {
                    temp = leftChildIndex;
                }
            }

            //      - leftChild 비교 후 rightChildIndex가 size를 넘지 않을 때
            //      - rightChildIndex를 통해 rightChild를 가져오고
            //      - leftChild가 swap 대상이 아니고 rightChild가 parent보다 작을 때
            //      또는 leftChild가 swap 대상인 상태에서 rightChild가 leftChild보다 작을 때
            //      swap 대상을 rightChildIndex로 설정
            if (rightChildIndex < size) {
                rightChild = this.values.get(rightChildIndex);
                if ((temp == null && rightChild.getPriority() < element.getPriority())
                        || (temp != null && rightChild.getPriority() < leftChild.getPriority())) {
                    temp = rightChildIndex;
                }
            }

            // swap 대상이 없다면 loop를 break
            if (temp == null) {
                break;
            }

            // - swap 대상이 존재하면 swap 과정을 진행하고 교체된 child index는 새로운 parentIndex가 됨
            this.values.set(parentIndex, this.values.get(temp));
            this.values.set(temp, element);
            parentIndex = temp;
        }

    }
}
