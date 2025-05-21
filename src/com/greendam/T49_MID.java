package com.greendam;

import java.util.*;

public class T49_MID {
    public static void main(String[] args) {
    String[] strs={"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res=groupAnagrams(strs);
        for (List<String> list : res) {
            System.out.println(list);
        }
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for (String s : strs) {
            //给拿到的字符串排序
            char[] a=s.toCharArray();
            Arrays.sort(a);
            //有顺序的字符串作为key
            String key= String.valueOf(a);
            //如果map中没有这个key，则将这个key放到map中，value为一个空的List，然后将这个字符串放到这个List中
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
                map.get(key).add(s);
            }else{
                //如果map中有这个key，则将这个字符串放到这个List中
                map.get(key).add(s);
            }
        }
        //将map中的value放到一个List中
        List<List<String>> res=new ArrayList<>();
        map.forEach((k,v)->{
            res.add(v);
        });
        return res;
    }
}
