package com.greendam;

import java.util.Arrays;

public class T740_MID {
    public static void main(String[] args) {
        int [] nums = {2, 2, 3,3,3,4};
        System.out.println(deleteAndEarn(nums));
    }
    //打家劫舍变种
    /*建立一个新数组nums2
    举个例子，原数组是【2,2,2,3,3,3,4,4】我们可以转为【0,0,6,9,8】
    把相同的值累加起来，将原数值作为下标，累加值作为值存储到新数组里
    题目中说得到num【i】的数值，值为num[i]+-1的值就删除，也就是不能取
    相当于新数组中选取一个值之后，相邻的值就不能选
    这就转化为了一个打家劫舍的问题，获取点数的最大值就是打家劫舍问题中的最大金额
    dp【i】的含义是转化数组有i个元素时所获取到的点数最大值
     */
    public static  int deleteAndEarn(int[] nums) {
        //获取最大值优化
       // int max = Arrays.stream(nums).max().getAsInt();
        int max=0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] nums2 = new int[max + 1];
//        int temp=0;
//        for(int i=0;i<nums2.length;i++){
//            if(nums2[i]!=0) break;
//            for(int j=0;j<nums.length;j++){
//                if(i==nums[j])
//                    temp++;
//            }
//            nums2[i]=temp*i;
//            temp=0;
//        }
        //数组转化优化
        for (int i = 0; i <nums.length ; i++) {
            nums2[nums[i]] += nums[i];
        }
      //数组转化完成，开始进行动态规划算法
        int[] dp = new int[nums2.length];
        dp[0]=nums2[0];
        if(nums2.length==1) return nums2[0];
        dp[1]=Math.max(nums2[0],nums2[1]);
        for (int i = 2; i <nums2.length; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums2[i]);
        }
        return dp[nums2.length-1];
    }
}
