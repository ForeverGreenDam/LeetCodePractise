package com.greendam.redo;


import java.util.HashMap;
import java.util.Map;

public class T3 {
    public static void main(String[] args) {
    String s= "abba";
        T3 solution=new T3();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left=0;
        int right=0;
        int max=0;
        while(right<s.length()){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                int index = map.get(c);
                while(left<=index){
                    map.remove(s.charAt(left));
                    left++;
                }
                map.put(c,right);
            }else{
                map.put(c,right);
            }
            max=Math.max(max,right-left+1);
            right++;
        }
        return max;
    }
}
