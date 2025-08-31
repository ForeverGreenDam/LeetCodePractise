package com.greendam.redo;

public class T24 {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        T24 t24=new T24();
        ListNode newHead=t24.swapPairs(head);
        while(newHead!=null){
            System.out.print(newHead.val+" ");
            newHead=newHead.next;
        }
    }
    public ListNode swapPairs(ListNode head){
        ListNode pre1=head;
        ListNode pre2=head==null? null : head.next;
        ListNode pre3=pre2==null? null : pre2.next;
        ListNode newHead=pre2;
        if(newHead==null){
            return head;
        }
        ListNode temp=null;
        while(pre2!=null){
            pre2.next=pre1;
            pre1.next=pre3;
            if(temp!=null){
                temp.next=pre2;
            }

            temp=pre1;
            pre1=pre3;
            pre2= pre1==null? null : pre1.next;
            pre3= pre2==null? null : pre2.next;
        }
        return newHead;
    }
}
