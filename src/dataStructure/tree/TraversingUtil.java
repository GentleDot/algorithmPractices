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

    public static List<Integer> depthfirstSearch(BinarySearchTree tree, String orderType) {
        // - 탐색 과정에서 방문하는 node의 value를 저장할 list 변수 생성
        ArrayList<Integer> valueList = new ArrayList<>();
        // - root를 current 변수에 저장
        Node current = tree.getRoot();
        // - node에 접근하는 helper function 사용
        // - list 변수를 반환
        if (orderType.equals("IN")) {
            nodeTraverseInOrder(valueList, current);
        } else if (orderType.equals("PRE")) {
            nodeTraversePreOrder(valueList, current);
        } else if (orderType.equals("POST")) {
            nodeTraversePostOrder(valueList, current);
        }
        return valueList;
    }

    // - node에 접근하는 helper function 작성 - InOrder
    private static void nodeTraverseInOrder(ArrayList<Integer> list, Node node) {
        //  - parameter node에 left가 있다면 left node를 parameter로 helper function을 호출
        if (node.getLeft() != null) {
            nodeTraverseInOrder(list, node.getLeft());
        }

        //  - node의 값을 list에 push
        list.add(node.getValue());

        //  - parameter node에 right가 있다면 right node를 parameter로 helper function을 호출
        if (node.getRight() != null) {
            nodeTraverseInOrder(list, node.getRight());
        }
    }

    // - node에 접근하는 helper function 작성 - PreOrder
    private static void nodeTraversePreOrder(ArrayList<Integer> list, Node node) {
        //  - node의 값을 list에 push
        list.add(node.getValue());

        //  - parameter node에 left가 있다면 left node를 parameter로 helper function을 호출
        if (node.getLeft() != null) {
            nodeTraversePreOrder(list, node.getLeft());
        }

        //  - parameter node에 right가 있다면 right node를 parameter로 helper function을 호출
        if (node.getRight() != null) {
            nodeTraversePreOrder(list, node.getRight());
        }
    }

    // - node에 접근하는 helper function 작성 - PostOrder
    private static void nodeTraversePostOrder(ArrayList<Integer> list, Node node) {
        //  - parameter node에 left가 있다면 left node를 parameter로 helper function을 호출
        if (node.getLeft() != null) {
            nodeTraversePostOrder(list, node.getLeft());
        }

        //  - parameter node에 right가 있다면 right node를 parameter로 helper function을 호출
        if (node.getRight() != null) {
            nodeTraversePostOrder(list, node.getRight());
        }

        //  - node의 값을 list에 push
        list.add(node.getValue());
    }
}
