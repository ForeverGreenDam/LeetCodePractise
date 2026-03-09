package com.greendam;

public class T92_MID {
    public static void main(String[] args) {
    ListNode head = ListNode.createList(new int[]{3,5});
    T92_MID t=new T92_MID();
   head= t.reverseBetween(head,1,2);
   ListNode.printList(head);
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null||head.next==null||left==right){
            return head;
        }
        ListNode p=head;
        ListNode pre = p;
        int temp=left;
        while(temp!=1){
            pre=p;
            p=p.next;
            temp--;
        }
        ListNode next=head;
        while(right!=0){
            next=next.next;
            right--;
        }
        if(left==1){
            head=fz(head,next);
        }else{
            pre.next=null;
            p= fz(p,next);
            pre.next=p;
        }
        return head;
    }
    public ListNode fz(ListNode head,ListNode next){
        ListNode ans=next;
        ListNode p=head;
        ListNode pre=p;
        while(p!=next){
            pre=p;
            p=p.next;
            pre.next=ans;
            ans=pre;
        }
        return ans;
    }
}
