package com.greendam.redo;

public class T25 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;
        T25 t25 = new T25();
        ListNode ans = t25.reverseKGroup(head, k);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k){
        if(head==null){
            return null;
        }
        int time=0;
        ListNode first = head;
        ListNode next=head;
        ListNode tail=null;
        boolean flag=false;

       while(next!=null){
           for (int i = 0; i < k; i++) {
               if(next!=null){
                   next=next.next;
               }else{
                     flag=true;
                     break;
               }
           }
           if(flag){
               break;
           }
           ListNode fz = fz(first, next);
           if(time==0){
                head=fz;
                time++;
           }else{
               tail.next = fz;
           }
           tail = first;
           first = next;
       }
       return head;
    }
    public static ListNode fz(ListNode head,ListNode next){
        ListNode ans = next;
        ListNode pre = null;
        ListNode cur = head;
        while(cur!=next){
            pre = cur;
            cur=cur.next;
            pre.next=ans;
            ans=pre;
        }
        return ans;
    }
}
