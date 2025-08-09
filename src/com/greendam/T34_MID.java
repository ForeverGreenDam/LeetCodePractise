package com.greendam;

import java.util.Arrays;

public class T34_MID {
    public static void main(String[] args) {
        int[] nums={2,2};
        int target = 2;
        T34_MID t = new T34_MID();
        System.out.println(Arrays.toString(t.searchRange(nums, target)));
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        int left = 0, right = nums.length - 1;
        int mid = -1;
        boolean found = false;
        while(left<=right){
            mid = (left+right)/2;
            if(nums[mid]==target){
                found = true;
                break;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        if(!found){
            return ans;
        }else{
            left = mid;
            right=mid;
           while(left>=0&&nums[left]==target){
                left--;
           }
              while(right<nums.length&&nums[right]==target) {
                  right++;
              }
            ans[0] = left + 1;
            ans[1] = right-1;
            return ans;
        }
    }
}
