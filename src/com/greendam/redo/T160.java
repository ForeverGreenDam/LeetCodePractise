package com.greendam.redo;

public class T160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode p = headA;
        ListNode op;
        int countA=0,countB=0;
        while(p!=null){
            countA++;
            p=p.next;
        }
        p=headB;
        while(p!=null){
            countB++;
            p=p.next;
        }
        int diff = countA-countB;
        if(diff>0){
            p=headA;
            while(countA>countB){
                p=p.next;
                countA--;
            }
            op=headB;
        }else{
            p=headB;
            while(countA<countB){
                p=p.next;
                countB--;
            }
            op=headA;
        }
        while(op!=null){
            if(op==p){
                return op;
            }
            op=op.next;
            p=p.next;
        }
        return null;
    }
}
