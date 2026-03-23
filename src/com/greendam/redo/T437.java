package com.greendam.redo;

import com.greendam.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class T437 {
    int ans =0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long,Integer> map=new HashMap<>();
        map.put(0L,1);
        dfs(root, 0, targetSum, map);
        return ans;
    }
    public  void dfs(TreeNode root,long sum,int target,Map<Long,Integer> map){
        if(root==null){
            return;
        }
        //前缀和（截止到当前节点）
        sum+=root.val;
        //目标
        long tar= sum-target;
        if(map.containsKey(tar)){
            ans+=map.get(tar);
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
        dfs(root.left,sum,target,map);
        dfs(root.right,sum,target,map);
        //回溯
        map.put(sum,map.get(sum)-1);
    }
}
