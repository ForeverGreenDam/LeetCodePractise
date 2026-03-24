package com.greendam.redo;

import java.util.ArrayList;
import java.util.List;

public class T78 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        T78 t = new T78();
        List<List<Integer>> ans = t.subsets(nums);
        System.out.println(ans);
    }

    //排列问题使用used数组保证每个元素只使用一次
    //组合问题使用now索引标记每次向后取元素保证前面用过的不重复用。
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtracking(nums, ans, new ArrayList<>(),0);
        return ans;
    }

    public void backtracking(int[] nums, List<List<Integer>> ans, List<Integer> result,int now) {
            ans.add(new ArrayList<>(result));
        for (int i = now; i < nums.length; i++) {
            result.add(nums[i]);
            backtracking(nums, ans, result,i+1);
            result.remove(result.size() - 1);
        }
    }
}
