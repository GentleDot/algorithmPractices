package dataStructure.tree;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree insert(Integer value) {
        if (value == null) {
            return this;
        }
        // - 전달받은 value로 새 node를 생성
        Node node = new Node(value);
        // - root에서 시작
        Node target = root;
        // - 만약 root가 없다면 root는 새 node로 설정
        if (target == null) {
            root = node;
            return this;
        }

        while (true) {
            // - root가 있다면 새 node의 값이 root의 값과 비교
            if (value.equals(target.getValue())) {
                return this;
            } else if (value > target.getValue()) {
                // - root 보다 큰 값이라면
                //     - root의 right에 node가 있는지 확인
                //         - node가 있다면 해당 node로 이동해서 node 비교 단계를 반복
                //         - node가 없다면 새 node를 right로 설정
                if (target.getRight() == null) {
                    target.setRight(node);
                    return this;
                } else {
                    target = target.getRight();
                }
            } else if (value < target.getValue()) {
                // - root 보다 작은 값이라면
                //     - root의 left에 node가 있는지 확인
                //         - node가 있다면 해당 node로 이동해서 node 비교 단계를 반복
                //         - node가 없다면 새 node를 left로 설정
                if (target.getLeft() == null) {
                    target.setLeft(node);
                    return this;
                } else {
                    target = target.getLeft();
                }
            }
        }
    }

    public boolean find(Integer value) {
        // - root가 없다면 검색 완료! false 반환
        if (value == null) {
            return false;
        } else if (root == null) {
            return false;
        }

        // - root가 있다면 전달받은 value와 비교
        Node target = root;
        while (true) {
            Integer targetValue = target.getValue();
            if (value.equals(targetValue)) {
                // - root의 value와 비교하여 같은 값이라면 true 반환
                return true;
            } else if (value > targetValue) {
                // - root의 value보다 크다면 root의 right를 확인
                //     - right node가 없다면 탐색 종료! false 반환
                //     - right node가 있다면 비교 단계 반복
                if (target.getRight() == null) {
                    return false;
                } else {
                    target = target.getRight();
                }
            } else if (value < targetValue) {
                // - root의 value보다 작다면 root의 left를 확인
                //     - left node가 없다면 탐색 종료! false 반환
                //     - left node가 있다면 비교 단계 반복
                if (target.getLeft() == null) {
                    return false;
                } else {
                    target = target.getLeft();
                }
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BinarySearchTree{");
        sb.append("root=").append(root);
        sb.append('}');
        return sb.toString();
    }
}
