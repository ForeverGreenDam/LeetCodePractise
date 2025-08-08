package com.greendam;

import java.util.ArrayList;
import java.util.List;

public class T39_MID {
    public static void main(String[] args){
        T39_MID solution = new T39_MID();
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(solution.combinationSum(candidates, target));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates,0,target,ans,path);


    return ans;
    }
    public void dfs(int[] candidates,int index,int target,List<List<Integer>> ans,List<Integer> path){
        if(target==0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(index==candidates.length||target<0){
            return;
        }
        //选择当前数
        path.add(candidates[index]);
        dfs(candidates,index,target-candidates[index],ans,path);
        //回溯
        path.remove(path.size()-1);
        //不选择当前数
        dfs(candidates,index+1,target,ans,path);
    }
}
