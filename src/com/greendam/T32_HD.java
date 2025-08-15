package com.greendam;

import java.util.Arrays;

public class T32_HD {
    public static void main(String[] args) {
        String s="()(())";
        T32_HD solution = new T32_HD();
        System.out.println(solution.longestValidParentheses(s));
    }
    public int longestValidParentheses(String s) {
        //dp[i]表示以s[i]结尾的最长有效括号长度
        //s[i]为‘(’时，dp[i]=0
        //s[i]为')'时，看s[i-1]是否为'('，如果是，则dp[i]=dp[i-2]+2
        //如果不是，则看s[i-1]是否为')'，如果是，则看s[i-dp[i-1]-1]是否为'('，如果是，则dp[i]=dp[i-1]+2+dp[i-dp[i-1]-2]
        int n = s.length();
        int[] dp = new int[n];
        if(n<=1) {
            return 0;
        }
        dp[0]=0;
        if(s.charAt(0)=='('&&s.charAt(1)==')'){
            dp[1]=2;
        }
        for (int i = 2; i <n ; i++) {
            char c = s.charAt(i);
            if(c=='('){
                dp[i]=0;
            }else{
                if(s.charAt(i-1)=='('){
                    dp[i]=dp[i-2]+2;
                } else {
                    if(i-dp[i-1]-1>=0 &&s.charAt(i-dp[i-1]-1)=='('){
                        dp[i]=dp[i-1]+2+ (i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0);
                    }
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
