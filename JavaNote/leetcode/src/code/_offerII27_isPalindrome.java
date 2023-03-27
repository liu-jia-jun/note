package code;

/**
 * @author 刘佳俊
 */
public class _offerII27_isPalindrome {

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }



        ListNode temp = new ListNode();
        ListNode reverseHead = new ListNode();

        while(slow!=null){
             temp = slow ;
             slow = slow.next;
             temp.next = reverseHead.next;
             reverseHead.next = temp;
        }

        fast = head;
        slow = reverseHead.next;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
