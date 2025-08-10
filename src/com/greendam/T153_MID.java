package com.greendam;

public class T153_MID {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 8, 9, 10,1, 2, 3 };
        T153_MID solution = new T153_MID();
        System.out.println(solution.findMin(arr));
    }
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(right+left)/2;
           if(nums[mid]>nums[nums.length-1]){
               left=mid+1;
           }else{
                right=mid-1;
           }
        }
        return nums[left];
    }
}
