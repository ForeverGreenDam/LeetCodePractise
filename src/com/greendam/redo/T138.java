package com.greendam.redo;

import java.util.ArrayList;
import java.util.List;

public class T138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {
        T138 t138 = new T138();
        Node n1 = t138.new Node(7);
        Node n2 = t138.new Node(13);
        Node n3 = t138.new Node(11);
        Node n4 = t138.new Node(10);
        Node n5 = t138.new Node(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;
        Node ans=t138.copyRandomList(n1);
        while(ans!=null){
            System.out.print(ans.val+" ");
            if(ans.random!=null){
                System.out.print(ans.random.val+" ");
            }else{
                System.out.print("null ");
            }
            ans=ans.next;
            System.out.println();
        }
    }
    public Node copyRandomList(Node head){
        if(head==null){
            return null;
        }
        Node cur=head;
        Node pre=cur;
        Node ans=new Node(0);
        Node p=ans;
        while(cur!=null){
            Node n=new Node(cur.val);
            p.next=n;

            pre=cur;
            cur=cur.next;
            n.random=pre;
            p=n;
            pre.next=n;
        }
        ans=ans.next;
        p=ans;
        List<Node> nodes=new ArrayList<>();

        while(p!=null){
            nodes.add(p.random);
            p.random=p.random.random==null? null:p.random.random.next;
            p=p.next;
        }
        for (int i = 0; i < nodes.size()-1; i++) {
            Node node=nodes.get(i);
            node.next = nodes.get(i+1);
        }
        nodes.get(nodes.size()-1).next=null;
    return ans;
    }
}
