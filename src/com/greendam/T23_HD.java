package com.greendam;

public class T23_HD {
     class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    /**
     * 分治法
     */
    public ListNode mergeKLists(ListNode[] lists) {
         if(lists.length == 0) {
             return null;
         }else if(lists.length == 1) {
             return lists[0];
         }
         ListNode ans =null;
        for (int i = 0; i < lists.length-1; i++) {
           ans= mergeTwoLists(lists[i], lists[i+1]);
            //将合并后的结果放回到数组中
              lists[i+1] = ans;
        }
        return ans;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //经典二路归并
        ListNode ans = new ListNode(0);
        ListNode tail = ans;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            int val1 = p1.val;
            int val2 = p2.val;
            if(val1<=val2){
                tail.next = p1;
                tail = tail.next;
                p1 = p1.next;
            }else{
                tail.next = p2;
                tail = tail.next;
                p2 = p2.next;
            }
        }
        if(p1!=null){
            tail.next = p1;
        }
        if(p2!=null){
            tail.next = p2;
        }
        return ans.next;
        }
}
