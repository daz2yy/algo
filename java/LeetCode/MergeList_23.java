import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/
 * 有序链表合并，考察链表操作，用时：20分钟内
 * 思路：
 *  1. 构造有限队列合并
 *  2. 哨兵节点优化代码
 */
public class MergeList_23 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public class QueueNode {
        Integer val;
        ListNode node;
        QueueNode(int val, ListNode node) {
            this.val = val;
            this.node = node;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {return null;}

        Queue queue = new PriorityQueue(lists.length, new Comparator<QueueNode>() {
            @Override
            public int compare(QueueNode o1, QueueNode o2) {
                return o1.val < o2.val ? -1 : 1;
            }
        });
        for (int i = 0; i < lists.length; ++i) {
            ListNode node = lists[i];
            if (node == null) {continue;}
            queue.add(new QueueNode(node.val, node));
        }
        ListNode head = new ListNode(0, null);
        ListNode result = head;
        while(!queue.isEmpty()) {
            QueueNode nextNode = (QueueNode) queue.poll();
            head.next = nextNode.node;
            head = head.next;
            if (nextNode.node.next == null) {continue;}
            queue.add(new QueueNode(nextNode.node.next.val, nextNode.node.next));
        }
        return result.next;
    }
}
