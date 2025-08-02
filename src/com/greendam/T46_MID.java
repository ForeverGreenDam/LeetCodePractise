package com.greendam;

import java.util.ArrayList;
import java.util.List;

public class T46_MID {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[len];
        dfs(nums,0, ans, path, used);
        return ans;
    }
    public void dfs(int[] nums,int depth, List<List<Integer>> ans, List<Integer> path, boolean[] used) {
        if(depth==nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums,depth+1,ans,path,used);
                //回溯，移除新添加的项
                path.remove(path.size()-1);
                used[i] = false;
            }
        }
    }
}
