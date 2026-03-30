package com.greendam.redo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T763 {
    public List<Integer> partitionLabels(String s) {
        //map记录每种字母最后出现位置
        Map<Character,Integer> map =new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),i);
        }
        int nextMax=0;
        int lastMax=-1;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            Integer length = map.get(c);
            nextMax=Math.max(nextMax,length);
            if(i==nextMax){
                ans.add(i-lastMax);
                lastMax=nextMax;
                nextMax=0;
            }
        }
        //ababcbac
        //a6 b5 c7
        return ans;
    }
}
