package com.greendam;

import java.util.ArrayList;
import java.util.List;

public class T17_MID {
    public static final String[] KEYS = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static void main(String[] args) {
        T17_MID t17_mid = new T17_MID();
        String digits = "23";
        List<String> combinations = t17_mid.letterCombinations(digits);
        // 输出: [ad, ae, af, bd, be, bf, cd, ce, cf]
        System.out.println(combinations);
    }
    /**
     *  字符对应数字，Ascii码- '0' = 数字
     */
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        char[] digitsCharArray = digits.toCharArray();
        if(digitsCharArray.length == 0) {
            //如果输入为空，直接返回空列表
            return ans;
        }
        StringBuilder path = new StringBuilder();
        dfs(0, ans, digitsCharArray, path);
        return ans;
    }
    public void dfs(int depth,List<String> ans,char[] digitsCharArray, StringBuilder sb) {
        if(depth == digitsCharArray.length) {
            ans.add(new String(sb));
            return;
        }
        int index = digitsCharArray[depth] - '0';
        for (char c : KEYS[index].toCharArray()) {
            sb.append(c);
            dfs(depth + 1, ans, digitsCharArray, sb);
            // 回溯，删除最后一个字符
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
