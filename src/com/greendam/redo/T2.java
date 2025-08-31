package com.greendam.redo;
import java.util.ArrayList;
import java.util.List;

public class T2 {
    public static void main(String[] args) {
        List<Integer> list1=new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            list1.add(9);
        }
        List<Integer> list2=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list2.add(9);
        }
        ListNode l1=tailAdd(list1);
        ListNode l2=tailAdd(list2);
        T2 t2=new T2();
        ListNode ans=t2.addTwoNumbers(l1,l2);
        while(ans!=null){
            System.out.print(ans.val+" ");
            ans=ans.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode p1=l1;
        ListNode p2=l2;
        ListNode ans=new ListNode(0);
        ListNode cur=ans;
        while(p1!=null && p2!=null){
            int num=p1.val+p2.val;
            ListNode newNode=new ListNode(num%10);
            cur.next=newNode;
            cur=cur.next;
            num/=10;
            p1=p1.next;
            p2=p2.next;
            if (p1 != null) {
                p1.val+=num;
            }else if(p2!=null){
                p2.val+=num;
            }else{
                if(num!=0){
                    ListNode last=new ListNode(num);
                    cur.next=last;
                }
            }
        }
       ListNode p= p1==null ? p2 : p1;
        while(p!=null) {
            int num = p.val;
            ListNode newNode = new ListNode(num % 10);
            cur.next = newNode;
            cur = cur.next;
            num /= 10;
            p = p.next;
            if (p != null) {
                p.val += num;
            }else{
                if(num!=0){
                    ListNode last=new ListNode(num);
                    cur.next=last;
                }
            }
        }
     return ans.next;
    }
    public static ListNode headAdd(List<Integer> nums){
        ListNode head=null;
        for (Integer num : nums) {
            ListNode newNode=new ListNode(num);
            newNode.next=head;
            head=newNode;
        }
        return head;
    }
    public static ListNode tailAdd(List<Integer> nums){
        ListNode head=new ListNode(0);
        ListNode p=head;
        for (Integer num : nums) {
            ListNode newNode=new ListNode(num);
            p.next = newNode;
            p = p.next;
        }
        return head.next;
    }
}
