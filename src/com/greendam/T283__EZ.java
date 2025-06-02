package com.greendam;

import java.util.Arrays;

public class T283__EZ {
    public static void main(String[] args) {
        int[] nums={1};
            moveZeroes(nums);
    }
    public static void moveZeroes(int[] nums) {
        int p1=0;
        int p2=0;
        while(p2<nums.length){
            if(nums[p2]!=0){
                while(p1<p2){
                    if(nums[p1]!=0){
                        p1++;
                    }else{
                        nums[p1]=nums[p2];
                        nums[p2]=0;
                        break;
                    }
                }
            }
            p2++;
        }
        System.out.println(Arrays.toString(nums));
    }
}
