package com.greendam.redo;

import java.util.ArrayList;
import java.util.List;

public class T131 {
    public static void main(String[] args) {
        T131 t=new T131();
        String s="aab";
        System.out.println(t.isBack("aa"));
        System.out.println(t.partition(s));
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        dfs(ans,new ArrayList<>(),0,s);
        return ans;
    }
    public boolean isBack(String s){
        for (int i = 0; i <s.length() ; i++) {
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    //按照分割几刀来计数
    //因为只能向后分割，所以我们这边加一个nowindex
    //刀数为s.length-1
    public void dfs(List<List<String>> ans,List<String> path,int nowIndex,String s){
      if(nowIndex==s.length()){
          ans.add(new ArrayList<>(path));
          return;
      }
      for(int i=nowIndex;i<s.length();i++){
          String substring = s.substring(nowIndex, i + 1);
          if(isBack(substring)){
                path.add(substring);
                dfs(ans,path,i+1,s);
                path.remove(path.size()-1);
          }
      }
    }
}
