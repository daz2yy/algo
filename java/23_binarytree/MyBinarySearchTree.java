/**
 * 二叉查找树:
 * 二叉查找树要求，在树中的任意一个节点，其左子树中的每个节点的值，都要小于这个节点的值，而右子树节点的值都大于这个节点的值
 * 操作：查询、删除、插入
 * 有重复数据的二叉树
 * 问题：
 * 1. 删除节点的时候，把data覆盖即可
 * 2. 遗漏了删除根节点的情况
 */
public class MyBinarySearchtree {
    private Node head;

    class Node {
        int data;
        Node left;
        Node right;

        Node (int data) {
            this.data = data;
        }
    }

    public Node find(int data) {
        if (head == null) {
            return null;
        }

        Node p = head;
        while (p != null) {
            if (p.data == data) {
                break;
            }
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        return p;
    }

    public void insert(int data) {
        if (head == null) {
            return;
        }

        Node newNode = new Node(data);
        Node p = head;
        Node pp = head;
        boolean isLeft = false;
        while (p != null) {
            pp = p;
            if (data >= p.data) {
                p = p.right;
                isLeft = false;
            } else {
                p = p.left;
                isLeft = true;
            }
        }
        if (isLeft) {
            pp.left = newNode;
        } else {
            pp.right = newNode;
        }
    }

    public void delete(int data) {
        // 三种情况：叶子节点，有一个子节点，有两个子节点
        if (head == null) {
            return;
        }

        Node p = head;
        Node pp = head;
        boolean isLeft = false;
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
                isLeft = false;
            } else {
                p = p.left;
                isLeft = true;
            }
        }
        if (p == null) {
            // 没找到
            return;
        }

        // 两个子节点的情况，找到右子树中的最小值替换自己
        if (p.left != null && p.right != null) {
            Node minP = p.right;
            Node minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            // 变成删除 minP 了
            p = minP;
            pp = minPP;
        }

        // 1个或0个子节点的情况
        if (p.left == null && p.right == null) {
            p = null;
        } else if (p.left == null) {
            p = p.right;
            if (isLeft) {
                pp.left = p;
            } else {
                pp.right = p;
            }
        } else if (p.right == null) {
            p = p.left;
            if (isLeft) {
                pp.left = p;
            } else {
                pp.right = p;
            }
        }

    }

}







