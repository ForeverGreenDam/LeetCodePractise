package com.greendam.redo;

public class T21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode p1=list1;
        ListNode p2=list2;
        ListNode ans=new ListNode(0);
        ListNode cur=ans;
        while(p1!=null&&p2!=null){
            if(p1.val<=p2.val){
                cur.next=p1;
                p1=p1.next;
            }else{
                cur.next=p2;
                p2=p2.next;
            }
            cur=cur.next;
        }
        if(p1!=null){
            cur.next=p1;
        }else{
            cur.next=p2;
        }
        return ans.next;
    }
}
