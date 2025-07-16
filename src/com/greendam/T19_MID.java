package com.greendam;

public class T19_MID {
    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        ListNode p = head;
        while(p!=null){
            count++;
            p = p.next;
        }
        int target = count - n;
        p= head;
        ListNode pre = null;
        for(int i=0;i<target;i++){
            pre=p;
            p=p.next;
        }
        if(pre==null){
            // 删除头节点
            head = head.next;
            return head;
        }
        pre.next=p.next;
        p.next=null;
        return head;
    }
}
