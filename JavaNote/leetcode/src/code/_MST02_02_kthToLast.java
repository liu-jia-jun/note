package code;

/**
 * @author 刘佳俊
 *
 * 返回倒数第 k 个节点
 *
 *
 * 面试题 02.02
 */
public class _MST02_02_kthToLast {
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        for(int i = k;i>0;i--){
            fast = fast.next;
        }

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow.val;
    }
}
