package com.greendam;

public class T1920_EZ {
    public static void main(String[] args) {
        int []nums={0,2,1,5,3,4};
        int []ans=buildArray(nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }
    public static int[] buildArray(int[] nums) {
        int[]  ans= new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
