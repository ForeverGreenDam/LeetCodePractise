package com.greendam.redo;

public class T19 {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode fast = head;
        ListNode slow = head;
        boolean flag = false;
        for (int i = 0; i < n+1; i++) {
            if(fast==null) {
                flag=true;
                break;
            }
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if(!flag) {
            slow.next = slow.next.next;
        }else{
            head = head.next;
        }
        return head;
    }
}
