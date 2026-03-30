package com.greendam.redo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class T347 {
    public static void main(String[] args) {
        int[] nums={4,1,-1,2,-1,2,3};
        int k=2;
        T347 t=new T347();
        int[] ans=t.topKFrequent(nums,k);
        for (int an : ans) {
            System.out.println(an);
        }
    }
    class Node{
        int val;
        int count;

        public Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans=new int[k];
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Queue<Node> queue=new PriorityQueue<>(k,(n1,n2)->{
            return n1.count-n2.count;
        });

        map.keySet().forEach(key->{
            if(queue.size()<k){
                queue.offer(new Node(key,map.get(key)));
            }else{
                if(map.get(key)>queue.peek().count){
                    queue.poll();
                    queue.offer(new Node(key,map.get(key)));
                }
            }
        });
        for (int i = 0; i < k; i++) {
            ans[i]=queue.poll().val;
        }
        return ans;
    }
}
