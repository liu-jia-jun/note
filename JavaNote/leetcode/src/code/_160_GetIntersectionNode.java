package code;

/**
 * @author 刘佳俊
 *
 * 相交链表: 两条链表可能相交可能不相交,返回相交节点或者 null值
 *
 * 思路:
 *      1. 双指针法
 *
 *      2. 设置两个变量分别指向两条链表的头
 *      3. 两个指针每次都走一步,当一个指针的next指向null证明这条链表走到头了,记下该节点为endA或者为endB
 *          并且在下一次走的时候将该指针指向另一条链表的头接着走,,另一个指针也是如此
 *      4. 记下endA和endB 每次判断,如果这两个值在不等于null的情况下相等证明两条链表相交,如果不等证明不相交返回 null
 *
 *      5. 每次判断两个指针是否相等,如果相等就是需要返回的节点值
 *
 */
public class _160_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        ListNode endA = null;
        ListNode endB = null;
        while (true) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            if (nodeA.next == null) {
                endA = nodeA;
                nodeA = headB;
            } else {
                nodeA = nodeA.next;
            }
            if (nodeB.next == null) {
                endB = nodeB;
                nodeB = headA;
            } else {
                nodeB = nodeB.next;
            }
            if (endA != null && endB != null && endA != endB) {
                return null;
            }

        }
    }
}
