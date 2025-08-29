package com.greendam.redo;

import java.util.Deque;
import java.util.LinkedList;

public class T239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        T239 t239 = new T239();
        int[] ans = t239.maxSlidingWindow(nums, k);
        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans=new int[nums.length-k+1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i <ans.length ; i++) {
            if(i==0){
                //初始化双端队列
                for (int j = 0; j < k; j++) {
                    int target=nums[j];
                    while(!deque.isEmpty()&&deque.peekLast()<target){
                        deque.pollLast();
                    }
                    deque.offerLast(target);
                }
                ans[i]=deque.peekFirst();
                continue;
        }
            int in=nums[i+k-1];
            int out=nums[i-1];
            while(!deque.isEmpty()&&deque.peekLast()<in){
            deque.pollLast();
            }
            deque.offerLast(in);
            if(!deque.isEmpty()&&deque.peekFirst()==out){
                deque.pollFirst();
            }
            ans[i]=deque.peekFirst();
        }
        return ans;
    }
}
