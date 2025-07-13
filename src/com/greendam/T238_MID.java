package com.greendam;

import java.util.Arrays;

public class T238_MID {
    public static void main(String[] args) {
        int[] nums={1};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
    public static int[] productExceptSelf(int[] nums) {
        if(nums.length==1){
            return new int[]{0};
        }
        int[] ans=new int[nums.length];
        int[] left=new int[nums.length];
        int[] right=new int[nums.length];
        left[0]=1;
        right[nums.length-1]=1;
        for(int i=1,j= nums.length-2;i<nums.length&&j>-1;i++,j--){
            left[i]= left[i-1] * nums[i-1];
            right[j]= right[j+1] * nums[j+1];
        }
        for(int i=0;i<nums.length;i++){
            ans[i]=left[i] * right[i];
        }
        return ans;
    }
}
