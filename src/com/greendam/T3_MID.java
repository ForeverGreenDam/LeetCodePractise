package com.greendam;

import java.util.HashMap;

public class T3_MID {
    public static void main(String[] args) {
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        //hashmap记录内容，key=子串中出现的字符，value= 字符所在位置
        HashMap<Character, Integer> map = new HashMap<>();
        int left=0;
        int n=s.length();
        int ans=0;
        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            //如果当前字符不在map中，说明没有重复字符，保存当前字符
            if(!map.containsKey(c)){
                map.put(c, right);
            }else {
                //如果当前字符在map中，说明有重复字符，更新左边界
                for (int i = left; i <map.get(c) ; i++) {
                    //首先移除左边界之前的所有字符
                    map.remove(s.charAt(i));
                }
                //更新左边界为重复字符的下一个位置
                left= map.get(c) + 1;
                //然后将当前字符重新放入map中
                map.put(c, right);
            }
            ans = Math.max(ans, map.size());
        }
        return ans;
    }
}
