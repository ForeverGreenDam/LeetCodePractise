package com.greendam;

import java.util.PriorityQueue;

public class T215_MID {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3,1,2,4, 5,5, 6};
        int[] nums2 = {3, 2, 1, 5, 6, 4};
        int k=4;
        int k2=2;
        T215_MID solution = new T215_MID();
        System.out.println(solution.findKthLargest(nums2, k2));
    }
    public int findKthLargest(int[] nums, int k) {
        int ans =0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (maxHeap.size() == k && num > maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(num);
            }else{
                if (maxHeap.size() < k) {
                    maxHeap.offer(num);
                }
            }
        }
        ans=maxHeap.peek();
        return ans;
    }
}
