package com.greendam;

import java.util.Arrays;

public class T75_MID {
    public static void main(String[] args) {
        int[] a = {4,2,3,7,5,6,2};
        new T75_MID().sortColors(a);
        System.out.println(Arrays.toString(a));
    }
    public void sortColors(int[] nums) {
        //重写排序算法
        sort(nums, 0, nums.length - 1);
    }
    private void sort(int[] nums, int low, int high) {
        if(low>=high){
            return;
        }
        int partition =  nums[low];
        int left=low,right=high;
        while(left<right){
            while(left<right&&nums[right]>=partition){
                right--;
            }
            while(left<right&&nums[left]<=partition){
                left++;
            }
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
        }
        nums[low] = nums[left];
        nums[left] = partition;
        sort(nums,low,right-1);
        sort(nums,left+1,high);
    }
}
