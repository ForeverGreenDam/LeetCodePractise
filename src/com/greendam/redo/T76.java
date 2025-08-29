package com.greendam.redo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class T76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        T76 t76 = new T76();
        String ans = t76.minWindow(s, t);
        System.out.println(ans);
    }
    public  String minWindow(String s, String t){
        if(s.isEmpty() || t.isEmpty()) {
            return "";
        }
        Map<Character,Integer> target=new HashMap<>();
        Map<Character,Integer> map=new HashMap<>();
        for(char c:t.toCharArray()){
            target.put(c,target.getOrDefault(c,0)+1);
        }
        int left=0,right=0;
        int minLen=Integer.MAX_VALUE;
        int start=0,end=0;
        while(right<s.length()&&left<=right){
            char c=s.charAt(right);
            map.put(c,map.getOrDefault(c,0)+1);
            boolean equals = check(map,target);
            if(equals){
                while(left<=right&&check(map,target)){
                    char pre=s.charAt(left);
                    left++;
                    map.put(pre,map.get(pre)-1);
                }
                //第一次不满意的时候，此时left指向start+1的位置，right指向end的位置
                if(minLen>right-left+2){
                    minLen=right-left+2;
                    start=left-1;
                    end=right;
                }
            }
            right++;
        }
        return minLen==Integer.MAX_VALUE ? "" :  s.substring(start,end+1);
    }
    private static boolean  check(Map<Character,Integer> source,Map<Character,Integer> target){
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
