package com.greendam;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class T1128_EZ {
    public static void main(String[] args) {
        int [][] dominoes={{1,2},{1,2},{1,1},{1,2},{2,2}};
        System.out.println(numEquivDominoPairs1 (dominoes));
    }
    //暴力解法
    public static int numEquivDominoPairs(int[][] dominoes) {
        int ans=0;
        for(int i=0;i<dominoes.length;i++){
            for(int  j=i+1;j<dominoes.length;j++){
                if((dominoes[i][0]==dominoes[j][0] && dominoes[i][1]==dominoes[j][1])||
                        (dominoes[i][0]==dominoes[j][1] && dominoes[i][1]==dominoes[j][0])){
                   ans++;
                }
            }
        }
        return ans;
    }
    public static int numEquivDominoPairs1(int[][] dominoes) {
        HashMap<String,Integer> map=new HashMap<>();
        for(int i=0;i<dominoes.length;i++){
            String key1=dominoes[i][0]+","+dominoes[i][1];
            String key2=dominoes[i][1]+","+dominoes[i][0];
            if(map.containsKey(key1)){
                map.put(key1,map.get(key1)+1);
            }else if(map.containsKey(key2)){
                map.put(key2,map.get(key2)+1);
            }else{
                map.put(key1,1);
            }
        }
        int ans=0;
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
           if(entry.getValue()>1){
               ans+=entry.getValue()*(entry.getValue()-1)/2;
           }
        }
        return ans;
    }
}
