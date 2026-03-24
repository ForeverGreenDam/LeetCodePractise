package com.greendam.redo;

import java.util.ArrayList;
import java.util.List;

public class T17 {
    public static void main(String[] args) {
        T17 t=new T17();
        System.out.println(t.letterCombinations("23"));
    }
    public static String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        dfs(ans,"",0,digits);
        return ans;
    }
    public void dfs(List<String> ans,String path, int now,String digits){
        if(path.length()==digits.length()){
            ans.add(path);
            return;
        }
      String str=map[digits.charAt(now)-'0'];
        for(int i=0;i<str.length();i++){
            path=path+str.charAt(i);
            dfs(ans,path,now+1,digits);
            path=path.substring(0,path.length()-1);
        }
    }
}
