package util;

import code.ListNode;

/**
 * @author 刘佳俊
 */
public class NodeUtil {


    public static ListNode arrayToListNode(int[] arr) {
        ListNode head = new ListNode();
        ListNode temp = head;
        for (int i = 0; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;

        }
        return head.next;
    }

    public static void printNode(ListNode node){
        System.out.print(node.val);
        if(node.next!=null){
             printNode(node.next);
        }
    }


}
