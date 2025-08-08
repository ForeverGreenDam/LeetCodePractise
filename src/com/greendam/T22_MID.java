package com.greendam;

import java.util.ArrayList;
import java.util.List;

public class T22_MID {
    public static void main(String[] args) {
        int n= 3;
        System.out.println(new T22_MID().generateParenthesis(n));
    }
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        dfs(0, 0, n, path, answer);
        return answer;
    }
    public void dfs(int left,int right,int n,StringBuilder path,List<String> answer){
        if(right>left){
            return;
        }
        if(left==n&&left==right){
            answer.add(path.toString());
            return;
        }
        if(left==right){
            path.append('(');
            dfs(left+1,right,n,path,answer);
            path.deleteCharAt(path.length()-1);
        }else if(left==n){
            path.append(')');
            dfs(left,right+1,n,path,answer);
            path.deleteCharAt(path.length()-1);
            return;
        }else{
            path.append('(');
            dfs(left+1,right,n,path,answer);
            path.deleteCharAt(path.length()-1);
            path.append(')');
            dfs(left,right+1,n,path,answer);
            path.deleteCharAt(path.length()-1);
        }
    }
}
