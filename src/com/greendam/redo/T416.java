package com.greendam.redo;

public class T416 {
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
        boolean[][] dp = new boolean[nums.length][target+1];
        //初始化第一行,第一列
        for (int i = 0; i <dp[0].length ; i++) {
            dp[0][i]= (nums[0]==i);
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=true;
        }
        //nums[i]选，则dp[i][j]=dp[i-1][j-nums[i]]，越界则为false（越界选他肯定组不成j）
        //nums[i]不选，则dp[i][j]=dp[i-1][j]
        //选或不选中只要有一个能成的话，dp[i][j]就为true
        for(int i=1;i< nums.length;i++){
            for(int j=1;j<=target;j++){
                dp[i][j]=dp[i-1][j];
                if(nums[i]<=j){
                    dp[i][j]=dp[i][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[nums.length-1][target];
    }
}
