package com.greendam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T763_MID {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        T763_MID solution = new T763_MID();
        System.out.println(solution.partitionLabels(s));
    }
    public List<Integer> partitionLabels(String s) {
        //map记录每个字符最后出现的位置
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int start = 0;
        int end = 0;
        int p=0;
        while(p < s.length()) {
            //每轮开始时预分配边界值，防止越界
            start=p;
            end = map.get(s.charAt(p));
            while (p <= end) {
                Character c = s.charAt(p);
                //找到当前字符的最后位置
                end = Math.max(end, map.get(c));
                p++;
            }
            //将[start, end]区间的字符分为一组
            ans.add(end-start+1);
        }
        return  ans;
    }
}
