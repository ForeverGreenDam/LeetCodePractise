package com.greendam;

public class T141_EZ {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public boolean hasCycle(ListNode head) {
        int flag=Integer.MAX_VALUE;
        ListNode pointer=head;
        while(pointer!=null){
            if(pointer.val==flag){
                return true;
            }
            pointer.val=flag;
            pointer=pointer.next;
        }
        return false;
    }
}
