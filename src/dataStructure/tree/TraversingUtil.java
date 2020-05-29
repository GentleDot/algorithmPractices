package dataStructure.tree;

import java.util.ArrayList;
import java.util.List;

public class TraversingUtil {

    public static List<Integer> breadthfirstSearch(BinarySearchTree tree) {
        // - Queue 구조와 탐색하는 node의 value를 저장할 수 있는 list 변수를 생성해둔다
        List<Node> queue = new ArrayList<>();
        List<Integer> valueList = new ArrayList<>();

        // - root node를 queue에 넣기
        Node current = tree.getRoot();
        queue.add(0, current);
        // - queue가 비어 있을 때까지 loop를 설정
        while (!queue.isEmpty()) {
            // - queue에서 dequeue로 node를 가져오고 node의 값을 list에 push
            int queueSize = queue.size();
            Node targetNode = queue.remove(queueSize - 1);
            valueList.add(targetNode.getValue());

            // - 가져온 node에 left 가 있다면 enqueue
            // - 가져온 node에 right가 있다면 enqueue
            if (targetNode.getLeft() != null) {
                queue.add(0, targetNode.getLeft());
            }
            if (targetNode.getRight() != null) {
                queue.add(0, targetNode.getRight());
            }
        }

        // - 값을 저장하는 변수 list를 반환
        return valueList;
    }
}
