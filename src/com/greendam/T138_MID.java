package com.greendam;

public class T138_MID {
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

    /**
     * 以下方式有误，现已废弃。深拷贝要求原链表不能改变，下面的方法会导致原链表破坏
     * @param head 原链表头节点
     * @return  新链表头节点
     */
    @Deprecated
    public Node copyRandomList(Node head) {
        //思路：先创建一张新链表，复制原链表的节点值，初始化每个节点的random指针指向复制的旧节点自身
        //处理旧链表，将每个节点的next指针指向对应新节点
        //最后遍历新链表，将每个节点的random指针指向对应的新节点
        Node pre=null;
        Node p=head;
        Node newHead=new Node(0);
        Node tail= newHead;
        while(p!=null){
            pre=p;
            p=p.next;
            tail.next=new Node(pre.val);
            tail=tail.next;
            //将新节点的random指针指向对应的旧节点
            tail.random=pre;
            //将旧节点的next指针指向对应新节点
            pre.next=tail;
        }
        //遍历新链表，将每个节点的random指针指向对应的新节点
        p=newHead.next;
        while(p!=null){
            p.random=p.random.random==null?null:p.random.random.next;
            p=p.next;
        }
        return newHead.next;
    }

    /**
     * 官方题解
     */
        public Node copyRandomList1(Node head) {
            if (head == null) {
                return null;
            }
            for (Node node = head; node != null; node = node.next.next) {
                Node nodeNew = new Node(node.val);
                nodeNew.next = node.next;
                node.next = nodeNew;
            }
            for (Node node = head; node != null; node = node.next.next) {
                Node nodeNew = node.next;
                nodeNew.random = (node.random != null) ? node.random.next : null;
            }
            Node headNew = head.next;
            for (Node node = head; node != null; node = node.next) {
                Node nodeNew = node.next;
                node.next = node.next.next;
                nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
            }
            return headNew;
        }
}
