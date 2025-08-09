package com.greendam;

import java.util.ArrayList;
import java.util.List;

public class T131_MID {
    public static void main(String[] args) {
        String s="aab";
        T131_MID t=new T131_MID();
        System.out.println(t.partition(s));
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0,s,path,ans);
        return ans;
    }
    public void dfs(int startIndex, String s, List<String> path, List<List<String>> ans) {
        if(startIndex ==s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex;i<s.length();i++){
            if(isPalindrome(s,startIndex,i)){
                path.add(s.substring(startIndex,i+1));
            }else{
                continue;
            }
            dfs(i+1,s,path,ans);
            //回溯
            path.remove(path.size()-1);
        }
    }
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
