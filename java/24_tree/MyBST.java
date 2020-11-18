import java.util.Objects;

public class MyBST {
    private Node tree;

    public class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {this.data = data;}
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (!Objects.nonNull(newNode)) {
            tree = newNode;
            return;
        }

        Node p = tree;
        Node pp = tree;
        boolean isLeft = false;
        while (Objects.nonNull(p)) {
            if (data < p.data) {
                pp = p;
                p = p.left;
                isLeft = true;
            } else {
                pp = p;
                p = p.right;
                isLeft = false;
            }
            if (p == null) {
                p = newNode;
                if (isLeft) {
                    pp.left = p;
                } else {
                    pp.right = p;
                }
            }
        }
    }

    public Node find(int data) {
        if (tree == null) {
            return null;
        }

        Node p = tree;
        while (p != null) {
            if (p.data == data) {
                break;
            }
            if (p.data > data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        return p;
    }

    public boolean delete(int data) {
        if (tree == null) {
            return false;
        }

        Node p = find(data);
        if (p == null) {
            return true;
        }
        // 处理三种情况
        // 有 0 或 1 个节点
        Node smallLeft = p.right;
        while (smallLeft.left != null) {
            smallLeft = smallLeft.left;
        }
    }
}



