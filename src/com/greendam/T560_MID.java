package com.greendam;

import java.util.HashMap;

public class T560_MID {
    public static void main(String[] args) {
        int[] nums= {1,2,3};
        int k = 3;
        System.out.println(subarraySum(nums,k));
    }

    /**
     * 题目条件有负数，不能使用滑动窗口计算，已弃用
     */
    @Deprecated
    public static int subarraySum1(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int ans=0;
        int sum =nums[0];
        while (right < nums.length) {
            if(sum==k){
                ans++;
                if (right== nums.length - 1) {
                    break;
                }
                right++;
                sum = sum+nums[right];
            }else if(sum>k){
                if(left==right){
                    if (right== nums.length - 1) {
                        break;
                    }
                    right++;
                    left++;
                    sum = nums[right];
                }else{
                    left++;
                    sum-=nums[left-1];
                }
            }else{
                if (right== nums.length - 1) {
                    break;
                }
                right++;
                sum+=nums[right];
            }
        }
        return ans;
    }

    /**
     * 使用前缀和计算
     */
    public static int subarraySum(int[] nums, int k) {
        // 前缀和数组
        int[] preSum = new int[nums.length];
        preSum[0]= nums[0];
        //寻找前缀和之差为k的子数组 pre[i]-pre[j] = k，可化简为:pre[j] = pre[i] - k(i>j)
        int ans=0;
        // 使用哈希表存储截止到 i 这个位置，之前的前缀和出现的次数（也就是上面说的pre[j]出现的次数）
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < preSum.length; i++) {
            if(i>0){
                preSum[i] = preSum[i-1] + nums[i];
            }
            int target = preSum[i] - k;
            if (map.containsKey(target)) {
                ans += map.get(target);
            }
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        return ans;
    }

}
