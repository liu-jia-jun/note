package code;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 *
 *输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）
 *
 * 思路:
 *      1. 链表题 惯用头插法 , 尾插法 , 反转链表 , 快慢指针法
 *
 *      2. 通过头插法的方式去反转链表 之后再去遍历 即可得到结果
 *
 */
public class _offer06_reversePrint {

    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        if (head.next == null) {
            return new int[]{head.val};
        }
        ListNode temp = new ListNode();
        ListNode reverseHead = new ListNode();
        int length = 0;
        while (head != null) {
            temp = head;
            head = head.next;
            temp.next = reverseHead.next;
            reverseHead.next = temp;
            length++;
        }
        head = reverseHead.next;
        int[] reuslt = new int[length];
        for (int i = 0; i < length; i++) {
            reuslt[i] = head.val;
            head = head.next;
        }
        return reuslt;
    }
}