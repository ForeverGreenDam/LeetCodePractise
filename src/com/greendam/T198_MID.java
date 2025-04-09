package com.greendam;

public class T198_MID {
    public static void main(String[] args) {
        int[] nums= {2,7,9,3,1,8,9,4};
        System.out.println(rob(nums));
    }
    //dp[i]的含义：偷到第i家时的最大金额（考虑第i家）
    //通过不完全归纳，可得dp[i]=dp[i-1] or dp[i]=dp[i-2]+nums[i]
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        //初始化dp
        dp[0]=nums[0];
        //补充边界条件
        if(nums.length==1) return nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        //循环递推公式
        for (int i = 2; i <nums.length ; i++) {
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        //返回结果
        return dp[nums.length-1];
    }
}
