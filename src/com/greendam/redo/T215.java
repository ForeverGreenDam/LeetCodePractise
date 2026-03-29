package com.greendam.redo;

import java.util.PriorityQueue;
import java.util.Queue;

public class T215 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue=new PriorityQueue<>(k);
        for (int num : nums) {
            if (queue.size() < k) {
                queue.offer(num);
            } else if (num > queue.peek()) {
                queue.poll();
                queue.offer(num);
            }
        }
        return queue.peek();
    }
}
