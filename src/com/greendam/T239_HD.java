package com.greendam;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class T239_HD {
    public static void main(String[] args) {
    int[] nums = {1,-1};
    int k = 1;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }
    public static Deque<Integer> deque = new LinkedList<>();
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans= new int[nums.length-k+1];
        for (int i = 0; i < ans.length; i++) {
            //先填入前k个元素
            if(i==0) {
                for (int j = 0; j < k; j++) {
                    while (!deque.isEmpty() && nums[j] >= nums[deque.peekLast()]) {
                        deque.pollLast();
                    }
                    deque.offerLast(j);
                }
                ans[i]=nums[deque.getFirst()];
                continue;
            }
            //处理后续元素
            //对于进入的元素，如果比前面前面的元素大，则前面的元素出队，直到进入的这个元素比前面的元素小为止
            //当前进入的元素
            int in = i + k - 1;
            while(!deque.isEmpty() && nums[in] >= nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(in);
            //对于出队的元素，每轮循环 要出队第i-1号元素
            int out = i - 1;
            if(deque.peekFirst()!=null &&deque.peekFirst()== out ){
                deque.pollFirst();
            }
            //将队首元素保存为答案
            ans[i]=nums[deque.getFirst()];
        }
        return ans;
    }
}
