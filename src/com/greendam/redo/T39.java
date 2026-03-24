package com.greendam.redo;

import java.util.ArrayList;
import java.util.List;

public class T39 {
    public static void main(String[] args) {
        T39 t=new T39();
        int[] candidates={2,3,6,7};
        System.out.println(t.combinationSum(candidates,7));
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans,new ArrayList<>(),0,candidates,target,0);
        return ans;
    }
    //nowIndex递归选择i+1，则表示自己不能重复选，每次只能选后面的元素
    //nowindex递归选择I，则表示自己可以重复选，每次都可以选自己和后面的元素
    //组合问题去重的方法就是使用nowindex，表明我所有的元素都是从自己往后选的，不会出现选完后面的元素再去选前面的元素的情况
    public void dfs( List<List<Integer>> ans,List<Integer> path,int nowSum,int[] candidates, int target ,int nowIndex){
        if(nowSum==target){

            ans.add(new ArrayList<>(path));
            return;
        }
        if(nowSum>target){
            return;
        }
        for(int i = nowIndex ; i < candidates.length ; i++){
            path.add(candidates[i]);
            dfs(ans,path,nowSum+candidates[i],candidates,target,i);
            path.remove(path.size()-1);
        }
    }
}
