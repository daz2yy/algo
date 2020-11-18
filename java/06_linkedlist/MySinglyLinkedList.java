package linkedlist;

/**
 * 1) 单链表，增删改查，回文判断，无哨兵节点链表反转，有哨兵节点链表反转，有序链表合并，快慢指针取中点，换判断
 * 2) 链表存储的是 int 类型
 * @author D
 */
public class MySinglyLinkedList {
    Node head = null;

    public void insertByValue(int value) {}
    public void insertByNode(Node node) {}

    public void deleteByValue(int value) {}
    public void deleteByNode(Node node) {}

    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) {
            p = p.next;
        }
        return p;
    }
    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }
        return p;
    }

    /**
     * 无哨兵链表反转
     * @param p 链表的最后一个节点
     */
    public Node inverseLinkList(Node p) {
        Node pre = null;
        Node next;
        Node cur = p;
        while (cur != p) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return p;
    }

    /**
     * 带有哨兵节点的链表反转
     * @param p
     */
    public void inverseLinkList_head(Node p) {
        Node new_head = new Node(0);
        new_head.next = null;
        Node cur = head;
        Node next;
        while (cur != p) {
            next = cur.next;
            cur.next = new_head.next;
            new_head.next = cur;
            cur = next;
        }
    }

    // 判断回文串
    public boolean checkReverseString() {
        // 1. 快慢指针取中点
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 2. 翻转链表
        Node leftNode = null;
        Node rightNode = null;
        // 1，3，5，7，9，null
        // 1，2，3，4，5
        if (fast.next == null) {
            // 9 个点，5是中点，但不是起点
            leftNode = inverseLinkList(slow).next;
            rightNode = slow.next;
        } else {
            // 10 个点，5是中点也是起点
            leftNode = inverseLinkList(slow);
            rightNode = slow.next;
        }
        // 3. 判断回文
        while (leftNode.next != null) {
            if (leftNode.data != rightNode.data) { return false; }
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }
        // 4. 复原

        return true;
    }

    // 遍历一次删除倒数第k个节点
    // 关键点：概念替换，一次遍历即可，增加了辅助指针，就像几何学里的辅助线一般
    public Node deleteLastKth(Node list, int k) {
        // 找到顺序的第 k 个节点
        Node first = list;
        int i = 1;
        while (first != null && i < k) {
            first = first.next;
            ++i;
        }
        if (first == null) {
            return list;
        }

        // 找到 n-k 个节点
        Node pre = null;
        Node second = list;
        while (first.next != null) {
            first = first.next;
            pre = second;
            second = second.next;
        }
        // 倒数第k个节点是第一个节点
        if (pre == null) {
            list = list.next;
        } else {
            pre.next = pre.next.next;
        }
        return list;
    }

    // 两个有序链表合并
    public Node merge(Node list1, Node list2) {
        Node soldier = new Node(1);   // 利用哨兵节点优化
        Node newList = soldier;
        while (list1.next != null && list2.next != null) {
            if (list1.data > list2.data) {
                newList.next = list1;
            } else {
                newList.next = list2;
            }
            newList = newList.next;
        }
        if (list1.next != null) newList.next = list1;
        if (list2.next != null) newList.next = list2;
        return soldier.next;
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int value) {
            data = value;
            next = null;
        }

        public int get() { return data; }
    }
}
