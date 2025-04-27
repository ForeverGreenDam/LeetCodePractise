package com.greendam;

public class T3392_EZ {
    public static void main(String[] args) {
        int[] nums={-1,-4,-1,4};
        System.out.println(countSubarrays(nums));
    }
    public static int countSubarrays(int[] nums) {
        //双指针
        int p1=0;
        int p2=2;
        int ans=0;
        for(;p2<nums.length;p2++){
            if(nums[p1]+nums[p2]==((double)nums[(p1+p2)/2])/2){
                ans++;
            }
            p1++;
        }
        return ans;
    }
}
