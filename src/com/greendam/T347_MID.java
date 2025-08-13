package com.greendam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class T347_MID {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        T347_MID solution = new T347_MID();
        System.out.println(Arrays.toString(solution.topKFrequent(nums, k)));
    }
    class Entry{
        int num;
        int count;
        Entry(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    //基于215题的扩展罢了
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Entry> pq = new PriorityQueue<>(k,(a,b)->a.count-b.count);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
           if(pq.size() ==k && map.get(key)>pq.peek().count){
               pq.poll();
                pq.offer(new Entry(key, map.get(key)));
           }else{
                if(pq.size() < k){
                     pq.offer(new Entry(key, map.get(key)));
                }
           }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().num;
        }
        return ans;
    }
}
