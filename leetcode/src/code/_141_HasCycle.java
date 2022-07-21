package code;

/**
 * @author 刘佳俊
 *
 * 环形链表: 判断是否为环形链表返回布尔值
 *
 * 思路:
 *      1. 快慢指针法
 *      2. 设置两个指针,一个快指针一次跳两个节点,一个慢指针一次跳一个节点
 *      3. 判断如果两个指针相遇则证明这个链表是环形链表
 *      4. 如果快指针来到了 null值则证明该链表不是环形链表
 *
 *
 */
public class _141_HasCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
