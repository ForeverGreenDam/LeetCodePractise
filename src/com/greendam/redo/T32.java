package com.greendam.redo;

import java.util.Arrays;

public class T32 {
    public int longestValidParentheses(String s) {
        if(s==null || s.length()<2) {
            return 0;
        }
        int[] dp=new int[s.length()];
        //dp[i]表示以s【i】为结尾的最长有效括号的长度
        dp[0]=0;
        if(s.charAt(1)=='('){
            dp[1]=0;
        }else{
            if(s.charAt(0)=='('){
                dp[1]=2;
            }
        }
        for (int i = 2; i <s.length() ; i++) {
            if(s.charAt(i)=='('){
                dp[i]=0;
            }else{
                if(s.charAt(i-1)=='('){
                    dp[i]=dp[i-2]+2;
                }else{
                    if(i-dp[i-1]-1>=0&&s.charAt(i-dp[i-1]-1)=='('){
                        if(i-dp[i-1]-2>=0){
                            dp[i]=dp[i-1]+2+dp[i-dp[i-1]-2];
                        }else{
                            dp[i]=dp[i-1]+2;
                        }
                    }else{
                        dp[i]=0;
                    }
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
