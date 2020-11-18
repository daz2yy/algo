/**
 * Trick：快慢指针
 * 本质：利用指针特性构造判定解的方法
 * 链表特点：指向下一个节点；
 * 应用：
 *  1. 构造出不同步长的两个指针
 *  2. 用每次走一步来计数，最古老的计数方法
 */
public class HasCycle_141 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean solve(ListNode head) {
        if (head == null) { return false; }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            if (fast.next == slow || fast.next.next == slow) {
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
