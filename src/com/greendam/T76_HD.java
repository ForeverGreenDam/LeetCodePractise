package com.greendam;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class T76_HD {
    public static void main(String[] args) {
    String s="A";
    String t="AA";
        System.out.println(minWindow(s, t));
    }
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> target = new HashMap<>();
        for (char c : t.toCharArray()) {
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int minWindow = Integer.MAX_VALUE;
        int start = 0;
        int end =0;
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> source = new HashMap<>();
        while (right < chars.length&&left<=right) {
            //首先先加入右端点
            char c = chars[right];
            source.put(c, source.getOrDefault(c, 0) + 1);
            //检查是否满足条件
            boolean check = check(source, target);
            //如果不满足条件，则开始下一轮循环
            if (!check) {
                right++;
            }else{
                //如果满足条件，开始收缩左端点
              while(left<=right&&check(source,target)){
                    left++;
                    char leftChar = chars[left - 1];
                    source.put(leftChar, source.get(leftChar) - 1);
              }
              //直到不满足条件，记录当前窗口大小以及结果
                if(minWindow> right - left + 1){
                    minWindow = right - (left-1)+1 ;
                    start=left-1;
                    end=right+1;
                }
                right++;
            }
        }
        return minWindow == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
    private static boolean  check(HashMap<Character,Integer> source,HashMap<Character,Integer> target){
        AtomicBoolean flag = new AtomicBoolean(true);
        target.forEach((k,v)->{
            if(source.containsKey(k)){
                if(source.get(k)<v){
                    flag.set(false);
                }
            }else{
                flag.set(false);
            }
        });
        return flag.get();
    }
}
