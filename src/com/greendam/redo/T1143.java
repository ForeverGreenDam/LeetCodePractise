package com.greendam.redo;

public class T1143 {
    public static void main(String[] args) {
        T1143 t = new T1143();
        System.out.println(t.longestCommonSubsequence("abcde", "ace"));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        //dp[i][j]表示text1[0...i-1]和text2[0...j-1]的最长公共子序列长度
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        //dp[i][j]=dp[i-1][j-1]+1如果最后一个字母都相等的话，这个字母选上
        //dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])如果最后一个字母不相等的话，选上text1的最后一个字母或者text2的最后一个字母
        //初始化第一行和第一列为0(java默认初始化为0，所以不需要初始化)

        for (int i = 1; i <=text1.length() ; i++) {
            for (int j = 1; j <=text2.length() ; j++) {
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
