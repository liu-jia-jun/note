package code;

/**
 * @author 刘佳俊
 */
public class _142_DetectCycle {
    public ListNode detectCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        boolean flag =false;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                flag=true;
                break;
            }
        }

        if(flag==true){
            slow=head;
            while(slow!=fast){
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }
        return null;

    }
}
