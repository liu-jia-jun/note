package code;

import util.NodeUtil;

/**
 * @author 刘佳俊
 * 指 Offer II 025. 链表中的两数相加
 */
public class _offerII25_AddTwoNumbers {

    public static void main(String[] args) {
        int[] arr1 = {
                2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 9};
        int[] arr2 = {
                5, 6, 4, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 2, 4, 3, 9, 9, 9, 9};

        ListNode node1 = NodeUtil.arrayToListNode(arr1);
        ListNode node2 =  NodeUtil.arrayToListNode(arr2);


        ListNode listNode = addTwoNumbers(node1, node2);
    }




    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reversal(l1);
        l2 = reversal(l2);
        ListNode head = new ListNode();
        // ListNode temp = head;
        int carry = 0;
        int result = 0;
        while (l1 != null && l2 != null) {

            result = l1.val + l2.val + carry;
            carry = 0;
            if (result >= 10) {
                result = result % 10;
                carry = 1;
            }
            ListNode newNode = new ListNode(result);
            newNode.next = head.next;
            head.next = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            result = l1.val + carry;
            carry = 0;
            if (result >= 10) {
                result = result % 10;
                carry = 1;
            }
            ListNode newNode = new ListNode(result);
            newNode.next = head.next;
            head.next = newNode;
            l1 = l1.next;
        }

        while (l2 != null) {
            result = l2.val + carry;
            carry = 0;
            if (result >= 10) {
                result = result % 10;
                carry = 1;
            }
            ListNode newNode = new ListNode(result);
            newNode.next = head.next;
            head.next = newNode;
            l2 = l2.next;
        }

        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = head.next;
            head.next = newNode;
        }
        return head.next;
    }

    public static ListNode reversal(ListNode list) {
        ListNode head = new ListNode();
        ListNode listTemp;
        while (list != null) {
            listTemp = list;
            list = list.next;
            listTemp.next = head.next;
            head.next = listTemp;
        }
        return head.next;
    }


}
