package com.greendam;

public class T72_MID {
    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        T72_MID solution = new T72_MID();
        System.out.println(solution.minDistance(word1, word2));
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        if(m==0){
            return n;
        }
        if(n==0){
            return m;
        }
        //dp[i][j]的含义：word1[0~i]和word2[0,j]的最小编辑距离（这里的数字不是指数组索引，而是指字符串长度，从1开始计数，word[0]表示空字符串）
        int[][] dp=new int[m+1][n+1];
        for(int i=0;i<m+1;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<n+1;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    dp[i][j]=Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1;
                }else{
                    dp[i][j]=Math.min(Math.min(dp[i][j-1]+1,dp[i-1][j]+1),dp[i-1][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
