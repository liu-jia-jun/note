package code;

/**
 * @author 刘佳俊
 *
 * 链表中倒数第k个节点
 *
 * 思路:
 *      快慢指针法
 */
public class _offer22_GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        for(int i = k;i>0;i--){
            fast = fast.next;
        }

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }
}
