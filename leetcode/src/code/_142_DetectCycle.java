package code;

/**
 * @author 刘佳俊
 *
 * 环形链表 II : 返回环形链表入环的第一个节点 如果不是环形链表则返回null
 *
 * 思路:
 *      1. 双指针法
 *      2. 先设置快慢指针,快指针一次走两步慢指针一次走一步,
 *          如果快指针走到了null值则该链表没有环返回null如果快指针和慢指针相等即指向同一个node则证明有环
 *      3. 在有环的情况下,设置快指针指向head
 *      4. 当fast!=slow的时候,快慢指针各移动一步,直到快慢指针相等,那便是需要返回的节点即入环节点
 *
 *
 *
 */
public class _142_DetectCycle {


    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                flag = true;
                break;
            }
        }

        if (flag == true) {
            fast = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
        return null;

    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null || head == head.next) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        boolean hasCycle = false;

        while (fast.next != null && fast.next.next != null) {
            if (hasCycle) {
                fast = fast.next;
                slow = slow.next;
                if (fast == slow) {
                    return fast;
                }
            } else {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    if (fast == head) {
                        return head;
                    }
                    fast = head;
                    hasCycle = true;
                }
            }

        }
        return null;

    }
}
