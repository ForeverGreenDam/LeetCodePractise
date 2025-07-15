package com.greendam;

public class T160_EZ {
   static class ListNode {
       int val;
       ListNode next;

       ListNode(int x) {
           val = x;
           next = null;
       }
   }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0, countB = 0;
        ListNode pointer=headA;
        while(pointer!=null){
            countA++;
            pointer = pointer.next;
        }
        pointer=headB;
        while(pointer!=null){
            countB++;
            pointer = pointer.next;
        }
        int diff=countA-countB;
        //pointer指向长的链表的头结点
        //otherPointer指向短链表的头结点
        ListNode otherPointer=null;
        if(diff>0){
            pointer=headA;
            otherPointer=headB;
        }else {
            pointer=headB;
            otherPointer=headA;
        }
        //将两个链表的指针移动到距离尾部同一距离的节点
        for(int i=0;i<Math.abs(diff);i++){
            pointer=pointer.next;
        }
        while(pointer!=null){
            if(pointer.equals(otherPointer)){
                return pointer;
            }
            pointer = pointer.next;
            otherPointer = otherPointer.next;
        }
        return null;
    }
}
