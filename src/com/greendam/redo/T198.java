package com.greendam.redo;

public class T198 {
    public int rob(int[] nums) {
        int[] bp=new int[nums.length];
        bp[0]= nums[0];
        if(nums.length==1) {
            return nums[0];
        }
        bp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i <nums.length ; i++) {
            bp[i]=Math.max(bp[i-2]+nums[i],bp[i-1]);
        }
        return bp[nums.length-1];
    }
}
