package code;

/**
 * @author 刘佳俊
 *
 * 删除链表指定节点
 *
 * 思路:
 *      1. 删除一个节点要找到这个节点的上一个节点 这样才能在单链表中将该节点删除
 *
 *
 *
 *
 */
public class _offer18_DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        // 当链表为空时 直接返回 null
        if (head == null) {
            return head;
        }
        // 删除头节点
        if (head.val == val) {
            return head.next;
        }
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;

        }

        return head;


    }
}
