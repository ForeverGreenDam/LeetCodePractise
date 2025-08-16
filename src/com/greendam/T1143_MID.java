package com.greendam;

public class T1143_MID {
    public static void main(String[] args) {
        String text1= "abcde";
        String text2= "ace";
        T1143_MID solution = new T1143_MID();
        System.out.println(solution.longestCommonSubsequence(text1, text2));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        //dp[i][j]表示text1的前i个字符和text2的前j个字符的最长公共子序列长度
        /*
        转化为选或不选的问题：如果选【i】和【j】这两个字符，则看这两个字符是否相等，如果相等，则dp[i][j]=dp[i-1][j-1]+1; 不相等为0
        如果不选，则有三种情况：
        1.不选text1的第i个字符，dp[i][j]=dp[i-1][j];
        2.不选text2的第j个字符，dp[i][j]=dp[i][j-1];
        3.不选text1的第i个字符和text2的第j个字符，dp[i][j]=dp[i-1][j-1];
         */
        int m = text1.length();
        int n= text2.length();
        int[][] dp = new int[m][n];
        //初始化第一行第一列
        boolean flag=false;
        for (int i = 0; i < m; i++) {
            dp[i][0]=0;
            if(text1.charAt(i)==text2.charAt(0)){
                flag=true;
            }
            if(flag){
                dp[i][0]=1;
            }
        }
        flag=false;
        for (int i = 0; i < n; i++) {
            dp[0][i]=0;
            if(text1.charAt(0)==text2.charAt(i)){
                flag=true;
            }
            if(flag){
                dp[0][i]=1;
            }
        }
        //开始填充dp数组
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int c1= text1.charAt(i)==text2.charAt(j) ? dp[i-1][j-1]+1 : 0;
                dp[i][j]=Math.max(Math.max(Math.max(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]),c1);
            }
        }
        return dp[m-1][n-1];
    }
}
