package com.greendam.redo;

import java.util.ArrayList;
import java.util.List;

public class T46 {
    public static void main(String[] args) {
        int [] nums = {1,2,3};
        T46 t = new T46();
        List<List<Integer>> ans = t.permute(nums);
        System.out.println(ans);
    }
    //排列问题使用used数组保证每个元素只使用一次
    //组合问题使用now索引标记每次向后取元素保证前面用过的不重复用。
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(nums,ans,new ArrayList<>(),used);
        return ans;
    }
    public void backtracking(int[] nums,List<List<Integer>> ans,List<Integer> result,boolean[] used ) {
        if(result.size() == nums.length) {
            ans.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i <nums.length ; i++) {
            if(!used[i]){
                result.add(nums[i]);
                used[i] = true;
                backtracking(nums,ans,result,used);
                result.remove(result.size()-1);
                used[i] = false;
            }
        }
    }
}
