package com.greendam;

import java.util.Arrays;

public class T53_MID {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray2(arr));
    }
    public static int maxSubArray(int[] nums) {
        //动态规划
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i-1]>0){
                nums[i]+=nums[i-1];
            }
        }
        return Arrays.stream(nums).max().getAsInt();
    }
    public static int maxSubArray2(int[] nums) {
        //贪心
        int maxSum = nums[0];
        int preSum=nums[0];
        int sum;
        for (int i = 1; i < nums.length; i++) {
            if(preSum<0){
                sum=nums[i];
            }else{
                sum=preSum+nums[i];
            }
            preSum=sum;
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }
}
