package com.greendam;

public class T746_EZ {
    public static void main(String[] args) {
    int[] cost={1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairs(cost));
    }
//dp[i]表示到达第i级台阶的最小花费
    //状态转移方程为dp[i]=min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
    //在台阶上不花费，只有跳的时候才花费
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length+1];
        dp[0]=0;
        dp[1]=0;
        for (int i = 2; i <dp.length; i++) {
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[dp.length-1];
    }
}
