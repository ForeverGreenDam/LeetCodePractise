package com.greendam.redo;

public class T234 {
    public boolean isPalindrome(ListNode head){
     ListNode slow=head;
     ListNode fast=head;
     ListNode pre=null;
     int count=0;
     while(fast!=null&&fast.next!=null){
         fast=fast.next.next;
         pre=slow;
         slow=slow.next;
         count++;
     }
     if(count==0){
         return true;
     }
     pre.next = null;
     slow = reverseList(slow);
     while(head!=null){
            if(head.val!=slow.val){
                return false;
            }
            head=head.next;
            slow=slow.next;
     }
     return true;
    }
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
