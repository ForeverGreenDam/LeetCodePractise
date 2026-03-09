package com.greendam;

public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     public static ListNode createList(int[] nums){
      ListNode head = new ListNode();
      ListNode cur = head;
      for (int num : nums) {
          cur.next = new ListNode(num);
       cur = cur.next;
       }
      return head.next;
     }
     public static void printList(ListNode head) {
      ListNode cur = head;
      while (cur != null) {
       System.out.print(cur.val + " --> ");
       cur = cur.next;
      }
     }
 }