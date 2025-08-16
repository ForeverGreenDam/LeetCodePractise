package com.greendam;

import java.util.Arrays;

public class T169_EZ {
    public static void main(String[] args) {
        int[] a = {6,5,5};
        T169_EZ t = new T169_EZ();
        System.out.println(t.majorityElement2(a));
    }
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    public int majorityElement2(int[] nums) {
        int ans=0,count=0;
        for(int i=0;i<nums.length;i++){
            if(count==0){
                ans=nums[i];
                count=1;
                continue;
            }
            if(nums[i]==ans){
                count++;
            }else{
                count--;
            }
        }
        return ans;
    }
}
