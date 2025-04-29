package com.greendam;

public class T2962_MID {
    public static void main(String[] args) {
  int[] nums={1,3,2,3,3};
        System.out.println(countSubarrays1(nums,2));
    }
    //超时
    public static long countSubarrays(int[] nums, int k) {
        int max=0;
        int count=0;
        int p1,p2;
        int ans=0;
        for (int num : nums) {
            if(num>max){
                max=num;
            }
        }
        for(p1=0;p1<nums.length;p1++){
           p2=p1;
           while(p2<nums.length&&count<k){
               if(nums[p2]==max){
                   count++;
               }
               p2++;
           }
           if(count==k){
               ans=ans+(nums.length-p2)+1;
           }
            count=0;
        }
        return ans;
    }
    //优化
    public static long countSubarrays1(int[] nums, int k) {
        int max=0;
        int count=0;
        int p1=0;
        long ans=0;
        for (int num : nums) {
            if(num>max){
                max=num;
            }
        }
        for(int num: nums){
            if(num==max){
                count++;
            }
            while(count==k){
                if(nums[p1]==max){
                    count--;
                }
                p1++;
            }
            ans+=p1;
        }

        return ans;
    }
}
