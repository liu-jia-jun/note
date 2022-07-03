package code;

/**
 * @author 刘佳俊
 *
 *  删除链表的倒数第 N 个结点
 *
 *  思路:
 *      快慢指针法
 *
 */
public class _19_RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for(int i=0;i<n;i++){
            fast =fast.next;
        }
        if(fast==null){
            return head.next;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;

        return head;

    }
}
