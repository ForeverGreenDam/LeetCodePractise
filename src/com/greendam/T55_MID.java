package com.greendam;

public class T55_MID {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int[] nums2 = {3,2,1,0,4};
        System.out.println(new T55_MID().canJump(nums));
    }
    public boolean canJump(int[] nums) {
        int maxJump=nums[0];
        int i=0;
       while(i<=maxJump){
           maxJump=Math.max(maxJump,i+nums[i]);
              if(maxJump>=nums.length-1){
                return true;
              }
              i++;
       }
         return false;
    }
}
