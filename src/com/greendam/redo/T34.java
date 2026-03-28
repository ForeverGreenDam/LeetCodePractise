package com.greendam.redo;

public class T34 {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                ans[0]=mid;
                ans[1]=mid;
                left=mid;
                right=mid;
                while(left>=0&&nums[left]==target){
                    left--;
                }
                while(right<nums.length&&nums[right]==target){
                    right++;
                }
                ans[0]=left+1;
                ans[1]=right-1;
                return ans;
            }else if(nums[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return ans;
    }
}
