package com.greendam;

public class T5_MID {
    public static void main(String[] args) {
        String s="babad";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
    //dp[i][j]数组的含义：第i到j个字符组成的字符串是不是回文字符串
        //[i][j]是回文子串，则必须满足[i+1][j-1]是回文子串，同时第i和第j个字符必须相等（这是在串的长度大于等于三的情况下）
        //如果串长度小于三，则必须满足第i和第j个字符相等
        //因此dp数组初始化要考虑串长小于三的情况
        int[][] dp= new int[s.length()][s.length()];
        //初始化dp数组
        //由于最后一行比较特殊，只有一个长度小于三的串，使用通用的方法处理会导致字符串越界，所以要单独处理
        for(int i=0;i<s.length()-1;i++) {
            for(int j=i;j<=i+1;j++) {
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=1;
                }
            }
        }
        //处理最后一行
        dp[s.length()-1][s.length()-1]=1;
        //递推，由于要得到dp[i][j]就要首先得到dp[i+1][j-1]，所以遍历顺序必须从下到上，从左到右，从倒数第三行开始
        for(int i=s.length()-3;i>=0;i--) {
            for(int j=i+2;j<s.length();j++) {
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==1){
                    dp[i][j]=1;
                }
            }
        }
        //获取最长回文子串
        int maxX=0;
        int maxY=0;
        int max=0;
        for(int i=0;i<s.length();i++) {
            for(int j=i;j<s.length();j++) {
                if(dp[i][j]==1){
                    if(j-i+1>max){
                        max=j-i+1;
                        maxX=i;
                        maxY=j;
                    }
                }
            }
        }
        //substring方法包含起始索引，不包含结束索引，因此最后要加一
        return s.substring(maxX,maxY+1);
    }
}
