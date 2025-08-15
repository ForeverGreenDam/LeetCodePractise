package com.greendam;

import java.util.Arrays;

public class T300_MID {
    public static void  main(String[] args) {
    int[] nums = {4,10,4,3,8,9};
    T300_MID solution = new T300_MID();
    System.out.println(solution.lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        //dp数组的含义：以第i个元素为结尾的最长递增子序列的长度
        //初始化dp[0]=1;
        int[] dp = new int[nums.length];
        dp[0]=1;
        for (int i = 0; i < nums.length; i++) {
            dp[i]=1;
            for (int j = 0; j <i; j++) {
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
