package com.greendam;

public class T416_MID {
    public static void main(String[] args) {
        int[] nums = {1,5,10,6};
        T416_MID solution = new T416_MID();
        System.out.println(solution.canPartition(nums));
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        if(sum%2!=0){
            return false;
        }
        int target=sum/2;
        //dp[i][j]表示前i个数中部分数之和是否可以组成j，如果能，则为true
        /*状态转移方程
        * 如果不选num[i]则dp[i][j]=dp[i-1][j]
        * 如果选num[i]则dp[i][j]=dp[i-1][j-num[i]]，前提是num[i]<=j，否则为false
         */
        boolean[][] dp = new boolean[nums.length][target+1];
        //初始化第一行,第一列
        for (int i = 0; i <dp[0].length ; i++) {
            dp[0][i]= (nums[0]==i);
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=true;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i-1][j];
                if(nums[i]<=j){
                    dp[i][j]=dp[i][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[nums.length-1][target];
    }
}
