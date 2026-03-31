package com.greendam.redo;

import java.util.Arrays;

public class T152 {
    public int maxProduct(int[] nums) {
        //为什么要用两个DP数组，因为以nums【i】为结尾的最大乘积不一定只包括仅当前元素或者当前元素乘前一个最大乘积，
        // 如果当前元素为负数的话，最大值应该是当前元素或者当前元素乘上一个元素为结尾的最小乘积
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxDp[i]=Math.max(nums[i],Math.max(maxDp[i-1]*nums[i],minDp[i-1]*nums[i]));
            minDp[i]=Math.min(nums[i],Math.min(maxDp[i-1]*nums[i],minDp[i-1]*nums[i]));
        }
        return Arrays.stream(maxDp).max().getAsInt();
    }
}
