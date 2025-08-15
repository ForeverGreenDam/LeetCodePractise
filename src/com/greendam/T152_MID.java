package com.greendam;

import java.util.Arrays;

public class T152_MID {
    public static void main(String[] args) {
        int[] nums = {-2,3,-1};
        T152_MID solution = new T152_MID();
        System.out.println(solution.maxProduct(nums));
    }
    public int maxProduct(int[] nums) {
        //dpMax数组表示以i结尾的最大子数组乘积
        //dpMin数组表示以i结尾的最小子数组乘积
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0]=nums[0];
        dpMin[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i]=Math.max(dpMax[i-1]*nums[i],Math.max(dpMin[i-1]*nums[i],nums[i]));
            dpMin[i]=Math.min(dpMax[i-1]*nums[i],Math.min(dpMin[i-1]*nums[i],nums[i]));
        }
        return Arrays.stream(dpMax).max().getAsInt();
    }
}
