package com.greendam;

public class T322_MID {
    public static void main(String[] args) {
        int[] coins={2,1};
        int amount=11;
        T322_MID solution = new T322_MID();
        System.out.println(solution.coinChange(coins, amount));
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i]=i+1;
            for (int coin : coins) {
                if(i>=coin&&dp[i-coin]!=-1){
                    dp[i]=Math.min(dp[i],  dp[i-coin]+1);
                }
            }
            if(dp[i]==i+1){
                dp[i]=-1;
            }
        }
        return dp[amount];
    }
}
