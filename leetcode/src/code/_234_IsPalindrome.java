package code;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 刘佳俊
 */
public class _234_IsPalindrome {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp=head;
        for(int i=1;i<=5;i++){
            temp.next=new ListNode(i);
            temp=temp.next;
        }
        boolean palindrome = isPalindrome(head);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode reversal = new ListNode();
        ListNode temp = null;
        if (fast != null) {
            slow = slow.next;
            while (slow != null) {
                temp = slow;
                slow = slow.next;
                temp.next = reversal.next;
                reversal.next = temp;
            }

        } else {
            while (slow != null) {
                temp = slow;
                slow = slow.next;
                temp.next = reversal.next;
                reversal.next = temp;
            }

        }
        fast = head;
        reversal = reversal.next;
        while (reversal != null) {
            if (fast.val == reversal.val) {
                fast = fast.next;
                reversal = reversal.next;
            } else {
                return false;
            }
        }
        return true;


    }

}
