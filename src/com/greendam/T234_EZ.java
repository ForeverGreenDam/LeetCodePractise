package com.greendam;

import java.util.Stack;

public class T234_EZ {
        class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
    public boolean isPalindrome(ListNode head) {
        int count=0;
        ListNode pointer=head;
        while(pointer!=null){
            count++;
            pointer=pointer.next;
        }
        int mid=(count+1)/2;
        pointer=head;
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i <mid; i++) {
            stack.push(pointer.val);
            pointer=pointer.next;
        }
        //如果是奇数个节点，则移除中间节点
        if(count%2!=0){
            stack.pop();
        }
        for (int i = mid; i < count; i++) {
            Integer peek = stack.peek();
            if(peek!=pointer.val){
                return false;
            }else{
                stack.pop();
                pointer=pointer.next;
            }
        }
            return true;
    }
}
