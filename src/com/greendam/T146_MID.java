package com.greendam;

import java.util.HashMap;

public class T146_MID {
    class LRUCache{
        class Node{
            int key;
            int value;
            Node prev;
            Node next;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        private int capacity;
        private Node head=new Node(-1,-1);
        private Node tail=new Node(-1,-1);
        private HashMap<Integer,Node> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>(capacity);
            head.next = tail;
            head.prev = null;
            tail.next = null;
            tail.prev = head;
        }
        public int get(int key){
            if(!map.containsKey(key)){
                return -1;
            }else{
                //获取值
                Node node = map.get(key);
                //更新节点位置到尾节点
                toTail(node);
                return node.value;
            }
        }

        private void toTail(Node node) {
            //更新节点到尾节点（默认头结点的下一个节点是最早使用的）
            Node pre=node.prev;
            Node next=node.next;
            pre.next=next;
            next.prev=pre;

            node.next=tail;
            node.prev=tail.prev;

            tail.prev.next=node;
            tail.prev=node;
        }

        public void put(int key,int value){
            //如果存在key，则更新
            if(map.containsKey(key)){
                //更新值
                Node node = map.get(key);
                node.value=value;
                //更新节点位置到尾节点
                toTail(node);
            }else{
                //判断是否超过容量
                if(map.size()==capacity){
                    //超出容量，则删除头结点的下一个节点
                    Node removeNode = head.next;
                    head.next=removeNode.next;
                    removeNode.next.prev=head;
                    map.remove(removeNode.key);
                }
                    //在尾节点加节点，map添加记录
                    Node node = new Node(key,value);
                    node.prev=tail.prev;
                    node.next=tail;
                    tail.prev.next=node;
                    tail.prev=node;
                    map.put(key,node);
            }
        }
    }
}
