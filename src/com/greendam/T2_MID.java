package com.greendam;

import java.util.ArrayList;
import java.util.List;

public class T2_MID {
    class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    /**
     * 大数加法无法满足
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1=l1;
        ListNode p2=l2;
        long num1=0;
        long num2=0;
        int count=0;
        while(p1!=null){
            num1+= (long) (p1.val*Math.pow(10,count));
            count++;
            p1=p1.next;
        }
        count=0;
        while(p2!=null){
            num2+= (long) (p2.val*Math.pow(10,count));
            count++;
            p2=p2.next;
        }
        long sum = num1 + num2;
        ListNode head = new ListNode(0);
        ListNode tail = head;

        do {
            int val = (int) (sum %10);
            tail.next = new ListNode(val);
            tail=tail.next;
            sum /=10;
        }while(sum!=0);
        return head.next;
    }
    /**
     * 通过数组模拟大数加法
     * 需要注意的是，链表的长度可能不相等
     * 需要补齐短的链表
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode p1=l1;
        ListNode p2=l2;
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        while(p1!=null){
            list1.add(p1.val);
            p1=p1.next;
        }
        while(p2!=null){
            list2.add(p2.val);
            p2=p2.next;
        }
        int len1 = list1.size();
        int len2 = list2.size();
        int diff=len1-len2;
        if(diff>0){
            for (int i = len2; i <len1 ; i++) {
                list2.add(0);
            }
        }else if(diff<0){
            for (int i = len1; i <len2 ; i++) {
                list1.add(0);
            }
        }
        int count = Math.min(len1, len2);
        List<Integer> ans= new ArrayList<>();
        list1.add(0);
        list2.add(0);
        for(int i=0;i<list1.size()-1;i++){
            int val1 = list1.get(i);
            int val2 = list2.get(i);
            int sum = val1 + val2;
            ans.add(sum%10);
            list1.set(i+1, list1.get(i+1) + sum / 10);
        }
        if(list1.get(list1.size()-1)!=0||list2.get(list2.size()-1)!=0) {
            ans.add(list1.get(list1.size()-1)+list2.get(list2.size()-1));
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        for(Integer val : ans) {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
    return head.next;
    }
}
