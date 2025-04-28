package com.greendam;


public class T2302_HD {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1};
        long k = 5;
        System.out.println(countSubarrays1(nums,k));
    }
    //超时
    public static long countSubarrays(int[] nums, long k) {
        int p1;
        int p2;
        int ans =0;
        long[] sum = new long[nums.length];
        //先求前缀和
        sum[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            sum[i] = sum[i-1]+nums[i];
        }
        //p1-p2区间和就是sum[p2]-sum[p1-1]，p1-p2之间元素的数量为p2-p1+1
        //所以，满足条件的区间就是（sum[p2]-sum[p1-1]）*（p2-p1+1） < k
        for(int i=0;i<nums.length;i++){
            p1=i;
            p2=p1;
            while(p2<nums.length){
                boolean flag = p1 != 0 ? (sum[p2]-sum[p1-1])*(p2-p1+1)<k: (sum[p2])*(p2-p1+1)<k;
                if(flag){
                    ans++;
                }
                p2++;
            }
        }
        return ans;
    }
    //优化：
public static long countSubarrays1(int[] nums, long k) {
    long ans = 0;
    long sum = 0;
    int left = 0;
    for (int right = 0; right < nums.length; right++) {
        sum += nums[right];
        while (sum * (right - left + 1) >= k) {
            sum -= nums[left];
            left++;
        }
        ans += right - left + 1;
    }
    return ans;
}
}
