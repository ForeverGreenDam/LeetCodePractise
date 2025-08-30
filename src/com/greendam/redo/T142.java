package com.greendam.redo;

public class T142 {
    public ListNode detectCycle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
           slow=slow.next;
           if(slow==fast){
               while(head!=slow){
                   head=head.next;
                   slow=slow.next;
               }
               return head;
           }
        }
        return null;
    }
}
