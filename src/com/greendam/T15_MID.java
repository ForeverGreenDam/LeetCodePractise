package com.greendam;

import java.util.*;

public class T15_MID {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <n-2 ; i++) {
            //防止重复1
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            //特殊情况
            if(nums[i]+nums[i+1]+nums[i+2]>0){
                break;
            }
            //特殊情况
            if(nums[n-1]+nums[n-2]+nums[n-3]<0){
                break;
            }
            //特殊情况
            if(nums[i]+nums[n-1]+nums[n-2]<0){
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum>0){
                    k--;
                } else if (sum < 0) {
                    j++;
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                    //防止重复2
                    do {
                        j++;
                    } while (j < k && nums[j] == nums[j - 1]);
                    //防止重复3
                    do {
                        k--;
                    } while (j < k && nums[k] == nums[k + 1]);
                }
            }
        }
        return result;
    }
}
