package code;

/**
 * @author 刘佳俊
 *
 *  两两交换链表中的节点
 *
 *  思路:
 *      1. 当未交换的节点的个数成对出现时才能进行交换,否则就直接返回即可
 *      2. 涉及到链表的交换所以我们要保存好头节点,因为头节点可能会变
 *      3. 立足一个节点之后将这个节点的下一个节点和下下一个节点进行交换并且要保证不会丢失后面的节点即可
 *
 */
public class _24_SwapPairs {

    // 迭代实现
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = head.next.next;
        newHead.next = head;
        if (newHead.next.next == null) {
            return newHead;
        }
        while (head.next != null && head.next.next != null) {
            ListNode temp = head.next.next;
            head.next.next = temp.next;
            temp.next = head.next;
            head.next = temp;
            head = head.next.next;
        }
        return newHead;
    }
    //  递归实现
    public ListNode swapPairs2(ListNode head) {
        if(head==null||head.next==null){
            return  head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs2(head);
        newHead.next= head;
        return newHead;
    }
}
