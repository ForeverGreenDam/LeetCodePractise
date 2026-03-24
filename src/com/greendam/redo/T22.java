package com.greendam.redo;

import java.util.ArrayList;
import java.util.List;

public class T22 {
    public static void main(String[] args) {
        T22 t=new T22();
        System.out.println(t.generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans,"",n,0,0);
        return ans;
    }
    public void dfs(List<String> ans,String path,int n,int left,int right){
        if(right>left){
            return;
        }
        if(left==right&&left==n){
            ans.add(path);
            return;
        }
        if(left==n){
            path+=")";
            dfs(ans,path,n,left,right+1);
            path=path.substring(0,path.length()-1);
        }else {
            path+=")";
            dfs(ans,path,n,left,right+1);
            path=path.substring(0,path.length()-1);
            path+="(";
            dfs(ans,path,n,left+1,right);
            path=path.substring(0,path.length()-1);
        }
    }
}
