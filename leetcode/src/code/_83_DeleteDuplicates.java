package code;

/**
 * @author 刘佳俊
 */
public class _83_DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode temp =head;
        while(null!=temp.next){
            if(temp.val==temp.next.val){
                temp.next=temp.next.next;
            }else{
                temp=temp.next;
            }
        }
        return head;

    }
}
