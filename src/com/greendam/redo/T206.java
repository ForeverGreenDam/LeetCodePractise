package com.greendam.redo;

public class T206 {
    public ListNode reverseList(ListNode head) {
        ListNode ans=null;
        ListNode pre=head;
        while(head!=null){
            pre=head;
            head=head.next;
            pre.next=ans;
            ans=pre;
        }
        return ans;
    }
}
