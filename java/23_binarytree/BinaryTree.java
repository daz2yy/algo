/**
 * 二叉树操作：遍历
 * 有重复数据的二叉树
 */
public class BinaryTree<T> {
    private Node head;

    class Node {
        T data;
        Node left;
        Node right;
        Node(T data) {
            this.data = data;
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder(Node p) {
        print(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    /**
     * 中序遍历
     * @param p
     */
    public void inOrder(Node p) {
        inOrder(p.left);
        print(p);
        inOrder(p.right);
    }

    /**
     * 后序遍历
     * @param p
     */
    public void postOrder(Node p) {
        postOrder(p.left);
        postOrder(p.right);
        print(p);
    }

    public void print(Node p) {
    }

}
