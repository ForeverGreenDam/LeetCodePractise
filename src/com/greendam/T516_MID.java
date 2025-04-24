package com.greendam;

public class T516_MID {
    public static void main(String[] args) {
    String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }
    public static int longestPalindromeSubseq(String s) {
        //dp[i][j]含义：字符串[i,j]范围内最长回文子序列长度
        //递推公式分析：求dp[i][j]，则要看其内部的dp[i+1][j-1]，以及s[i]和s[j]，如果s[i]==s[j]，则dp[i][j]=dp[i+1][j-1]+2;
        //如果s[i]!=s[j]，则s[i]和s[j]不能同时加入回文子序列中，只能选一个加入，如果加入左边，dp[i][j]=dp[i][j-1]如果加入右边，dp[i][j]=dp[i+1][j]，所以取二者的最大值
        //由于我们求dp[i][j]，需要其下面或者左面或者左下角的dp值，因此我们要从下往上，从右往左遍历，初始化都为1
        //i<=j，数组是个三角
        int[][] dp = new int[s.length()][s.length()];
        //初始化长度为1对应的dp值
        for (int i = 0; i <s.length() ; i++) {
            dp[i][i]=1;
        }
        //递推
        for(int i=s.length()-1;i>=0;i--) {
            for(int j=i+1;j<s.length();j++) {
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else {
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}
