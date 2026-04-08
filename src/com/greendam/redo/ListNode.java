package com.greendam.redo;

public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }

      public static ListNode create(int[] nums) {
          if (nums == null || nums.length == 0) {
              return null;
          }
          ListNode dummy = new ListNode(0);
          ListNode current = dummy;
          for (int num : nums) {
              current.next = new ListNode(num);
              current = current.next;
          }
          return dummy.next;
      }
}