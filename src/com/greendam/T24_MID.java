package com.greendam;

public class T24_MID {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode swapPairs(ListNode head) {
        ListNode pre1 = null;
        ListNode pre2 = null;
        ListNode pre3 = null;
        ListNode p = head;
        if(head!=null&&head.next!=null){
            head=head.next;
        }
        while(p!=null&&p.next!=null){
            pre3=pre1;
            pre1 = p;
            pre2 = p.next;
            p=p.next.next;
            pre1.next = p;
            pre2.next = pre1;
            if (pre3!=null){
                pre3.next = pre2;
            }
        }
        return head;
    }
}
