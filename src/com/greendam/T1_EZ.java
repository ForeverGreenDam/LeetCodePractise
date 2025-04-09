package com.greendam;

public class T1_EZ {
    public static void main(String[] args) {
    Solution1 s= new Solution1();
    int [] nums={2,7,11,15};
    int target=9;
        int[] x = s.twoSum(nums, target);
        for (int i:x){
            System.out.print(i+" ");
        }
    }
}
class Solution1 {
    //暴力求解
    public int[] twoSum(int[] nums, int target) {
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length;j++){
                if (i!=j && nums[i]+nums[j]==target){
                    int[] ans={i,j};
                    return ans;
                    }
                }
            }
            return null;
        }

    }
