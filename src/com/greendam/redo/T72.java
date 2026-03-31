package com.greendam.redo;

public class T72 {
    public int minDistance(String word1, String word2) {
        //dp[i][j]表示word1[0...i-1]和word2[0...j-1]的编辑距离
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        //dp[i][j]=dp[i-1][j-1]如果最后一个字母相等的话
        //dp[i][j]=dp[i-1][j-1]+1如果最后一个字母不相等的话，替换最后一个字母
        //dp[i][j]=dp[i-1][j]+1,如果最后一个字母不相等的话，删除最后一个字母
        //dp[i][j]=dp[i][j-1]+1,如果最后一个字母不相等的话，插入一个字母
        //初始化第一行和第一列
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i]=i;
        }
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0]=i;
        }
        for(int i=1;i<=word1.length();i++){
            for(int j=1;j<=word2.length();j++){
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
