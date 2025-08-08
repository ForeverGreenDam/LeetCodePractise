package com.greendam;

public class T35_EZ {
    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        T35_EZ t = new T35_EZ();
        System.out.println(t.searchInsert(nums,target));
    }
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid=(left + right) / 2;
        while (left < right) {
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                right=mid;
                mid=(left + right) / 2;
            }else{
                left=mid+1;
                mid=(left + right) / 2;
            }
        }
        return nums[left]>=target?left:left+1;
    }
}
