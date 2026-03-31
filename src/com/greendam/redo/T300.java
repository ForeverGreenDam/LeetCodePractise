package com.greendam.redo;

import java.util.Arrays;

public class T300 {
    public int lengthOfLIS(int[] nums) {
        //以nums[i]为结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            dp[i]=1;
            for (int j=0;j<i;j++){
                //只有nums[i]>nums[j]时，i才能拼接到j的后面，形成一个更长的递增子序列
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
