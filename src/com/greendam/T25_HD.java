package com.greendam;

public class T25_HD {
    class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public static void main(String[] args) {
        // Example usage
        T25_HD t25_hd = new T25_HD();
        ListNode head = t25_hd.new ListNode(1);
        head.next = t25_hd.new ListNode(2);
        head.next.next = t25_hd.new ListNode(3);
        head.next.next.next = t25_hd.new ListNode(4);
        head.next.next.next.next = t25_hd.new ListNode(5);
        ListNode result = t25_hd.reverseKGroup(head, 2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre=head;
        ListNode p = head;
        ListNode pre2 = null;
        int len=0;
        while(p!=null){
            p=p.next;
            len++;
        }
        p= head;
        for (int i = 0; i < len/k; i++) {
            int count = 1;
            while (count < k && p != null) {
                p = p.next;
                if (p == null) {
                    break;
                }
                count++;
            }
            if (count == k) {
                ListNode newHead = reverseLinkList(pre, p, p.next);
                if (pre2 != null) {
                    pre2.next = newHead;
                } else {
                    head = newHead;
                }
                pre2= pre;
                pre = pre.next;
                p = pre;
            } else {
                break;
            }
        }
    return head;
    }
    public static ListNode reverseLinkList(ListNode head,ListNode tail, ListNode next) {
        ListNode ans = next;
        ListNode pre=null;
        ListNode p = head;
        while(p!=next){
            pre=p;
            p=p.next;
            pre.next = ans;
            ans=pre;
        }
        return ans;
    }
}
