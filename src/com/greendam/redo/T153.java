package com.greendam.redo;

public class T153 {
    public static void main(String[] args) {
        int [] nums = {3,4,5};
        T153 t153 = new T153();
        System.out.println(t153.findMin(nums));
    }
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        if(nums.length==1||nums[0]<nums[right]){
            return nums[0];
        }
        if(nums[right-1]>nums[right]){
            return nums[right];
        }
        while(left<=right){
            int mid=(left+right)/2;
            if(mid>=1&& nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            if(mid<nums.length-1&&nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid]>nums[0]){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return 0;
    }
}
