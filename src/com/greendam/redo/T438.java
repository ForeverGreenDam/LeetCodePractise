package com.greendam.redo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T438 {
    public static void main(String[] args) {
    String s="abab", p="ab";
        T438 solution=new T438();
        System.out.println(solution.findAnagrams(s,p));
    }
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length()<p.length()){
            return new ArrayList<>();
        }
        Map<Character,Integer> map=new HashMap<>();
        for(char c:p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int left=0;
        int right=0;
        int count=p.length();
        Map<Character,Integer> tempMap=new HashMap<>();
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i <count ; i++) {
            tempMap.put(s.charAt(i),tempMap.getOrDefault(s.charAt(i),0)+1);
            right++;
        }
        if(map.equals(tempMap)){
            res.add(left);
        }
        while(right<s.length()){
            char r=s.charAt(right);
            char l=s.charAt(left);
            tempMap.put(r,tempMap.getOrDefault(r,0)+1);
            if(tempMap.get(l)==1){
                tempMap.remove(l);
            }else{
                tempMap.put(l,tempMap.get(l)-1);
            }
            left++;
            right++;
            if(map.equals(tempMap)){
                res.add(left);
            }
        }
        return res;
    }
}
