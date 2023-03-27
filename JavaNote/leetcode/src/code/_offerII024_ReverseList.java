package code;

import java.util.Stack;

/**
 * @author 刘佳俊
 *
 * 反转链表
 *
 * 思路:
 *      方法一 :
 *              1. 使用栈结构  先将链表节点 依次入栈 再将栈中的 节点依次出栈  并在出栈的时候 将这些节点一个一个的连接起来
 *              2. 注意 : 我们将节点一个一个入栈的时候一定要将这个节点变成单独的一个节点  也就是 入栈的节点的 next 指针需要置为 null
 *                       否则会出现链表成环的情况
 *
 *     方法二 :
 *              1. 递归实现
 *              2. 我们在递归的时候 保存每次递归传递的头节点 当我们调用到最后一个节点的 时候
 *                  我们就用一个所有方法栈共享的 newHead 节点来作为整个链表的头节点去连接这些节点
 *              3. 对于递归调用 在递归的过程中 相当于 是使用 方法栈 来替换掉 栈结构
 *              4. 注意 : 我们将节点一个一个入栈的时候一定要将这个节点变成单独的一个节点  也就是 入栈的节点的 next 指针需要置为 null
 *                        否则会出现链表成环的情况
 *
 *     方法三 :
 *              1. 迭代实现 , 头插法
 *              注意 : 我们将节点一个一个入栈的时候一定要将这个节点变成单独的一个节点  也就是 入栈的节点的 next 指针需要置为 null
 *                       否则会出现链表成环的情况
 *
 */
public class _offerII024_ReverseList {


    // 入栈出栈 反转链表
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            head = head.next;
            temp.next = null;
            stack.push(temp);
            temp = head;

        }
        head = stack.pop();
        temp = head;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        return head;
    }


    // 递归反转链表
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode();

        process(head, newHead);
        return newHead.next;
    }

    public ListNode process(ListNode head, ListNode newHead) {
        if (head.next == null) {
            newHead.next = head;
            return head;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;

        ListNode node = process(head, newHead);
        node.next = temp;
        return temp;
    }

    // 迭代实现反转链表 ( 头插法 )

    public ListNode reverseList3(ListNode head) {
        if (head==null||head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode();
        ListNode temp = head;
        while (head != null) {
            head = head.next;
            temp.next = newHead.next;
            newHead.next = temp;
            temp = head;
        }
        return newHead.next;
    }


}
