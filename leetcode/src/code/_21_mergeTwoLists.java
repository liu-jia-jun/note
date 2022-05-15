package code;

import java.math.BigInteger;

/**
 * @author 刘佳俊
 *
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 这里推荐一下方法，创建一个节点，之后将其余两条链表依次添加进去，
 *
 * 注意判断成立条件
 */



public class _21_mergeTwoLists {

    public static void main(String[] args) {
     long number = 4000000006L;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list = new ListNode();
        ListNode temp = list;
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                temp.next=list1;
                list1=list1.next;
                temp=temp.next;
            }else{
                temp.next=list2;
                list2=list2.next;
                temp=temp.next;
            }
        }
        // 当两条链表中其中一条为null，此时我们就可以将另一条链表剩余部分直接加在temp上
        if(list1==null){
            temp.next=list2;
        }else{
            temp.next=list1;
        }

        return list.next;
    }
}
