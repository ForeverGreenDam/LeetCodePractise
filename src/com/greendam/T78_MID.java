package com.greendam;

import java.util.ArrayList;
import java.util.List;

public class T78_MID {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        //先加入空集
        res.add(new ArrayList<>());
        List<Integer> path = new ArrayList<>();
        dfs(nums,0, res, path);
return res;
    }
    public void dfs(int[] nums,int startIndex, List<List<Integer>> res,List<Integer> path) {
        if(startIndex>=nums.length) {
            return;
        }
        for(int i=startIndex;i<nums.length;i++) {
            //选择当前元素
            path.add(nums[i]);
            //将当前路径加入结果集
            res.add(new ArrayList<>(path));
            //继续递归，选择下一个元素
            dfs(nums, i + 1, res, path);
            //回溯，移除当前元素
            path.remove(path.size() - 1);
        }
    }
}
