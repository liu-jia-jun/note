package code;

/**
 * @author 刘佳俊
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class _2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l = new ListNode();
        ListNode temp = l;

        // n 表示为每次两个数相加的进位
        int n=0;
        int sum =0;
        while(l1!=null&&l2!=null){
            sum = l1.val+l2.val+n;
            if(sum >= 10){
                n =1;
                temp.next= new ListNode(sum%10);
                temp=temp.next;
                l1=l1.next;
                l2=l2.next;
            }else{
                n=0;
                temp.next=new ListNode(sum);
                temp=temp.next;
                l1=l1.next;
                l2=l2.next;

            }
        }
        while(l1!=null){
            if(n>0){
                sum=n+l1.val;
                if(sum>=10){
                    n=1;
                    temp.next= new ListNode(sum%10);
                    temp=temp.next;
                    l1=l1.next;
                }else{
                    n=0;
                    temp.next= new ListNode(sum);
                    temp=temp.next;
                    l1=l1.next;
                }
            }else{
                temp.next=l1;
                break;
            }
        }
        while(l2!=null){
            if(n>0){
                sum=n+l2.val;
                if(sum>=10){
                    n=1;
                    temp.next= new ListNode(sum%10);
                    temp=temp.next;
                    l2=l2.next;
                }else{
                    n=0;
                    temp.next= new ListNode(sum);
                    temp=temp.next;
                    l2=l2.next;
                }
            }else{
                temp.next=l2;
                break;
            }
        }
        if(n>0){
            temp.next=new ListNode(n);
        }
        return l.next;
    }
}