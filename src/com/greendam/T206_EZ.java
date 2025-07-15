package com.greendam;

public class T206_EZ {
    class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode reverseList(ListNode head) {
        ListNode ans=null;
        ListNode pointer=head;
        while(pointer!=null){
            pointer=pointer.next;
            head.next=ans;
            ans=head;
            head=pointer;
        }
    return ans;
    }
}
