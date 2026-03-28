package com.greendam.redo;

public class T33 {
    public static void main(String[] args) {
        T33 t33 = new T33();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(t33.search(nums, 0));
    }
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if(nums[0]>nums[mid]){
                if(nums[mid]<target&&target<=nums[right]){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }else{
                if(nums[mid]>target&&target>=nums[left]){
                    right=mid-1;
                } else {
                    left=mid+1;
                }
            }
        }
        return -1;
    }
}
