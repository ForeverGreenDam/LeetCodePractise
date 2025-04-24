package com.greendam;

import java.util.ArrayList;
import java.util.List;

public class T139_MID {
    public static void main(String[] args) {
        String s="aaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");
        System.out.println(wordBreak(s, wordDict));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        //dp[i]含义：从头开始，长度为i的字符串是否可以被wordDict中的单词拼接而成
        //递推公式：dp[i]=dp[j] && wordDict中包含s[j,i]
        //公式化来说，我们需要枚举 s[0..i−1] 中的分割点 j ，看 s[0..j−1] 组成的字符串 s1(也就是dp[j])
        //（默认 j=0 时 s为空串）和 s[j..i−1] 组成的字符串 s2是否都合法，如果两个字符串均合法，那么按照定义 s1和 s2拼接成的字符串也同样合法。
        //只要我枚举的分割点 j 中有一个合法的，那么 dp[i] 就是合法的，不必再循环，直接跳出。
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++){
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
