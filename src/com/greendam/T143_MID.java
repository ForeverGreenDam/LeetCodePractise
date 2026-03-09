package com.greendam;

public class T143_MID {
    //找中间节点+反转链表+链表排序
    public static void main(String[] args) {
        int[]arr={1,2,3,4};
        ListNode head= ListNode.createList(arr);
        T143_MID t=new T143_MID();
        ListNode solution = t.solution(head);
        ListNode.printList(solution);
    }
    public  ListNode solution (ListNode head) {
        ListNode slow = head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode list2=slow.next;
        slow.next=null;
        list2=fz(list2);

        ListNode p2=list2;
        ListNode pre2=p2;
        ListNode p1=head;
        while(p2!=null){
            pre2=p2;
            p2=p2.next;
            pre2.next=p1.next;
            p1.next=pre2;
            p1=pre2.next;
        }
        return head;
    }
    public ListNode fz(ListNode head) {
        ListNode ans=null;
        ListNode p=head;
        ListNode pre=p;
        while(p!=null){
            pre=p;
            p=p.next;
            pre.next=ans;
            ans=pre;
        }
        return ans;
    }
}
