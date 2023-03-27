package code;

import util.NodeUtil;

import java.util.Stack;

/**
 * @author 刘佳俊
 */
public class _25_ReverseKGroup {
    public static void main(String[] args) {
        _25_ReverseKGroup app = new _25_ReverseKGroup();

        int[] arr = {1,2,3};

        ListNode head = NodeUtil.arrayToListNode(arr);
        ListNode newHead = app.reverseKGroup(head, 3);
        NodeUtil.printNode(newHead);

    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode();
        ListNode temp = newHead;
        Stack<ListNode> stack = new Stack<>();

        ListNode end = null;
        while (head != null) {
            end = kNode(head, k);

            if (end != null) {
                end=end.next;
                while (head != end) {
                    stack.add(head);
                    head = head.next;
                }
                while (!stack.isEmpty()) {
                    temp.next = stack.pop();
                    temp = temp.next;

                }

                // 这里将temp.next 设置为null 是为了 如果链表数量和k相等,此时 第一个和第二个连个节点会互相指向对方,这里是防止形成一个环
                temp.next=null;

            } else {
                temp.next= head;
                head = null;
            }
        }
        return newHead.next;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {

        ListNode end = kNode(head, k);
        ListNode start = head;
        if (end == null) {
            return head;
        }
        // 将这个头节点指向第一组的末尾,
        // 因为第一组最后的节点经过反转之后会变成整条链表的头部所以需要将这个节点返回
        head = end;

        reverseList(start, end);


        ListNode lastEnd = start;

        while (end != null) {
            start = lastEnd.next;
            end = kNode(start, k);
            if (end == null) {
                return head;
            }
            reverseList(start, end);
            lastEnd.next = end;
            lastEnd = start;

        }
        return head;

    }


    public void reverseList(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = start;

        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        // 这里将start 指向了end 即更新了下一组的开始节点
        start.next = end;


    }

    // 返回从头部开始数的第k个节点如果没有则返回null
    public ListNode kNode(ListNode head, int k) {
        ListNode temp = head;
        while (temp != null && k > 1) {
            temp = temp.next;
            k--;
        }

        return k == 1 ? temp : null;


    }
}
