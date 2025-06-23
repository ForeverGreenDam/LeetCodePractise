package com.greendam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T438_MID {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p= "abc";
        System.out.println(findAnagrams(s, p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int n=s.length();
        int size = p.length();
        if(size>n){
            return new ArrayList<>();
        }
        int left = 0;
        int right=0;
        HashMap<Character,Integer> pMap=new HashMap<>();
        HashMap<Character,Integer> map=new HashMap<>();
        //初始化
        for(;right<size;right++){
            if(pMap.containsKey(p.charAt(right))){
                pMap.put(p.charAt(right),pMap.get(p.charAt(right))+1);
            }else {
                pMap.put(p.charAt(right),1);
            }
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),map.get(s.charAt(right))+1);
            }else {
                map.put(s.charAt(right),1);
            }
        }
        right=size-1;
        List<Integer> ans=new ArrayList<>();
        if(pMap.equals(map)){
            ans.add(left);
        }
        while(left<n-size){
            //移动窗口，将左边的字符移除，右边的字符加入
            if(map.get(s.charAt(left))==1){
                map.remove(s.charAt(left));
            }else{
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
            }
            left++;
            right++;
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right),map.get(s.charAt(right))+1);
            }else{
                map.put(s.charAt(right),1);
            }
            //如果两个map相等，说明找到了一个字母异位词
            if(pMap.equals(map)){
                ans.add(left);
            }
        }
        return ans;
    }
}
