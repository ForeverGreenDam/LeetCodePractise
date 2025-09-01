package com.greendam.redo;

public class T148 {
    public ListNode sortList(ListNode head) {
        //递归：寻找中间节点(T876)，然后分割链表排序，排序后获得的结果再进行两个有序链表的合并（T21）
        ListNode slow = head, fast = head, pre = slow;
        if(head == null||head.next==null){
            return head;
        }
        while(fast!=null&&fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre.next = null;

        head = sortList(head);
        slow = sortList(slow);
        return  mergeTwoLists(head, slow);
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
