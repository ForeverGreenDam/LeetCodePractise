package com.greendam.redo;

public class T5 {
    public static void main(String[] args){
        T5 t5 = new T5();
        System.out.println(t5.longestPalindrome("aaaa"));
    }
    public String longestPalindrome(String s) {
            boolean[][] dp=new boolean[s.length()][s.length()];
            //dp[i][j]=dp[i+1][j-1]&&s.charAt(i)==s.charAt(j)
            //dp[i][i]=true
        for (int i = 0; i < s.length(); i++) {
            dp[i][i]=true;
        }
        for (int i = s.length()-1; i>=0; i--) {
            for (int j = i+1; j < s.length(); j++) {
                if(j==i+1){
                    dp[i][j]=(s.charAt(i)==s.charAt(j));
                }else{
                    dp[i][j]=dp[i+1][j-1]&&(s.charAt(i)==s.charAt(j));
                }
            }
        }
        int max=0;
        int start=0;
        int end=0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if(dp[i][j]&&j-i+1>max){
                    max=j-i+1;
                    start=i;
                    end=j;
                }
            }
            }
        return s.substring(start, end+1);
    }
}
